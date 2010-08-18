package com.agritrace.edairy.desktop.member.ui.dialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.compositetable.AbstractNativeHeader;
import org.eclipse.swt.nebula.widgets.compositetable.CompositeTable;
import org.eclipse.swt.nebula.widgets.compositetable.ResizableGridRowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;

public class OwnershipGroup extends CompositePanel  implements IComplexComponent  {
	
	final private List<Object> uiControls = new LinkedList<Object>();
	
	/**
	 * Header for a {@link CompositeTable} widget.
	 */
	private static final class Header extends AbstractNativeHeader {
		/**
		 * Must have a two-arguments constructor.
		 * 
		 * @param parent
		 *            the parent Composite; non null
		 * @param style
		 *            the style bits
		 */
		public Header(final Composite parent, final int style) {
			super(parent, style);
			setWeights(new int[] {100});
			setColumnText(new String[] { "Owner"}); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Row for a {@link CompositeTable} widget.
	 */
	private static final class Row extends CompositePanel implements IComplexComponent {
		private final List<Object> controls = new ArrayList<Object>();

		/**
		 * Must have a two-arguments constructor.
		 * 
		 * @param parent
		 *            the parent Composite; non null
		 * @param style
		 *            the style bits
		 */
		public Row(final Composite parent, final int style) {
			super(parent, style);
			this.setLayout(new ResizableGridRowLayout());
		
			final Text text = UIControlsFactory.createText(this, SWT.LEFT | SWT.SINGLE);
			addUIControl(text, "owner"); //$NON-NLS-1$
		}

		public List<Object> getUIControls() {
			return Collections.unmodifiableList(controls);
		}

		private void addUIControl(final Object uiControl, final String bindingId) {
			controls.add(uiControl);
			// Set's binding property into the widget.
			// Need this for the widget <-> ridget binding
			SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);
		}
	}


	public static String BIND_ID_BTN_ADD = "owner.add";

	public static String BIND_ID_BTN_DELETE = "owner.delete";
	public static String BIND_ID_BTN_DELETEALL = "owner.deleteall";
	public static String BIND_ID_TABLE = "owner.edittable";

	public OwnershipGroup(Composite parent) {
		this(parent, SWT.NULL);
	}
	
	public OwnershipGroup(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		final CompositeTable table = new CompositeTable(this, SWT.BORDER);
		new Header(table, SWT.BORDER);
		new Row(table, SWT.BORDER);
		table.setInsertHint("");
		table.setLinesVisible(true);
		table.setRunTime(true);
						
		GridDataFactory.defaultsFor(table).align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(table);
		addUIControl(table, BIND_ID_TABLE);
		
		Control control = createButtons(this);
		GridDataFactory.defaultsFor(control).align(SWT.BEGINNING, SWT.BEGINNING).applyTo(control);
	}


	private Control createButtons(Composite parent) {
		final Composite buttonPanel = UIControlsFactory.createComposite(parent, SWT.NONE);
		buttonPanel.setLayout(new GridLayout(1, false));		
		
		final Button addButton = UIControlsFactory.createButton(buttonPanel, "Add");
		GridDataFactory.defaultsFor(addButton).align(SWT.FILL, SWT.BEGINNING).applyTo(addButton);
		addUIControl(addButton, BIND_ID_BTN_ADD);		
		
		final Button deleteButton = UIControlsFactory.createButton(buttonPanel, "Delete" );
		GridDataFactory.defaultsFor(deleteButton).align(SWT.FILL, SWT.BEGINNING).applyTo(deleteButton);
		addUIControl(deleteButton, BIND_ID_BTN_DELETE);		

		final Button deleteAllButton = UIControlsFactory.createButton(buttonPanel, "Delete All" );
		GridDataFactory.defaultsFor(deleteAllButton).align(SWT.FILL, SWT.BEGINNING).applyTo(deleteAllButton);
		addUIControl(deleteAllButton, BIND_ID_BTN_DELETEALL);		

		return buttonPanel;	
	}	
	
	private void addUIControl(final Object uiControl, final String bindingId) {
		uiControls.add(uiControl);
		// Set's binding property into the widget.
		// Need this for the widget <-> ridget binding
		SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl, bindingId);
	}

	@Override
	public List<Object> getUIControls() {
		return Collections.unmodifiableList(uiControls);
	}
}
