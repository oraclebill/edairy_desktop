package com.agritrace.edairy.desktop.common.ui.controls.assetinfo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;

public class AssetInfo extends Composite implements IComplexComponent {
	
	static {
		// TODO: should this be in the activator?
		SwtControlRidgetMapper.getInstance().addMapping(AssetInfo.class, AssetInfoRidget.class);
	}

	public static final String BIND_ID_ASSET_DATE_ACQUIRED = "asset.date.acquired";
	public static final String BIND_ID_ASSET_DATE_DAMAGE = "asset.date.damage";
	public static final String BIND_ID_ASSET_DATE_DISPOSAL = "asset.date.disposal";
	public static final String BIND_ID_ASSET_DESC_DAMAGE = "asset.des.damage";
	public static final String BIND_ID_ASSET_REASON_DISPOSAL = "asset.date.reason";
	public static final String BIND_ID_ASSET_WITNESS_DISPOSAL = "asset.witness.disposal";

	private final List<Object> uiControls = new LinkedList<Object>();

	public AssetInfo(Composite parent, int style) {
		super(parent, style);
		setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
//		setBackground(parent.getBackground());
		
		// Date Acquired
		UIControlsFactory.createLabel(this, "Date Acquired");
		final DateTime dateAcqText = UIControlsFactory.createDate(this, SWT.MEDIUM,
				BIND_ID_ASSET_DATE_ACQUIRED);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(dateAcqText);
		uiControls.add(dateAcqText);

		// Damage Date
		UIControlsFactory.createLabel(this, "Damage Date");
		final DateTime damageDateText = UIControlsFactory.createDate(this, SWT.MEDIUM,
				BIND_ID_ASSET_DATE_DAMAGE);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(damageDateText);
		uiControls.add(damageDateText);

		// Damage Description
		UIControlsFactory.createLabel(this, "Damage Description"); //$NON-NLS-1$
		final Text damageDescText = UIControlsFactory.createTextMulti(this, true, true,
				BIND_ID_ASSET_DESC_DAMAGE);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(damageDescText);
		uiControls.add(damageDescText);

		// Disposal Date
		UIControlsFactory.createLabel(this, "Disposal Date"); //$NON-NLS-1$
		final DateTime disposalDateText = UIControlsFactory.createDate(this, SWT.MEDIUM,
				BIND_ID_ASSET_DATE_DISPOSAL);
		GridDataFactory.swtDefaults().grab(false, false).applyTo(disposalDateText);
		uiControls.add(disposalDateText);

		// Disposal Reason
		UIControlsFactory.createLabel(this, "Disposal Reason"); //$NON-NLS-1$
		final Text disposalReasonText = UIControlsFactory.createTextMulti(this, true, true,
				BIND_ID_ASSET_REASON_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).hint(-1, 50).applyTo(disposalReasonText);
		uiControls.add(disposalReasonText);

		// Disposal Witness
		UIControlsFactory.createLabel(this, "Disposal Witness"); //$NON-NLS-1$
		final Text witnessText = UIControlsFactory.createText(this, SWT.NONE,
				BIND_ID_ASSET_WITNESS_DISPOSAL);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(witnessText);
		uiControls.add(witnessText);
	}

	// private void addUIControl(final Object uiControl, final String bindingId)
	// {
	// uiControls.add(uiControl);
	// SWTBindingPropertyLocator.getInstance().setBindingProperty(uiControl,
	// bindingId);
	// }
	//
	@Override
	public List<Object> getUIControls() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(uiControls);
	}
}