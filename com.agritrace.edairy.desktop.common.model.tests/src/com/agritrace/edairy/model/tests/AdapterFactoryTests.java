package com.agritrace.edairy.model.tests;

import java.text.MessageFormat;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.ui.IViewSite;
import org.junit.Test;

public class AdapterFactoryTests {

	public class GenericMapCellLabelProvider extends ObservableMapCellLabelProvider {
		private IObservableMap[] attributeMaps;
		private String messagePattern;

		/**
		 * Create a new label provider
		 * 
		 * @param messagePattern
		 *            the message pattern
		 * @param attributeMaps
		 *            the values to observe
		 */
		public GenericMapCellLabelProvider(String messagePattern, IObservableMap... attributeMaps) {
			super(attributeMaps);
			this.messagePattern = messagePattern;
			this.attributeMaps = attributeMaps;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			Object[] values = new Object[attributeMaps.length];
			int i = 0;
			for (IObservableMap m : attributeMaps) {
				values[i++] = m.get(element);
				if (values[i - 1] == null) {
					cell.setText("");
					return;
				}
			}
			cell.setText(MessageFormat.format(messagePattern, values));
		}
	}

	@Test
	public void testItemProvider() throws Exception {
//		DairyAdapterFactory daf = new DairyAdapterFactory();
//		MembershipItemProvider mip = new MembershipItemProvider(daf);
//		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
//		Membership member = DairyFactory.eINSTANCE.createMembership();
//		populate(member);
//		dairy.getMemberships().add(member);
//		for (int i = 0; i < 10; i++) {
//			dairy.getMemberships().add(EcoreUtil.copy(member));
//		}
//
//		DairyItemProviderAdapterFactory dipaf = new DairyItemProviderAdapterFactory();
//
//		Adapter a = dipaf.createMembershipAdapter();
//		TableViewer tv = new TableViewer(null);
//		tv.setContentProvider(new IContentProvider() {
//
//			@Override
//			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void dispose() {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		System.err.println(mip.getElements(member));
//		System.err.println(mip.getElements(dairy));
	}
}
