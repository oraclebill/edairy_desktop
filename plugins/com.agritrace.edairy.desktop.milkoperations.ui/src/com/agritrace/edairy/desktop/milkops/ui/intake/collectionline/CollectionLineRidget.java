package com.agritrace.edairy.desktop.milkops.ui.intake.collectionline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.riena.ui.ridgets.validation.IValidationCallback;
import org.eclipse.riena.ui.ridgets.validation.ValidatorCollection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.internal.milkops.ui.Activator;
import com.agritrace.edairy.desktop.milkops.ui.intake.ViewWidgetId;

public class CollectionLineRidget extends AbstractCompositeRidget implements ICollectionLineRidget {

	public static final String CONFIRM_CLEAR_COLLECTION_LINE = CollectionLineRidget.class.getName() + ".confirmClear";

	private static Color SUCCESS_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
	private static Color WARNING_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_CYAN);
	private static Color ERROR_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_RED);
	private static Color NORMAL_COLOR = AbstractDirectoryController.getDisplay().getSystemColor(SWT.COLOR_BLACK);

	private IComboRidget binCombo;
	private ITextRidget canText;
	private IComboRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	private IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;
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
	boolean cachedHideState = false;

	// working memory
	private CollectionJournalLine workingJournalLine;
	private List<Bin> binList;
	private ICompositeRidget qualityGroup;
	private final ValidatorCollection validatorCollection;
	private Bin savedContainer;

	private IMemberLookup memberInfoProvider;
	private IValidator routeValidator;

	public CollectionLineRidget() {
		validatorCollection = new ValidatorCollection();
	}

	@Override
	public void setBinList(List<Bin> binList) {
		this.binList = binList;
	}

	@Override
	public void setMemberInfoProvider(IMemberLookup provider) {
		this.memberInfoProvider = provider;
	}

	@Override
	public IMemberLookup getMemberInfoProvider() {
		return this.memberInfoProvider;
	}

	@Override
	public List<Bin> getBinList() {
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
		final Collection<IValidator> toBeRemoved = validatorCollection.getValidators();
		for (final IValidator dumpMe : toBeRemoved) {
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
		// service.getBoolean("com.agritrace.edairy.desktop.milkops.ui.components",
		// "confirmClearCollectionsEntryAction", true, null);
		// validateBin =
		// service.getBoolean("com.agritrace.edairy.desktop.milkops.ui.components",
		// "validateBinOnAddLine", true, null);
		// validateMember =
		// service.getBoolean("com.agritrace.edairy.desktop.milkops.ui.components",
		// "validateMemberOnAddLine", true, null);

		//
		// get ridgets
		//

		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		binCombo.setMandatory(true);

		memberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberNameText);

		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		canText.setDirectWriting(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);
		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);

		qualityButton = getRidget(IToggleButtonRidget.class, "display-quality-controls-button");
		qualityGroup = getRidget(ICompositeRidget.class, "quality-group");

		milkfatTxt = getRidget(IDecimalTextRidget.class, "milk-fat-percent-text");
		milkfatTxt.setDirectWriting(true);

		alcoholPercentTxt = getRidget(IDecimalTextRidget.class, "alcohol-percent-text");
		alcoholPercentTxt.setDirectWriting(true);

		addedWaterButton = getRidget(IToggleButtonRidget.class, "added-water-checkbox");

		addButton = getRidget(IActionRidget.class, ViewWidgetId.addButton);
		clearButton = getRidget(IActionRidget.class, ViewWidgetId.entryInputClear);

		//
		// configure ridgets
		//

// markerViewer.addRidget(memberIDRidget);
// markerViewer.addMarkerType(MandatoryErrorMarker.class);
// markerViewer.setVisible(true);

		// member number
		memberIDRidget = getRidget(IComboRidget.class, ViewWidgetId.memberIdText);
		memberIDRidget.setMandatory(true);
		// FIXME: disabled quick entry of 'NPR' and 'REJECTED' statuses
// memberIDRidget.setInputToUIControlConverter(new InlineInputFlagConverter(this, String.class, String.class));
		memberIDRidget.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
