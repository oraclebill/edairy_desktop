package com.agritrace.edairy.desktop.milkops.ui.navigation;

public interface NavigationConstants {

	public static final String SUBAPP_MILK_VIEWID = "com.agritrace.edairy.desktop.milk";//$NON-NLS-1$

	public static final String SUBAPP_MILK = "com.agritrace.edairy.desktop.milk";//$NON-NLS-1$

	public static final String MODULE_GROUP_MILK = "milk.navgroup";//$NON-NLS-1$
	public static final String MODULE_MILK_COLLECTIONS = "edm.milk.collection";//$NON-NLS-1$
	public static final String MODULE_MILK_SALES = "edm.milk.delivery";//$NON-NLS-1$
	public static final String MODULE_MILK_ADJUSMENTS = "MODULE_MILK_ADJUSMENTS";//$NON-NLS-1$
	public static final String MODULE_MILK_QCC = "MODULE_MILK_QCC";//$NON-NLS-1$
	public static final String MODULE_MILK_SETUP = "MODULE_MILK_SETUP";//$NON-NLS-1$

	public static final String SUBMODULE_MILK_INTAKE_REGISTER = "edm.milk.collection.log";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_SALES_REGISTER = "edm.milk.delivery.log";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_ADJUSTMENTS_REGISTER = "SUBMODULE_MILK_ADJUSTMENTS_REGISTER";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_TRANSFER_ADJUSTMENTS = "SUBMODULE_MILK_TRANSFER_ADJUSTMENTS";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_GRADE_ADJUSTMENTS = "SUBMODULE_MILK_GRADE_ADJUSTMENTS";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_QCC_VIEWS = "SUBMODULE_MILK_QCC_VIEWS";//$NON-NLS-1$
	public static final String SUBMODULE_MILK_GRADE_LIST = "SUBMODULE_MILK_GRADE_LIST";//$NON-NLS-1$


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

}