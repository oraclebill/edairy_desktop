package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
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
import org.eclipse.jface.preference.IPreferenceStore;
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
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;

public class CollectionLineRidget extends AbstractCompositeRidget implements ICollectionLineRidget {

	public static final String CONFIRM_CLEAR_COLLECTION_LINE = CollectionLineRidget.class.getName() + ".confirmClear";

	private static Color SUCCESS_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
	private static Color WARNING_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_CYAN);
	private static Color ERROR_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_RED);
	private static Color NORMAL_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_BLACK);

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

	private IMemberInfoProvider memberInfoProvider;
	private IValidator routeValidator;
	
//	private IMessageMarkerViewer markerViewer;

	public CollectionLineRidget() {
		validatorCollection = new ValidatorCollection();
//		markerViewer = new TooltipMessageMarkerViewer();
		
	}

	@Override
	public void setBinList(List<DairyContainer> binList) {
		this.binList = binList;
	}

	@Override
	public void setMemberInfoProvider(IMemberInfoProvider provider) {
		this.memberInfoProvider = provider;
	}
	
	@Override
	public IMemberInfoProvider getMemberInfoProvider() {
		return this.memberInfoProvider;
	}
	
	@Override
	public List<DairyContainer> getBinList() {
		return binList;
	}

	public IValidator getRouteValidator() {
		return routeValidator;
	}

	@Override
	public void setRouteValidator(IValidator routeValidator) {
		this.routeValidator = routeValidator;
	}

	@Override
	synchronized public void addValidator(IValidator vc) {
		validatorCollection.add(vc);
	}

	@Override
	public void removeValidator(IValidator vc) {
		validatorCollection.remove(vc);
	}
	
	@Override
	synchronized public void clearValidators() {
		Collection<IValidator> toBeRemoved = validatorCollection.getValidators();
		for (IValidator dumpMe : toBeRemoved) {
			validatorCollection.remove(dumpMe);
		}
	}


	@Override
	public void configureRidgets() {
		super.configureRidgets();

		//
		// get preferences
		//

		// IPreferencesService service = Platform.getPreferencesService();
		// confirmClear =
		// service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
		// "confirmClearCollectionsEntryAction", true, null);
		// validateBin =
		// service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
		// "validateBinOnAddLine", true, null);
		// validateMember =
		// service.getBoolean("com.agritrace.edairy.desktop.collection.ui.components",
		// "validateMemberOnAddLine", true, null);

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

//		markerViewer.addRidget(memberIDRidget);
//		markerViewer.addMarkerType(MandatoryErrorMarker.class);
//		markerViewer.setVisible(true);

		// bin
		binCombo.setMandatory(true);

		// member number
		memberIDRidget.setMandatory(true);
		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new InlineInputFlagConverter(this, String.class, String.class));
		memberIDRidget.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				final String oldVal = normalizeMemberNumber(evt.getOldValue());
				final String newVal = normalizeMemberNumber(evt.getNewValue());
				if (! oldVal.equals(newVal)) {
					updateValidatedMember(newVal);
					updateMemberNameText();
				}
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
				handleSaveLine();
			}
		});

		// clear line button
		clearButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleClearLine();
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




	protected void sillyNormalize(Object memberString) {
		
		String rawMemberNum = (String) memberString;
		String prefix = "";
		String digits = "";
		String suffix = "";
		int state = 0;
		int i = 0;
		boolean done = false;
		while (!done) {
			char cur = rawMemberNum.charAt(i);
			switch(state) {
			case 0: // initial
				if ( Character.isLetter(cur) ) {
					prefix = prefix + cur;
					break;
				} else if ( Character.isDigit(cur )) {
					digits = digits + cur;
					state = 1;
					break;
				} else {
					break;
				}
			case 1:
				if ( Character.isDigit(cur) ) {
					digits = digits + cur;
					break;
				} else {
					state = 2;
				} 
			case 2:
				if ( Character.isDigit(cur) ) {
					done = true;
					break;
				} else if (Character.isLetter(cur)) {
					suffix = suffix + cur;
				} else {
					break;
				}
			}
			if (++i > 15) done = true;
		}
	}

	@Override
	public void createCollectionLine() {
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		if (getBinList() == null) {
			throw new IllegalArgumentException("No bin list. Call setBinList before binding!");
			// binList = Collections.EMPTY_LIST;
		}
		binCombo.bindToModel(new WritableList(binList, DairyContainer.class), DairyContainer.class, "getContainerId",
				PojoObservables.observeValue(workingJournalLine,
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER.getName()));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

		memberIDRidget.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER));
		// memberNameRidget.bindToModel(workingJournalLine,
		// "validatedMember.member" );
		// memberNameRidget.setModelToUIControlConverter(new
		// PersonToFormattedNameConverter("<unknown>"));
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
		log(LogService.LOG_DEBUG, " ** updateEnabled: " + enabled);
		for (IRidget ridget : getRidgets()) {
			ridget.setEnabled(enabled);
		}
	}

	protected void clearJournalLine(boolean saveBin) {
		if (workingJournalLine == null)
			return;
		for (EStructuralFeature feature : DairyPackage.Literals.COLLECTION_JOURNAL_LINE.getEAllStructuralFeatures()) {
			if (saveBin && feature != DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER)
				workingJournalLine.eSet(feature, feature.getDefaultValue());
		}
		updateAllRidgetsFromModel();
	}

	/**
	 * 
	 */
	private void handleClearLine() {
		log(LogService.LOG_DEBUG, "\nhandleClearLine: journal-line: %s\n", workingJournalLine);
//		IPreferenceStore prefStore = PlatformUI.getPreferenceStore();
//		boolean confirmClear = prefStore.getBoolean(CONFIRM_CLEAR_COLLECTION_LINE);
//		if (confirmClear) {
//			Dialog dialog = MessageDialogWithToggle.openYesNoQuestion(getShell(), "Confirm",
//					"Are you sure you want to clear the input fields?", null, confirmClear, prefStore,
//					CONFIRM_CLEAR_COLLECTION_LINE);
			if (MessageDialog.openQuestion(getShell(), "Confirm",
					"Are you sure you want to clear the input fields?")) {
				clearJournalLine(true);
			}
//		}
	}

	/**
	 * 
	 */
	private void handleSaveLine() {
		IStatus result = validatorCollection.validate(workingJournalLine);
		log(LogService.LOG_DEBUG, "handleSaveLine: journal-line: %s, validation result: [%s]\n", workingJournalLine, result);
		if (result.isOK()) {
			savedContainer = workingJournalLine.getDairyContainer();
			firePropertyChange(VALIDATED_VALUE, null, workingJournalLine);
		} 
		else if (result.matches(IStatus.WARNING | IStatus.INFO )) {
//			markerViewer.setVisible(true);
			if(displaySuspendMessage(result)) {
				workingJournalLine.setFlagged(true);
				savedContainer = workingJournalLine.getDairyContainer();
				firePropertyChange(VALIDATED_VALUE, null, workingJournalLine);
			}
		}
		else if (result.matches(IStatus.ERROR | IStatus.CANCEL )) {
			displayMessage(result);
		} 
	}

	protected void displayMessage(final IStatus validationResult) {
		displayMessage(validationResult, IStatus.ERROR | IStatus.CANCEL);
	}
	
	protected void displayMessage(final IStatus validationResult, int mask) {
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (IStatus status : statusList) {
			if (status.matches(mask)) {
//				formatter.format("[%s] %s: %s\n", status.getCode(), status.getSeverity(), status.getMessage());
				System.err.println("status: " + status.getClass().getName());
				System.err.println("Severity: " + status.getSeverity());
				System.err.println("MAsk: " + mask);
				
				formatter.format("%s\n", status.getMessage());
			}
		}
		try {
			MessageDialog.openError(getShell(), "Validation Error(s)", message.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(message.toString());
		}
	}
	
	protected boolean displaySuspendMessage(final IStatus validationResult) {
		boolean ret = false;
		StringBuffer message = new StringBuffer();
		Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (IStatus status : statusList) {
			if (status.matches(IStatus.WARNING | IStatus.INFO)) {
				System.err.printf("[%s] %s: %s\n", status.getClass().getName(), status.getSeverity(), status.getMessage());
				formatter.format("%s\n",  status.getMessage());
			}
		}
		try {
			formatter.format("\n\nSelect 'Yes' to suspend this record, or 'No' to correct the error(s)");
			ret = MessageDialog.openQuestion(getShell(), "Suspend Confirmation", message.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(message.toString());
		}
		return ret;
	}

	/**
	 * 
	 */
	public void enableQualityWidgets(boolean enabled) {
		qualityGroup.setEnabled(enabled);
		qualityGroup.setVisible(enabled);
		// for(IRidget ridget : qualityGroup.getRidgets()) {
		// ridget.setEnabled(enabled);
		// }
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

	// /**
	// * Reset the working memory used by the journal line widgets, saving the
	// bin value if set.
	// *
	// */
	// private void resetJournalEntryInputs() {
	// resetJournalEntryInputs(true);
	// }

	// /**
	// * Reset the working memory used by the journal line widgets, saving the
	// bin value 'holdContainer' is 'true'.
	// *
	// * @param holdContainer
	// * true if the value of 'bin' is to be held.
	// */
	// private void resetJournalEntryInputs(boolean holdContainer) {
	// log(LogService.LOG_DEBUG, "resetJournalEntryInputs: " +
	// workingJournalLine.getDairyContainer());
	// for (EStructuralFeature feature :
	// DairyPackage.Literals.COLLECTION_JOURNAL_LINE.getEAllStructuralFeatures())
	// {
	// if (holdContainer &&
	// feature.equals(DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER))
	// continue;
	// workingJournalLine.eSet(feature, feature.getDefaultValue());
	// }
	// log(LogService.LOG_DEBUG, " (after) resetJournalEntryInputs: " +
	// workingJournalLine.getDairyContainer());
	//
	// updateAllRidgetsFromModel();
	// setJournalLineFocus();
	// }
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

	private String normalizeMemberNumber(Object memberString) {
		String normal = "";
		String prefix = "";
		if (memberString instanceof String) {			
			normal = ((String) memberString).trim();
			while(normal.length() > 0 
					&& (normal.startsWith("0") 
							|| !Character.isDigit(normal.charAt(0)))) {
				if (Character.isLetter(normal.charAt(0))) {
					prefix += normal.charAt(0);
				}
				normal = normal.substring(1);
			}
		}
		if (normal.length()< 5) {
			normal = "00000".substring(normal.length()) + normal;
		}
		if (normal.length() > 5) {
			normal = "";
			prefix = "";
		}
		return (prefix + normal).toUpperCase();
	}
	
	private void updateValidatedMember(String memberId) {
		Membership member = memberInfoProvider.getMember(memberId);
		workingJournalLine.setValidatedMember(member);
		
	}

	private void updateMemberNameText() {
		String memberNameText = "<unknown>";
		Label label = (Label) memberNameRidget.getUIControl();
		if (label != null) {
			label.setForeground(NORMAL_COLOR);
		}
		Membership member = workingJournalLine.getValidatedMember();
		if (member != null) {
//			workingJournalLine.setValidatedMember(member);
			memberNameText = formatPersonName(member.getMember());
			if (label != null) {
				if (routeValidator == null || routeValidator.validate(member).isOK())
					label.setForeground(SUCCESS_COLOR);
				else 
					label.setForeground(WARNING_COLOR);
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

	/**
	 * 
	 */
	private void log(int level, String message, Object... args) {
		Log4r.getLogger(Activator.getDefault(), getClass()).log(level, String.format(message, args));
	}

	public static Shell getShell() {
		return AbstractDirectoryController.getShell();
	}

	@Override
	public CollectionJournalLine getWorkingCollectionLine() {
		return workingJournalLine;
	}


}
