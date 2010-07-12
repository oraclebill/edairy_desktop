package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.math.BigDecimal;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.internal.collection.ui.Activator;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class MilkCollectionJournalController extends SubModuleController {

	public class MemberDeliversOncePerSessionValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			// TODO: implement
			return Status.OK_STATUS;
		}
	}

	public class MemberNumberExistsValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			String memberName = null;
			if (value instanceof String) {
				final String memberID = (String) value;
				memberName = validatedMemberNames.get(memberID);
				if (memberName == null) {
					final Membership member = dairyRepo
							.getMembershipById(memberID);
					if (member != null) {
						memberName = formatPersonName(member.getMember());
						validatedMemberNames.put(memberID, memberName);
					}
				}
			}
			if (memberName != null) {
				memberNameRidget.setText(memberName);
				return Status.OK_STATUS;
			}
			return ERROR_STATUS;
		}
	}

	public static class ValidationError extends Error {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ValidationError() {
			super();
		}

		public ValidationError(String s) {
			super(s);
		}
	}

	public static final String CAN_COLUMN_HEADER = "CAN Number";
	public static final String LINE_COLUMN_HEADER = "Line";
	public static final String MEMBER_COLUMN_HEADER = "Member ID";
	public static final String NPR_COLUMN_HEADER = "NPR Missing";
	public static final String QUANTITY_COLUMN_HEADER = "Quantity";
	public static final String REJECTED_COLUMN_HEADER = "Rejected";
	public static final String TOTAL_LABEL = "Total : ";

	private static final String[] columnNames = { LINE_COLUMN_HEADER,
			MEMBER_COLUMN_HEADER, CAN_COLUMN_HEADER, QUANTITY_COLUMN_HEADER,
			NPR_COLUMN_HEADER, REJECTED_COLUMN_HEADER };
	private static Logger LOG = Log4r.getLogger(Activator.getDefault(),
			MilkCollectionJournalController.class);

	private static final String[] propertyNames = {
			"lineNumber", "recordedMember", "farmContainer", "quantity", "notRecorded", "rejected" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	static IStatus ERROR_STATUS = new Status(Status.ERROR, Activator.PLUGIN_ID,
			"Invalid membership number");

	static final HashMap<String, String> validatedMemberNames = new HashMap<String, String>();

	private final IDairyRepository dairyRepo;
	private final List<DairyContainer> bins;

	private final boolean errorDialogsEnabled = true; // todo: get from
						
	// milk Entry group
	private ITextRidget canText;
	private IComboRidget binCombo;
	private ITextRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	private IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;

	private ITableRidget table;
	private ILabelRidget totalLabelRidget;

	private DairyContainer workingBin;

	private CollectionJournalLine workingJournalLine;

	private CollectionJournalPage workingJournalPage;
	private JournalHeaderRidget journalHeaderRidget;

	/**
	 * 
	 */
	public MilkCollectionJournalController() {
		super();
		dairyRepo = DairyRepository.getInstance();
		bins = dairyRepo.allDairyContainers();
//		drivers = dairyRepo.employeesByPosition("Driver");
//		vehicles = dairyRepo.allVehicles();
//		routes = dairyRepo.allRoutes();
	}

	private void addButtonClicked() {
		try {
			validate(workingJournalLine);

			workingJournalPage.getJournalEntries().add(workingJournalLine);
			workingJournalPage.setRecordTotal(workingJournalPage
					.getRecordTotal().add(workingJournalLine.getQuantity()));

			resetJournalEntryInputs();

		} catch (final ValidationError invalid) {
			MessageDialog.openError(null, "Validation Error",
					invalid.getMessage());
		}
	}

	/**
	 * 
	 */
	@Override
	public void afterBind() {
		super.afterBind();

		// setSubGroupsVisible(false);

		workingJournalPage = getJournalPageFromContext();

		bindHeaderRidgets();

		bindDataEntryRidgets();

		updateAllRidgetsFromModel();
	}

	/**
	 * 
	 */
	protected void bindDataEntryRidgets() {
		workingJournalLine = DairyFactory.eINSTANCE
				.createCollectionJournalLine();

		// editable widgets
		// todo: should bind to bins for this route only..
		binCombo.bindToModel(
				new WritableList(bins, DairyContainer.class),
				DairyContainer.class,
				"getContainerId",
				EMFObservables
						.observeValue(
								workingJournalLine,
								DairyPackage.Literals.COLLECTION_JOURNAL_LINE__DAIRY_CONTAINER));

		canText.bindToModel(EMFObservables.observeValue(workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FARM_CONTAINER));

		memberIDRidget
				.bindToModel(EMFObservables
						.observeValue(
								workingJournalLine,
								DairyPackage.Literals.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER));

		nprMissingButton.bindToModel(EMFObservables.observeValue(
				workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED));
		rejectedButton.bindToModel(EMFObservables.observeValue(
				workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED));

		table.bindToModel(
				EMFObservables
						.observeList(
								workingJournalPage,
								DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_ENTRIES),
				CollectionJournalLine.class, propertyNames, columnNames);

		// problem children
		memberNameRidget.setText("");

		quantityText.bindToModel(PojoObservables.observeValue(
				workingJournalLine,
				DairyPackage.Literals.COLLECTION_JOURNAL_LINE__QUANTITY
						.getName()));

		totalLabelRidget.bindToModel(PojoObservables.observeValue(
				workingJournalPage,
				DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL
						.getName()));
		totalLabelRidget.setModelToUIControlConverter(NumberToStringConverter
				.fromBigDecimal());

	}

	private void bindHeaderRidgets() {
		journalHeaderRidget.bindToModel(workingJournalPage);
	}

	/**
	 * 
	 */
	private void clearAllJournalEntiresButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Delete Milk Collection Records",
				"Do you want to delete all milk collection records?")) {
			// records.clear();
			workingJournalPage.getJournalEntries().clear();
			updateJournalTotals();
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
	}

	/**
	 * 
	 */
	private void clearMilkJournalGroupButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Clear Input", "Do you want to clear input fields?")) {
			resetJournalEntryInputs();
		}
	}

	/**
	 * 
	 */
	protected void configureDataEntryRidgets() {

		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		binCombo.setMandatory(true);
		// binCombo.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);

		// milk entry group
		memberIDRidget = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberIDRidget.setMandatory(true);
		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new Converter(String.class,
				String.class) {
			@Override
			public Object convert(Object fromObject) {
				if ((fromObject instanceof String)
						&& !((String) fromObject).isEmpty()) {
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
		});
		// memberIDRidget.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
		// final IValidator memberExistsRule = new
		// MemberNumberExistsValidator();
		// final IMessageMarker memberExistsMarker = new
		// ErrorMessageMarker("Member does not exist.");
		// memberIDRidget.addValidationRule(memberExistsRule,
		// ValidationTime.ON_UI_CONTROL_EDIT); // todo:
		// memberIDRidget.addValidationMessage(memberExistsMarker,
		// memberExistsRule);
		// memberIDRidget
		// .addValidationRule(new MemberDeliversOncePerSessionValidator(),
		// ValidationTime.ON_UPDATE_TO_MODEL); // todo:

		// memberIDRidget.addPropertyChangeListener(new PropertyChangeListener()
		// {
		// @Override
		// public void propertyChange(PropertyChangeEvent evt) {
		// if (evt.getPropertyName().equals("textAfter")) {
		// Object value = evt.getNewValue();
		// if (value instanceof String) {
		// String memberID = (String)value;
		// Membership membership = dairyRepo.getMembershipById(memberID);
		// workingJournalLine.setValidatedMember(membership);
		// System.err.println(" ----------updating from model-------- " + evt);
		// memberNameRidget.updateFromModel();
		// }
		// }
		// }
		// });

		memberNameRidget = getRidget(ILabelRidget.class, "member-name");

		canText = getRidget(ITextRidget.class, ViewWidgetId.canIdText);
		// canText.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);
		// canText.addValidationRule(new MemberOwnsCanValidator(),
		// ValidationTime.ON_UPDATE_TO_MODEL); // todo:

		quantityText = getRidget(IDecimalTextRidget.class,
				ViewWidgetId.quantityText);
		quantityText.setMandatory(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class,
				ViewWidgetId.nprMissingCombo);

		rejectedButton = getRidget(IToggleButtonRidget.class,
				ViewWidgetId.rejectedCombo);

		totalLabelRidget = getRidget(ILabelRidget.class,
				ViewWidgetId.totalLabel);

		table = getRidget(ITableRidget.class, ViewWidgetId.milkEntryTable);
		table.setColumnFormatter(2, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof CollectionJournalLine) {
					if (((CollectionJournalLine) element).getFarmContainer() != null) {
						return ""
								+ ((CollectionJournalLine) element)
										.getFarmContainer().getContainerId();
					}

				}
				return null;
			}
		});

		table.setSelectionType(SelectionType.MULTI);
		table.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				if (table.getSelection().size() == 0) {
					updateBottomButtons(false);
				} else {
					updateBottomButtons(true);
				}
			}
		});

		// buttons
		((IActionRidget) getRidget(ViewWidgetId.addButton))
				.addListener(new IActionListener() {
					@Override
					public void callback() {
						addButtonClicked();
					}
				});

		((IActionRidget) getRidget(ViewWidgetId.entryInputClear))
				.addListener(new IActionListener() {
					@Override
					public void callback() {
						clearMilkJournalGroupButtonClicked();
					}
				});

		((IActionRidget) getRidget(ViewWidgetId.modifyButton))
				.addListener(new IActionListener() {

					@Override
					public void callback() {
						// MilkCollectionRecord aRecord = (MilkCollectionRecord)
						// table.getSelection().get(0);
						// ModifyMilkRecordDialog modifyDialog = new
						// ModifyMilkRecordDialog(Display.getDefault().getActiveShell());
						// aRecord.setLine("");
						// modifyDialog.setRecord(aRecord);
						// if(modifyDialog.open() == Window.OK){
						// table.updateFromModel();
						// totalLabelRidget.updateFromModel();
						// }
					}

				});

		((IActionRidget) getRidget(ViewWidgetId.deleteButton))
				.addListener(new IActionListener() {

					@Override
					public void callback() {
						deleteJournalEntryButtonClicked();
					}
				});

		((IActionRidget) getRidget(ViewWidgetId.clearButton))
				.addListener(new IActionListener() {

					@Override
					public void callback() {
						clearAllJournalEntiresButtonClicked();
					}
				});

		((IActionRidget) getRidget(ViewWidgetId.saveButton))
				.addListener(new IActionListener() {

					@Override
					public void callback() {
						createAndSaveCollectionJournalPage();
					}
				});
	}

	private void configureHeaderRidgets() {
		journalHeaderRidget = getRidget(JournalHeaderRidget.class, "journal-header");
		journalHeaderRidget.setOutputOnly(true);

	}

	/**
	 * 
	 */
	@Override
	public void configureRidgets() {

		configureHeaderRidgets();

		configureDataEntryRidgets();

		updateBottomButtons(false);
	}


	/**
	 * Called when 'Save Page' is clicked.
	 */
	private void createAndSaveCollectionJournalPage() {

		if (!workingJournalPage.getDriverTotal().equals(
				workingJournalPage.getRecordTotal())) {
			if (!handleTotalsNotEqualOnSave()) {
				return;
			}
		}

		dairyRepo.saveNewJournalPage(workingJournalPage);

		// todo:// resetPageData(workingJournalPage);
		resetJournalEntryInputs();
	}

	/**
	 * 
	 */
	private void deleteJournalEntryButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Delete Milk Collection Records",
				"Do you want to delete the selected milk collection records?")) {
			final List<Object> selectedRecords = table.getSelection();
			if (selectedRecords != null) {
				// records.removeAll(selectedRecords);
				workingJournalPage.getJournalEntries().removeAll(
						selectedRecords);
			}
			updateJournalTotals(); // todo: test
			table.updateFromModel();
			totalLabelRidget.updateFromModel();
		}
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	String formatPersonName(Person person) {
		final StringBuffer sb = new StringBuffer();
		if (person != null) {
			new Formatter(sb).format("%s, %s", person.getFamilyName(),
					person.getGivenName());
		}
		return sb.toString();
	}

	/**
	 * 
	 */
	protected CollectionJournalPage getJournalPageFromContext() {
		CollectionJournalPage workingJournalPage = null;
		Object contextObj = null;
		final NavigationArgument navArg = getNavigationNode()
				.getNavigationArgument();
		if (navArg != null) {
			contextObj = navArg.getParameter();
		}
		if (contextObj == null) {
			LOG.log(0,
					"failed to get page from navigation - falling back to context");
			contextObj = getNavigationNode().getContext("JOURNAL_PAGE");
		}
		if (contextObj instanceof CollectionJournalPage) {
			workingJournalPage = (CollectionJournalPage) contextObj;
		} else {
			LOG.log(0, "ERROR: unable to get journal page from context.");
			throw new IllegalStateException(
					"ERROR: unable to get journal page from context.");
		}
		assert (workingJournalPage != null);
		return workingJournalPage;
	}

	/**
	 * Called when the ID specified is not valid.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return
	 */
	protected boolean handleInvalidCanID(
			final CollectionJournalLine journalLine, final String canId) {
		boolean ret = true;

		if (errorDialogsEnabled) {
			ret = MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error creating journal line",
							"Can't find container for "
									+ canId
									+ ". Do you want to continue create a new record? ");
		}

		// if we choose to continue;
		if (ret) {
			// suspend the record
			journalLine.setFlagged(true);
		}
		return ret;
	}

	/**
	 * 
	 */
	protected boolean handleInvalidMemberID(
			final CollectionJournalLine journalLine, final String memberId) {
		boolean ret = true;
		if (errorDialogsEnabled) {
			ret = MessageDialog
					.openConfirm(
							Display.getDefault().getActiveShell(),
							"Error creating collection journal record!",
							"Can't find valid membership for "
									+ memberId
									+ ". The record will be marked as Suspended. Do you want to continue create a new record? ");
		}
		return ret;
	}

	/**
	 * Called when there is no can id specified.
	 * 
	 * @param journalLine
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	protected boolean handleNoCanSpecified(
			final CollectionJournalLine journalLine) {
		// this is the normal case for now.. in the future, this may be an error
		// or warning.
		return true;
	}

	/**
	 * 
	 * @return
	 */
	private boolean handleTotalsNotEqualOnSave() {
		MessageDialog.openError(Display.getDefault().getActiveShell(),
				"Error Save Collection Journal", "Journal Total value ("
						+ workingJournalPage.getRecordTotal()
						+ ") doesn't match collection journal records total ("
						+ workingJournalPage.getDriverTotal() + ").");
		return false;
	}

	/**
	 * Called when a can id is not recognized.
	 * 
	 * @param journalLine
	 * @param canId
	 * @return false to abort the current operation (usually the 'save' of a
	 *         journal line)
	 */
	protected boolean handleUnregisteredCan(
			final CollectionJournalLine journalLine, String canId) {

		return true;
	}

	/**
	 * Reset the working memory used by the journal line widgets. Also saves the
	 * avlue of the old dairy container (bin), so it can be reused.
	 */
	private void resetJournalEntryInputs() {
		// stash or reset the working bin
		if (null != workingJournalLine) {
			workingBin = workingJournalLine.getDairyContainer();
		} else {
			workingBin = null;
		}

		// reset the working journal line.
		workingJournalLine = DairyFactory.eINSTANCE
				.createCollectionJournalLine();

		// rebind all widgets to new working line
		bindDataEntryRidgets();

		// restore stashed bin
		if (workingBin != null) {
			workingJournalLine.setDairyContainer(workingBin);
			canText.requestFocus();
		}

		// update ui with new model
		updateAllRidgetsFromModel();

	}

	/**
	 * 
	 * @param visble
	 */
	// private void setSubGroupsVisible(boolean visble) {
	// if (journalNumber != null) {
	// ((Control) journalNumber.getUIControl()).getParent().setVisible(visble);
	// }
	// if (memberIDRidget != null) {
	// ((Control)
	// memberIDRidget.getUIControl()).getParent().getParent().setVisible(visble);
	// }
	// if (table != null) {
	// ((Control)
	// table.getUIControl()).getParent().getParent().getParent().setVisible(visble);
	// }
	// }

	/**
	 * 
	 * @param enable
	 */
	private void updateBottomButtons(boolean enable) {
		((IActionRidget) getRidget(ViewWidgetId.modifyButton))
				.setEnabled(enable);
		((IActionRidget) getRidget(ViewWidgetId.deleteButton))
				.setEnabled(enable);
	}

	/**
	 * 
	 */
	private void updateJournalTotals() {
		int counter = 0;
		final BigDecimal total = new BigDecimal(0);

		for (final CollectionJournalLine line : workingJournalPage
				.getJournalEntries()) {
			line.setLineNumber(++counter);
			total.add(line.getQuantity());
		}
		workingJournalPage.setRecordTotal(total);
	}

	private void validate(CollectionJournalLine line) {
		if (line == null) {
			throw new IllegalStateException();
		}
		if (line.getDairyContainer() == null) {
			throw new ValidationError("BIN number is required!");
		}
		if ((line.getQuantity() == null)
				|| line.getQuantity().equals(BigDecimal.ZERO)) {
			throw new ValidationError("Quantity must be greater than zero!");
		}
		if ((line.getRecordedMember() == null)
				|| (line.getRecordedMember().length() <= 0)) {
			throw new ValidationError("Invalid member number!");
		}
	}
}
