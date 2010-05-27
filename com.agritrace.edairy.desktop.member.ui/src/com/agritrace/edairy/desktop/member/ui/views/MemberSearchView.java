package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.DetachedViewsManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberSearchView extends SubModuleView implements SelectionListener {

	public static final String ID = MemberSearchView.class.getName();

	public static final String MEMBER_INFO_GROUP = "Members Information";
	

	// container button
	public static final String ADD_BUTTON = "Add";
	public static final String REMOVE_BUTTON = "Remove";

	private Composite main;
	private Text txtName;
	//    private Text txtId;
	private List lstMembers;

	private MemberInfoGroup infoGroup;

	private Button saveButton;
	private Button cancelButton;

	public MemberSearchView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		main = UIControlsFactory.createComposite(parent);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(main);

		/*
		 * Button searchButton = UIControlsFactory.createButton(main,"Search",
		 * ViewWidgetId.memberInfo_searchButton);
		 * GridDataFactory.swtDefaults().align(SWT.END,
		 * SWT.FILL).grab(false,false).applyTo(searchButton);
		 */
		createMemberSelectorGroup(main);
		createMasterDetails(main);

		final MemberSearchNodeListener newListener = new MemberSearchNodeListener();
		getNavigationNode().addSimpleListener(newListener);
		MemberSearchSelectionManager.INSTANCE.setSearchNode(newListener);

	}

	private void createMemberSelectorGroup(Composite composite) {
		infoGroup = new MemberInfoGroup(composite);
		infoGroup.getComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	protected DataBindingContext initDataBindings() {
		final DataBindingContext bindingContext = new DataBindingContext();
		//
		final IObservableValue lstMembersObserveSelectionObserveWidget = SWTObservables.observeSelection(lstMembers);
		final IObservableValue txtNameTextObserveValue = PojoObservables.observeValue(txtName, "text");
		bindingContext.bindValue(lstMembersObserveSelectionObserveWidget, txtNameTextObserveValue, null, null);
		//
		return bindingContext;
	}

	private Composite createMasterDetails(Composite parent) {

		final Composite details = UIControlsFactory.createComposite(parent);
		final GridData detailsGD = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		detailsGD.minimumHeight = 200;
		details.setLayoutData(detailsGD);
		final GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		details.setLayout(detaLayout);

		final Group detailGroup = UIControlsFactory.createGroup(details, MEMBER_INFO_GROUP);
		detailGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 1;
		detailGroup.setLayout(groupLayout);
		detailGroup.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		final CTabFolder tabfolder = new CTabFolder(detailGroup, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// tabfolder.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		// tabfolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		final Color startColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR);
		final Color endColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR);
		tabfolder.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		tabfolder.setSelectionBackground(new Color[] { startColor, endColor }, new int[] { 50 }, true);
		// tabfolder.setSimple(false);

		//profile tab
		final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
		profileTab.setText("Profile");
		final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		profileComposite.setLayout(new GridLayout(1, true));
		MemberProfileWidget profileWidget = new MemberProfileWidget(profileComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(profileWidget.getComposite());
		profileTab.setControl(profileComposite);


		// account summary
		final CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
		accountTab.setText("Account Summary");
		final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1, true));
		MemberAccountWidget accountWidget = new MemberAccountWidget(accountComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(accountWidget.getComposite());		accountTab.setControl(accountComposite);
		accountTab.setControl(accountComposite);

		final CTabItem transactionTab = new CTabItem(tabfolder, SWT.NULL);
		transactionTab.setText("Transactions");
		Composite transComposite =  UIControlsFactory.createComposite(tabfolder,SWT.NONE);
		transComposite.setLayout(new GridLayout(1, true));
		MemberTransactionWidget transWidget = new MemberTransactionWidget(transComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(transWidget.getComposite());
		transactionTab.setControl(transComposite);

		final CTabItem collectionTab = new CTabItem(tabfolder, SWT.NULL);
		collectionTab.setText("Collection Records");
		final Composite collectionComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		collectionComposite.setLayout(new GridLayout(1, true));
		MemberCollectionRecordsWidget collectionWidget = new MemberCollectionRecordsWidget(collectionComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(collectionWidget.getComposite());
		collectionTab.setControl(collectionComposite);

		final CTabItem farmTab = new CTabItem(tabfolder, SWT.NULL);
		farmTab.setText("Farm");
		final Composite farmComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		farmComposite.setLayout(new GridLayout(1, true));
		MemberFarmWidget farmWidget = new MemberFarmWidget(farmComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(farmWidget.getComposite());
		farmTab.setControl(farmComposite);

		final CTabItem livestockTab = new CTabItem(tabfolder, SWT.NULL);
		livestockTab.setText("Livestock");
		final Composite livestockComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		livestockComposite.setLayout(new GridLayout(1, true));
		MemberLiveStockWidget liveStockWidget = new MemberLiveStockWidget(livestockComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(liveStockWidget.getComposite());
		livestockTab.setControl(livestockComposite);

		final CTabItem containerTab = new CTabItem(tabfolder, SWT.NULL);
		containerTab.setText("Containers");
		final Composite containerComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		containerComposite.setLayout(new GridLayout(1, false));
		MemberContainerWidget containerWidget = new MemberContainerWidget(containerComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(containerWidget.getComposite());
		containerTab.setControl(containerComposite);

		tabfolder.setSelection(accountTab);

		final Composite buttonPanel = UIControlsFactory.createComposite(details);
		buttonPanel.setLayoutData(new GridData(SWT.END, SWT.FILL, true, false));
		buttonPanel.setLayout(new GridLayout(3, false));

		final Button searchButton = UIControlsFactory.createButton(buttonPanel, "Search",
				ViewWidgetId.memberInfo_searchButton);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(searchButton);

		saveButton = UIControlsFactory.createButton(buttonPanel, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, ViewWidgetId.memberInfo_saveButton);

		cancelButton = UIControlsFactory.createButton(buttonPanel, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, ViewWidgetId.memberInfo_cacelButton);

		return details;
	}

	public class MemberSearchNodeListener extends SimpleNavigationNodeAdapter {

		private final DetachedViewsManager dvManager = new DetachedViewsManager(getSite());

		@Override
		public void activated(INavigationNode<?> source) {
			// showView(true);
			System.out.println("active !!!!!!!!!!!!!!!!");
		}

		@Override
		public void deactivated(INavigationNode<?> source) {
			System.out.println("deactive !!!!!!!!!!!!!!!!");

			showView(false);
		}

		@Override
		public void disposed(INavigationNode<?> source) {
			// closes all detached views by this manager
			dvManager.dispose();
			// remove this listener - if not removing here, this can also be
			// done in in
			// the view's dispose method.
			getNavigationNode().removeSimpleListener(this);
			MemberSearchSelectionManager.INSTANCE.setSearchNode(null);
		}

		public void showView(boolean show) {
			if (show) {
				dvManager.showView(MemberSearchDetachedView.ID, MemberSearchDetachedView.class, SWT.RIGHT);

			} else {
				dvManager.hideView(MemberSearchDetachedView.ID);
			}
		}
	}

	@Override
	public void dispose() {
		MemberSearchSelectionManager.INSTANCE.clearListeners();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == saveButton) {
			// MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this,
			// selectedMember);
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}


}
