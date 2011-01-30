package com.agritrace.edairy.desktop.common.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;

public abstract class CustomerLookupDialog extends TitleAreaDialog implements IActionListener {

	private final class CustomerViewerFilter extends ViewerFilter {
		private final CCombo combo;
		private final Text text;

		public CustomerViewerFilter(CCombo field, Text text) {
// System.err.printf("CustomerViewerFilter: %s, %s\n", field, text);
			this.combo = field;
			this.text = text;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {

			boolean selected = true;

			if (combo == null || combo.getText().trim().length() == 0) {
				return true;
			}

			if (text == null || text.getText().trim().length() == 0) {
				return true;
			}
			final String textStr = text.getText().trim().toLowerCase();
			final String comboStr = combo.getText();

			if (element instanceof Customer) {
				final Customer customer = (Customer) element;
				if (comboStr.equals("ID")) {
					selected = customer.getCustomerNumber().toLowerCase().contains(textStr);
				} else if (comboStr.equals("Name")) {
					String name = customer.getCompanyName().toLowerCase();
					if (name != null && name.trim().length() > 0) {
						selected = name.contains(textStr);
					}
					name = customer.getLegalName().toLowerCase();
					if (name != null && name.trim().length() > 0) {
						selected = selected || name.toLowerCase().contains(textStr);
					}
				} else {
					throw new RuntimeException("ERR: " + combo);
				}
			} else {
				throw new IllegalArgumentException(element.getClass().getName());
			}
			return selected;
		}

	}

	private final class LookupSelection extends SelectionAdapter implements ModifyListener {
		TableViewer myTable;

		public LookupSelection(TableViewer tableView) {
			myTable = tableView;
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (e.widget == searchType) {
				if (filterText != null) {
					filterText.setText("");
				}
			}
			widgetSelected(null);
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(null);
		}

		@Override
		public void widgetSelected(SelectionEvent event) {
// System.err.println("widgetSelected: " + e);
			final ViewerFilter filter = new CustomerViewerFilter(searchType, filterText);
// System.err.println("widgetSelected: adding filter " + filter);
			myTable.setFilters(new ViewerFilter[] { filter });
		}

	}

	public class CustomerLabelProvider extends BaseLabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Customer) {
				final Customer customer = (Customer) element;
				assert customer != null;
				switch (columnIndex) {
				case 0:
					return customer.getCustomerNumber();
				case 1:
					return customer.getCompanyName();
				case 2:
					return customer.getLegalName();
				case 3:
					try {
						return customer.getLocation().getPostalLocation().getDistrict();
					} catch (final Exception e) {
						return "<location not found>";
					}
				}
			}
			return null;
		}
	}

	String dlgPrompt = "Please input customer search criterias";
	String dlgTitle = "Customer Lookup";
	List<Customer> customerList;

	Customer selectedCustomer;

	private CCombo searchType;
	private Text filterText;

	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
//	@Inject
	public CustomerLookupDialog( /*@Named("current") */Shell shell, List<Customer> customerList) {
		super(shell);
		this.customerList = customerList;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedObj) {
		selectedCustomer = selectedObj;
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setSize(450, 500);
		super.configureShell(newShell);
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Select", false);
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	@Override
	protected Control createContents(Composite parent) {
		final Control contents = super.createContents(parent);
		setTitle(dlgTitle);
		setMessage(dlgPrompt);
		return contents;
	}

	/**
	 * Creates the gray area
	 * 
	 * @param parent
	 *            the parent composite
	 * @return Control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		final Composite dialogArea = new Composite(composite, SWT.NULL);
		dialogArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		dialogArea.setLayout(new GridLayout(4, false));

		final Label label = new Label(dialogArea, SWT.NULL);
		label.setText("Lookup field:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		searchType = new CCombo(dialogArea, SWT.BORDER);
		searchType.setItems(new String[] { "ID", "Name" });
		searchType.setText("ID");
		searchType.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));

		filterText = new Text(dialogArea, SWT.NULL | SWT.BORDER | SWT.SINGLE);
		filterText.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		final Button lookupButton = new Button(dialogArea, SWT.PUSH);
		lookupButton.setText("Lookup");
		lookupButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

// getShell().setDefaultButton(lookupButton);
//
		final Composite panel = new Composite(dialogArea, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		final TableViewer tableView = new TableViewer(panel, SWT.FULL_SELECTION | SWT.BORDER | SWT.SINGLE);
		final Table table = tableView.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final LookupSelection refreshListener = new LookupSelection(tableView);

		lookupButton.addSelectionListener(refreshListener);
		filterText.addModifyListener(refreshListener);
		searchType.addModifyListener(refreshListener);

		tableView.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				final ISelection selection = event.getSelection();
				handleSelection(selection);
				close();
			}
		});

		// Create two columns and show
		final TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");

		final TableColumn givenName = new TableColumn(table, SWT.LEFT);
		givenName.setText("First Name");

		final TableColumn familyName = new TableColumn(table, SWT.LEFT);
		familyName.setText("Last Name");

		final TableColumn location = new TableColumn(table, SWT.LEFT);
		location.setText("Location");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(id, new ColumnWeightData(15));
		layout.setColumnData(givenName, new ColumnWeightData(30));
		layout.setColumnData(familyName, new ColumnWeightData(50));
		layout.setColumnData(location, new ColumnWeightData(50));

		tableView.setContentProvider(new ArrayContentProvider());
		tableView.setLabelProvider(new CustomerLabelProvider());
		tableView.setInput(customerList);
		tableView.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				final ISelection sel = event.getSelection();
				handleSelection(sel);
			}
		});

		parent.getShell().setDefaultButton(lookupButton);

		panel.setLayout(layout);
		return composite;
	}

	void handleSelection(ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			final IStructuredSelection selected = (IStructuredSelection) sel;
			final Object selectedObj = selected.getFirstElement();
			if (selectedObj instanceof Customer) {
				setSelectedCustomer((Customer) selectedObj);
			}
		}
	}

	@Override
	public void callback() {
		final int retVal = open();
		if (retVal == Window.OK) {
			final Customer selectedCustomer = getSelectedCustomer();
			callback(selectedCustomer);
		}
	}

	protected abstract void callback(Customer selectedCustomer);
}
