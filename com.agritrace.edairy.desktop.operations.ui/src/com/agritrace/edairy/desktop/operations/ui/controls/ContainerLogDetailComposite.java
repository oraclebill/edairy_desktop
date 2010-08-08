package com.agritrace.edairy.desktop.operations.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.AssetInfo;

public class ContainerLogDetailComposite extends CompositePanel {

	public ContainerLogDetailComposite(Composite parent) {
		super(parent, SWT.NONE);
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));		
		addDescriptionGroup(this);
		addAssetInfoGroup(this);
		GridLayoutFactory.fillDefaults().generateLayout(this);
		

	}

	private void addAssetInfoGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Asset Info");
		GridLayoutFactory.fillDefaults().applyTo(detailGroup);
		
		Control control = new AssetInfo(detailGroup, SWT.NULL);
		SWTBindingPropertyLocator.getInstance().setBindingProperty(control, 
				ContainerLogDetailBindConstants.BIND_ID_ASSET_INFO);
		GridDataFactory.fillDefaults().grab(true,true).applyTo(control);
	}
	
	
	private void addDescriptionGroup(Composite boxyBrown) {
		final Group comp = UIControlsFactory.createGroup(boxyBrown, "Description");
		
		comp.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());
		GridDataFactory fieldDefault = GridDataFactory.swtDefaults().grab(true, false).minSize(140, -1);
		{
			final Composite detailGroup = UIControlsFactory.createComposite(comp, SWT.NULL);
			detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
			GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

			{
				Control sizingLabel = UIControlsFactory.createLabel(detailGroup, "Container ID:");
				GridDataFactory.fillDefaults().hint(120, -1).applyTo(sizingLabel);
				final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
						ContainerLogDetailBindConstants.BIND_ID_CONTAINER_ID);
				text.setText("<generated>");
				fieldDefault.applyTo(text);
			}
			{
				UIControlsFactory.createLabel(detailGroup, "Tracking Number:");
				final Control text = UIControlsFactory.createText(detailGroup, SWT.NONE,
						ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TRACKING_NUM);
				fieldDefault.applyTo(text);
			}
			{
				UIControlsFactory.createLabel(detailGroup, "Capacity:");
				final Text text = UIControlsFactory.createTextDecimal(detailGroup,
						ContainerLogDetailBindConstants.BIND_ID_CONTAINER_CAPACITY);
				fieldDefault.applyTo(text);
			}
			{
				UIControlsFactory.createLabel(detailGroup, "Unit of Measure:");
				final CCombo text = UIControlsFactory.createCCombo(detailGroup,
						ContainerLogDetailBindConstants.BIND_ID_CONTAINER_UOM);
				fieldDefault.applyTo(text);
			}
		}
	
	}

}