package com.agritrace.edairy.desktop.common.ui.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;

import static org.junit.Assert.*;

public class EMFUtilTestCase {

	class EArray extends ArrayList<EClass> {
	};

	class OArray extends ArrayList<EObject> {
	};

	@Test
	public void testContainment() {
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
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
		Dairy dairy1 = DairyFactory.eINSTANCE.createDairy();
		Dairy dairy2 = DairyFactory.eINSTANCE.createDairy();

		assertTrue(EMFUtil.compare(dairy1, dairy2));
		
		EMFUtil.populate(dairy1);
		assertFalse(EMFUtil.compare(dairy1, dairy2));
		
		EMFUtil.populate(dairy2);
		assertTrue(EMFUtil.compare(dairy1, dairy2));

		dairy1.setCompanyId(3l);
		assertFalse(EMFUtil.compare(dairy1, dairy2));
		
		Dairy dairy3 = DairyFactory.eINSTANCE.createDairy();
		EMFUtil.copy(dairy2, dairy3, -1);
		assertTrue(EMFUtil.compare(dairy3, dairy2));
		
		int nodeCount = 0;
		TreeIterator<EObject> iter = dairy3.eAllContents();
		while(iter.hasNext()) {
			nodeCount++;
			iter.next();
		}
		assertEquals(25, nodeCount);
	}

}
