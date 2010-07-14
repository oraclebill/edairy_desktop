package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.navigation.IAction;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.employee.EmployeeRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.EmployeeDirectoryView;

public class EmployeeDirectoryController extends BasicDirectoryController<Employee> {


	private IComboRidget departmentSearchCombo;
	private ITextRidget nameSearchText;
	private IComboRidget positionSearchCombo;

	private final DairyRepository dairyRepo = DairyRepository.getInstance();
	private final Dairy localDairy = dairyRepo.getLocalDairy();
	private final List<Employee> allEmployees = dairyRepo.getLocalDairy().getEmployees();
	private final EmployeeSearchBean searchBean = new EmployeeSearchBean();

	public EmployeeDirectoryController() {
		super();
		setRepository(new EmployeeRepository());
		setEClass(DairyPackage.Literals.EMPLOYEE);
		// setEntityClass(Employee.class);

		addTableColumn("ID", DairyPackage.Literals.EMPLOYEE__ID);
		addTableColumn("Last Name", ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTableColumn("First Name", ModelPackage.Literals.PERSON__GIVEN_NAME);
		addTableColumn("Position", DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION);
		addTableColumn("Since", DairyPackage.Literals.EMPLOYEE__START_DATE);
	}

	@Override
	protected void configureFilterRidgets() {
		nameSearchText = getRidget(ITextRidget.class, EmployeeDirectoryView.BIND_ID_FILTER_NAME);
		nameSearchText.setDirectWriting(true);
		nameSearchText.bindToModel(searchBean, "name");

		//
		positionSearchCombo = getRidget(IComboRidget.class, EmployeeDirectoryView.BIND_ID_FILTER_JOBFUNC);
		positionSearchCombo.bindToModel(searchBean, "positions", String.class, null, searchBean, "position");
		positionSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		positionSearchCombo.updateFromModel();
		positionSearchCombo.setSelection(EMPTY_SELECTION_TEXT);

		//
		departmentSearchCombo = getRidget(IComboRidget.class, EmployeeDirectoryView.BIND_ID_FILTER_DEPT);
		departmentSearchCombo.bindToModel(searchBean, "departments", String.class, null, searchBean, "department");
		departmentSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		departmentSearchCombo.updateFromModel();
		departmentSearchCombo.setSelection(EMPTY_SELECTION_TEXT);
		
		//
		getNavigationNode().addAction(new IAction() {
			
			@Override
			public void run() {
				System.err.println("Action run.");
				
			}
		});
	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	@Override
	protected Employee createNewModel() {
		final Employee employee = (Employee) EMFUtil.createWorkingCopy(this.getEClass(), 3);
		// employee.setPhoneNumber("");
		return employee;
	}


	@Override
	protected List<Employee> getFilteredResult() {
		final List<Employee> filtered = new ArrayList<Employee>();
		for (final Employee e : allEmployees) {
			if (( MatchUtil.matchContains(searchBean.getName(), e.getFamilyName()) 
					|| MatchUtil.matchContains(searchBean.getName(), e.getGivenName()) )
					&& MatchUtil.matchContains(searchBean.getPosition(), e.getJobFunction() )
				) {
				filtered.add(e);
			}
		}
		return filtered;
	}

	@Override
	protected RecordDialog<Employee, EmployeeEditDialogController> getRecordDialog(Shell shell) {
		return new EmployeeEditDialog(shell);
	}

	
	@Override
	protected void createEntity(Employee newEntity) {
		localDairy.getEmployees().add(newEntity);
		dairyRepo.save(localDairy);
	}

	@Override
	protected void updateEntity(Employee updateableEntity) {
		dairyRepo.save(updateableEntity);
	}

	@Override
	protected void resetFilterConditions() {
		nameSearchText.setText("");
		positionSearchCombo.setSelection(positionSearchCombo.getEmptySelectionItem());
		departmentSearchCombo.setSelection(departmentSearchCombo.getEmptySelectionItem());
	}
}
