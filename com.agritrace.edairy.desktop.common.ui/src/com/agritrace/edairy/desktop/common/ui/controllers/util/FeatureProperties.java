package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EStructuralFeature;

class FeatureProperties {
	private final String bindingId;
	private IObservableList domainList;
	private Class<?> entityClass;
	private final FeaturePath featurePath;

	public FeatureProperties(String bindingId, EStructuralFeature... featureList) {
		this(bindingId, null, FeaturePath.fromList(featureList));
	}

	public FeatureProperties(String bindingId, List<?> domainList, EStructuralFeature... featureList) {
		this(bindingId, domainList, FeaturePath.fromList(featureList));
	}

	public FeatureProperties(String bindingId, List<?> domainObjects, FeaturePath featurePath) {
		this.bindingId = bindingId;
		this.featurePath = featurePath;
//		this.domainList = domainObjects == null ? null : Observables.staticObservableList(domainObjects);
		this.domainList = domainObjects == null ? null : new WritableList(domainObjects, getTailFeature().eClass().getInstanceClass());
	}

	public String getBindingId() {
		return bindingId;
	}

	public IObservableList getDomainList() {
		return domainList;
	}

	public Class<?> getEntityClass() {
		if (entityClass == null) {
			entityClass = getTailFeature().eClass().getInstanceClass();
		}
		return entityClass;
	}

	public FeaturePath getFeaturePath() {
		return featurePath;
	}

	public EStructuralFeature getTailFeature() {
		EStructuralFeature tailFeature = null;
		if (featurePath != null) {
			final EStructuralFeature[] features = featurePath.getFeaturePath();
			if (features.length > 0) {
				tailFeature = features[features.length - 1];
			}
		}
		return tailFeature;
	}
}