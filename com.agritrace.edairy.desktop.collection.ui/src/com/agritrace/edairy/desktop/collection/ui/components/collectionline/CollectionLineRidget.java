package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Formatter;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.validation.ValidatorCollection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.components.validators.MandatoryFieldsCheck;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

@SuppressWarnings("restriction")
public class CollectionLineRidget extends AbstractCompositeRidget implements ICollectionLineEditRidget {

	private static  Color SUCCESS_COLOR;
	private static  Color WARNING_COLOR;
	private static  Color ERROR_COLOR;
	private static  Color NORMAL_COLOR;
	
	static {
		Display display;
		try {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		catch(Exception e ) {
			display = Display.getCurrent();
		}
		SUCCESS_COLOR = display.getSystemColor(SWT.COLOR_GREEN);
		WARNING_COLOR = display.getSystemColor(SWT.COLOR_YELLOW);
		ERROR_COLOR = display.getSystemColor(SWT.COLOR_RED);
		NORMAL_COLOR = display.getSystemColor(SWT.COLOR_BLACK);
	}
	
	private IComboRidget binCombo;
	private ITextRidget canText;
	private ITextRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	IToggleButtonRidget rejectedButton;
	private IToggleButtonRidget qualityButton;
	private ITextRidget milkfatTxt;
	private ITextRidget alcoholPercentTxt;
	private IToggleButtonRidget addedWaterButton;
	private IActionRidget addButton;
	private IActionRidget clearButton;

	// preferences
	boolean validateBin = true;
	boolean validateMember = true;
	boolean confirmClear = true;

	// working memory
	private CollectionJournalLine workingJournalLine;
	private List<DairyContainer> binList;
	boolean cachedHideState = false;
	private ICompositeRidget qualityGroup;
	private final ValidatorCollection validatorCollection;
	private DairyContainer savedContainer;

	public CollectionLineRidget() {
		validatorCollection = new ValidatorCollection();
		addValidator(new MandatoryFieldsCheck(this));
	}

	@Override
	public void setBinList(List<DairyContainer> binList) {
		this.binList = binList;
	}

	@Override
	public List<DairyContainer> getBinList() {
		return binList;
	}

	@Override
	public void addValidator(IValidator vc) {
		validatorCollection.add(vc);
	}

	@Override
	public void removeValidator(IValidator vc) {
		 validatorCollection.remove(vc);
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

		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);
		
		qualityButton = getRidget(IToggleButtonRidget.class, "display-quality-controls-button");
		qualityGroup = getRidget(ICompositeRidget.class, "quality-group");
		milkfatTxt = getRidget(IDecimalTextRidget.class, "milk-fat-percent-text");
		alcoholPercentTxt = getRidget(IDecimalTextRidget.class, "alcohol-percent-text");
		addedWaterButton = getRidget(IToggleButtonRidget.class, "added-water-checkbox");

		addButton = getRidget(IActionRidget.class, ViewWidgetId.addButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.entryInputClear);

		//
		// configure ridgets
		//

		// bin
		binCombo.setMandatory(true);

		// member number
		memberIDRidget.setMandatory(true);
//		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new InlineInputFlagConverter(this, String.class, String.class));
		memberIDRidget.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				updateMemberNameText();
			}
		});

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
		addButton.setFocusable(true);
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

		qualityButton.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				log(LogService.LOG_DEBUG, "qualityButton: propertyChange: " + evt);
				enableQualityWidgets(qualityButton.isSelected());
			}
		});
	}

	@Override
	public void createCollectionLine() {
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		if (getBinList() == null) {
			throw new IllegalArgumentException("No bin list. Call setBinList before binding!");
//			binList = Collections.EMPTY_LIST;
		}
		binCombo.bindToModel(new WritableList(binList, DairyContainer.class), DairyContainer.class, "getContainerId",
				PojoObservables.observeValue(workingJournalLine,
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER.getName()));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

		memberIDRidget.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER));
