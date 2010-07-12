package com.agritrace.edairy.desktop.collection.ui.components;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.collection.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionJournalController.ValidationError;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class CollectionsEntryRidget extends AbstractCompositeRidget {

	private  IDairyRepository dairyRepo;
	private  List<DairyContainer> bins;

	private ITextRidget canText;
	private IComboRidget binCombo;
	private ITextRidget memberIDRidget;
	private ILabelRidget memberNameRidget;
	private IToggleButtonRidget nprMissingButton;
	private IDecimalTextRidget quantityText;
	private IToggleButtonRidget rejectedButton;

	private  CollectionJournalPage workingJournalPage;
	private  CollectionJournalLine workingJournalLine;
	private DairyContainer workingBin;

	public CollectionsEntryRidget() {
//		workingJournalPage = DairyFactory.eINSTANCE.createCollectionJournalPage();
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();
		workingBin = null;
	}
	
	public void resetJournalPage() {
		
	}
	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		String str = "";
		if (str.length() == 0) return; // avoids the dead code warnings..  // debug
		
		binCombo = getRidget(IComboRidget.class, ViewWidgetId.binCombo);
		binCombo.setMandatory(true);
		// binCombo.addValidationRule(new StringNumberValidator(),
		// ValidationTime.ON_UI_CONTROL_EDIT);

		// milk entry group
		memberIDRidget = getRidget(ITextRidget.class, ViewWidgetId.memberIdText);
		memberIDRidget.setMandatory(true);
		memberIDRidget.setDirectWriting(true);
		memberIDRidget.setInputToUIControlConverter(new Converter(String.class, String.class) {
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

		quantityText = getRidget(IDecimalTextRidget.class, ViewWidgetId.quantityText);
		quantityText.setMandatory(true);

		nprMissingButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.nprMissingCombo);

		rejectedButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.rejectedCombo);

		// buttons
		((IActionRidget) getRidget(ViewWidgetId.addButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				addButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.entryInputClear)).addListener(new IActionListener() {
			@Override
			public void callback() {
				clearMilkJournalGroupButtonClicked();
			}
		});

		((IActionRidget) getRidget(ViewWidgetId.modifyButton)).addListener(new IActionListener() {

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

		// bind
		workingJournalLine = DairyFactory.eINSTANCE.createCollectionJournalLine();

		// editable widgets
		// todo: should bind to bins for this route only..
		binCombo.bindToModel(new WritableList(bins, DairyContainer.class), DairyContainer.class, "getContainerId",
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
	private void clearMilkJournalGroupButtonClicked() {
		if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),
				"Clear Input", "Do you want to clear input fields?")) {
			resetJournalEntryInputs();
		}
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
		configureRidgets();

		// restore stashed bin
		if (workingBin != null) {
			workingJournalLine.setDairyContainer(workingBin);
			canText.requestFocus();
		}

		// update ui with new model
		updateAllRidgetsFromModel();

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
