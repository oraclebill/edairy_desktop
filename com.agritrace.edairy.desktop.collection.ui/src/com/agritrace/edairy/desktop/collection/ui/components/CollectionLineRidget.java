package com.agritrace.edairy.desktop.collection.ui.components;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.List;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.riena.internal.ui.ridgets.swt.ActionObserver;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

@SuppressWarnings("restriction")
public class CollectionLineRidget extends AbstractCompositeRidget implements ICollectionLineEditRidget {

	private static class ValidationError extends Error {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unused")
		public ValidationError() {
			super();
		}

		public ValidationError(String s) {
			super(s);
		}
	}

	public static final class PersonNameConverter extends Converter {
		private String defaultValue;

		public PersonNameConverter(String defaultValue) {
			super(Person.class, String.class);
			this.defaultValue = defaultValue;
		}

		@Override
		public Object convert(Object fromObject) {
			String formattedName = defaultValue;
			if (fromObject instanceof Person) {
				Person person = (Person) fromObject;
				formattedName = String.format("%s, %s", person.getFamilyName(), person.getGivenName());
			}
			return formattedName;
		}
	}

	private final class InlineInputFlagConverter extends Converter {
		private InlineInputFlagConverter(Object fromType, Object toType) {
			super(fromType, toType);
		}

		@Override
		public Object convert(Object fromObject) {
			if ((fromObject instanceof String) && !((String) fromObject).isEmpty()) {
				String text = (String) fromObject;
				final String firstChar = text.substring(0, 1);
				if (firstChar.equalsIgnoreCase("N")) {
					text = text.substring(1);
					nprMissingButton.setSelected(true);
					return text;
				} else if (firstChar.equalsIgnoreCase("R")) {
					text = text.substring(1);
					rejectedButton.setSelected(true);
					return text;
				}
			}
			return fromObject;
		}
	}

	// private IDairyRepository dairyRepo;
	// private List<DairyContainer> bins;

	private IComboRidget binCombo;
	private ITextRidget canText;
	private ITextRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	private IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;
	private IToggleButtonRidget qualityButton;
	private ITextRidget milkfatTxt;
	private ITextRidget alcoholPercentTxt;
	private IToggleButtonRidget addedWaterButton;
	private final ActionObserver addActionObserver, clearActionObserver;
	private IActionRidget addButton;
	private IActionRidget clearButton;

	// preferences
	boolean validateBin = true;
	boolean validateMember = true;
	boolean confirmClear = true;

	// working memory
	private CollectionJournalLine workingJournalLine;
	private IObservableList binList;
	boolean cachedHideState = false;

	public CollectionLineRidget() {
		addActionObserver = new ActionObserver(this);
		clearActionObserver = new ActionObserver(this);
	}

	public void setBinList(List<DairyContainer> binList) {
		this.binList = new WritableList(binList, DairyContainer.class);
	}

	@Override
	public void setBinList(IObservableList binList) {
		this.binList = binList;
	}

	public IObservableList getBinList() {
		return binList;
	}

	public void setData(CollectionJournalLine createCollectionJournalLine) {
		workingJournalLine = createCollectionJournalLine;
		bindRidgets();
	}

	@Override
	public void setData(Object rowData) {
		if (rowData instanceof CollectionJournalLine) {
			setData((CollectionJournalLine) rowData);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		//
		// get preferences
		//

//		IPreferencesService service = Platform.getPreferencesService();
//		confirmClear = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
//				"confirmClearCollectionsEntryAction", true, null);
//		validateBin = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
//				"validateBinOnAddLine", true, null);
//		validateMember = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
//				"validateMemberOnAddLine", true, null);

		//
		// get ridgets
		//

		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		memberIDRidget = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberNameText);
		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		addButton = getRidget(IActionRidget.class, ViewWidgetId.addButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.entryInputClear);
		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);
		qualityButton = getRidget(IToggleButtonRidget.class, "display-quality-controls-button");
		milkfatTxt = getRidget(IDecimalTextRidget.class, "milk-fat-percent-text");
		alcoholPercentTxt = getRidget(IDecimalTextRidget.class, "alcohol-percent-text");
		addedWaterButton = getRidget(IToggleButtonRidget.class, "added-water-checkbox");

		//
		// configure ridgets
		//

		// bin
		binCombo.setMandatory(true);

