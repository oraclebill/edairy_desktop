package com.agritrace.edairy.desktop.common.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.ui.ridgets.EditableTable;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class CommunicationsGroupWidget {
	private final Group communicationGroup;

	public static final String COMMUNICATION_GROUP_TXT = "Communications";
	public static final String EMAIL_TXT = "Email:";
	public static final String PHONE_TXT = "Phone:";
	
	public static String BIND_ID_TABLE ="cg.edittable";
	public static String BIND_ID_BTN_ADD="cg.btn.add";
	public static String BIND_ID_BTN_DELETE="cg.btn.delete";
	public static String BIND_ID_BTN_DELETEALL="cg.btn.deleteall";

	private Text emailText;
	private Text phoneText;
	private Text secondPhoneText;

	public CommunicationsGroupWidget(Composite parent) {
		communicationGroup = UIControlsFactory.createGroup(parent, COMMUNICATION_GROUP_TXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communicationGroup);
		//creatDirectonsGroup();
		communicationGroup.setLayout(new GridLayout(2, false));
		EditableTable table = new EditableTable(communicationGroup, SWT.SINGLE
				| SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// Type
		List<String> items = new ArrayList<String>();
		for (ContactMethodType type : ContactMethodType.VALUES) {
			items.add(type.toString());
		}
		ComboBoxCellEditor editor = new ComboBoxCellEditor(table,
				(String[]) items.toArray(new String[items.size()]));
		table.setCellEditor(0, editor);
		// Value
		TextCellEditor textEditor = new TextCellEditor(
				table);
		table.setCellEditor(1, textEditor);
		
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(table);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(table, BIND_ID_TABLE);
		
		createButtons(communicationGroup);
	}

	private void createButtons(Group parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(comp);
		Button  addButton= UIControlsFactory.createButton(comp, "Add", BIND_ID_BTN_ADD);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(addButton);
		Button  deleteButton= UIControlsFactory.createButton(comp, "Delete", BIND_ID_BTN_DELETE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(deleteButton);
		Button  deleteAllButton= UIControlsFactory.createButton(comp, "Delete All", BIND_ID_BTN_DELETEALL);
		
		
	}

	private void creatDirectonsGroup() {
		communicationGroup.setLayout(new GridLayout(2, false));
		UIControlsFactory.createLabel(communicationGroup, EMAIL_TXT);
		emailText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE | SWT.BORDER, ViewWidgetId.EMAIL_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(emailText);

		UIControlsFactory.createLabel(communicationGroup, PHONE_TXT);
		phoneText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE | SWT.BORDER, ViewWidgetId.PHONE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(phoneText);

		UIControlsFactory.createLabel(communicationGroup, PHONE_TXT);
		secondPhoneText = UIControlsFactory.createText(communicationGroup, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.SECOND_PHONE_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(secondPhoneText);
	}

	public Group getGroup() {
		return communicationGroup;
	}
}
