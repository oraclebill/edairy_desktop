package com.agritrace.edairy.desktop.birt.viewer;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.junit.Test;


public class ReportsIndexViewControllerTest extends AbstractSubModuleControllerTest<ReportsIndexViewController> {

		public ReportsIndexViewControllerTest() {
			
		}

		@Override
		protected ReportsIndexViewController createController(ISubModuleNode node) {
			return new ReportsIndexViewController();
		}
		
		
		@Test
		public void testReportIndex() throws Exception {
			ReportsIndexViewController controller = getController();
			ITableRidget reportTable = controller.getRidget(ITableRidget.class, "report-list-table");
			IObservableList tableItems = reportTable.getObservableList();
			
			for (Object item : tableItems) {
				System.err.println(item);
			}
			
			
		}
}
