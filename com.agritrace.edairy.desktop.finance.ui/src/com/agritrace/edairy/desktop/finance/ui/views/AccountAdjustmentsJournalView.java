/**
 * 
 */
package com.agritrace.edairy.desktop.finance.ui.views;

import java.util.List;

import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;

/**
 * @author bjones
 *
 */
public class AccountAdjustmentsJournalView extends BasicDirectoryController<AdjustmentTransaction> {
	
	public static final String ID = "member.account.adjustment.journal";

	@Override
	protected void configureFilterRidgets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<AdjustmentTransaction> getFilteredResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RecordDialog<AdjustmentTransaction, ?> getRecordDialog(Shell shell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		// TODO Auto-generated method stub
		
	}

}
