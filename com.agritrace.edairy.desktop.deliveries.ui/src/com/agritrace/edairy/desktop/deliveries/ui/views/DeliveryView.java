package com.agritrace.edairy.desktop.deliveries.ui.views;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.deliveries.ui.beans.Item;
import com.agritrace.edairy.desktop.deliveries.ui.beans.ItemsFactory;
import com.agritrace.edairy.desktop.deliveries.ui.dialogs.AddItemDialog;

public class DeliveryView extends SubModuleView {
	private class ItemLabelProivder implements ITableLabelProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Item) {
				switch (columnIndex) {
				case 0:
					return ((Item) element).getId();
				case 1:
					return ((Item) element).getNumber() + "";
				case 2:
					return ((Item) element).getDescription();
				}
			}
			return null;
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

	}

	public static final String ID = "milk.delivery.entry";

	private static final String RESOURCE_PLUGIN = "com.agritrace.edairy.desktop.resources";

	private Button calendarButton;
	private Text dateField;

	private final List<Item> input = ItemsFactory.createItemList();

	public DeliveryView() {
	}

	@Override
	public void basicCreatePartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final Label titleLabel = new Label(parent, SWT.NULL);
		titleLabel.setText("Delivery Information");
		final Font labelFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);
		titleLabel.setFont(labelFont);

		final Composite upperPanel = new Composite(parent, SWT.NULL);
		upperPanel.setLayout(new GridLayout(5, false));
		upperPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Label dateLabel = new Label(upperPanel, SWT.NULL);
		dateLabel.setText("Date:");

		dateField = new Text(upperPanel, SWT.BORDER | SWT.SINGLE);
		dateField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		dateField.setText("3/24/2010");

		calendarButton = new Button(upperPanel, SWT.PUSH);
		final ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(RESOURCE_PLUGIN, "icons/search.png");
		if (desc != null) {
			calendarButton.setImage(desc.createImage());
		}

		calendarButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		calendarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final Shell dialog = new Shell(AbstractDirectoryController.getShell(), SWT.DIALOG_TRIM);
				dialog.setLayout(new GridLayout(3, false));

				final DateTime calendar = new DateTime(dialog, SWT.CALENDAR | SWT.BORDER);
				if ((dateField.getText() != null) && !dateField.getText().equals("")) {
					final String[] textDate = dateField.getText().split("/");
					if ((textDate != null) && (textDate.length == 3)) {
						final int month = new Integer(textDate[0]).intValue() - 1;
						final int day = new Integer(textDate[1]).intValue();
						final int year = new Integer(textDate[2]).intValue();
						calendar.setMonth(month);
						calendar.setDay(day);
						calendar.setYear(year);

					}
				}

				new Label(dialog, SWT.NONE);
				new Label(dialog, SWT.NONE);
				final Button ok = new Button(dialog, SWT.PUSH);
				ok.setText("OK");
				ok.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
				ok.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						final String textDate = calendar.getMonth() + 1 + "/" + calendar.getDay() + "/"
								+ calendar.getYear();
						dateField.setText(textDate);
						dialog.close();
					}
				});
				dialog.setDefaultButton(ok);
				dialog.pack();
				dialog.open();
			}
		});

		final Label driverLabel = new Label(upperPanel, SWT.NULL);
		driverLabel.setText("Driver:");

		final Combo driverBox = new Combo(upperPanel, SWT.NULL);
		driverBox.setItems(new String[] { "Doe John", "Jackson Janet" });
		driverBox.select(0);
		driverBox.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Label vehicle = new Label(upperPanel, SWT.NULL);
		vehicle.setText("Vehicle:");

		final Combo vehicleBox = new Combo(upperPanel, SWT.NULL);
		vehicleBox.setItems(new String[] { "NH46789", "VI5678" });
		vehicleBox.select(0);
		vehicleBox.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		final Label driveFrom = new Label(upperPanel, SWT.NULL);
		driveFrom.setText("Drive To:");

		final Combo driveFromBox = new Combo(upperPanel, SWT.NULL);
		driveFromBox.setItems(new String[] { "Green Farm", "Harvest Farm" });
		driveFromBox.select(0);
		driveFromBox.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Group itemsGroup = new Group(parent, SWT.BORDER);
		itemsGroup.setText("Items Details");
		itemsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		itemsGroup.setLayout(new GridLayout(2, false));

		final Composite tableContainer = new Composite(itemsGroup, SWT.NULL);
		tableContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

		final TableViewer tableViewer = new TableViewer(tableContainer, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.BORDER);
		final Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");

		final TableColumn number = new TableColumn(table, SWT.LEFT);
		number.setText("Number");

		final TableColumn description = new TableColumn(table, SWT.LEFT);
		description.setText("Description");

		final TableColumnLayout layout = new TableColumnLayout();

		layout.setColumnData(id, new ColumnWeightData(20));
		layout.setColumnData(number, new ColumnWeightData(20));
		layout.setColumnData(description, new ColumnWeightData(60));
		tableContainer.setLayout(layout);

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new ItemLabelProivder());
		tableViewer.setInput(input);

		final Button addButton = new Button(itemsGroup, SWT.NULL);
		addButton.setText("Add...");
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		addButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				final AddItemDialog addItem = new AddItemDialog(addButton.getShell());
				if (addItem.open() == Window.OK) {
					final Item newItem = addItem.getNewItem();
					if (newItem != null) {
						input.add(newItem);
						tableViewer.setInput(input);
					}

				}
			}
		});

		final Button removeButton = new Button(itemsGroup, SWT.NULL);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				final IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (!selection.isEmpty()) {
					if (MessageDialog.openConfirm(removeButton.getShell(), "Remove Items",
							"Do you want to remove the selected items?")) {
						final Iterator<?> i = selection.iterator();
						while (i.hasNext()) {
							final Item item = (Item) i.next();
							input.remove(item);
						}
						tableViewer.setInput(input);
					}

				}

			}
		});
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));

		final Composite savePanel = new Composite(parent, SWT.NULL);
		savePanel.setLayoutData(new GridData(SWT.END, SWT.FILL, false, false));
		savePanel.setLayout(new GridLayout(2, false));

		final Button saveButton = new Button(savePanel, SWT.PUSH);
		saveButton.setText("Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		final Button cancelButton = new Button(savePanel, SWT.PUSH);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
