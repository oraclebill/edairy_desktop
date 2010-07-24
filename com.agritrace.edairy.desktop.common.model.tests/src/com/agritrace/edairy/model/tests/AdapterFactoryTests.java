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

	private void init(IViewSite site, CTabFolder folder, DataBindingContext ctx, EditingDomain editingDomain,
			IObservableValue master) {
		final TableViewer viewer = new TableViewer(folder, SWT.FULL_SELECTION);

		viewer.getTable().setHeaderVisible(true);
		new ObservableListContentProvider();

//		{
//			IObservableMap[] attributeMap = new IObservableMap[2];
//			attributeMap[0] = EMFEditProperties.value(
//					editingDomain,
//					FeaturePath.fromList(ProjectPackage.Literals.COMMITTER_SHIP__PERSON,
//							ProjectPackage.Literals.PERSON__LASTNAME)).observeDetail(cp.getKnownElements());
//
//			attributeMap[1] = EMFEditProperties.value(
//					editingDomain,
//					FeaturePath.fromList(ProjectPackage.Literals.COMMITTER_SHIP__PERSON,
//							ProjectPackage.Literals.PERSON__FIRSTNAME)).observeDetail(cp.getKnownElements());
//
//			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
//			column.getColumn().setText("Name");
//			column.getColumn().setWidth(150);
//			column.setLabelProvider(new GenericMapCellLabelProvider("{0}, {1}", attributeMap));
//		}
//
//		{
//			IObservableMap attributeMap = EMFEditProperties.value(editingDomain,
//					ProjectPackage.Literals.COMMITTER_SHIP__START).observeDetail(cp.getKnownElements());
//
//			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
//			column.getColumn().setText("Start");
//			column.getColumn().setWidth(100);
//			column.setLabelProvider(new GenericMapCellLabelProvider("{0,date,short}", attributeMap));
//		}
//
//		{
//			IObservableMap attributeMap = EMFEditProperties.value(editingDomain,
//					ProjectPackage.Literals.COMMITTER_SHIP__END).observeDetail(cp.getKnownElements());
//
//			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
//			column.getColumn().setText("End");
//			column.getColumn().setWidth(100);
//			column.setLabelProvider(new GenericMapCellLabelProvider("{0,date,short}", attributeMap));
//		}
//
//		IListProperty prop = EMFEditProperties.list(editingDomain, ProjectPackage.Literals.PROJECT__COMMITTERS);
//		viewer.setContentProvider(cp);
//		viewer.setInput(prop.observeDetail(master));
//
//		MenuManager mgr = new MenuManager();
//		mgr.add(new Action("Hide historic committers", IAction.AS_CHECK_BOX) {
//			@Override
//			public void run() {
//				if (isChecked()) {
//					viewer.addFilter(new ViewerFilterImpl());
//				} else {
//					viewer.setFilters(new ViewerFilter[0]);
//				}
//			}
//		});
//
//		viewer.getControl().setMenu(mgr.createContextMenu(viewer.getControl()));
//		site.registerContextMenu(Activator.PLUGIN_ID + ".committers", mgr, viewer);
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

	private void populate(EObject parent) {
		for (EReference containedIn : parent.eClass().getEAllContainments()) {
			if (containedIn.isTransient() || containedIn.isVolatile() || containedIn.isDerived()) {
				;
				;
			}
			// else if ( containedIn.isRequired() ) {
			else {
				EObject child = EcoreUtil.create(containedIn.getEReferenceType());
				if (containedIn.isMany()) {
					if (containedIn.getLowerBound() > 0) {
						EList<EObject> theList = (EList<EObject>) parent.eGet(containedIn);
						theList.add(child);
						populate(child);
					}
				} else {
					parent.eSet(containedIn, child); // does not work for
														// many-valued
					populate(child);
				}
			}
		}
	}
}
