package com.agritrace.edairy.desktop.member.ui.controls;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberCollectionRecordsWidgetController implements WidgetController, DateRangeFilter, IActionListener {

	public final static class JournalSessionColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				CollectionJournal journal = ((CollectionJournalLine) element).getCollectionJournal();
				if (journal != null) {
					return journal.getSession().toString();
				}
			}
			return null;
		}
	}

	public final static class DairyContainerIdColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				if (((CollectionJournalLine) element).getDairyContainer() != null) {
					return "" + ((CollectionJournalLine) element).getDairyContainer().getContainerId();
				}
			}
			return null;
		}
	}

	private final class EntryDateColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				final Date entryDate = ((CollectionJournalLine) element).getCollectionJournal().getJournalDate();
				final SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
				dateFormatter.setDate(entryDate);
				return dateFormatter.getFormattedDate();
			}
			return null;
		}
	}

	private IController controller;
	private Membership membership;

	private DateRangeSearchController dateSearchController;

	private ITableRidget collectionTable;
	private final String[] collectionPropertyNames = { "collectionJournal", "collectionJournal", "dairyContainer",
			"quantity", "notRecorded", "rejected", "flagged" };
	private final String[] collectionColumnHeaders = { "Session", "Date", "Container", "Quantity", "NPR Missing",
			"Rejected", "Suspended" };
	private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
	private IToggleButtonRidget nprMissing;
	private IToggleButtonRidget rejected;
	private IToggleButtonRidget suspended;

	public MemberCollectionRecordsWidgetController(IController controller) {
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		
		collectionTable = controller.getRidget(ITableRidget.class, ViewWidgetId.COLLECTION_TABLE);
		if (null == collectionTable) {
			return;
		}

		collectionTable.setColumnFormatter(0, new JournalSessionColumnFormatter());
		collectionTable.bindToModel(new WritableList(records, CollectionJournalLine.class),
				CollectionJournalLine.class, collectionPropertyNames, collectionColumnHeaders);

		nprMissing = controller.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_NPRMISSING);
		rejected = controller.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_REJECTED);
		suspended = controller.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_FLAG);
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.COLLECTION_FILTER_STARTDATE,
				ViewWidgetId.COLLECTION_FILTER_ENDDATE, ViewWidgetId.COLLECTION_FILTER_STARTBUTTON,
				ViewWidgetId.COLLECTION_FILTER_ENDBUTTON, this);
		nprMissing.addListener(this);
		rejected.addListener(this);
		suspended.addListener(this);

	}

	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return membership;
	}

	@Override
	public void setInputModel(Object model) {
		this.membership = (Membership) model;
		if (collectionTable != null) {
			updateBinding();
		}
	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;
		configure();

	}

	@Override
	public void updateBinding() {
		if (null == collectionTable) {
			return;
		}
		records.clear();
		records.addAll(getCollectionJournalLines());

		collectionTable.setColumnFormatter(1, new EntryDateColumnFormatter());
		collectionTable.setColumnFormatter(2, new DairyContainerIdColumnFormatter());
		collectionTable.updateFromModel();
		if (dateSearchController != null) {
			filter(dateSearchController.getStartDate(), dateSearchController.getEndDate());
		}

	}

	// todo: temporary util method, get a list of collection records
	private List<CollectionJournalLine> getCollectionJournalLines() {
		final List<CollectionJournalLine> collectionJournalRecords = new ArrayList<CollectionJournalLine>();
		if (membership != null) {
			final String selectedMemberId = "" + membership.getMemberId();
			final EObject container = membership.eContainer();
			if (container != null && container instanceof Dairy) {
				final List<CollectionJournal> allRecords = ((Dairy) container).getCollectionJournals();
				for (final CollectionJournal j : allRecords) {
					final List<CollectionJournalLine> jEntries = j.getJournalEntries();
					for (final CollectionJournalLine e : jEntries) {
						if (selectedMemberId.equals(e.getRecordedMember())) {
							collectionJournalRecords.add(e);
						}
					}
				}
			}
		}
		return collectionJournalRecords;
	}

	@Override
	public List<CollectionJournalLine> filter(String startDate, String endDate) {
		List<CollectionJournalLine> objs = filterNPR();
		objs = filterDate(objs, startDate, endDate);
		collectionTable.bindToModel(new WritableList(objs, CollectionJournalLine.class), CollectionJournalLine.class,
				collectionPropertyNames, collectionColumnHeaders);
		collectionTable.updateFromModel();
		return objs;
	}

	private List<CollectionJournalLine> filterDate(List<CollectionJournalLine> inputRecrods, String startDate,
			String endDate) {
		List<CollectionJournalLine> objs = new ArrayList<CollectionJournalLine>();
		if (inputRecrods == null || inputRecrods.isEmpty()) {
			return objs;
		}
		try {
			final NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
				@Override
				public long longValue(Object object) {
					return ((Date) object).getTime();
				}

				@Override
				public Long adapt(Object value) {
					return longValue(value);
				}
			};

			final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

			SELECT select = null;
			if (startDate != null) {
				// StartDate
				if (!"".equals(startDate)) {
					final Condition startDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							startDate).getTime(), RelationalOperator.GREATER_THAN_OR_EQUAL_TO, dateAdapter);

					final EObjectAttributeValueCondition startDateAttributeCondition = new EObjectAttributeValueCondition(
							DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_DATE, startDateCondition);
					condtions.add(startDateAttributeCondition);
				}

			}
			// End Date
			if (endDate != null) {
				if (!"".equals(endDate)) {
					final Condition endDateCondition = new NumberCondition<Long>(DateTimeUtils.DATE_FORMAT.parse(
							endDate).getTime() + 86400000l, RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

					final EObjectAttributeValueCondition endDateAttributeCondition = new EObjectAttributeValueCondition(
							DairyPackage.Literals.COLLECTION_JOURNAL__JOURNAL_DATE, endDateCondition);
					condtions.add(endDateAttributeCondition);
				}
			}

			// AND all conditions
			if (condtions.size() > 0) {
				final EObjectCondition first = condtions.get(0);
				EObjectCondition ret = first;
				for (int i = 1; i < condtions.size(); i++) {
					ret = ret.AND(condtions.get(i));
				}
				for (CollectionJournalLine record : inputRecrods) {
					select = new SELECT(new FROM(record.getCollectionJournal()), new WHERE(ret));
					final IQueryResult result = select.execute();
					if (!result.isEmpty()) {
						objs.add(record);
					}

				}

			} else {
				objs.addAll(inputRecrods);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Activator.getDefault().logError(e, e.getMessage());
		}
		return objs;
	}

	private List<CollectionJournalLine> filterNPR() {
		List<CollectionJournalLine> filteredRecords = new ArrayList<CollectionJournalLine>();
		if (records == null || records.isEmpty()) {
			return filteredRecords;
		}
		final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

		SELECT select = null;
		// nprmissing
		if (nprMissing != null) {
			final boolean isNPRmissing = nprMissing.isSelected();
			if (isNPRmissing) {
				final Condition nprMissingCondition = new BooleanCondition(isNPRmissing);

				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__NOT_RECORDED, nprMissingCondition);
				condtions.add(startDateCondition);
			}
		}
		// rejected
		if (rejected != null) {
			final boolean isRejected = rejected.isSelected();
			if (isRejected) {
				final Condition rejectedCondition = new BooleanCondition(isRejected);
				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__REJECTED, rejectedCondition);
				condtions.add(startDateCondition);
			}
		}

		// suspended
		if (suspended != null) {
			final boolean isSuspended = suspended.isSelected();
			if (isSuspended) {
				final Condition suspendedCondition = new BooleanCondition(isSuspended);
				final EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						DairyPackage.Literals.COLLECTION_JOURNAL_LINE__FLAGGED, suspendedCondition);
				condtions.add(startDateCondition);
			}
		}
		// AND all conditions
		if (condtions.size() > 0) {
			final EObjectCondition first = condtions.get(0);
			EObjectCondition ret = first;
			for (int i = 1; i < condtions.size(); i++) {
				ret = ret.AND(condtions.get(i));
			}
			select = new SELECT(new FROM(records), new WHERE(ret));

		} else {
			select = new SELECT(new FROM(records), new WHERE(EObjectCondition.E_TRUE));
		}
		final IQueryResult result = select.execute();
		for (final EObject object : result.getEObjects()) {
			filteredRecords.add((CollectionJournalLine) object);
		}

		return filteredRecords;

	}

	@Override
	public void callback() {
		if (null == collectionTable) {
			return;
		}
		if (dateSearchController != null) {
			filter(dateSearchController.getStartDate(), dateSearchController.getEndDate());
		}
	}
}
