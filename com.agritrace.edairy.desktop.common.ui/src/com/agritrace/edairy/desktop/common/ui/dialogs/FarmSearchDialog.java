package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.views.AbstractDialogView;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;

/**
 * Member Search Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class FarmSearchDialog extends AbstractDialogView {

	IMemberRepository memberRepo;
	List<Farm> farmList;
	Membership selectedMember;
	Farm selectedFarm;

	public static final String[] labels = new String[] { "ID", "Name",
			"Location" };

	public static final String SEARCH_COLUMN_COMBO = "search.column.combo";
	public static final String SEARCH_COLUMN_TEXT = "search.column.text";
	public static final String SEARCH_BUTTON = "search.button";
	public static final String RESULT_LIST = "result.list";

	public Farm getSelectedFarm() {
		return selectedFarm;
	}

	public void setSelectedMember(Membership selectedMember) {
		this.selectedMember = selectedMember;
	}

	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public FarmSearchDialog(Shell shell) {
		super(shell);
		memberRepo = new MemberRepository();
		farmList = memberRepo.getMemberFarms();
	}

	// /**
	// * Creates the dialog's contents
	// *
	// * @param parent
	// * the parent composite
	// * @return Control
	// */
	// @Override
	// protected Control createContents(Composite parent) {
	// final Control contents = super.createContents(parent);
	// setTitle("Farm Lookup");
	// setMessage("Please input farm search criterias");
	// return contents;
	// }

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setSize(450, 500);
		super.configureShell(newShell);
		setTitle("Farm Lookup");
	}

	@Override
	protected Control buildView(Composite parent) {
		final Composite composite = UIControlsFactory.createComposite(parent,
				SWT.NULL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(composite);
		composite.setLayout(new GridLayout(4, false));
		UIControlsFactory.createLabel(composite, "Lookup field");

		// Column combo
		UIControlsFactory.createCombo(composite, SEARCH_COLUMN_COMBO);
		// Text value
		Text lookupValue = UIControlsFactory.createText(composite, SWT.NULL | SWT.BORDER
				| SWT.SINGLE, SEARCH_COLUMN_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(lookupValue);

		UIControlsFactory.createButton(composite, "Lookup", SEARCH_BUTTON);

		final Composite panel = new Composite(composite, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		panel.setLayout(GridLayoutFactory.swtDefaults().create());

		Table table = UIControlsFactory.createTable(composite,
				SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI, RESULT_LIST);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// // Create two columns and show
		// final TableColumn id = new TableColumn(table, SWT.LEFT);
		// id.setText("ID");
		//
		// final TableColumn name = new TableColumn(table, SWT.LEFT);
		// name.setText("Name");
		//
		// final TableColumn location = new TableColumn(table, SWT.LEFT);
		// location.setText("Location");
		//
		// final TableColumnLayout layout = new TableColumnLayout();
		// layout.setColumnData(id, new ColumnWeightData(20));
		// layout.setColumnData(name, new ColumnWeightData(30));
		// layout.setColumnData(location, new ColumnWeightData(50));
		//
		// tableView.setContentProvider(new ArrayContentProvider());
		// tableView.setLabelProvider(new FarmLabelProvider());
		//
		// tableView.setInput(farmList); // TODO: TEST - setup
		// tableView.addFilter(new ViewerFilter() {
		// @Override
		// public boolean select(Viewer arg0, Object arg1, Object arg2) {
		// if (null == selectedMember) {
		// return true;
		// }
		// if (selectedMember.getMember().getFarms().contains(arg2)) {
		// return true;
		// }
		// return false;
		// }
		// });
		// tableView.addSelectionChangedListener(new ISelectionChangedListener()
		// {
		//
		// @Override
		// public void selectionChanged(SelectionChangedEvent event) {
		// ISelection selection = event.getSelectionProvider()
		// .getSelection();
		// if (selection != null
		// && selection instanceof IStructuredSelection) {
		// IStructuredSelection sel = (IStructuredSelection) selection;
		// Object obj = sel.getFirstElement();
		// if (obj instanceof Farm) {
		// selectedFarm = (Farm) obj;
		// } else {
		// throw new IllegalStateException();
		// }
		// }
		// }
		// });
		// panel.setLayout(layout);
		// return composite;
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Select", true);
	}

	// public class FarmLabelProvider implements ITableLabelProvider {
	//
	// @Override
	// public void addListener(ILabelProviderListener listener) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void dispose() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean isLabelProperty(Object element, String property) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void removeListener(ILabelProviderListener listener) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public Image getColumnImage(Object element, int columnIndex) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String getColumnText(Object element, int columnIndex) {
	// if (element instanceof Farm) {
	// final Farm farm = (Farm) element;
	// assert (farm != null);
	// switch (columnIndex) {
	// case 0:
	// try {
	// return farm.getFarmId().toString();
	// } catch (NullPointerException npe) {
	// return "N/A";
	// }
	// case 1:
	// return farm.getName();
	// case 2:
	// try {
	// return farm.getLocation().getPostalLocation()
	// .getEstate();
	// } catch (final Exception e) {
	// return "<location not found>";
	// }
	// }
	// }
	// return null;
	// }
	//
	// }

	@Override
	protected AbstractWindowController createController() {
		return new LookupDialogController() {

			@Override
			protected String getEntityName() {
				return "Farm";
			}

			@Override
			protected EClass getEClass() {
				return TrackingPackage.Literals.FARM;
			}

			@Override
			public void configureRidgets() {
				IMemberRepository repo = new MemberRepository();
				super.configureRidgets();
				
				// Column comobo
				IComboRidget columns = getRidget(IComboRidget.class,
						FarmSearchDialog.SEARCH_COLUMN_COMBO);
				List<String> columnOptions = new ArrayList<String>();
				columnOptions.add("ID");
				columnOptions.add("Name");
				columnOptions.add("Location");
				columns.bindToModel(Observables.staticObservableList(columnOptions), String.class, null,
						new WritableValue());
				columns.updateFromModel();
				
				ITableRidget listTable = getRidget(ITableRidget.class,
						FarmSearchDialog.RESULT_LIST);
				WritableList list = new WritableList(repo.getMemberFarms(),
						Farm.class);
				listTable.bindToModel(list, Farm.class, new String[] {
						TrackingPackage.Literals.FARM__FARM_ID.getName(),
						TrackingPackage.Literals.FARM__NAME.getName(),
						TrackingPackage.Literals.FARM__LOCATION.getName() },
						new String[] { "ID", "Name", "Location" });
				listTable.updateFromModel();

			}

			@Override
			protected IRepository createRepository() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected String[] getColumnProperties() {
				// TODO Auto-generated method stub
				return null;
			}
			
			

		};
	}
}
