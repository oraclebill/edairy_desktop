package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.model.dairy.*;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.RouteEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.RouteListView;

public class RouteListController extends BasicDirectoryController<Route> {

	public static class SearchBean extends AbstractBean {
		public static final String NAME_PROP = "name";
		public static final String DESCRIPTION_PROP = "description";

		private String name;
		private String description;

		public SearchBean() {
			name = "";
			description = "";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			Object old = this.name;
			this.name = name;
			this.firePropertyChanged(NAME_PROP, old, this.name);
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			Object old = this.description;
			this.description = description;
			this.firePropertyChanged(DESCRIPTION_PROP, old, this.description);
		}
	}

	private final SearchBean searchBean = new SearchBean();
	private ITextRidget name;
	private ITextRidget description;
	private DairyRepository dairyRepo = new DairyRepository();

	public RouteListController() {
		setRepository(new RouteRepository());
		setEClass(DairyPackage.Literals.ROUTE);
		setEntityClass(Route.class);
		
//		addTableColumn("ID", DairyPackage.Literals.ROUTE__ID);
		addTableColumn("Code", DairyPackage.Literals.ROUTE__CODE);
		addTableColumn("Name", DairyPackage.Literals.ROUTE__NAME);
		addTableColumn("Description", DairyPackage.Literals.ROUTE__DESCRIPTION);
//		addTableColumn("ID", DairyPackage.Literals.ROUTE__ID);
		
	}

	@Override
	protected void configureFilterRidgets() {
		name = getRidget(ITextRidget.class, RouteListView.BIND_ID_FILTER_NAME);
		description = getRidget(ITextRidget.class, RouteListView.BIND_ID_FILTER_DESC);

		name.bindToModel(searchBean, "name");
		description.bindToModel(searchBean, "description");

		name.updateFromModel();
		description.updateFromModel();
	}

	@Override
	protected List<Route> getFilteredResult() {
		List<Route> allRoutes = getRepository().all();
		List<Route> filteredRoutes = new ArrayList<Route>();

		for (Route r : allRoutes) {
			if (MatchUtil.matchContains(searchBean.getName(), r.getName())
					&& MatchUtil.matchContains(searchBean.getDescription(), r.getDescription())) {
				filteredRoutes.add(r);
			}
		}

		return filteredRoutes;
	}

	@Override
	protected RecordDialog getRecordDialog(Shell shell) {
		return new RouteEditDialog(shell);
	}

	@Override
	protected void resetFilterConditions() {
		name.setText("");
		description.setText("");
	}

}
