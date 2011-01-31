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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.common.persistence.dao.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.internal.home.HomeActivator;
import com.google.inject.Inject;
import com.swtdesigner.SWTResourceManager;

public class DairyHomeView extends ViewPart {
	public static final String ID = "desktop.home.view";
	private Browser browser;

	private static class HomepageLocationListener extends LocationAdapter {
		@Override
		public void changing(LocationEvent event) {
			System.err.println("CHANGING: " + event.location);
		}
	}

	private static class GetIntakeData extends BrowserFunction {
		private ICollectionJournalLineRepository journalRepository;

		GetIntakeData(ICollectionJournalLineRepository journalRepository,
				Browser browser, String name) {
			super(browser, name);
			this.journalRepository = journalRepository;
		}

		@Override
		public Object function(Object[] arguments) {
			Date dateArg = getDateArg(arguments, 0);
			if (dateArg == null) {
				dateArg = new Date();
			}
			List<Object[]> sums = journalRepository.dailyCollectionsSummary(dateArg);

			Object[] retVal;
			final HashMap<String, Object[]> centerSums = new HashMap<String, Object[]>();

			// for each group, add its collections to the proper sum
			for (Object[] result : sums ) { //  i = 0; i < groups.size(); i++) {

				final String centerName = (String) result[1];

				// get or create a slot to accumulate the sum of the groups
				// collections
				Object[] sumArray = centerSums.get(centerName);
				if (sumArray == null) {
					sumArray = new Object[3];
					sumArray[0] = centerName;
					sumArray[1] = new BigDecimal(0.0);
					sumArray[2] = new BigDecimal(0.0);
					centerSums.put(centerName, sumArray);
				}
				
				// a group contains collections for at most one session -
				// identify it.
				// default to 'am'
				int sessionIndex = 1;
				final String session = (String)result[2];
				if (session != null) {
					if ("PM".equals(session)) {
						sessionIndex = 2;
					}
				}

				sumArray[sessionIndex] = new BigDecimal((Double)result[3]);
				
//				// calculate the sum of collections and store it
//				// values that are flagged or rejected are ignored.
//				final List<CollectionJournalLine> lines = group
//						.getJournalEntries();
//				for (final CollectionJournalLine line : lines) {
//					if (line.isRejected()) {
//						continue;
//					}
//					if (line.isFlagged()) {
//						continue;
//					}
//					sumArray[sessionIndex] = line.getQuantity().add(
//							(BigDecimal) sumArray[sessionIndex]);
//				}
			}

			if (centerSums.size() > 0) {
				List<Object[]> values = new ArrayList<Object[]>(
						centerSums.values());
				Collections.sort(values, new Comparator<Object[]>() {
					@Override
					public int compare(Object[] o1, Object[] o2) {
						return ((String) o1[0]).compareTo((String) o2[0]);
					}
				});
				// NumberFormat formatter = DecimalFormat.getInstance();
				// for (Object obj[] : values) {
				// try {
				// obj[1] = formatter.format((BigDecimal)obj[1]);
				// }
				// catch(IllegalArgumentException ie) {
				// ie.printStackTrace();
				// }
				// try {
				// obj[2] = formatter.format((BigDecimal)obj[2]);
				// }
				// catch(IllegalArgumentException ie) {
				// ie.printStackTrace();
				// }
				// }
				retVal = values.toArray();

			} else {
				retVal = new Object[] { new Object[] { "", 0.0, 0.0 }, };
			}

			return retVal;
		}

		private Date getDateArg(Object[] arguments, int index) {
			Date dateArg = null;
			if (arguments.length > 0) {
				if (arguments[index] instanceof String) {
					String s = (String) arguments[index];
					try {
						dateArg = new SimpleDateFormat("MM/dd/yyyy").parse(s);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return dateArg;
		}

	}

	@Inject
	private static ICollectionJournalLineRepository journalRepository;

	public static ICollectionJournalLineRepository getRepository() {
		return journalRepository;
	}
	
//	@Inject
//	private static ScaleImportAction scaleImportAction;
	
	public DairyHomeView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().generateLayout(parent);
		parent.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		parent.setLayout(new GridLayout(1, false));
		Composite buttonbar = new Composite(parent, SWT.BORDER); 
		buttonbar.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		buttonbar.setLayout( new GridLayout( 7, true) );
		buttonbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		GridDataFactory buttonDataFactory = GridDataFactory.fillDefaults().grab(true, true).hint(-1,40);
		Font buttonFont = SWTResourceManager.getFont("Lucida Grande", 12, SWT.BOLD);
		
		final Button btnImportScale = new Button(buttonbar, SWT.BORDER | SWT.FLAT);
		btnImportScale.setFont(buttonFont);
		btnImportScale.setText("Scale Import");
		buttonDataFactory.applyTo(btnImportScale);
//		btnImportScale.addSelectionListener(scaleImportAction);
//		final Image buttonImage = HomeActivator.getDefault().getImageDescriptor(ImageRegistry.sample_memberphoto);
//		System.err.println("IMAGE: " + buttonImage);
//		btnImportScale.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				btnImportScale.setImage(buttonImage);
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				btnImportScale.setImage(null);
//			}
//			
//		});
		
		Button button_1 = new Button(buttonbar, SWT.FLAT);
		button_1.setFont(buttonFont);
		button_1.setText("Milk Delivery");
		buttonDataFactory.applyTo(button_1);
		
		Button button_2 = new Button(buttonbar, SWT.FLAT);
		button_2.setFont(buttonFont);
		button_2.setText("Farmer Registration");
		buttonDataFactory.applyTo(button_2);
		
		Button button_3 = new Button(buttonbar, SWT.FLAT);
		button_3.setFont(buttonFont);
		button_3.setText("Livestock Registration");
		buttonDataFactory.applyTo(button_3);
		
		Button button_4 = new Button(buttonbar, SWT.FLAT);
		button_4.setFont(buttonFont);
		button_4.setText("Veterinary Requests");
		buttonDataFactory.applyTo(button_4);
		
		Button button_5 = new Button(buttonbar, SWT.FLAT);
		button_5.setFont(buttonFont);
		button_5.setText("Credit Sales");
		buttonDataFactory.applyTo(button_5);
		
		Button button_6 = new Button(buttonbar, SWT.FLAT);
		button_6.setFont(buttonFont);
		button_6.setText("Supplier Directory");
		buttonDataFactory.applyTo(button_6);
		
		browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		browser.addLocationListener(new HomepageLocationListener());
		BrowserFunction bf = new GetIntakeData(journalRepository, browser,
				"getIntakeData");
		try {
			browser.setUrl(FileLocator.resolve(
					new URL(HomeActivator.PLUGIN_WEB_PATH + "index.html"))
					.toString());
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
		browser.refresh();
	}
}
