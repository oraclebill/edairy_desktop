package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.util.Assert;

class FeatureProperties {
	private String bindingId;
	private FeaturePath featurePath;
	private IObservableList domainList;
	private Class<?> entityClass;

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

	public FeaturePath getFeaturePath() {
		return featurePath;
	}

	public IObservableList getDomainList() {
		return domainList;
	}

	public void setDomainList(IObservableList domainList) {
		Assert.isLegal(domainList.getElementType() == getEntityClass(), "Entity class  " + getEntityClass()
				+ "' and list type '" + domainList.getElementType() + "' not equal");
		this.domainList = domainList;
	}

	public Class<?> getEntityClass() {
		if (entityClass == null) {
			entityClass = getTailFeature().eClass().getInstanceClass();
		}
		return entityClass;
	}

	public EStructuralFeature getTailFeature() {
		EStructuralFeature tailFeature = null;

		if (featurePath != null) {
			EStructuralFeature[] features = featurePath.getFeaturePath();
			if (features.length > 0) {
				tailFeature = features[features.length - 1];
			}
		}

		return tailFeature;
	}

}