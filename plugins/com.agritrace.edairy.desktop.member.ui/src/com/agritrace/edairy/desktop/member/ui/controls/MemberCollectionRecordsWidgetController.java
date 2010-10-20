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

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.DateFilterUtil;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.IDateRangeRidget;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberCollectionRecordsWidgetController implements
		WidgetController<Membership>, IActionListener {

	public final static class DairyContainerIdColumnFormatter extends
			ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				if (((CollectionJournalLine) element).getDairyContainer() != null) {
					return ""
							+ ((CollectionJournalLine) element)
									.getDairyContainer().getContainerId();
				}
			}
			return null;
		}
	}

	public final static class JournalSessionColumnFormatter extends
			ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof CollectionJournalLine) {
				final CollectionGroup journal = ((CollectionJournalLine) element)
						.getCollectionJournal();
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
				final Date entryDate = ((CollectionJournalLine) element)
						.getCollectionJournal().getJournalDate();
				final SimpleFormattedDateBean dateFormatter = new SimpleFormattedDateBean();
				dateFormatter.setDate(entryDate);
				return dateFormatter.getFormattedDate();
			}
			return null;
		}
	}

	private final String[] collectionColumnHeaders = { "Session", "Date",
			"Container", "Quantity", "NPR Missing", "Rejected", "Suspended" };
	private final String[] collectionPropertyNames = { "collectionJournal",
			"collectionJournal", "dairyContainer", "quantity", "notRecorded",
			"rejected", "flagged" };

	private ITableRidget collectionTable;

	private IRidgetContainer container;
	private IDateRangeRidget dateRangeRidget;
	private Membership membership;
	private IToggleButtonRidget nprMissing;
	private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
	private IToggleButtonRidget rejected;
	private IToggleButtonRidget suspended;
	private IMilkCollectionRepository collectionsRepo;

	public MemberCollectionRecordsWidgetController(IController controller,
			IMilkCollectionRepository collectionsRepo) {
		this.container = controller;
		this.collectionsRepo = collectionsRepo;
		configure();
	}

	@Override
	public void callback() {
		updateBinding();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}

		collectionTable = container.getRidget(ITableRidget.class,
				ViewWidgetId.COLLECTION_TABLE);
		// if (null == collectionTable) {
		// return;
		// }

		collectionTable.setColumnFormatter(0,
				new JournalSessionColumnFormatter());
		collectionTable.setColumnFormatter(1, new EntryDateColumnFormatter());
		collectionTable.setColumnFormatter(2,
				new DairyContainerIdColumnFormatter());

		collectionTable.bindToModel(new WritableList(records,
				CollectionJournalLine.class), CollectionJournalLine.class,
				collectionPropertyNames, collectionColumnHeaders);

		nprMissing = container.getRidget(IToggleButtonRidget.class,
				ViewWidgetId.COLLECTION_FILTER_NPRMISSING);
		rejected = container.getRidget(IToggleButtonRidget.class,
				ViewWidgetId.COLLECTION_FILTER_REJECTED);
		suspended = container.getRidget(IToggleButtonRidget.class,
				ViewWidgetId.COLLECTION_FILTER_FLAG);
		dateRangeRidget = container.getRidget(IDateRangeRidget.class,
				ViewWidgetId.COLLECTION_FILTER_DATE_RANGE);
		nprMissing.addListener(this);
		rejected.addListener(this);
		suspended.addListener(this);

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
//		this.container = container;
//		configure();
		throw new UnsupportedOperationException();
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

		collectionTable.updateFromModel();
	}

	private List<CollectionJournalLine> getCollectionJournalLines() {
		final Date startDate = dateRangeRidget.getStartDate();
		final Date endDate = dateRangeRidget.getEndDate();
		final boolean isMissing = nprMissing.isSelected(), isRejected = rejected
				.isSelected();
		return collectionsRepo.findCollections(null, null, startDate, endDate,
				isMissing, isRejected, null);
	}
}
