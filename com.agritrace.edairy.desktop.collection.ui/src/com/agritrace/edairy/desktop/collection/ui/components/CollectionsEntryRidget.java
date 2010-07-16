package com.agritrace.edairy.desktop.collection.ui.components;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionJournalController.ValidationError;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;

@SuppressWarnings("restriction")
public class CollectionsEntryRidget extends AbstractCompositeRidget {

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

//	private  IDairyRepository dairyRepo;
	private  List<DairyContainer> bins;

	private IComboRidget binCombo;
	private ITextRidget canText;
	private ITextRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	private IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;

	private final ActionObserver addActionObserver, clearActionObserver;
	private IActionRidget addButton;
	private IActionRidget clearButton;

	// preferences
	boolean validateBin = true;
	boolean validateMember = true;
	boolean confirmClear = true;

	// working memory
	private final /* CollectionJournalLine */ IObservableValue workingJournalLine;
	private IObservableList binList;
	

	public CollectionsEntryRidget() {
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		addActionObserver = new ActionObserver(this);
		clearActionObserver = new ActionObserver(this);
	}
	
	public void setBinList(List<DairyContainer> binList) {
		this.binList = new WritableList(binList, DairyContainer.class);
	}
	
	public void setBinList(IObservableList binList) {
		this.binList = binList; 
	}
	
	public IObservableList getBinList() {
		return binList;
	}
	
	public void bindToModel(WritableValue writableValue) {
		workingJournalLine = writableValue;
	}

	public void bindToModel(CollectionJournalLine workingJournalLine) {
		workingJournalLine = new WritableValue(workingJournalLine, CollectionJournalLine.class);
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		// get preferences 
		IPreferencesService service = Platform.getPreferencesService();
		confirmClear = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components", "confirmClearCollectionsEntryAction", true, null);
		validateBin = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components", "validateBinOnAddLine", true, null);
		validateMember = service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components", "validateMemberOnAddLine", true, null);
				
		// get ridgets
		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		memberIDRidget = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberNameRidget = getRidget(ILabelRidget.class, "member-name");
		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		addButton = getRidget(IActionRidget.class, ViewWidgetId.addButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.clearButton);

		// configure ridgets
		
		// bin
		binCombo.setMandatory(true);
		
		// member number
		memberIDRidget.setMandatory(true);
		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new InlineInputFlagConverter(String.class, String.class));

		// quantity
		quantityText.setMandatory(true);

		// mpr (member personal record) missing button
		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		
		// milk rejection button
		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);

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
		
		bindRidgets();
	}

	private void bindRidgets() {
		// editable widgets
		// todo: should bind to bins for this route only..
		binCombo.bindToModel(binList, DairyContainer.class, "getContainerId",
				EMFObservables.observeValue(workingJournalLine,
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

		memberIDRidget.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER));

		nprMissingButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED));
		
		rejectedButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED));

		// problem children
		memberNameRidget.setText("");

		quantityText.bindToModel(PojoObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY.getName()));
	}

	@Override
	protected void updateEnabled() {
		// TODO Auto-generated method stub
		super.updateEnabled();
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
		if (confirmClear || MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Clear Input", "Do you want to clear input fields?")) {
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
			MessageDialog.openError(null, "Validation Error",
					invalid.getMessage());
		}
	}
	
	/**
	 * Reset the working memory used by the journal line widgets, saving the bin value 
	 * if set. 
	 * 
	 */
	private void resetJournalEntryInputs() {
		resetJournalEntryInputs(true);
	}
	
	/**
	 * Reset the working memory used by the journal line widgets, saving the bin value 
	 * 'holdContainer' is 'true'. 
	 * 
	 * @param holdContainer true if the value of 'bin' is to be held.
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
		}
		else {
			binCombo.requestFocus();
		}
	}

	private void validate(CollectionJournalLine line) {
		if (line == null) {
			throw new IllegalStateException();
		}
		if (validateBin && line.getDairyContainer() == null) {
			throw new ValidationError("BIN number is required!");
		}
		if ((line.getQuantity() == null)
				|| line.getQuantity().equals(BigDecimal.ZERO)) {
			throw new ValidationError("Quantity must be greater than zero!");
		}
		if (validateMember && (line.getRecordedMember() == null)
				|| (line.getRecordedMember().length() <= 0)) {
			throw new ValidationError("Invalid member number!");
		}
	}
	
	private void updateAllRidgetsFromModel() {
		for (IRidget ridget : getRidgets()) {
			ridget.updateFromModel();
		}
	}
	
	boolean cachedHideState = false;
	public void hide(boolean dontShow) {
		if (dontShow == cachedHideState) {
			return;
		}
		cachedHideState = dontShow;		
		Object obj = getUIControl();
		if (obj instanceof CollectionsEntryPanel) {
			CollectionsEntryPanel panel = (CollectionsEntryPanel) obj;
			panel.hide(cachedHideState);
		}
	}

	@Override
	protected void bindUIControl() {
		super.bindUIControl();
		hide(cachedHideState);
	}

}