		// member number
		memberIDRidget.setMandatory(true);
		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new InlineInputFlagConverter(String.class, String.class));

		// member name
		memberNameRidget.setModelToUIControlConverter(new PersonNameConverter("n/a"));

		// quantity
		quantityText.setMandatory(true);

		// rejected
		rejectedButton.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				handleRejectedPropertyChange(evt);
			}
		});
		// milk fat

		// alcohol

		// water checkbox

		// add line button
		addButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				addButtonClicked();
			}
		});

		// clear line button
		clearButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				clearButtonClicked();
			}
		});

		qualityButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				qualityButtonClicked(qualityButton.isEnabled());
			}

		});
	}

	public void bindRidgets() {
		
		if (workingJournalLine == null) {
			throw new IllegalStateException("No model. Call setData before binding!");
		}
		// editable widgets
		// todo: should bind to bins for this route only..
		binCombo.bindToModel(binList, DairyContainer.class, "getContainerId", EMFObservables.observeValue(
				workingJournalLine, DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

		memberIDRidget.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER));

		nprMissingButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED));

		rejectedButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED));

		// problem children
		// memberNameRidget.setText("");
		memberNameRidget.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER.getName());

		quantityText.bindToModel(workingJournalLine, DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY.getName());

		milkfatTxt.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE.getName());

		alcoholPercentTxt.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE.getName());

		addedWaterButton.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__WATER_ADDED.getName());

	}

	@Override
	protected void updateVisible() {
		Object controlObj = getUIControl();
		if (controlObj instanceof Control) {
			Control control = (Control) controlObj;
			control.setVisible(isVisible());
		}
	}

	/**
	 * 
	 */
	private void clearButtonClicked() {
		Dialog dialog = MessageDialogWithToggle.openYesNoQuestion(activeShell(), "Confirm",
				"Do you want to clear the input fields?", null, confirmClear, PlatformUI.getPreferenceStore(),
				getClass().getName() + ".confirmClear");
		if (confirmClear || dialog.open() == Dialog.OK) {
			resetJournalEntryInputs();
		}
		clearActionObserver.widgetSelected(null);
	}

	/**
	 * 
	 */
	private void addButtonClicked() {
		try {
			validate(workingJournalLine);
			addActionObserver.widgetSelected(null);
			resetJournalEntryInputs();
		} catch (final ValidationError invalid) {
			MessageDialogWithToggle.openError(null, "Validation Error", invalid.getMessage());
		}
	}

	private void qualityButtonClicked(boolean enabled) {
		// TODO Auto-generated method stub

	}

	protected void handleRejectedPropertyChange(PropertyChangeEvent evt) {
		boolean newRejectedValue = (Boolean) evt.getNewValue();
		if (newRejectedValue && evt.getNewValue() != evt.getOldValue()) {
			// MessageDialog.openQuestion(activeShell(),
			// "Milk Rejection Reason", "Enter reason milk was rejected -");
		}
	}

	/**
	 * Reset the working memory used by the journal line widgets, saving the bin
	 * value if set.
	 * 
	 */
	private void resetJournalEntryInputs() {
		resetJournalEntryInputs(true);
	}

	/**
	 * Reset the working memory used by the journal line widgets, saving the bin
	 * value 'holdContainer' is 'true'.
	 * 
	 * @param holdContainer
	 *            true if the value of 'bin' is to be held.
	 */
	private void resetJournalEntryInputs(boolean holdContainer) {

		workingJournalLine.eSetDeliver(false);
		for (EStructuralFeature feature : DairyPackage.Literals.COLLECTION_JOURNAL_LINE.getEAllStructuralFeatures()) {
			if (holdContainer && feature.equals(DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER))
				continue;
			workingJournalLine.eSet(feature, feature.getDefaultValue());
		}
		workingJournalLine.eSetDeliver(true);

		updateAllRidgetsFromModel();

		if (holdContainer && workingJournalLine.getDairyContainer() != null) {
			canText.requestFocus();
		} else {
			binCombo.requestFocus();
		}
	}

	/**
	 * TODO: use validators, check more conditions..
	 * 
	 * @param line
	 */
	private void validate(CollectionJournalLine line) {
		if (line == null) {
			throw new IllegalStateException();
		}
		if (validateBin && line.getDairyContainer() == null) {
			throw new ValidationError("BIN number is required!");
		}
		if ((line.getQuantity() == null) || line.getQuantity().equals(BigDecimal.ZERO)) {
			throw new ValidationError("Quantity must be greater than zero!");
		}
		if (validateMember && (line.getRecordedMember() == null) || (line.getRecordedMember().length() <= 0)) {
			throw new ValidationError("Invalid member number!");
		}
	}

	private void updateAllRidgetsFromModel() {
		for (IRidget ridget : getRidgets()) {
			ridget.updateFromModel();
		}
	}

	// public void hide(boolean dontShow) {
	// if (dontShow == cachedHideState) {
	// return;
	// }
	// cachedHideState = dontShow;
	// Object obj = getUIControl();
	// if (obj instanceof CollectionsEntryPanel) {
	// CollectionsEntryPanel panel = (CollectionsEntryPanel) obj;
	// panel.hide(cachedHideState);
	// }
	// }
	//
	// @Override
	// protected void bindUIControl() {
	// super.bindUIControl();
	// hide(cachedHideState);
	// }

	private static final Shell activeShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

}
