package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.swtdesigner.SWTResourceManager;

public class MemberBadge extends Composite {

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public MemberBadge(Composite parent, String name, String id, String location) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
		this.setSize(336, 100);

		final Composite main = UIControlsFactory.createComposite(this);
		main.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).margins(5, 5).create());

		final Composite panel = UIControlsFactory.createComposite(main);
		panel.setLocation(5, 5);
		panel.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).margins(3, 3).create());
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Label lblFarmerImage = UIControlsFactory.createLabel(main, "");
		lblFarmerImage.setImage(Activator.getImage(ImageRegistry.sample_memberphoto));
		lblFarmerImage.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 1, 1));

		final Label lblFarmerName = UIControlsFactory.createLabel(panel, name);
		lblFarmerName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		lblFarmerName.setFont(SWTResourceManager.getFont("Lucida Grande", 14, SWT.BOLD));

		// Label spacer = UIControlsFactory.createLabel(subPanel, "");
		// spacer.setLayoutData(GridDataFactory.fillDefaults().span(2,1).create());

		final Font labelFont = SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD);
		UIControlsFactory.createLabel(panel, "Member No.");
		final Label lblFarmerIdValue = UIControlsFactory.createLabel(panel, id);
		lblFarmerIdValue.setFont(labelFont);

		UIControlsFactory.createLabel(panel, "Primary Route");
		final Label lblFarmerRouteValue = UIControlsFactory.createLabel(panel, location);
		lblFarmerRouteValue.setFont(labelFont);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
