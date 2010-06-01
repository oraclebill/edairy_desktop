package com.agritrace.edairy.desktop.common.ui.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.IComplexRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.ridgets.uibinding.CorrespondingLabelMapper;
import org.eclipse.riena.ui.ridgets.uibinding.DefaultBindingManager;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.ridgets.uibinding.IControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.osgi.framework.BundleContext;

/**
 * Utilies class for ridget
 * 
 * @author Hui(Spark Wans
 * 
 */
public class RidgetUtils {

	private static class BindingManager extends DefaultBindingManager {
		public BindingManager(IBindingPropertyLocator propertyStrategy, IControlRidgetMapper<Object> mapper) {
			super(propertyStrategy, mapper);

		}

		@Override
		public void injectRidget(IRidgetContainer ridgetContainer, String bindingProperty, IRidget ridget) {
			super.injectRidget(ridgetContainer, bindingProperty, ridget);
		}
	}

	private static final BindingManager BINDING_MAN = new BindingManager(SWTBindingPropertyLocator.getInstance(),
			SwtControlRidgetMapper.getInstance());

	/**
	 * Inject ridgets without configRidgets
	 * 
	 * @param ridgetContainer
	 *            Ridget container
	 * @param uiControls
	 *            UI contros
	 * @param propertyStrategy
	 *            Property strategy
	 */
	public static void injectRidgets(BundleContext context, IRidgetContainer ridgetContainer, List<Object> uiControls,
			IBindingPropertyLocator propertyStrategy) {
		final CorrespondingLabelMapper ridgetMapper = new CorrespondingLabelMapper(ridgetContainer);
		if (context != null) {
			Wire.instance(ridgetMapper).andStart(context);
		}

		final Map<String, IRidget> controls = new HashMap<String, IRidget>();

		for (final Object control : uiControls) {
			final String bindingProperty = propertyStrategy.locateBindingProperty(control);
			if (bindingProperty != null) {
				final IRidget ridget = BINDING_MAN.createRidget(control);
				BINDING_MAN.injectRidget(ridgetContainer, bindingProperty, ridget);

				// because the ridgets are not bound yet, we have to save the
				// bindingProperty separately
				if (!(ridget instanceof ILabelRidget)) {
					controls.put(bindingProperty, ridget);
				}

				if (control instanceof IComplexComponent) {
					final IComplexRidget complexRidget = (IComplexRidget) ridget;
					final IComplexComponent complexComponent = (IComplexComponent) control;
					BINDING_MAN.injectRidgets(complexRidget, complexComponent.getUIControls());
				}
				ridget.setUIControl(control);

			}
		}

		// iterate over all controls that are not ILabelRidgets and try to
		// connect
		// them with their corresponding Label
		final Iterator<Entry<String, IRidget>> it = controls.entrySet().iterator();
		while (it.hasNext()) {
			final Entry<String, IRidget> entry = it.next();
			ridgetMapper.connectCorrespondingLabel(entry.getValue(), entry.getKey());
		}

		if (null != context) {
			// TODO This unveils a weakness of the wiring stuff because the
			// dependency (to the wiring) is just moved the ridget containers to
			// here :-(
			Wire.instance(ridgetContainer).andStart(context);
		}

	}
}
