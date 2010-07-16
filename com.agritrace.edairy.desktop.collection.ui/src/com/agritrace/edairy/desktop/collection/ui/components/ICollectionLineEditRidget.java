package com.agritrace.edairy.desktop.collection.ui.components;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.riena.ui.ridgets.IRowRidget;

public interface ICollectionLineEditRidget extends IRowRidget {

	void setBinList(IObservableList binList);

}
