package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.beans.common.AbstractBean;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.dialogs.RouteEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.RouteDirectoryView;
import com.google.inject.Inject;
import com.google.inject.Provider;

@PermissionRequired(UIPermission.VIEW_ROUTES)
public class RouteListController extends BasicDirectoryController<TransportRoute> {

	public static class SearchBean extends AbstractBean {
		public static final String DESCRIPTION_PROP = "description";
		public static final String NAME_PROP = "name";

		private String description;
		private String name;

		public SearchBean() {
			name = "";
			description = "";
		}

		public String getDescription() {
			return description;
		}

		public String getName() {
			return name;
		}

		public void setDescription(String description) {
			final Object old = this.description;
			this.description = description;
			this.firePropertyChanged(DESCRIPTION_PROP, old, this.description);
		}

		public void setName(String name) {
			final Object old = this.name;
			this.name = name;
			this.firePropertyChanged(NAME_PROP, old, this.name);
		}
	}

	private final IDairyRepository dairyRepo;
	private final Provider<RouteEditDialog> editDialogProvider;
	private ITextRidget description;
	private ITextRidget name;
	private final SearchBean searchBean = new SearchBean();

	@Inject
	public RouteListController(final IDairyRepository dairyRepo, final IRepository<TransportRoute> repo,
			final Provider<RouteEditDialog> editDialogProvider) {
		this.dairyRepo = dairyRepo;
		this.editDialogProvider = editDialogProvider;
		setRepository(repo);
		setEClass(DairyPackage.Literals.TRANSPORT_ROUTE);

		// addTableColumn("Code", DairyPackage.Literals.TRANSPORT_ROUTE__CODE);
		addTableColumn("Name", DairyPackage.Literals.TRANSPORT_ROUTE__NAME);
		addTableColumn("Vehicle", DairyPackage.Literals.TRANSPORT_ROUTE__VEHICLE, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				final Vehicle vehicle = ((TransportRoute) element).getVehicle();
				return vehicle == null ? "" : vehicle.getRegistrationNumber();
			}
		});
		addTableColumn("Description", DairyPackage.Literals.TRANSPORT_ROUTE__DESCRIPTION);
	}

	@Override
	protected void configureFilterRidgets() {
		name = getRidget(ITextRidget.class, RouteDirectoryView.BIND_ID_FILTER_NAME);
		description = getRidget(ITextRidget.class, RouteDirectoryView.BIND_ID_FILTER_DESC);

		name.bindToModel(searchBean, "name");
		name.setDirectWriting(true);
		name.updateFromModel();

		description.bindToModel(searchBean, "description");
		description.setDirectWriting(true);
		description.updateFromModel();

		final PropertyChangeListener listener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				refreshTableContents();
			}
		};

		name.addPropertyChangeListener("text", listener);
		description.addPropertyChangeListener("text", listener);
	}

	@Override
	protected List<TransportRoute> getFilteredResult() {
		final List<TransportRoute> allRoutes = getRepository().all();
		final List<TransportRoute> filteredRoutes = new ArrayList<TransportRoute>();

		for (final TransportRoute r : allRoutes) {
			if (MatchUtil.matchContains(searchBean.getName(), r.getName())
					&& MatchUtil.matchContains(searchBean.getDescription(), r.getDescription())) {
				filteredRoutes.add(r);
			}
		}

		return filteredRoutes;
	}

	@Override
	protected RecordDialog<TransportRoute> getRecordDialog(Shell shell) {
		return editDialogProvider.get();
	}

	@Override
	protected void resetFilterConditions() {
		name.setText("");
		description.setText("");
	}

	@Override protected void createEntity(TransportRoute newRoute) {
		dairyRepo.addRoute(newRoute);
	}

	@Override
	protected void deleteEntity(TransportRoute deletableEntity) {
		if(deletableEntity != null){
			dairyRepo.deleteRoute(deletableEntity);
		}

	}

}
