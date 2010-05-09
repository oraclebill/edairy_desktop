package com.agritrace.edairy.service.ui.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Hui(Spark) Wan
 *
 */
public abstract class EMFModel2UIConverter implements IConverter {

	private EStructuralFeature feature;
	private EObject eObject;
	private Object targetType;

	public EMFModel2UIConverter(EObject eObject,
			EStructuralFeature fromTypeFeature, Object targetType) {
		super();
		this.eObject = eObject;
		this.feature = fromTypeFeature;
		this.targetType = targetType;
	}

	@Override
	public Object getFromType() {
		return EMFObservables.observeValue(this.eObject, this.feature)
				.getValueType();
	}

	protected Object filter(Object object) {
		return object;

	}

	@Override
	public Object getToType() {
		return targetType;
	}

}