//		memberNameRidget.bindToModel(workingJournalLine, "validatedMember.member" );
//		memberNameRidget.setModelToUIControlConverter(new PersonToFormattedNameConverter("<unknown>"));
		nprMissingButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED));

		rejectedButton.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED));

		quantityText.bindToModel(workingJournalLine, DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY.getName());

		milkfatTxt.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE.getName());

		alcoholPercentTxt.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE.getName());

		addedWaterButton.bindToModel(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__WATER_ADDED.getName());
		
		if (savedContainer != null && workingJournalLine.getDairyContainer() == null) {
			workingJournalLine.setDairyContainer(savedContainer);
		}
		updateAllRidgetsFromModel();
		enableQualityWidgets(false);
		setJournalLineFocus();
		
	}
	
	/**
	 * Updates the enabled state of the complex UI control (and of the UI
	 * controls it contains). This default implementation does nothing and
	 * should be overridden by subclasses.
	 */
	@Override
	protected void updateEnabled() {
		super.updateEnabled();
		boolean enabled = this.isEnabled();
		for (IRidget ridget : getRidgets()) {
			log(LogService.LOG_DEBUG, " ** Enabling: " + ridget);
			ridget.setEnabled(enabled);
		}
	}

	protected void clearJournalLine() {
		if (workingJournalLine == null ) return;
		
		for (EStructuralFeature feature : DairyPackage.Literals.COLLECTION_JOURNAL_LINE.getEAllStructuralFeatures()) {
			workingJournalLine.eSet(feature, feature.getDefaultValue());
		}
	}

	/**
	 * 
	 */
	private void clearButtonClicked() {
		Dialog dialog = MessageDialogWithToggle.openYesNoQuestion(activeShell(), "Confirm",
				"Are you sure you want to clear the input fields?", null, confirmClear, PlatformUI.getPreferenceStore(),
				getClass().getName() + ".confirmClear");
		if (confirmClear || dialog.open() == Dialog.OK) {
			clearJournalLine();
		}
	}


	/**
	 * 
	 */
	private void addButtonClicked() {
		IStatus result = validatorCollection.validate(workingJournalLine);
		if (result.isOK()) {
			savedContainer = workingJournalLine.getDairyContainer();
			firePropertyChange(VALIDATED_VALUE, null, workingJournalLine);
//			resetJournalEntryInputs();
		} else {
			displayMessage(result);
		}
	}

	protected void displayMessage(final IStatus validationResult) {
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (IStatus status : statusList) {
			formatter.format("[%s] %s: %s\n", status.getCode(), status.getSeverity(), status.getMessage());
		}
		try {
			MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Validation Error(s)",
					message.toString());
		}
		catch(Exception e) {			
			e.printStackTrace();
			System.err.println(message.toString());
		}
	}

	/**
	 * 
	 */
	public void enableQualityWidgets(boolean enabled) {
		qualityGroup.setEnabled(enabled);
		qualityGroup.setVisible(enabled);
//		for(IRidget ridget : qualityGroup.getRidgets()) {
//			ridget.setEnabled(enabled);
//		}
	}

	/**
	 * 
	 */
	protected void handleRejectedPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("selected")) {
			boolean newRejectedValue = (Boolean) evt.getNewValue();
			if (newRejectedValue && evt.getNewValue() != evt.getOldValue()) {
				// MessageDialog.openQuestion(activeShell(),
				// "Milk Rejection Reason", "Enter reason milk was rejected -");
			}
		}
	}

//	/**
//	 * Reset the working memory used by the journal line widgets, saving the bin value if set.
//	 * 
//	 */
//	private void resetJournalEntryInputs() {
//		resetJournalEntryInputs(true);
//	}

//	/**
//	 * Reset the working memory used by the journal line widgets, saving the bin value 'holdContainer' is 'true'.
//	 * 
//	 * @param holdContainer
//	 *            true if the value of 'bin' is to be held.
//	 */
//	private void resetJournalEntryInputs(boolean holdContainer) {
//		log(LogService.LOG_DEBUG, "resetJournalEntryInputs: " + workingJournalLine.getDairyContainer());
//		for (EStructuralFeature feature : DairyPackage.Literals.COLLECTION_JOURNAL_LINE.getEAllStructuralFeatures()) {
//			if (holdContainer && feature.equals(DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER))
//				continue;
//			workingJournalLine.eSet(feature, feature.getDefaultValue());
//		}
//		log(LogService.LOG_DEBUG, " (after) resetJournalEntryInputs: " + workingJournalLine.getDairyContainer());
//
//		updateAllRidgetsFromModel();
//		setJournalLineFocus();
//	}
//	
	private void setJournalLineFocus() {
		if (workingJournalLine.getDairyContainer() != null) {
			canText.requestFocus();
		} else {
			binCombo.requestFocus();
		}
	}

	private void updateAllRidgetsFromModel() {
		for (IRidget ridget : getRidgets()) {
			ridget.updateFromModel();
		}
		updateMemberNameText();
	}

	private void updateMemberNameText() {
		String memberNameText = "<unknown>";
		Label label = (Label)memberNameRidget.getUIControl();
		if (label != null) {
			label.setForeground(NORMAL_COLOR);
		}
		Membership member = workingJournalLine.getValidatedMember();
		if (member == null) {
			String memberId = memberIDRidget.getText();
			if (memberId != null && memberId.trim().length() > 0) {
				member = DairyRepository.getInstance().getMemberByMemberId(memberId);
			}
		}
		if (member != null) {
			workingJournalLine.setValidatedMember(member);
			memberNameText = formatPersonName(member.getMember());
			if (label != null) {
				label.setForeground(SUCCESS_COLOR);
			}
		}
		memberNameRidget.setText(memberNameText);
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	private String formatPersonName(Person person) {
		final StringBuffer sb = new StringBuffer();
		if (person != null) {
			new Formatter(sb).format("%s, %s", person.getFamilyName(), person.getGivenName());
		}
		return sb.toString();
	}

	private static final Shell activeShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

	/**
	 * 
	 */
	private void log(int level, String message) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, message);
	}

}
