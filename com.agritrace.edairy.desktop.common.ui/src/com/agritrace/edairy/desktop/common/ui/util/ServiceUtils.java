package com.agritrace.edairy.desktop.common.ui.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.ui.common.IComplexComponent;
import org.eclipse.riena.ui.ridgets.IComplexRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;
import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.eclipse.riena.ui.ridgets.uibinding.CorrespondingLabelMapper;
import org.eclipse.riena.ui.ridgets.uibinding.DefaultBindingManager;
import org.eclipse.riena.ui.ridgets.uibinding.IBindingPropertyLocator;
import org.eclipse.riena.ui.ridgets.uibinding.IControlRidgetMapper;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.framework.BundleContext;

/**
 * Utilities class for Service
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceUtils {

	

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
	 * Dispose composite's children recursively
	 * 
	 * @param comp
	 */
	public static void disposeAllChildrens(Composite comp) {
		if (comp == null) {
			return;
		}
		for (final Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				disposeAllChildrens((Composite) control);

			}
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
	}

	/**
	 * Inject ridgets without configRidgets
	 * 
	 * @param ridgetContainer
	 * @param uiControls
	 * @param propertyStrategy
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

	public static boolean compare(EObject source, EObject target) {
		if (source == null || target == null) {
			return false;
		}
		if (!source.getClass().equals(target.getClass())) {
			return false;
		}
		final EClass eClass = source.eClass();
		// compare all features - all must match exactly.. do not follow references
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			final EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (feature instanceof EAttribute) {
				try {
					Object srcVal, targVal;
					srcVal = source.eGet(feature);
					targVal = target.eGet(feature);
					if ((srcVal != null) && (targVal != null)) {
						if ( ! srcVal.equals(targVal)) return false;
					}
					else if (srcVal == null || targVal == null ) {
						return false;
					}
				} catch (final Exception e) {
					e.printStackTrace();					
					return false;
				}
			} 
			// references should equal each other..
			// if one is a ref, both must be refs
			else if (feature instanceof EReference 
					&& source.eGet(feature) instanceof EObject
					&& target.eGet(feature) instanceof EObject
					&& (source.eGet(feature) != target.eGet(feature))) {
				return false;
			}
		}
		return true;
	}
	
	
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
			} else if (feature instanceof EReference && source.eGet(feature) instanceof EObject
					&& target.eGet(feature) instanceof EObject) {
				copy((EObject) source.eGet(feature), (EObject) target.eGet(feature));
				// } else if (feature instanceof EReference
				// && source.eGet(feature) instanceof List
				// && target.eGet(feature) instanceof List) {
				// {
				// List sourceList = (List) source.eGet(feature);
				// List targetList = (List) target.eGet(feature);
				//
				// if (sourceList.size)
				// for (int j = 0; j < sourceList.size(); j++) {
				// Object sourceObj = sourceList.get(j);
				// Object targetObj = targetList.get(j);
				// if (sourceObj instanceof EObject
				// && targetObj instanceof EObject) {
				// copy((EObject) sourceObj, (EObject) targetObj);
				// }
				//
				// }
				// }
			}
		}

	}
	
	/**
	 * Get one month date before the current date
	 * @return date one month ago, {@link Date}
	 */
	public static Date getOneMonthBeforeCurrentDate(){
		  Calendar now = Calendar.getInstance();
		  now.add(Calendar.MONDAY,-1);
		  return now.getTime();
	}
	
	/**
	 * Get the formatted String of the date one month before the current date.
	 * @return the formatted String "MM/dd/yyyy"
	 */
	public static String getOneMonthBeforeCurrentDateString(){
		Date date = getOneMonthBeforeCurrentDate();
		return DATE_FORMAT.format(date);
	}
	
	/**
	 * Get the current date
	 * @return date one month ago, {@link Date}
	 */
	public static Date getCurrentDate(){
		  Calendar now = Calendar.getInstance();
		  return now.getTime();
	}
	
	/**
	 * Get the formatted String of the current date.
	 * @return the formatted String "MM/dd/yyyy"
	 */
	public static String getCurrentDateString(){
		Date date = getCurrentDate();
		return DATE_FORMAT.format(date);
	}
}
