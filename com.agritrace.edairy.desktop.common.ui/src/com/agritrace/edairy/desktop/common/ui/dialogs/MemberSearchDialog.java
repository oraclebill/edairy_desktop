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

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;

public class MemberSearchDialog extends TitleAreaDialog {

	private final class MemberViewerFilter extends ViewerFilter {
		private CCombo combo;
		private Text text;

		public MemberViewerFilter(CCombo field, Text text) {
//			System.err.printf("MemberViewerFilter: %s, %s\n", field, text);
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
			String textStr = text.getText().trim().toLowerCase();
			String comboStr = combo.getText();
			
			if (element instanceof Membership) {
				Membership membership = (Membership) element;
				if (comboStr.equals("ID")) {
					selected = membership.getMemberNumber().toLowerCase().contains(textStr);
				} else if (comboStr.equals("Name")) {
					Person member = membership.getMember();
					if (member != null) {
						String name = member.getGivenName().toLowerCase();
						if (name != null && name.trim().length() > 0) {
							selected = name.contains(textStr);
						}
						name = member.getFamilyName().toLowerCase();
						if (name != null && name.trim().length() > 0) {
							selected = selected || name.toLowerCase().contains(textStr);
						}
					}
				} else {
					System.err.println("ERR: " + combo);
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
			widgetSelected( null );
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected( null );
		}

		@Override
		public void widgetSelected(SelectionEvent event) {
//			System.err.println("widgetSelected: " + e);
			ViewerFilter filter = new MemberViewerFilter(searchType, filterText);
//			System.err.println("widgetSelected: adding filter " + filter);
			myTable.setFilters(new ViewerFilter[] { filter });
		}

	}

	public class MemberLabelProvider extends BaseLabelProvider implements ITableLabelProvider {
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Membership) {
				final Membership membership = (Membership) element;
				final Person member = membership.getMember();
				assert (member != null);
				switch (columnIndex) {
				case 0:
					return membership.getMemberNumber();
				case 1:
					return member.getGivenName();
				case 2:
					return member.getFamilyName();
				case 3:
					try {
						return member.getLocation().getPostalLocation().getDistrict();
					} catch (final Exception e) {
						return "<location not found>";
					}
				}
			}
			return null;
		}
	}

	String dlgPrompt = "Please input member search criterias";
	String dlgTitle = "Member Lookup";
	List<Membership> memberList;
	IMemberRepository memberRepo;

	Farm selectedFarm;
	Membership selectedMember;

	private CCombo searchType;
	private Text filterText;

	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public MemberSearchDialog(Shell shell) {
		super(shell);
		memberRepo = RepositoryFactory.getMemberRepository();
		memberList = memberRepo.all();
	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	@Override
	public boolean close() {

		return super.close();
	}

	public Farm getSelectedFarm() {
		return selectedFarm;
	}

	public Membership getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedFarm(Farm selectedFarm) {
		this.selectedFarm = selectedFarm;
	}

	public void setSelectedMember(Membership selectedObj) {
		selectedMember = selectedObj;
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

//		getShell().setDefaultButton(lookupButton);
//		
		final Composite panel = new Composite(dialogArea, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		final TableViewer tableView = new TableViewer(panel, SWT.FULL_SELECTION | SWT.BORDER | SWT.SINGLE);
		final Table table = tableView.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		LookupSelection refreshListener = new LookupSelection(tableView);
		
		lookupButton.addSelectionListener(refreshListener);
		filterText.addModifyListener(refreshListener);
		searchType.addModifyListener(refreshListener);
		
		tableView.addDoubleClickListener(new IDoubleClickListener() {			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				handleSelection(selection);
				close();
			}
		});
		
		// Create two columns and show
		final TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");

		final TableColumn givenName = new TableColumn(table, SWT.LEFT);
		givenName.setText("Given Name");

		final TableColumn familyName = new TableColumn(table, SWT.LEFT);
		familyName.setText("Family Name");

		final TableColumn location = new TableColumn(table, SWT.LEFT);
		location.setText("Location");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(id, new ColumnWeightData(15));
		layout.setColumnData(givenName, new ColumnWeightData(30));
		layout.setColumnData(familyName, new ColumnWeightData(50));
		layout.setColumnData(location, new ColumnWeightData(50));

		tableView.setContentProvider(new ArrayContentProvider());
		tableView.setLabelProvider(new MemberLabelProvider());
		tableView.setInput(memberList);
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
			if (selectedObj instanceof Membership) {
				setSelectedMember((Membership) selectedObj);
			}
		}
	}
}
