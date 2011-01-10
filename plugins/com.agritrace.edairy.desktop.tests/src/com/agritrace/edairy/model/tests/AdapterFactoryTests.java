package com.agritrace.edairy.model.tests;

import java.text.MessageFormat;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.junit.Test;

public class AdapterFactoryTests {

	public class GenericMapCellLabelProvider extends ObservableMapCellLabelProvider {
		private final IObservableMap[] attributeMaps;
		private final String messagePattern;

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
			final Object element = cell.getElement();
			final Object[] values = new Object[attributeMaps.length];
			int i = 0;
			for (final IObservableMap m : attributeMaps) {
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
