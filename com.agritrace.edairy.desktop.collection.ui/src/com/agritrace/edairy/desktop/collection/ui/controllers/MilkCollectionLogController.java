package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationArgument;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.SubModuleNode;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.collection.ui.dialogs.NewMilkCollectionJournalDialog;
import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionJournalView;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class MilkCollectionLogController extends BasicDirectoryController<CollectionJournalPage> {

	private final MilkCollectionLogFilterBean filterBean = new MilkCollectionLogFilterBean();

	private IDateTimeRidget startDate;
	private IDateTimeRidget endDate;
	private IComboRidget route;
	private IToggleButtonRidget mprMissing;
	private IToggleButtonRidget suspended;
	private IToggleButtonRidget rejected;

	private DairyRepository dairyRepository = new DairyRepository();

	public MilkCollectionLogController() {
		setEClass(DairyPackage.Literals.COLLECTION_JOURNAL_PAGE);
//		setEntityClass(CollectionJournalPage.class);
		setRepository(new MilkCollectionJournalRepository());

		addTableColumn("Date", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__JOURNAL_DATE);
		// addTableColumn("Route",
		// DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE, new
		// RouteNameFormatter() );
		addTableColumn("Route", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ROUTE, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				Route route = null;
				if ( element instanceof Route  ) {
					route = (Route)element;
					return route.getName();
				}
				else if (element instanceof CollectionJournalPage) {
					Route r = ((CollectionJournalPage)element).getRoute();
					if (route != null) {
						return r.getName();
					}
					else {
						return "(empty)";
					}
				}
				System.err.println("element->class: "+ element.getClass());
				return super.getText(element);
			}			
		});
		addTableColumn("Session", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SESSION);
		addTableColumn("Driver Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__RECORD_TOTAL);
		addTableColumn("Entry Total", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__DRIVER_TOTAL);
		addTableColumn("# Members", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__ENTRY_COUNT);
		addTableColumn("# Suspended", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__SUSPENDED_COUNT);
		addTableColumn("# Rejected", DairyPackage.Literals.COLLECTION_JOURNAL_PAGE__REJECTED_COUNT);

		filterBean.setRoutes(new DairyRepository().allRoutes());
	}

	
	@Override
	public void afterBind() {
		super.afterBind();
		getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_NEW_BUTTON).setText("Enter Collection Journals");
		
		getRidget(IActionRidget.class, "import-file-button").addListener(new IActionListener() {
			@Override
			public void callback() {
				FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM);
				String retVal = fileDialog.open();
				System.err.println("File " + retVal + " opened.");
			}
			
		});
		
		ISubModuleNode myNode = getNavigationNode();
		if (myNode != null) {
			myNode.addSimpleListener(new org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter() {

				@Override
				public void prepared(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void selectedChanged(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void childAdded(INavigationNode<?> source, INavigationNode<?> childAdded) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void childRemoved(INavigationNode<?> source, INavigationNode<?> childRemoved) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void activated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void beforeActivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void afterActivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void deactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void beforeDeactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void afterDeactivated(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void disposed(INavigationNode<?> source) {
					// TODO Auto-generated method stub
					
				}


				
			});
		}
	}


	@Override
	protected void configureFilterRidgets() {
		startDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_START_DATE_TEXT);
		endDate = getRidget(IDateTimeRidget.class, ViewConstants.COLLECTION_FILTER_END_DATE_TEXT);
		route = getRidget(IComboRidget.class, ViewConstants.COLLECTION_FILTER_ROUTE_COMBO);
		mprMissing = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_MPR_MISSING_CHK);
		suspended = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_SUSPENDED_CHK);
		rejected = getRidget(IToggleButtonRidget.class, ViewConstants.COLLECTION_FILTER_REJECTED_CHK);

		startDate.bindToModel(filterBean, "startDate");
		endDate.bindToModel(filterBean, "endDate");
		route.bindToModel(filterBean, "routes", Route.class, null, filterBean, "route");
		mprMissing.bindToModel(filterBean, "mprMissing");
		suspended.bindToModel(filterBean, "suspended");
		rejected.bindToModel(filterBean, "rejected");
	}

	@Override
	protected void resetFilterConditions() {
		startDate.setDate(new Date());
		endDate.setDate(new Date());
		route.setSelection(-1);
		mprMissing.setSelected(false);
		suspended.setSelected(false);
		rejected.setSelected(false);
	}

	@Override
	protected List<CollectionJournalPage> getFilteredResult() {
		final List<CollectionJournalPage> allJournals = getRepository().all();
		final List<CollectionJournalPage> filteredJournals = new ArrayList<CollectionJournalPage>();

		for (final CollectionJournalPage cj : allJournals) {
			final boolean condition = true;
			// filter logic goes here...
			if (condition) {
				filteredJournals.add(cj);
			}
		}
		return filteredJournals;
	}

	@Override
	protected RecordDialog<CollectionJournalPage, ?> getRecordDialog(Shell shell) {
		throw new UnsupportedOperationException("unsupported");
	}

	@Override
	protected void handleNewItemAction() {
		NewMilkCollectionJournalDialog dialog = new NewMilkCollectionJournalDialog(new Shell());
		// dialog.getController().setContext(EDITED_OBJECT_ID,
		// createNewModel());
		// dialog.getController().setContext(EDITED_ACTION_TYPE, ACTION_NEW);

		int returnCode = dialog.open();
		System.err.println("return code : " + returnCode);
		if (Window.OK == returnCode) {
			CollectionJournalPage newPage = dialog.getNewJournalPage();
			activateDetailView(dialog.getNewJournalPage());
		}
		refreshTableContents();
	}
	
	
	
	@Override
	protected void handleViewItemAction() {
		// FIXME: demo only!!! - use view page!!
		CollectionJournalPage newPage = (CollectionJournalPage)table.getSelection().get(0);
		activateDetailView(newPage);
	}


	private ISubModuleNode createCollectionDetailNode( CollectionJournalPage journalPage ) {
		getNavigationNode().navigate(
				new NavigationNodeId("riena.demo.client.customermailfolders.module", journalPage.getReferenceNumber()), //$NON-NLS-1$
				new NavigationArgument(journalPage));
		
		ISubModuleNode detailViewNode = new SubModuleNode(
				new NavigationNodeId("milk-collection-entry-node", journalPage.getReferenceNumber()), 
				"Collections Entry for " + journalPage.getReferenceNumber()); //$NON-NLS-1$
		detailViewNode.setIcon("milk_detail.gif"); //$NON-NLS-1$
		detailViewNode.setContext("JOURNAL_PAGE", journalPage);
		WorkareaManager.getInstance().registerDefinition(
				detailViewNode, 
				MilkCollectionJournalController.class,
				MilkCollectionJournalView.ID).setRequiredPreparation(true); //$NON-NLS-1$
		return detailViewNode;
	}
		
	private void activateDetailView( CollectionJournalPage journalPage ) {
		ISubModuleNode myNode = getNavigationNode();
		System.err.println("Node:    " + myNode);
		System.err.println("Actions: " + myNode.getActions());
		ISubModuleNode childNode = createCollectionDetailNode(journalPage);
		System.err.println("Child Node: " + childNode);
		myNode.addChild(childNode);
//		myNode.getNavigationProcessor().navigate(myNode, childNode.getNodeId(), new NavigationArgument(journalPage));
		try {
			childNode.activate();
		}
		catch(Exception e) {
			myNode.removeChild(childNode);
			e.printStackTrace();
		}
	}
}
