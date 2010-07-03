package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.util.Assert;

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
		this.domainList = Observables.staticObservableList(domainObjects);
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

	public void setDomainList(IObservableList domainList) {
		Assert.isLegal(domainList.getElementType() == getEntityClass(), "Entity class  " + getEntityClass()
				+ "' and list type '" + domainList.getElementType() + "' not equal");
		this.domainList = domainList;
	}

}