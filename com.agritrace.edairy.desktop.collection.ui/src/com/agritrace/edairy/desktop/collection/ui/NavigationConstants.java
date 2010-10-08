package com.agritrace.edairy.desktop.collection.ui;

public interface NavigationConstants {

	public static final String SUBAPP_MILK_VIEWID = "com.agritrace.edairy.desktop.milk";


	public static final String MODULE_GROUP_MILK = "milk.navgroup";//$NON-NLS-1$
	public static final String MODULE_MILK_COLLECTIONS = "edm.milk.collection";//$NON-NLS-1$
	public static final String MODULE_MILK_DELIVERY = "edm.milk.delivery";//$NON-NLS-1$
	// MILK
	public static final String SUBAPP_MILK = "com.agritrace.edairy.desktop.milk";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_COLLECTIONS_DETAIL_ENTRY = "edm.milk.collection.entry";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_COLLECTIONS_DETAIL_REGISTER = "edm.milkcollection.detail.log";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_COLLECTIONS_REGISTER = "edm.milk.collection.log";//$NON-NLS-1$

	public static final String SUBMODULE_MILK_DELIVERY_REGISTER = "edm.milk.delivery.log";//$NON-NLS-1$


	/**
	- milk
		- collections by route (journal-file-view)
			- posted (journal-file-view)
				- journal view (journal-detail-view) [edit -> working]
			- working (journal-file-view)
				- detail entry view (journal-detail-edit-view) [save -> completed, suspend -> suspended]
				- validate import view [save, suspend]
			- suspended (journal-file-view)
				- journal view [admin-edit]
			- completed
				- journal view [archive]
		- deliveries
			- posted
			- working
			- completed

	- milk collections
		- by route
			- by status

	**/
//	public static final String MILK_COLLECTION_JOURNAL_DETAIL_NODE = "milk.collection.working-journals";
	public static final String MILK_COLLECTION_JOURNAL_DETAIL_NODE = "milk.collection.working-journals";

}