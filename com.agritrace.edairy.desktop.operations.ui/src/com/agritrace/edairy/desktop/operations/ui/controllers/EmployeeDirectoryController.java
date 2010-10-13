package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.IAction;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.EmployeeDirectoryView;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(Permission.VIEW_EMPLOYEES)
public class EmployeeDirectoryController extends BasicDirectoryController<Employee> {
	private IComboRidget departmentSearchCombo;
	private ITextRidget nameSearchText;
	private IComboRidget positionSearchCombo;

	private final IDairyRepository dairyRepo;
	private final Dairy localDairy;
	private final List<Employee> allEmployees;
	private final Provider<EmployeeEditDialog> editDialogProvider;
	private final EmployeeSearchBean searchBean = new EmployeeSearchBean();

	@Inject
	public EmployeeDirectoryController(final IDairyRepository dairyRepo, final IRepository<Employee> repo,
			final Provider<EmployeeEditDialog> editDialogProvider) {
		this.dairyRepo = dairyRepo;
		this.editDialogProvider = editDialogProvider;
		localDairy = dairyRepo.getLocalDairy();
		allEmployees = dairyRepo.getLocalDairy().getEmployees();
		setRepository(repo);
		setEClass(DairyPackage.Literals.EMPLOYEE);

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

		nameSearchText.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				refreshTableContents();
			}
		});

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
		employee.setRole(null);
		setDefaults(employee);
		// employee.setPhoneNumber("");
		return employee;
	}


	private void setDefaults(Employee employee) {
		Location defaultLocation = EcoreUtil.copy(localDairy.getLocation());
		employee.setLocation(defaultLocation);
		employee.setPhoneNumber("254 ");
	}

	@Override
	protected List<Employee> getFilteredResult() {
		final List<Employee> filtered = new ArrayList<Employee>();

		for (final Employee e : allEmployees) {
			String memberName = "";
			if (nameSearchText != null && !(nameSearchText.getText().trim().length() == 0)) {
				memberName = nameSearchText.getText();
			}
			final String matchText = e.getGivenName() + " " + e.getFamilyName() + " "	+ e.getAdditionalNames();
			if (matchText.toUpperCase().contains(memberName.toUpperCase())
					&& MatchUtil.matchEquals(searchBean.getDepartment(),e.getDepartment())
					&& MatchUtil.matchContains(searchBean.getPosition(), e.getJobFunction() )
			) {
				filtered.add(e);
			}
		}

		return filtered;

	}

	@Override
	protected RecordDialog<Employee> getRecordDialog(Shell shell) {
		return editDialogProvider.get();
	}

	private void handleException(Throwable e) {
		String message;

//		if (e instanceof ConstraintViolationException) {
		if (e.getClass().getName().startsWith("org.hibernate")) {  // TODO: replace hibernate exceptions with domain specific..
			message = "Could not save the employee record. An employee with this username already exists.";
		} else {
			message = "Unhandled exception: " + e.getMessage();
		}

		MessageDialog.openError(getShell(), "Error", message);
	}

	@Override
	protected void createEntity(Employee newEntity) {
		try {
			localDairy.getEmployees().add(newEntity);
			dairyRepo.save(localDairy);
		} catch (final Exception e) {
			e.printStackTrace();
			handleException(e.getCause());
		}
	}

	@Override
	protected void updateEntity(Employee updateableEntity) {
		try {
			dairyRepo.save(updateableEntity);
		} catch (final Exception e) {
			e.printStackTrace();
			handleException(e.getCause());
		}
	}

	@Override
	protected void resetFilterConditions() {
		nameSearchText.setText("");
		positionSearchCombo.setSelection(positionSearchCombo.getEmptySelectionItem());
		departmentSearchCombo.setSelection(departmentSearchCombo.getEmptySelectionItem());
	}

	@Override
	protected void deleteEntity(Employee deletableEntity) {
		localDairy.getEmployees().remove(deletableEntity);
		dairyRepo.save(localDairy);

	}
}
