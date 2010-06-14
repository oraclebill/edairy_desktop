package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.employee.EmployeeRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;

public class EmployeeDirectoryController extends BasicDirectoryController<Employee> {

	private ITextRidget nameSearchText;
	private IComboRidget positionSearchCombo;

	private EmployeeSearchBean searchBean = new EmployeeSearchBean();

	public EmployeeDirectoryController() {
		super();
		setRepository(new EmployeeRepository());
		setEClass(DairyPackage.Literals.CUSTOMER);
		setEntityClass(Customer.class);

		addTableColumn("ID", DairyPackage.Literals.EMPLOYEE__ID);
		addTableColumn("Last Name", ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTableColumn("First Name", ModelPackage.Literals.PERSON__GIVEN_NAME);
		addTableColumn("Position", DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION);
		addTableColumn("Since", DairyPackage.Literals.EMPLOYEE__START_DATE);
	}

	@Override
	protected void configureFilterRidgets() {
		nameSearchText = getRidget(ITextRidget.class, CustomerDirectoryView.BIND_ID_FILTER_COMPANYNAME);
		nameSearchText.setDirectWriting(true);
		nameSearchText.bindToModel(searchBean, "name");

		//
		positionSearchCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_CUSTOMERTYPE);
		positionSearchCombo.bindToModel(searchBean, "positions", String.class, null, searchBean, "position");
		positionSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		positionSearchCombo.updateFromModel();
		positionSearchCombo.setSelection(EMPTY_SELECTION_TEXT);

	}

	@Override
	protected void resetFilterConditions() {
		nameSearchText.setText("");
		positionSearchCombo.setSelection(positionSearchCombo.getEmptySelectionItem());
	}

	@Override
	protected List<Employee> getFilteredResult() {
		List<Employee> filtered = new ArrayList<Employee>();
		List<Employee> allCustomers = getRepository().all();
		for (final Employee e : allCustomers) {
			if ((MatchUtil.matchContains(searchBean.getName(), e.getFamilyName()) 
					|| MatchUtil.matchContains(searchBean.getName(), e.getGivenName()))
					&& MatchUtil.matchContains(searchBean.getPosition(), e.getJobFunction())) {
				filtered.add(e);
			}
		}
		return filtered;
	}

	@Override
	protected RecordDialog<Employee, EmployeeEditDialogController> getRecordDialog(Shell shell) {
		return new EmployeeEditDialog(shell);
	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	protected Employee createNewModel() {
		Employee employee = (Employee) EMFUtil.createWorkingCopy(this.getEClass(), 3);
		//employee.setPhoneNumber("");
		return employee;
	}
}
