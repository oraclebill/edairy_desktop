package com.agritrace.edairy.desktop.common.ui.util;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EMFUtil {
    public static boolean compare(EObject src, EObject dst) {
	if (src == null && dst == null) {
	    return true;
	}
	if (src == null || dst == null) {
	    return false;
	}

	final String str1 = src.toString();
	final String str2 = dst.toString();
	return str1.substring(str1.indexOf('('), str1.indexOf(')')).equals(
		str2.substring(str2.indexOf('('), str2.indexOf(')')));
    }
    
    /**
     * Copy EMF objects from sourc to target
     * 
     * @param source
     * @param target
     */
	public static void copy(EObject source, EObject target) {
		if (source == null || target == null) {
			return;
		}
		if (!source.getClass().equals(target.getClass())) {
			return;
		}
		final EClass eClass = source.eClass();
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {

			final EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (feature instanceof EAttribute) {
				try {
					target.eSet(feature, source.eGet(feature));
				} catch (final Exception e) {

				}
			} else if (feature instanceof EReference
					&& source.eGet(feature) instanceof EObject
					&& target.eGet(feature) instanceof EObject) {
				copy((EObject) source.eGet(feature), (EObject) target
						.eGet(feature));
			} else if (feature instanceof EReference
					&& source.eGet(feature) instanceof List
					&& target.eGet(feature) instanceof List) {
				{
					List sourceList = (List) source.eGet(feature);
					List targetList = (List) target.eGet(feature);

					for (int j = 0; j < sourceList.size(); j++) {
						Object sourceObj = sourceList.get(j);
						if (targetList.size() > j) {
							Object targetObj = targetList.get(j);
							if (sourceObj instanceof EObject
									&& targetObj instanceof EObject) {
								copy((EObject) sourceObj, (EObject) targetObj);
							}
						}

					}
				}
			}
		}

	}

}
