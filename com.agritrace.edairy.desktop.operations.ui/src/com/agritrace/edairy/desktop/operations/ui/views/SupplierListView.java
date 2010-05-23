package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class SupplierListView extends AbstractRecordListView {

	public static final String ID = "edairy.supplier.list.view";

	public static final String BIND_ID_FILTER_CATEGORIES = "bind.id.fitler.categories";
	public static final String BIND_ID_FILTER_CONTACT = "bind.id.fitler.contact";
	public static final String BIND_ID_FILTER_STATUS = "bind.id.fitler.status";

	@Override
	protected void createFilterCondtions(Composite parent) {
		parent.setLayout(GridLayoutFactory.swtDefaults().margins(0, 0)
				.numColumns(2).create());
		GridDataFactory.swtDefaults().grab(true, false).applyTo(parent);

		// Categories
		UIControlsFactory.createLabel(parent, "Categories");

		List categoriesList = UIControlsFactory.createList(parent, false, true);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(categoriesList);
		addUIControl(categoriesList, BIND_ID_FILTER_CATEGORIES);

		// Contact name
		UIControlsFactory.createLabel(parent, "Contact Name");
		Text contactName = UIControlsFactory.createText(parent, SWT.None);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(contactName);
		addUIControl(contactName, BIND_ID_FILTER_CONTACT);

		// Status
		UIControlsFactory.createLabel(parent, "Status");
		Combo status = UIControlsFactory.createCombo(parent);
		GridDataFactory.swtDefaults().grab(true, false).applyTo(status);
		addUIControl(status, BIND_ID_FILTER_STATUS);

	}

	// public SupplierListView() {
	// }
	//
	// @Override
	// protected void basicCreatePartControl(Composite parent) {
	//
	// parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	//
	// parent.setLayout(new GridLayout(1, false));
	//
	// final Composite composite = new Composite(parent, SWT.NONE);
	// final GridData data = new GridData();
	// data.grabExcessHorizontalSpace = true;
	// data.horizontalAlignment = SWT.FILL;
	// data.grabExcessVerticalSpace = true;
	// data.verticalAlignment = SWT.FILL;
	// composite.setLayoutData(data);
	//
	// final GridLayout layout = new GridLayout();
	// layout.marginHeight = 5;
	// layout.marginWidth = 5;
	// layout.numColumns = 1;
	// composite.setLayout(layout);
	// createMasterDetails(composite);
	//
	// // UIControlsFactory.createButton(parent,
	//	//				"enable/disable", "enableDisable"); //$NON-NLS-1$ //$NON-NLS-2$
	//
	// }
	//
	// public class SupplierInfoMDComposite extends MasterDetailsComposite {
	//
	// public SupplierInfoMDComposite(Composite parent, int style) {
	// super(parent, style);
	// setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// // TODO Auto-generated constructor stub
	// }
	//
	// @Override
	// protected Table createTable(Composite tableComposite, TableColumnLayout
	// layout) {
	// if (tableComposite.getParent() != null) {
	// tableComposite.getParent().setLayoutData(new GridData(SWT.FILL, SWT.FILL,
	// true, true));
	//
	// }
	// tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
	// true));
	// tableComposite.setLayout(layout);
	//
	// return super.createTable(tableComposite, layout);
	// }
	// }
	//
	// // helping methods
	// // ////////////////
	//
	// private Group createMasterDetails(Composite parent) {
	//	final Group result = UIControlsFactory.createGroup(parent, "Supplier Information:"); //$NON-NLS-1$
	// result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	// //
	// final GridLayout layout = new GridLayout();
	// layout.marginHeight = 20;
	// layout.marginWidth = 20;
	// layout.numColumns = 1;
	// result.setLayout(layout);
	//
	// final SupplierInfoMDComposite mdComposite = new
	// SupplierInfoMDComposite(result, SWT.NONE);
	// final Composite details = mdComposite.getDetails();
	// details.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	// final GridLayout detaLayout = new GridLayout();
	// detaLayout.numColumns = 1;
	// details.setLayout(detaLayout);
	//
	// final Group detailGroup = UIControlsFactory.createGroup(details,
	// "Details");
	// detailGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	//
	// final GridLayout layout2 = new GridLayout(3, false);
	// layout.makeColumnsEqualWidth = false;
	// detailGroup.setLayout(layout2);
	//
	//	UIControlsFactory.createLabel(detailGroup, "Company"); //$NON-NLS-1$
	//	final Text txtDep = UIControlsFactory.createText(detailGroup, SWT.BORDER, "company"); //$NON-NLS-1$
	// txtDep.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2,
	// 1));
	//
	// GridDataFactory.swtDefaults().align(PROP_TITLE, PROP_TITLE).span(1,
	// 3).hint(SWT.DEFAULT, 40)
	//		.applyTo(UIControlsFactory.createLabel(detailGroup, "Decription")); //$NON-NLS-1$
	// final Text description =
	// UIControlsFactory.createTextMultiWrap(detailGroup, false, true);
	// description.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
	// 3));
	//	//		mdComposite.addUIControl(description, "description"); //$NON-NLS-1$
	//	addUIControl(description, "description"); //$NON-NLS-1$
	//
	//	GridDataFactory.swtDefaults().hint(-1, 25).span(3, 1).applyTo(UIControlsFactory.createLabel(detailGroup, "")); //$NON-NLS-1$
	// // Text txtLast = UIControlsFactory.createText(detailGroup, SWT.BORDER,
	//	//				"last"); //$NON-NLS-1$
	// // txtLast.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
	// // false,
	// // 2, 1));
	//
	//	UIControlsFactory.createLabel(detailGroup, "Contact Name"); //$NON-NLS-1$
	//	final Text txtFirst = UIControlsFactory.createText(detailGroup, SWT.BORDER, "first"); //$NON-NLS-1$
	// txtFirst.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2,
	// 1));
	//
	// // Label imageLable = new Label(detailGroup, SWT.BORDER);
	// // GridData imagData = new GridData();
	// // imagData.heightHint = 100;
	// // imagData.widthHint = 100;
	// // imagData.minimumHeight =48;
	// // imagData.minimumWidth=48;
	// // GridData imagData = new GridData(SWT.FILL,SWT.TOP,false,false);
	//
	// // imagData.verticalSpan = 4;
	// // Image photoImage = EDairyActivator.getImage(ImageRegistry.smileFace);
	// // imageLable.setImage(photoImage);
	// // imageLable.setLayoutData(imagData);
	//
	//	UIControlsFactory.createLabel(detailGroup, "Contact Number"); //$NON-NLS-1$
	//	final Text txtPhone = UIControlsFactory.createText(detailGroup, SWT.BORDER, "phone"); //$NON-NLS-1$
	// txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
	// 2, 1));
	//
	//	UIControlsFactory.createLabel(detailGroup, "Address"); //$NON-NLS-1$
	//	final Text txtAdd = UIControlsFactory.createText(detailGroup, SWT.BORDER, "address"); //$NON-NLS-1$
	// txtAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2,
	// 1));
	//
	//	//		UIControlsFactory.createLabel(details, "Pets:"); //$NON-NLS-1$
	// // ChoiceComposite ccPets = new ChoiceComposite(details, SWT.NONE,
	// // true);
	// // ccPets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
	// // 1,
	// // 1));
	// // ccPets.setOrientation(SWT.HORIZONTAL);
	//	//		mdComposite.addUIControl(ccPets, "pets"); //$NON-NLS-1$
	//
	//	this.addUIControl(mdComposite, "master"); //$NON-NLS-1$
	//
	// final Composite buttonPanel = UIControlsFactory.createComposite(details);
	// buttonPanel.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
	// buttonPanel.setLayout(new GridLayout(2, false));
	// final Button saveButton = UIControlsFactory.createButton(buttonPanel,
	// "Save");
	// saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
	//
	// final Button cancelButton = UIControlsFactory.createButton(buttonPanel,
	// "Cancel");
	// cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
	// false));
	//
	// // DefaultButtonManager dbm = new
	// // DefaultButtonManager(parent.getShell());
	// // dbm.addButton(mdComposite.getButtonApply(), mdComposite);
	//
	// return result;
	// }

}