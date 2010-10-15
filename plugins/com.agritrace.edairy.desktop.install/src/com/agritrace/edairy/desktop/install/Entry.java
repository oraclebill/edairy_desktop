package com.agritrace.edairy.desktop.install;

import org.eclipse.emf.ecore.EStructuralFeature;

public class Entry {
	int field;
	EStructuralFeature feature;

	Entry(int field, EStructuralFeature feature) {
		this.field = field;
		this.feature = feature;
	}
}