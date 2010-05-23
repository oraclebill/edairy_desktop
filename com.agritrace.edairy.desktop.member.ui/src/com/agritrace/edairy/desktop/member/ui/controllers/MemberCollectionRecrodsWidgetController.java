package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class MemberCollectionRecrodsWidgetController implements
		WidgetController {

	private IController controller;
	private Membership membership;
	
	private ITableRidget collectionTable;
	private final String[] collectionPropertyNames = { "lineNumber", "collectionJournal", "dairyContainer", "quantity",
			"notRecorded", "rejected", "flagged" };
	private final String[] collectionColumnHeaders = { "Line", "Date", "Container", "Quantity", "NPR Missing",
			"Rejected", "Suspended" };
	private final List<CollectionJournalLine> records = new ArrayList<CollectionJournalLine>();
	
	public MemberCollectionRecrodsWidgetController(SubModuleController controller){
		this.controller = controller;
	}
	@Override
	public void configue() {
		if(controller == null){
			return;
		}
		collectionTable = controller.getRidget(ITableRidget.class, ViewWidgetId.COLLECTION_TABLE);
		collectionTable.bindToModel(new WritableList(records, CollectionJournalLine.class),
				CollectionJournalLine.class, collectionPropertyNames, collectionColumnHeaders);

	}

	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return membership;
	}

	@Override
	public void setInputModel(Object model) {
		this.membership = (Membership)model;
		if(collectionTable != null){
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
		configue();

	}

	@Override
	public void updateBinding() {
		records.clear();
		records.addAll(getCollectionJournalLines());
		collectionTable.setColumnFormatter(1, new ColumnFormatter() {

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
		});
		collectionTable.setColumnFormatter(2, new ColumnFormatter() {

			@Override
			public String getText(Object element) {
				if (element instanceof CollectionJournalLine) {
					if (((CollectionJournalLine) element).getDairyContainer() != null) {
						return ((CollectionJournalLine) element).getDairyContainer().getContainerId();
					}
				}
				return null;
			}
		});
		collectionTable.updateFromModel();


	}
	
	// todo: temporary util method, get a list of collection records
	private List<CollectionJournalLine> getCollectionJournalLines() {
		final List<CollectionJournalLine> collectionJournalRecords = new ArrayList<CollectionJournalLine>();
		if (membership != null) {
			final String selectedMemberId = membership.getMemberId();
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

}
