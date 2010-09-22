/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package com.agritrace.edairy.desktop.home.views;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.internal.home.HomeActivator;

public class DairyHomeView extends ViewPart {
	public static final String ID = "desktop.home.view";

	private static class HomepageLocationListener extends LocationAdapter {
		@Override
		public void changing(LocationEvent event) {
			System.err.println("CHANGING: " + event.location);
		}
	}

	private static class GetIntakeData extends BrowserFunction {
		GetIntakeData(Browser browser, String name) {
			super(browser, name);
		}
		public Object function (Object[] arguments) {
			Date today = new Date();
			ICollectionJournalLineRepository journalRepository = (ICollectionJournalLineRepository) RepositoryFactory.getRepository(CollectionJournalLine.class);
			List<CollectionGroup> groups = journalRepository.allForDate(today);

			Object[] retVal;
			HashMap<String, Object[]> centerSums = new HashMap<String, Object[]>();
			
			// for each group, add its collections to the proper sum
			for (int i = 0; i < groups.size(); i++) {
				CollectionGroup group = groups.get(i);
				String centerName = group.getCollectionCenter().getName();
				
				// get or create a slot to accumulate the sum of the groups collections
				Object[] sumArray = centerSums.get(centerName);
				if (sumArray == null) {
					sumArray = new Object[3];
					sumArray[0] = centerName;
					sumArray[1] = new BigDecimal(0.0);
					sumArray[2] = new BigDecimal(0.0);
					centerSums.put(centerName, sumArray);
				}
				
				// a group contains collections for at most one session - identify it.
					// default to 'am'
				int sessionIndex = 1;
				CollectionSession session = group.getSession();
				if ( session != null ) {
					if( "PM".equals(session.getCode()) ) sessionIndex = 2;	
				}
				
				// calculate the sum of collections and store it 
				//    values that are flagged or rejected are ignored.
				List<CollectionJournalLine> lines = group.getJournalEntries();
				for ( CollectionJournalLine line : lines ) {
					if (line.isRejected()) continue;
					if (line.isFlagged()) continue;
					
					sumArray[sessionIndex] = line.getQuantity().add((BigDecimal)sumArray[sessionIndex]); 
				}
			}
			retVal = centerSums.values().toArray();	
			return retVal;
		}

	}
	
	public DairyHomeView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().generateLayout(parent);
		parent.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		parent.setLayout(new GridLayout(1, false));

		Browser browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		browser.addLocationListener(new HomepageLocationListener());
		new GetIntakeData(browser, "getIntakeData");
		
		try {
			browser.setUrl(FileLocator.resolve(
					new URL(HomeActivator.PLUGIN_WEB_PATH + "index.html"))
					.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
	}

}
