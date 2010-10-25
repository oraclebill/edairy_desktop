package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SessionEditDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SessionDirectoryController extends BasicDirectoryController<CollectionSession> {
	private static final DateFormat TIME_FORMAT = DateFormat.getTimeInstance(DateFormat.SHORT);
	
	private final IRepository<CollectionSession> repository;
	private final Provider<SessionEditDialog> dialogProvider;

	@Inject
	public SessionDirectoryController(final IRepository<CollectionSession> repository,
			final Provider<SessionEditDialog> dialogProvider) {
		this.repository = repository;
		this.dialogProvider = dialogProvider;
		setRepository(repository);
		setEClass(DairyPackage.Literals.COLLECTION_SESSION);

		addTableColumn("Code", DairyPackage.Literals.COLLECTION_SESSION__CODE);
		addTableColumn("Time of Day", DairyPackage.Literals.COLLECTION_SESSION__TIME_OF_DAY, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				return TIME_FORMAT.format(((CollectionSession) element).getTimeOfDay());
			}
		});
		addTableColumn("Description", DairyPackage.Literals.COLLECTION_SESSION__DESCRIPTION);
	}

	@Override
	protected void configureFilterRidgets() {
		getRidget(BaseListView.BIND_ID_FILTER_SEARCH).setVisible(false);
		getRidget(BaseListView.BIND_ID_FILTER_RESET).setVisible(false);
	}

	@Override
	protected List<CollectionSession> getFilteredResult() {
		return repository.all();
	}

	@Override
	protected RecordDialog<CollectionSession> getRecordDialog(Shell shell) {
		return dialogProvider.get();
	}

	@Override
	protected void resetFilterConditions() {
		// Do nothing
	}

	@Override
	protected CollectionSession createNewModel() {
		final CollectionSession session = super.createNewModel();
		session.setTimeOfDay(new GregorianCalendar(1970, Calendar.JANUARY, 1, 9, 0, 0).getTime());
		return session;
	}
}
