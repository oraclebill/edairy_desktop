package com.agritrace.edairy.desktop.dairy.locations.ui.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;

public class DairyLocationView extends SubModuleView {

	private static class DairyLocationMasterDetailsComposite extends MasterDetailsComposite {

		public DairyLocationMasterDetailsComposite(Composite parent, int style) {
			super(parent, style);
			setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}

		@Override
		public boolean confirmRemove(Object item) {
			final String title = "Confirm Remove";
			final String message = "Do you want to delete this item?"; //$NON-NLS-1$
			final boolean result = MessageDialog.openQuestion(getShell(), title, message);
			return result;
		}

		@Override
		protected Table createTable(Composite tableComposite, TableColumnLayout layout) {
			if (tableComposite.getParent() != null) {
				tableComposite.getParent().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			}
			tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			tableComposite.setLayout(layout);

			return super.createTable(tableComposite, layout);
		}

	}

	public final static String ID = "dairy.locations.editor";

//	final static int COLUMN_MARGIN = 20;
//
//	final static int FORM_MARGIN = 10;
//
//	final static int ROW_MARGIN = 10;
//
//	final static int WIDTH_UNIT = 60;

	private Composite contentArea;

	public DairyLocationView() {
	}

	public Image getIcon() {
		return AbstractUIPlugin.imageDescriptorFromPlugin("com.agritrace.edairy.desktop",
				"/icons/edairymanagericon16.png").createImage();
	}

	private void createDetailsPanel(Composite details) {
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.FILL;
		// gd.heightHint = ROW_MARGIN * 2;
		details.setLayoutData(gd);

		final GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		final Group detailGroup = UIControlsFactory.createGroup(details, "Details");
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		detailGroup.setLayoutData(gd);
		final GridLayout layout2 = new GridLayout(3, false);
		detailGroup.setLayout(layout2);

		UIControlsFactory.createLabel(detailGroup, "Location #", SWT.LEFT);

		final Text idText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_COLLECTION_CENTRE_ID);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT;
		gd.horizontalSpan = 2;
		idText.setEditable(false);
		idText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Name", SWT.LEFT);

		final Text nameText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_NAME);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		nameText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Description", SWT.LEFT);

		final Text descriptionText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_DESCRIPTION);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		descriptionText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Phone", SWT.LEFT);

		final Text phoneText = UIControlsFactory.createText(detailGroup, SWT.BORDER | SWT.SINGLE,
				DairyLocationController.RIDGET_ID_PHONE);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.horizontalSpan = 2;
		phoneText.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Date Opened", SWT.LEFT);

		final DatePickerComposite dateOpenedPicker = UIControlsFactory.createDatePickerComposite(detailGroup,
				DairyLocationController.RIDGET_ID_DATEOPENED);
		gd = new GridData();
		gd.horizontalSpan = 2;
		dateOpenedPicker.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Functions", SWT.LEFT);

		final ChoiceComposite functionsChoice = UIControlsFactory.createChoiceComposite(detailGroup, SWT.None, true,
				DairyLocationController.RIDGET_ID_FUNCTIONS);
		functionsChoice.setOrientation(SWT.HORIZONTAL);
		gd = new GridData();
		gd.horizontalSpan = 2;
		functionsChoice.setLayoutData(gd);

		UIControlsFactory.createLabel(detailGroup, "Route", SWT.LEFT);

		final CCombo combo = UIControlsFactory.createCCombo(detailGroup, DairyLocationController.RIDGET_ID_ROUTE);
		gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.verticalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalSpan = 2;
		combo.setLayoutData(gd);

		// UIControlsFactory.createButton(detailGroup, "?",
		// DairyLocationController.RIDGET_ID_CONFIGURE_ROUTE_ACTION);

		LocationTabFolder tabs = new LocationTabFolder(detailGroup, SWT.NULL);
		gd = new GridData();
		gd.horizontalSpan = 3;
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		tabs.setLayoutData(gd);
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		this.contentArea = parent;
		contentArea.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		final GridLayout layout = new GridLayout(1, false);
		contentArea.setLayout(layout);
		final DairyLocationMasterDetailsComposite master = new DairyLocationMasterDetailsComposite(contentArea,
				SWT.NONE);
		this.addUIControl(master, "master");
		final GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		master.setLayoutData(gd);
		final Composite details = master.getDetails();
		createDetailsPanel(details);
	}

}
