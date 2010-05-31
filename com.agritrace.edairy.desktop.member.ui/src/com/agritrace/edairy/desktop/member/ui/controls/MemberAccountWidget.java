package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberAccountWidget {
	
	private Composite composite;
	
	public static final String DELIVERIES_GROUP="Deliveries";
	
	public static final String DELIVERIES_GROUP_TOTOAL_DELIVERIES="Total Deliveries:";
	
	public static final String DELIVERIES_GROUP_TOTOAL_ACCEPTED="Total Accepted:";
	
	public static final String DELIVERIES_GROUP_TOTOAL_REJECTED="Total Rejected:";


	public MemberAccountWidget(Composite parent){
		composite = UIControlsFactory.createComposite(parent);
		composite.setLayout(new GridLayout(3, true));
		initGUI();
		
	}
	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}
	
	public void initGUI(){
	 createDeliveriesGroup();
	 createShareGroup();
	 createCreditsGroup();
		
	}
	
	private void createDeliveriesGroup(){
		final Group deliveriesGroup = UIControlsFactory.createGroup(composite, DELIVERIES_GROUP);
		deliveriesGroup.setLayout(new GridLayout(2, false));
		deliveriesGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(deliveriesGroup, DELIVERIES_GROUP_TOTOAL_DELIVERIES);

		final Text deliveryField = UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE | SWT.BORDER,ViewWidgetId.DELIVERIES_GROUP_TOTOAL_DELIVERIES_TXT);
		deliveryField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		UIControlsFactory.createLabel(deliveriesGroup, DELIVERIES_GROUP_TOTOAL_ACCEPTED);

		final Text acceptField = UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE | SWT.BORDER,ViewWidgetId.DELIVERIES_GROUP_TOTOAL_ACCEPTED_TXT);
		acceptField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


		UIControlsFactory.createLabel(deliveriesGroup, DELIVERIES_GROUP_TOTOAL_REJECTED);

		final Text rejectField = UIControlsFactory.createText(deliveriesGroup, SWT.SINGLE | SWT.BORDER,ViewWidgetId.DELIVERIES_GROUP_TOTOAL_REJECTED_TXT);
		rejectField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}
	
	private void createShareGroup(){
		final Group sharesGroupd = UIControlsFactory.createGroup(composite, "Shares");
		sharesGroupd.setLayout(new GridLayout(4, false));
		sharesGroupd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(sharesGroupd, "Total/Recov. :");

		final Text recCobTxt1 = UIControlsFactory.createText(sharesGroupd, SWT.SINGLE | SWT.BORDER);
		recCobTxt1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// recCobTxt1.setText("2500");

		UIControlsFactory.createLabel(sharesGroupd, "/");

		final Text recCobTxt2 = UIControlsFactory.createText(sharesGroupd, SWT.SINGLE | SWT.BORDER);
		recCobTxt2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		UIControlsFactory.createLabel(sharesGroupd, "Recovered:");

		final Text recoveredTxt1 = UIControlsFactory.createText(sharesGroupd, SWT.SINGLE | SWT.BORDER);
		recoveredTxt1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,3,1));
		// recCobTxt2.setText("1250");
		
	}
	
	private void createCreditsGroup(){
		final Group creditsGroup = UIControlsFactory.createGroup(composite, "Credits");
		creditsGroup.setLayout(new GridLayout(2, false));
		creditsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UIControlsFactory.createLabel(creditsGroup, "Credit Score :");

		final Text creditScoreTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE | SWT.BORDER);
		creditScoreTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


		UIControlsFactory.createLabel(creditsGroup, "Credit Limit:");

		final Text creditLimitTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE | SWT.BORDER);
		creditLimitTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));


		UIControlsFactory.createLabel(creditsGroup, "Credit Avalable:");
		final Text creditAvalableTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE | SWT.BORDER);
		creditAvalableTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		UIControlsFactory.createLabel(creditsGroup, "Credit Balance :");

		final Text creditBalanceTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE | SWT.BORDER);
		creditBalanceTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		UIControlsFactory.createLabel(creditsGroup, "Cash Balance :");
		final Text cashBalanceTxt = UIControlsFactory.createText(creditsGroup, SWT.SINGLE | SWT.BORDER);
		cashBalanceTxt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
	}

}
