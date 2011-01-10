package com.agritrace.edairy.desktop.common.ui.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;

public class EMFUtilTestCase {

	class EArray extends ArrayList<EClass> {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
	};

	class OArray extends ArrayList<EObject> {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
	};

	@Test
	public void testContainment() {
		final Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		int count;

		System.out.println("Count : " + (count = EMFUtil.populate(dairy)));
//		System.out.println( EMFUtil.visitedClasses.size() + ": " );
//		for (EClass cls : visitedClasses) {
//			System.out.println (cls.getEPackage().getName() + " : " +  cls.getName());
//		}
		assertEquals(12, count);

		System.out.println("Count : " + (count = EMFUtil.populateMinimal(dairy)));
//		System.out.println( visitedClasses.size() + ": " );
//		for (EClass cls : visitedClasses) {
//			System.out.println (cls.getEPackage().getName() + " : " +  cls.getName());
//		}
		assertEquals(2, count);

	}

	@Test public void testCopyCompare() {
		final Dairy dairy1 = DairyFactory.eINSTANCE.createDairy();
		final Dairy dairy2 = DairyFactory.eINSTANCE.createDairy();

		assertTrue(EMFUtil.compare(dairy1, dairy2));

		EMFUtil.populate(dairy1);
		assertFalse(EMFUtil.compare(dairy1, dairy2));

		EMFUtil.populate(dairy2);
		assertTrue(EMFUtil.compare(dairy1, dairy2));

		dairy1.setCompanyId(3l);
		assertFalse(EMFUtil.compare(dairy1, dairy2));

		final Dairy dairy3 = DairyFactory.eINSTANCE.createDairy();
		EMFUtil.copy(dairy2, dairy3, -1);
		assertTrue(EMFUtil.compare(dairy3, dairy2));

		int nodeCount = 0;
		final TreeIterator<EObject> iter = dairy3.eAllContents();
		while(iter.hasNext()) {
			nodeCount++;
			iter.next();
		}
		assertEquals(25, nodeCount);
	}

}
