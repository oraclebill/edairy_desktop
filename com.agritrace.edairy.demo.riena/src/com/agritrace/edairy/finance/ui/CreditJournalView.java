package com.agritrace.edairy.finance.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.ui.EDairyActivator;
import com.agritrace.edairy.ui.ImageRegistry;
import com.agritrace.edairy.ui.views.data.CreditRecord;
import com.agritrace.edairy.ui.views.data.CreditRecordFactory;

public class CreditJournalView extends ViewPart {

	public static final String ID = CreditJournalView.class.getName();

	private Text dateField;
	private Button calendarButton;

	private TableViewer tableViewer;

	private List<CreditRecord> input = CreditRecordFactory
			.createCreditRecords();

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Credit Sales Journal");
		Font labelFont = JFaceResources.getFontRegistry().getBold(
				JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		Group upperPanel = new Group(parent, SWT.NULL);
		upperPanel.setLayout(new GridLayout(5, false));
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		upperPanel.setText("Category");

		final Combo storeTypeBox = new Combo(upperPanel, SWT.NULL
				| SWT.READ_ONLY);
		storeTypeBox.setItems(new String[] { "Store", "Vaterinary", "Other" });
		storeTypeBox.select(0);
		storeTypeBox
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Combo locationBox = new Combo(upperPanel, SWT.NULL
				| SWT.READ_ONLY);
		locationBox.setItems(new String[] { "Route 2 - Ngecha",
				"Route 3 - Kelly" });
		locationBox.select(0);
		locationBox
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Label dateLabel = new Label(upperPanel, SWT.NULL);
		dateLabel.setText("Date:");

		dateField = new Text(upperPanel, SWT.BORDER | SWT.SINGLE
				| SWT.READ_ONLY);
		dateField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		Date current = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		dateField.setText(formatter.format(current));

		calendarButton = new Button(upperPanel, SWT.PUSH);
		Image searchImage = EDairyActivator.getImage(ImageRegistry.search);
		calendarButton.setImage(searchImage);

		calendarButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false));
		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final Shell dialog = new Shell(Display.getDefault()
						.getActiveShell(), SWT.DIALOG_TRIM);
				dialog.setLayout(new GridLayout(3, false));

				final DateTime calendar = new DateTime(dialog, SWT.CALENDAR
						| SWT.BORDER);
				if (dateField.getText() != null
						&& !dateField.getText().equals("")) {
					String[] textDate = dateField.getText().split("/");
					if (textDate != null && textDate.length == 3) {
						int month = new Integer(textDate[0]).intValue() - 1;
						int day = new Integer(textDate[1]).intValue();
						int year = new Integer(textDate[2]).intValue();
						calendar.setMonth(month);
						calendar.setDay(day);
						calendar.setYear(year);

					}
				}

				new Label(dialog, SWT.NONE);
				new Label(dialog, SWT.NONE);
				Button ok = new Button(dialog, SWT.PUSH);
				ok.setText("OK");
				ok.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false));
				ok.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						String textDate = (calendar.getMonth() + 1) + "/"
								+ calendar.getDay() + "/" + calendar.getYear();
						dateField.setText(textDate);
						dialog.close();
					}
				});
				dialog.setDefaultButton(ok);
				dialog.pack();
				dialog.open();
			}
		});

		Composite middlePanel = new Composite(parent, SWT.NULL);
		middlePanel.setLayout(new GridLayout(3, false));
		middlePanel.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, true,
				false));

		Label referenceNumber = new Label(middlePanel, SWT.NULL);
		referenceNumber.setText("Reference #");

		final Text referenceText = new Text(middlePanel, SWT.BORDER);
		referenceText.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false, 2, 1));
		referenceText.setTextLimit(20);
		referenceText.setText("V-4599887");

		Label recordLabel = new Label(middlePanel, SWT.NULL);
		recordLabel.setText("Record #");

		final Text recordLabelText = new Text(middlePanel, SWT.BORDER);
		recordLabelText.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL,
				false, false, 2, 1));
		recordLabelText.setTextLimit(5);
		recordLabelText.setText("2");

		Label memberNumber = new Label(middlePanel, SWT.NULL);
		memberNumber.setText("Member #");

		final Text memberText = new Text(middlePanel, SWT.BORDER);
		memberText.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false,
				false, 2, 1));
		memberText.setTextLimit(20);
		memberText.setText("#45678");

		Label memberNumberAddressLabel = new Label(middlePanel, SWT.NULL);
		memberNumberAddressLabel.setText("");

		final Text memberAddressText = new Text(middlePanel, SWT.BORDER);
		GridData gd = new GridData(SWT.BEGINNING, SWT.FILL, true, false, 2, 1);
		gd.widthHint = 200;
		memberAddressText.setLayoutData(gd);
		memberAddressText.setTextLimit(60);
		memberAddressText.setText("23 South Rd. Prinection NJ 08550");

		Label amountLabel = new Label(middlePanel, SWT.NULL);
		amountLabel.setText("Amount");

		final Text amountText = new Text(middlePanel, SWT.BORDER);
		amountText.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false,
				false, 2, 1));
		amountText.setTextLimit(20);
		amountText.setText("90");

		Button addButton = new Button(middlePanel, SWT.PUSH);
		addButton.setText("Add Record");
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		addButton.addSelectionListener(new SelectionListener() {

		
			@Override
			public void widgetSelected(SelectionEvent e) {
				CreditRecord record = new CreditRecord();

				record.setStore(storeTypeBox.getText());
				record.setDate(dateField.getText());
				record.setReference(referenceText.getText());
				String amount = amountText.getText();
				if (amount != null && !amount.trim().equals("")) {
					Integer i = new Integer(amount.trim());
					record.setAmount(i.intValue());

				}
				record.setMember(memberText.getText());
				record.setRecord(recordLabelText.getText());
				input.add(record);
				tableViewer.setInput(input);

			}

			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});

		final Button clearButton = new Button(middlePanel, SWT.PUSH);
		clearButton.setText("Clear");
		clearButton
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		clearButton.addSelectionListener(new SelectionListener() {
			
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(MessageDialog.openConfirm(clearButton.getShell(), "Clear input fields" , "Do you want to clear input fields?")){
					referenceText.setText("");
					memberText.setText("");
					memberAddressText.setText("");
					amountText.setText("");
					recordLabelText.setText("");
				}
				
			}
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
				
			}
		});

		Group itemsGroup = new Group(parent, SWT.BORDER);
		itemsGroup.setText("Credit Records ");
		itemsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		itemsGroup.setLayout(new GridLayout(2, false));

		Composite tableContainer = new Composite(itemsGroup, SWT.NULL);
		tableContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2));

		tableViewer = new TableViewer(tableContainer, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn store = new TableColumn(table, SWT.LEFT);
		store.setText("Store");

		TableColumn date = new TableColumn(table, SWT.LEFT);
		date.setText("Date");

		TableColumn referecne = new TableColumn(table, SWT.LEFT);
		referecne.setText("Reference #");

		TableColumn record = new TableColumn(table, SWT.LEFT);
		record.setText("Record #");

		TableColumn member = new TableColumn(table, SWT.LEFT);
		member.setText("Member #");

		TableColumn amount = new TableColumn(table, SWT.LEFT);
		amount.setText("Amount");

		TableColumnLayout layout = new TableColumnLayout();

		layout.setColumnData(store, new ColumnWeightData(20));
		layout.setColumnData(date, new ColumnWeightData(20));
		layout.setColumnData(referecne, new ColumnWeightData(20));
		layout.setColumnData(record, new ColumnWeightData(20));
		layout.setColumnData(member, new ColumnWeightData(20));
		layout.setColumnData(amount, new ColumnWeightData(20));

		tableContainer.setLayout(layout);

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new CreditRecordLabelProivder());
		tableViewer.setInput(input);

		final Button removeButton = new Button(itemsGroup, SWT.NULL);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionListener() {

			
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer
						.getSelection();
				if (!selection.isEmpty()) {
					if (MessageDialog.openConfirm(removeButton.getShell(),
							"Remove Items",
							"Do you want to remove the selected records?")) {
						Iterator i = selection.iterator();
						while (i.hasNext()) {
							CreditRecord item = (CreditRecord) i.next();
							input.remove(item);
						}
						tableViewer.setInput(input);
					}

				}

			}

			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});
		removeButton
				.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		
		
		Composite savePanel = new Composite(parent, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END,SWT.FILL,false,false));
		savePanel.setLayout(new GridLayout(2,false));
		
		Button saveButton = new Button(savePanel,SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		Button cancelButton = new Button(savePanel,SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
	}

	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private class CreditRecordLabelProivder implements ITableLabelProvider {

	
		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	
		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}


		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	
		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof CreditRecord) {
				switch (columnIndex) {
				case 0:
					return ((CreditRecord) element).getStore();
				case 1:
					return ((CreditRecord) element).getDate();
				case 2:
					return ((CreditRecord) element).getReference();
				case 3:
					return ((CreditRecord) element).getRecord();
				case 4:
					return ((CreditRecord) element).getMember();
				case 5:
					return ((CreditRecord) element).getAmount() + "";
				}
			}
			return null;
		}

	}

}