// final String oldVal = normalizeMemberNumber(evt.getOldValue());
// final String newVal = normalizeMemberNumber(evt.getNewValue());
				Object oldVal, newVal;
				oldVal = evt.getOldValue();
				newVal = evt.getNewValue();
				if (!oldVal.equals(newVal)) {
					updateValidatedMember((String) newVal);
					updateMemberNameText();
				}
			}
		});

		// quantity
		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		quantityText.setMandatory(true);
		quantityText.setDirectWriting(true);

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

	@Override
	public void createCollectionLine() {
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		if (getBinList() == null) {
			throw new IllegalArgumentException("No bin list. Call setBinList before binding!");
			// binList = Collections.EMPTY_LIST;
		}
		workingJournalLine.setFlagged(false);

		binCombo.bindToModel(new WritableList(binList, Bin.class), Bin.class,
				"getTrackingNumber", PojoObservables.observeValue(workingJournalLine,
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER.getName()));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

// final ListBean input = new ListBean(memberInfoProvider.findAllMemberInfo(true));
		WritableList memberIdList = new WritableList(memberInfoProvider.findAllMemberNumbers(true), String.class);
		IObservableValue memberNumberObservable = EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER);
		memberIDRidget.bindToModel(memberIdList, String.class, "toString", memberNumberObservable);

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
	 * Updates the enabled state of the complex UI control (and of the UI controls it contains). This default
	 * implementation does nothing and should be overridden by subclasses.
	 */
	@Override
	protected void updateEnabled() {
		super.updateEnabled();
		final boolean enabled = this.isEnabled();
		log(LogService.LOG_DEBUG, " ** updateEnabled: " + enabled);
		for (final IRidget ridget : getRidgets()) {
			ridget.setEnabled(enabled);
		}
	}

	protected void clearJournalLine(boolean saveBin) {
		if (workingJournalLine == null) {
			return;
		}
		for (final EStructuralFeature feature : DairyPackage.Literals.COLLECTION_JOURNAL_LINE
				.getEAllStructuralFeatures()) {
			if (saveBin && feature != DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER) {
				workingJournalLine.eSet(feature, feature.getDefaultValue());
			}
		}
		updateAllRidgetsFromModel();
	}

	/**
	 *
	 */
	private void handleClearLine() {
		log(LogService.LOG_DEBUG, "\nhandleClearLine: journal-line: %s\n", workingJournalLine);
// IPreferenceStore prefStore = PlatformUI.getPreferenceStore();
// boolean confirmClear = prefStore.getBoolean(CONFIRM_CLEAR_COLLECTION_LINE);
// if (confirmClear) {
// Dialog dialog = MessageDialogWithToggle.openYesNoQuestion(getShell(), "Confirm",
// "Are you sure you want to clear the input fields?", null, confirmClear, prefStore,
// CONFIRM_CLEAR_COLLECTION_LINE);
		if (MessageDialog.openQuestion(getShell(), "Confirm", "Are you sure you want to clear the input fields?")) {
			clearJournalLine(true);
		}
// }
	}

	/**
	 *
	 *
	 */
	private void handleSaveLine() {
		IValidationCallback callback = new IValidationCallback() {
			@Override
			public void validationRuleChecked(IValidator validationRule, IStatus status) {
				System.err.format("Validating %s: %s", validationRule, status);
			}

			@Override
			public void validationResult(IStatus status) {
				System.err.format("Result %s", status);
			}
		};
		final IStatus result = validatorCollection.validate(workingJournalLine, callback);
		log(LogService.LOG_DEBUG, "handleSaveLine: journal-line: %s, validation result: [%s]\n", workingJournalLine,
				result);
		if (result.isOK()) {
			savedContainer = workingJournalLine.getDairyContainer();
			firePropertyChange(VALIDATED_VALUE, null, workingJournalLine);
		} else if (result.matches(IStatus.WARNING | IStatus.INFO)) {
// markerViewer.setVisible(true);
			if (displaySuspendMessage(result)) {
				workingJournalLine.setFlagged(true);
				savedContainer = workingJournalLine.getDairyContainer();
				firePropertyChange(VALIDATED_VALUE, null, workingJournalLine);
			}
		} else if (result.matches(IStatus.ERROR | IStatus.CANCEL)) {
			displayMessage(result);
		}
	}

	protected void displayMessage(final IStatus validationResult) {
		displayMessage(validationResult, IStatus.ERROR | IStatus.CANCEL);
	}

	protected void displayMessage(final IStatus validationResult, int mask) {
		final StringBuffer message = new StringBuffer();
		final Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (final IStatus status : statusList) {
			if (status.matches(mask)) {
// formatter.format("[%s] %s: %s\n", status.getCode(), status.getSeverity(), status.getMessage());
				System.err.println("status: " + status.getClass().getName());
				System.err.println("Severity: " + status.getSeverity());
				System.err.println("MAsk: " + mask);

				formatter.format("%s\n", status.getMessage());
			}
		}
		try {
			MessageDialog.openError(getShell(), "Validation Error(s)", message.toString());
		} catch (final Exception e) {
			e.printStackTrace();
			System.err.println(message.toString());
		}
	}

	protected boolean displaySuspendMessage(final IStatus validationResult) {
		boolean ret = false;
		final StringBuffer message = new StringBuffer();
		final Formatter formatter = new Formatter(message);
		IStatus[] statusList;
		if (validationResult.isMultiStatus()) {
			statusList = validationResult.getChildren();
		} else {
			statusList = new IStatus[] { validationResult };
		}
		for (final IStatus status : statusList) {
			if (status.matches(IStatus.WARNING | IStatus.INFO)) {
				System.err.printf("[%s] %s: %s\n", status.getClass().getName(), status.getSeverity(),
						status.getMessage());
				formatter.format("%s\n", status.getMessage());
			}
		}
		try {
			formatter.format("\n\nSelect 'Yes' to suspend this record, or 'No' to correct the error(s)");
			ret = MessageDialog.openQuestion(getShell(), "Suspend Confirmation", message.toString());
		} catch (final Exception e) {
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
			final boolean newRejectedValue = (Boolean) evt.getNewValue();
			if (newRejectedValue && evt.getNewValue() != evt.getOldValue()) {
				// MessageDialog.openQuestion(activeShell(),
				// "Milk Rejection Reason", "Enter reason milk was rejected -");
			}
		}
	}

	private void setJournalLineFocus() {
		if (workingJournalLine.getDairyContainer() != null) {
			memberIDRidget.requestFocus();
		} else {
			binCombo.requestFocus();
		}
	}

	private void updateAllRidgetsFromModel() {
		for (final IRidget ridget : getRidgets()) {
			ridget.updateFromModel();
		}
		updateMemberNameText();
	}

	private String normalizeMemberNumber(Object memberString) {
		String normal = "";
		String prefix = "";
		if (memberString instanceof String) {
			normal = ((String) memberString).trim();
			while (normal.length() > 0 && (normal.startsWith("0") || !Character.isDigit(normal.charAt(0)))) {
				if (Character.isLetter(normal.charAt(0))) {
					prefix += normal.charAt(0);
				}
				normal = normal.substring(1);
			}
		}
		if (normal.length() < 5) {
			normal = "00000".substring(normal.length()) + normal;
		}
		if (normal.length() > 5) {
			normal = "";
			prefix = "";
		}
		return (prefix + normal).toUpperCase();
	}

	private void updateValidatedMember(String memberId) {
		final Membership member = memberInfoProvider.getMember(memberId);
		workingJournalLine.setValidatedMember(member);

	}

	private void updateMemberNameText() {
		String memberNameText = "<unknown>";
		final Label label = (Label) memberNameRidget.getUIControl();
		if (label != null) {
			label.setForeground(NORMAL_COLOR);
		}
		final Membership member = workingJournalLine.getValidatedMember();
		if (member != null) {
// workingJournalLine.setValidatedMember(member);
			memberNameText = formatPersonName(member.getFarmer());
			if (label != null) {
				if (routeValidator == null || routeValidator.validate(member).isOK()) {
					label.setForeground(SUCCESS_COLOR);
				} else {
					label.setForeground(WARNING_COLOR);
				}
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

	public void setMPRMissing(boolean b) {
		this.nprMissingButton.setSelected(b);
	}

	public void setRejected(boolean b) {
		this.rejectedButton.setSelected(b);
	}

}
