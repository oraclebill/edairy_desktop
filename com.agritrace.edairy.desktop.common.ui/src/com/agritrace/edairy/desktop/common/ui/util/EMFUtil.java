package com.agritrace.edairy.desktop.common.ui.util;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EMFUtil {

	public static boolean compare(EObject src, EObject dst) {
		if ((src == null) && (dst == null)) {
			return true;
		}
		if ((src == null) || (dst == null)) {
			return false;
		}

		final String str1 = src.toString();
		final String str2 = dst.toString();
		return str1.substring(str1.indexOf('('), str1.indexOf(')')).equals(
				str2.substring(str2.indexOf('('), str2.indexOf(')')));
	}

	/**
	 * Copy EMF objects from source to target
	 * 
	 * @param source
	 *            Source EMF Object
	 * @param target
	 *            Target EMF object
	 */
	@SuppressWarnings("unchecked")
	public static void copy(EObject source, EObject target, int depth) {
		System.out.println("Source:" + source.eClass().getName() + " Target:" + target.eClass().getName());
		if ((source == null) || (target == null)) {
			return;
		}
		if (!source.getClass().equals(target.getClass())) {
			return;
		}
		final EClass eClass = source.eClass();
		if (depth > -1) {
			for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {

				final EStructuralFeature feature = eClass.getEStructuralFeature(i);
				if (feature instanceof EAttribute) {
					try {
						target.eSet(feature, source.eGet(feature));
					} catch (final Exception e) {

					}
				} else if ((feature instanceof EReference) && (source.eGet(feature) instanceof EObject)
						&& (target.eGet(feature) instanceof EObject)) {
					copy((EObject) source.eGet(feature), (EObject) target.eGet(feature), depth - 1);
				} else if ((feature instanceof EReference) && (source.eGet(feature) instanceof List)
						&& (target.eGet(feature) instanceof List)) {
					{
						final List<EObject> sourceList = (List<EObject>) source.eGet(feature);
						final List<EObject> targetList = (List<EObject>) target.eGet(feature);
						targetList.clear();

						for (int j = 0; j < sourceList.size(); j++) {
							final EObject sourceObj = (EObject) sourceList.get(j);
							final EObject targetObj = createObject(sourceObj.eClass());
							// if (sourceObj instanceof EObject
							// && targetObj instanceof EObject) {
							copy(sourceObj, targetObj, depth - 1);
							// //}
							targetList.add(targetObj);

						}
					}
				}
			}
		}

	}

	/**
	 * Create working copy
	 * 
	 * @param className
	 * @return
	 */
	public static EObject createWorkingCopy(EClass cls, int depth) {

		final EObject object = createObject(cls);
		if (depth > -1) {
			if (object != null) {
				for (final EReference reference : cls.getEAllReferences()) {
					if (!reference.isMany()) {

						object.eSet(reference, createWorkingCopy(reference.getEReferenceType(), depth - 1));

					}
					else if (reference.isContainment())
					{
						object.eSet(reference, new BasicEList());
					}
				}
			}
		}

		return object;
	}

	/**
	 * Creates EObject
	 * 
	 * @param className
	 * @return
	 */
	public static EObject createObject(EClass cls) {
		final EFactory eFactory = cls.getEPackage().getEFactoryInstance();
		return eFactory.create(cls);

	}

	/**
	 * Compares EObject feature by feature
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean compareAllFeatures(EObject source, EObject target) {
		if ((source == null) || (target == null)) {
			return false;
		}
		if (!source.getClass().equals(target.getClass())) {
			return false;
		}
		final EClass eClass = source.eClass();
		// compare all features - all must match exactly.. do not follow
		// references
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			final EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (feature instanceof EAttribute) {
				try {
					Object srcVal, targVal;
					srcVal = source.eGet(feature);
					targVal = target.eGet(feature);
					if ((srcVal != null) && (targVal != null)) {
						if (!srcVal.equals(targVal))
							return false;
					} else if ((srcVal == null) || (targVal == null)) {
						return false;
					}
				} catch (final Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			// references should equal each other..
			// if one is a ref, both must be refs
			else if ((feature instanceof EReference) && (source.eGet(feature) instanceof EObject)
					&& (target.eGet(feature) instanceof EObject) && (source.eGet(feature) != target.eGet(feature))) {
				return false;
			}
		}
		return true;
	}

}
