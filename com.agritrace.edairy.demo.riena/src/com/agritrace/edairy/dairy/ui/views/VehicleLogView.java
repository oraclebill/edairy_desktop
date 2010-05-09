package com.agritrace.edairy.dairy.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.requests.RequestType;

/**
 * Services log view
 * 
 * @author Spark Wan
 * 
 */
public class VehicleLogView extends SubModuleView {

	public static final String ID = VehicleLogView.class.getName();
	public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$
	
	
	public class VehicleMasterDetailComposite extends MasterDetailsComposite {

		private Composite specialComp;
		private Group inseminationGroup;
		private Composite verternaryComp;
		private Composite inseminationComp;
		private RequestType previousType;
		public static final String INSE_TIME_HEATED_DETECTED = "time_heated_detected";//$NON-NLS-1$

		public VehicleMasterDetailComposite(Composite parent, int style) {
			super(parent, style);
			setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}

		@Override
		protected Table createTable(Composite tableComposite,
				TableColumnLayout layout) {

			Table table = super.createTable(tableComposite, layout);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.grabExcessVerticalSpace = true;
			// Same height with the filter section
			data.heightHint = getParent().getChildren()[0].computeSize(-1, -1).y;
			tableComposite.setLayoutData(data);		
			tableComposite.setLayout(layout);
			return table;
		}
		
		
		@Override
		protected Composite createButtons(Composite parent) {
			Composite composite = super.createButtons(parent);
			// TODO: update, delete, 
			return composite;
		}

		@Override
		protected void createDetails(Composite parent) {

			Group detailGroup = UIControlsFactory.createGroup(parent,
					"Request Detail");
			GridLayout groupLayout = new GridLayout();
			groupLayout.numColumns = 2;
			detailGroup.setLayout(groupLayout);

			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalSpan = 2;
			detailGroup.setLayoutData(data);
			detailGroup.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_WHITE));
			// Create common controls
			createIdentificationControls(detailGroup);
			// Create specific controls
			createDescriptionControls(detailGroup);

		}

		private void createIdentificationControls(Composite parent) {
			Composite comonComp = UIControlsFactory.createComposite(parent);
			comonComp.setLayout(new GridLayout(3, false));

			UIControlsFactory.createLabel(comonComp, "Log Number"); //$NON-NLS-1$
			Text logNumber = UIControlsFactory.createText(comonComp);
			GridData dateData = new GridData();
			dateData.horizontalSpan = 1;
			logNumber.setLayoutData(dateData);
			addUIControl(logNumber, "logNumber"); //$NON-NLS-1$

			ImageButton button = UIControlsFactory.createImageButton(comonComp,
					SWT.None);

			UIControlsFactory.createLabel(comonComp, "Type"); //$NON-NLS-1$
			Text txtType = UIControlsFactory.createText(comonComp);
			GridData textData = new GridData(GridData.FILL_HORIZONTAL);
			textData.horizontalSpan = 2;
			txtType.setLayoutData(textData);
			addUIControl(txtType, "type"); //$NON-NLS-1$

			UIControlsFactory.createLabel(comonComp, "Make"); //$NON-NLS-1$
			Text txtMake = UIControlsFactory.createText(comonComp);
			txtMake.setLayoutData(GridDataFactory.copyData(textData));
			addUIControl(txtMake, "make"); //$NON-NLS-1$

			UIControlsFactory.createLabel(comonComp, "Model"); //$NON-NLS-1$
			Text txtModel = UIControlsFactory.createText(comonComp, SWT.MULTI);
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.heightHint = 50;
			data.horizontalSpan = 2;
			txtModel.setLayoutData(data);
			addUIControl(txtModel, "model"); //$NON-NLS-1$

			UIControlsFactory.createLabel(comonComp, "Color"); //$NON-NLS-1$
			Text txtColor = UIControlsFactory.createText(comonComp);
			GridData colorData = new GridData(GridData.FILL_HORIZONTAL);
			colorData.horizontalSpan = 2;
			txtType.setLayoutData(colorData);
			addUIControl(txtColor, "color"); //$NON-NLS-1$

		}

		private void createDescriptionControls(Group parent) {
			// TODO: 
		}
		

	
	}
	
	@Override	
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		Composite panel = new Composite(parent, SWT.NULL);
		panel.setLayout(new GridLayout(2, false));
		panel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		panel.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		// Creates filter section
		VehicleFilterSection filterSection = new VehicleFilterSection();
		filterSection.createSection(panel);	
		// Since Master/Detail are in different composite, we need to pass the panel as detail composite
		VehicleMasterDetailComposite mdComposite = new VehicleMasterDetailComposite(
				panel, SWT.NONE);
		addUIControl(mdComposite, BIND_ID_MASTER);

	}


}
