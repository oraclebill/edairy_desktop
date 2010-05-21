package com.agritrace.edairy.desktop.services.ui.utils;

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

import com.agritrace.edairy.desktop.services.ui.Activator;

/**
 * Utilities class for Service
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceUtils {

    /**
     * Defaults date format pattern
     */
    public static String DEFAULT_DATE_PATTERN = "MM/dd/yyyy";
    /**
     * Default date format instance
     */
    public static DateFormat DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
    /**
     * Date to String converter using default date pattern
     */
    public static IConverter DEFAULT_DATE_STRING_CONVERTER = new DateToStringConverter(
	    ServiceUtils.DEFAULT_DATE_PATTERN);

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
     * Gets the first day of month of specific date
     * 
     * @param date
     *            Specific date
     * @return First Day String
     */
    public static String getFirstDayofMonth(Date date) {
	final Date firstDate = getFirstDayOfMonth(date);
	return DATE_FORMAT.format(firstDate);
    }

    /**
     * Gets the first day of month of current time
     * 
     * @return
     */
    public static String getFirstDayofMonth() {
	return getFirstDayofMonth(Calendar.getInstance().getTime());
    }

    /**
     * Gets the first day of a month
     * 
     * @param date
     *            One day in a month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
	final Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.set(Calendar.DAY_OF_MONTH, 1);
	return cal.getTime();
    }

    /**
     * Gets the last day of a month
     * 
     * @param date
     *            One day in a month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {

	final Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	final int lastDate = calendar.getActualMaximum(Calendar.DATE);
	calendar.set(Calendar.DATE, lastDate);
	return calendar.getTime();

    }

    /**
     * Gets the first day of month of specific date
     * 
     * @param date
     *            Specific date
     * @return First Day String
     */
    public static String getLastDayofMonth(Date date) {
	final Date firstDate = getLastDayOfMonth(date);
	return DATE_FORMAT.format(firstDate);
    }

    /**
     * Gets the first day of month of current time
     * 
     * @return
     */
    public static String getLastDayofMonth() {
	return getLastDayofMonth(Calendar.getInstance().getTime());
    }

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
    public static void injectRidgets(IRidgetContainer ridgetContainer, List<Object> uiControls,
	    IBindingPropertyLocator propertyStrategy) {
	final CorrespondingLabelMapper ridgetMapper = new CorrespondingLabelMapper(ridgetContainer);
	if (Activator.getDefault() != null) {
	    Wire.instance(ridgetMapper).andStart(Activator.getDefault().getBundle().getBundleContext());
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

	if (Activator.getDefault() != null) {
	    // TODO This unveils a weakness of the wiring stuff because the
	    // dependency (to the wiring) is just moved the ridget containers to
	    // here :-(
	    Wire.instance(ridgetContainer).andStart(Activator.getDefault().getBundle().getBundleContext());
	}

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
}
