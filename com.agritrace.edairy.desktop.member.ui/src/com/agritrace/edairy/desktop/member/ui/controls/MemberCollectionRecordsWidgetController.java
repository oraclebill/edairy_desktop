package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberCollectionRecordsWidgetController implements WidgetController<Membership>, IActionListener {

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

	public final static class JournalSessionColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				final CollectionGroup journal = ((CollectionJournalLine) element).getCollectionJournal();
				if (journal != null) {
					return journal.getSession().toString();
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

	private final String[] collectionColumnHeaders = { "Session", "Date", "Container", "Quantity", "NPR Missing",
			"Rejected", "Suspended" };
	private final String[] collectionPropertyNames = { "collectionJournal", "collectionJournal", "dairyContainer",
			"quantity", "notRecorded", "rejected", "flagged" };

	private ITableRidget collectionTable;

	private IRidgetContainer container;
	private IDateRangeRidget dateRangeRidget;
	private Membership membership;
	private IToggleButtonRidget nprMissing;
	private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
	private IToggleButtonRidget rejected;
	private IToggleButtonRidget suspended;

	public MemberCollectionRecordsWidgetController(IController controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void callback() {
		if (null == collectionTable) {
			return;
		}
		if (dateRangeRidget != null) {
			filter(dateRangeRidget.getStartDate(), dateRangeRidget.getEndDate());
		}
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}

		collectionTable = container.getRidget(ITableRidget.class, ViewWidgetId.COLLECTION_TABLE);
		if (null == collectionTable) {
			return;
		}

		collectionTable.setColumnFormatter(0, new JournalSessionColumnFormatter());
		collectionTable.bindToModel(new WritableList(records, CollectionJournalLine.class),
				CollectionJournalLine.class, collectionPropertyNames, collectionColumnHeaders);

		nprMissing = container.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_NPRMISSING);
		rejected = container.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_REJECTED);
		suspended = container.getRidget(IToggleButtonRidget.class, ViewWidgetId.COLLECTION_FILTER_FLAG);
		// dateRangeRidget = new DateRangeSearchController(container,
		// ViewWidgetId.COLLECTION_FILTER_STARTDATE,
		// ViewWidgetId.COLLECTION_FILTER_ENDDATE,
		// ViewWidgetId.COLLECTION_FILTER_STARTBUTTON,
		// ViewWidgetId.COLLECTION_FILTER_ENDBUTTON, this);
		dateRangeRidget = container.getRidget(IDateRangeRidget.class, ViewWidgetId.COLLECTION_FILTER_DATE_RANGE);
		nprMissing.addListener(this);
		rejected.addListener(this);
		suspended.addListener(this);

	}

	public List<CollectionJournalLine> filter(Date startDate, Date endDate) {
		List<CollectionJournalLine> objs = filterNPR();
		objs = filterDate(objs, startDate, endDate);
		collectionTable.bindToModel(new WritableList(objs, CollectionJournalLine.class), CollectionJournalLine.class,
				collectionPropertyNames, collectionColumnHeaders);
		collectionTable.updateFromModel();
		return objs;
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Membership getInputModel() {
		return membership;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;
		configure();

	}

	@Override
	public void setInputModel(Membership model) {
		this.membership = model;
		if (collectionTable != null) {
			updateBinding();
		}
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
		if (dateRangeRidget != null) {
			filter(dateRangeRidget.getStartDate(), dateRangeRidget.getEndDate());
		}
	}

	private List<CollectionJournalLine> filterDate(List<CollectionJournalLine> inputRecords, Date startDate,
			Date endDate) {
		DateFilterUtil<CollectionJournalLine> filterUtil = new DateFilterUtil<CollectionJournalLine>(
				CollectionJournalLine.class, DairyPackage.Literals.COLLECTION_JOURNAL_LINE__COLLECTION_JOURNAL,
				DairyPackage.Literals.COLLECTION_GROUP__JOURNAL_DATE);
		return filterUtil.filterDate(inputRecords, startDate, endDate);		
	}

	private List<CollectionJournalLine> filterNPR() {
		final List<CollectionJournalLine> filteredRecords = new ArrayList<CollectionJournalLine>();
		if ((records == null) || records.isEmpty()) {
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

	// todo: temporary util method, get a list of collection records
	private List<CollectionJournalLine> getCollectionJournalLines() {
		final List<CollectionJournalLine> collectionJournalRecords = new ArrayList<CollectionJournalLine>();
		if (membership != null) {
			final String selectedMemberId = "" + membership.getMemberId();
			final EObject container = membership.eContainer();
			if ((container != null) && (container instanceof Dairy)) {
				final List<CollectionGroup> allRecords = ((Dairy) container).getCollectionJournals();
				for (final CollectionGroup j : allRecords) {
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
}
