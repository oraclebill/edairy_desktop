package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.ui.controls.CompositePanel;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.AssetInfo;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.controllers.ContainerEditDialogController;

public class ContainerEditDialog extends RecordDialog<Bin> {

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

			final Control control = new AssetInfo(detailGroup, SWT.NULL);
			SWTBindingPropertyLocator.getInstance().setBindingProperty(control,
					ContainerBindingConstants.BIND_ID_ASSET_INFO);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		}

		private void addDescriptionGroup(Composite boxyBrown) {
			final Group comp = UIControlsFactory.createGroup(boxyBrown, "Description");

			comp.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).create());
			final GridDataFactory fieldDefault = GridDataFactory.swtDefaults().grab(true, false).minSize(140, -1);
			{
				final Composite detailGroup = UIControlsFactory.createComposite(comp, SWT.NULL);
				detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
				GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

//				{
//					final Control sizingLabel = UIControlsFactory.createLabel(detailGroup, "Container ID:");
//					GridDataFactory.fillDefaults().hint(120, -1).applyTo(sizingLabel);
//					final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
//							ContainerBindingConstants.BIND_ID_CONTAINER_ID);
//					text.setText("<generated>");
//					fieldDefault.applyTo(text);
//				}
				{
					UIControlsFactory.createLabel(detailGroup, "Tracking Number:");
					final Control text = UIControlsFactory.createText(detailGroup, SWT.NONE,
							ContainerBindingConstants.BIND_ID_CONTAINER_TRACKING_NUM);
					fieldDefault.applyTo(text);
				}
				{
					UIControlsFactory.createLabel(detailGroup, "Capacity:");
					final Text text = UIControlsFactory.createTextDecimal(detailGroup,
							ContainerBindingConstants.BIND_ID_CONTAINER_CAPACITY);
					fieldDefault.applyTo(text);
				}
				{
					UIControlsFactory.createLabel(detailGroup, "Unit of Measure:");
					final CCombo text = UIControlsFactory.createCCombo(detailGroup,
							ContainerBindingConstants.BIND_ID_CONTAINER_UOM);
					fieldDefault.applyTo(text);
				}
			}

		}
	}

	private Composite comonComp;

	public ContainerEditDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void buildWorkArea(Composite parent) {
		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(1, true));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		final ContainerLogDetailComposite details = new ContainerLogDetailComposite(comonComp);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(details);

		parent.pack();
	}

	@Override
	protected ContainerEditDialogController createController() {
		return new ContainerEditDialogController();
	}

}
