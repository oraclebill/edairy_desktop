package com.agritrace.edairy.desktop.dairy.containers.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.grouplayout.GroupLayout;

public class ContainerLogDetailComposite extends Composite {

	public ContainerLogDetailComposite(Composite parent) {
		super(parent, SWT.NONE);
		setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		setLayout(new FillLayout());

		Composite detailGroup_1 = UIControlsFactory.createGroup(this, "Container Detail");

		addDescriptionGroup(detailGroup_1);
		addAssetInfoGroup(detailGroup_1);
		
		GridLayoutFactory.fillDefaults().generateLayout(detailGroup_1);
		pack();
	}

	private void addAssetInfoGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Asset Info");
		detailGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.fillDefaults().span(2, 1).applyTo(detailGroup);

		// Date Acquired
		UIControlsFactory.createLabel(detailGroup, "Date Acquired");
		final Text dateAcqText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_ACQUIRED);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateAcqText);
		// addUIControl(dateAcqText, BIND_ID_ASSET_DATE_ACQUIRED);

		// Damage Date
		UIControlsFactory.createLabel(detailGroup, "Damage Date");
		final Text damageDateText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_DAMAGE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(damageDateText);
		// addUIControl(damageDateText, BIND_ID_ASSET_DATE_DAMAGE);

		// Damage Description
		UIControlsFactory.createLabel(detailGroup, "Damage Description"); //$NON-NLS-1$
		final Text damageDescText = UIControlsFactory.createTextMulti(detailGroup, true, true,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_DESC_DAMAGE);
		damageDescText.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(damageDescText);
		// addUIControl(damageDescText, BIND_ID_ASSET_DESC_DAMAGE);

		// Disposal Date
		UIControlsFactory.createLabel(detailGroup, "Disposal Date"); //$NON-NLS-1$
		final Text disposalDateText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(disposalDateText);
		// addUIControl(disposalDateText, BIND_ID_ASSET_DATE_DISPOSAL);

		// Disposal Reason
		UIControlsFactory.createLabel(detailGroup, "Disposal Reason"); //$NON-NLS-1$
		final Text disposalReasonText = UIControlsFactory.createTextMulti(detailGroup, true, true,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_REASON_DISPOSAL);
		disposalReasonText.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(disposalReasonText);
		// addUIControl(disposalReasonText, BIND_ID_ASSET_REASON_DISPOSAL);

		// Disposal Witness
		UIControlsFactory.createLabel(detailGroup, "Disposal Witness"); //$NON-NLS-1$
		final Text witnessText = UIControlsFactory.createText(detailGroup, SWT.NONE,
				ContainerLogDetailBindConstants.BIND_ID_ASSET_WITNESS_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(witnessText);
		// addUIControl(witnessText, BIND_ID_ASSET_WITNESS_DISPOSAL);

	}

	private void addDescriptionGroup(Composite parent) {
		final Group detailGroup = UIControlsFactory.createGroup(parent, "Description");
		detailGroup.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		detailGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(detailGroup);

		{
			UIControlsFactory.createLabel(detailGroup, "Container ID");
			final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_ID);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		}
		{
			UIControlsFactory.createLabel(detailGroup, "Type");
			final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TYPE);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		}
		{
			UIControlsFactory.createLabel(detailGroup, "Capacity");
			final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_CAPACITY);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		}
		{
			UIControlsFactory.createLabel(detailGroup, "UOM");
			final Text text = UIControlsFactory.createText(detailGroup, SWT.NONE,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_UOM);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		}

	}

}