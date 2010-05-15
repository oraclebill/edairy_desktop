package com.agritrace.edairy.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.dairy.ui.StaffInfoMasterDetailsComposite;
import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.ui.EDairyActivator;

public class NetworklDairyView extends SubModuleView {

	public static final String ID = NetworklDairyView.class.getName();

	public NetworklDairyView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.grabExcessVerticalSpace = true;
		data.verticalAlignment = SWT.FILL;
		composite.setLayoutData(data);

		GridLayout layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		layout.numColumns = 1;
		composite.setLayout(layout);
		createMasterDetails(composite);

		// UIControlsFactory.createButton(parent,
		//				"enable/disable", "enableDisable"); //$NON-NLS-1$ //$NON-NLS-2$

	}

	// helping methods
	// ////////////////

	private Group createMasterDetails(Composite parent) {
		Group result = UIControlsFactory.createGroup(parent,
				"Network Dairy Information:"); //$NON-NLS-1$
		result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//
		GridLayout layout = new GridLayout();
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		layout.numColumns = 1;
		result.setLayout(layout);

		StaffInfoMasterDetailsComposite mdComposite = new StaffInfoMasterDetailsComposite(
				result, SWT.NONE);
		Composite details = mdComposite.getDetails();
		details.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		Group detailGroup = UIControlsFactory.createGroup(details, "Details");
		detailGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		GridLayout layout2 = new GridLayout(3, false);
		layout.makeColumnsEqualWidth = false;
		detailGroup.setLayout(layout2);

		UIControlsFactory.createLabel(detailGroup, "First Name:"); //$NON-NLS-1$
		Text txtFirst = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"first"); //$NON-NLS-1$
		txtFirst.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label imageLable = new Label(detailGroup, SWT.BORDER); 
//		GridData imagData = new GridData();
//		imagData.heightHint = 100;
//		imagData.widthHint = 100;
		// imagData.minimumHeight =48;
		// imagData.minimumWidth=48;
		GridData imagData = new GridData(SWT.FILL,SWT.TOP,false,false);
		imagData.verticalSpan = 4;

		Image photoImage = EDairyActivator.getImage(ImageRegistry.smileFace);
		imageLable.setImage(photoImage);
		imageLable.setLayoutData(imagData);

		UIControlsFactory.createLabel(detailGroup, "Last Name:"); //$NON-NLS-1$
		Text txtLast = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"last"); //$NON-NLS-1$
		txtLast.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		UIControlsFactory.createLabel(detailGroup, "Phone Number"); //$NON-NLS-1$
		Text txtPhone = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"phone"); //$NON-NLS-1$
		txtPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		
		UIControlsFactory.createLabel(detailGroup, "Farm"); //$NON-NLS-1$
		Text txtDep = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"farm"); //$NON-NLS-1$
		txtDep.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		
		UIControlsFactory.createLabel(detailGroup, "Address"); //$NON-NLS-1$
		Text txtAdd = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"address"); //$NON-NLS-1$
		txtAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));
		
		// status
		UIControlsFactory.createLabel(detailGroup, "Organization Type:"); //$NON-NLS-1$
		Combo comboStatus = UIControlsFactory.createCombo(detailGroup, "organizationType");
		comboStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		
		UIControlsFactory.createLabel(detailGroup, "Organization Name"); //$NON-NLS-1$
		Text txtOragText = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				"organizationName"); //$NON-NLS-1$
		txtOragText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));

		UIControlsFactory.createLabel(detailGroup, "Gender:"); //$NON-NLS-1$
		ChoiceComposite ccGender = new ChoiceComposite(detailGroup, SWT.NONE,
				false);
		ccGender.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1));
		ccGender.setOrientation(SWT.HORIZONTAL);
		mdComposite.addUIControl(ccGender, "gender"); //$NON-NLS-1$

		//		UIControlsFactory.createLabel(details, "Pets:"); //$NON-NLS-1$
		// ChoiceComposite ccPets = new ChoiceComposite(details, SWT.NONE,
		// true);
		// ccPets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
		// 1,
		// 1));
		// ccPets.setOrientation(SWT.HORIZONTAL);
		//		mdComposite.addUIControl(ccPets, "pets"); //$NON-NLS-1$

		this.addUIControl(mdComposite, "master"); //$NON-NLS-1$
		
		Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel
		.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(2,false));
		Button saveButton = UIControlsFactory.createButton(buttonPanel,"Save");
		saveButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		Button cancelButton = UIControlsFactory.createButton(buttonPanel,"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));

		// DefaultButtonManager dbm = new
		// DefaultButtonManager(parent.getShell());
		// dbm.addButton(mdComposite.getButtonApply(), mdComposite);

		return result;
	}

}

