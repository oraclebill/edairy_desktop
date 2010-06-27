/*******************************************************************************
 * Copyright (c) 2007, 2010 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.swt.lnf;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.service.log.LogService;

import org.eclipse.equinox.log.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.cache.LRUHashMap;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;

/**
 * This class updates the properties of the UI controls according the settings
 * of the current Look&Feel.
 */
public class LnFUpdater {

	private final static Map<String, Object> RESOURCE_CACHE = LRUHashMap.createSynchronizedLRUHashMap(200);
	private static final Object NULL_RESOURCE = new Object();
	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/**
	 * System property defining if properties of views are updated.
	 */
	private static final String PROPERTY_RIENA_LNF_UPDATE_VIEW = "riena.lnf.update.view"; //$NON-NLS-1$

	private final static Map<Class<? extends Control>, List<PropertyDescriptor>> CONTROL_PROPERTIES = new HashMap<Class<? extends Control>, List<PropertyDescriptor>>();
	private final static Map<Class<? extends Control>, Map<String, Object>> DEFAULT_PROPERTY_VALUES = new HashMap<Class<? extends Control>, Map<String, Object>>();
	private final static Set<Class<? extends Control>> CONTROLS_AFTER_BIND = new HashSet<Class<? extends Control>>();

	private final static List<PropertyDescriptor> EMPTY_DESCRIPTORS = Collections.emptyList();

	private static final Composite SHELL_COMPOSITE = new Composite(new Shell(), SWT.NONE);

	private boolean dirtyLayout;
	private static final Map<Class<? extends Control>, String> SIMPLE_NAMES = new HashMap<Class<? extends Control>, String>();

	private static final Logger LOGGER = Log4r.getLogger(LnFUpdater.class);

	public LnFUpdater() {
		super();
	}

	/**
	 * @since 1.2
	 */
	public static void addControlsAfterBind(Class<? extends Control> controlClass) {
		CONTROLS_AFTER_BIND.add(controlClass);
	}

	/**
	 * Updates the properties of all children of the given composite.
	 * 
	 * @param parent
	 *            composite which children are updated.
	 * @param updateLayout
	 *            on {@code true} update the layout; otherwise not
	 */
	public void updateUIControls(Composite parent, boolean updateLayout) {

		if (checkPropertyUpdateView()) {
			setDirtyLayout(false);
			updateUIControlsRecursive(parent);
		} else {
			setDirtyLayout(true);
		}
		if (updateLayout) {
			updateLayout(parent);
		}

	}

	/**
	 * Updates the layout of the given composite only if it's necessary.
	 * 
	 * @param parent
	 *            composite which children are updated.
	 */
	private void updateLayout(Composite parent) {
		if (isDirtyLayout()) {
			parent.layout(true, true);
			setDirtyLayout(false);
		}
	}

	/**
	 * Updates the properties of all children of the given composite.
	 * 
	 * @param parent
	 *            composite which children are updated.
	 */
	private void updateUIControlsRecursive(Composite parent) {

		Control[] controls = parent.getChildren();
		for (Control uiControl : controls) {

			updateUIControl(uiControl);

			if (uiControl instanceof Composite) {
				updateUIControlsRecursive((Composite) uiControl);
			}

		}

	}

	/**
	 * Updates the properties of all children of the given composite and updates
	 * the layout of the given parent.
	 * 
	 * @param parent
	 *            composite which children are updated.
	 */
	public void updateUIControlsAfterBind(Composite parent) {

		if (checkPropertyUpdateView()) {
			setDirtyLayout(false);
			updateUIControlsRecursive(parent);
		} else {
			setDirtyLayout(true);
		}
		updateLayout(parent);

	}

	/**
	 * Checks the value of the system property "riena.lnf.update.view".
	 * 
	 * @return value of system property
	 */
	private boolean checkPropertyUpdateView() {
		return Boolean.getBoolean(PROPERTY_RIENA_LNF_UPDATE_VIEW);
	}

	/**
	 * Updates the properties of the UI control according to the values of the
	 * LnF.
	 * <p>
	 * Note: this is very frequently (basically once for each control in the UI)
	 * so it is performance sensitive.
	 * 
	 * @param control
	 *            UI control
	 */
	public void updateUIControl(Control control) {

		if (!checkPropertyUpdateView()) {
			return;
		}

		int classModifiers = control.getClass().getModifiers();
		if (!Modifier.isPublic(classModifiers)) {
			return;
		}
		if (!checkLnfKeys(control)) {
			return;
		}
		List<PropertyDescriptor> properties = getProperties(control);
		for (PropertyDescriptor property : properties) {
			Object newValue = getLnfValue(control, property);
			if (newValue == null) {
				continue;
			}
			Object currentValue = getPropertyValue(control, property);
			if (valuesEquals(currentValue, newValue)) {
				continue;
			}
			if (hasNoDefaultValue(control, property, currentValue)) {
				continue;
			}
			try {
				Method setter = property.getWriteMethod();
				setter.invoke(control, newValue);
				setDirtyLayout(true);
			} catch (IllegalArgumentException e) {
				LOGGER.log(LogService.LOG_WARNING, getErrorMessage(control, property), e);
			} catch (IllegalAccessException e) {
				LOGGER.log(LogService.LOG_WARNING, getErrorMessage(control, property), e);
			} catch (InvocationTargetException e) {
				LOGGER.log(LogService.LOG_WARNING, getErrorMessage(control, property), e);
			}
		}
	}

	/**
	 * Returns whether the given property should be ignored for the given
	 * control.
	 * <p>
	 * Properties of the annotation {@code IgnoreLnFUpdater} should not be
	 * changed.
	 * 
	 * @param control
	 *            UI control
	 * @param property
	 *            property to check
	 * @return {@code true} if property should be ignored; otherwise {@code
	 *         false}
	 */
	private boolean ignoreProperty(final Class<? extends Control> controlClass, final PropertyDescriptor property) {

		final IgnoreLnFUpdater ignoreLnFUpdater = controlClass.getAnnotation(IgnoreLnFUpdater.class);
		if (ignoreLnFUpdater != null) {
			String[] ignoreProps = ignoreLnFUpdater.value();
			for (String ignoreProp : ignoreProps) {
				if (ignoreProp != null) {
					if (ignoreProp.equals(property.getName())) {
						return true;
					}
				}
			}
		}
		//		final Class<?> superclass = controlClass.getSuperclass();
		//		if (Control.class.isAssignableFrom(superclass)) {
		//			return ignoreProperty((Class<? extends Control>) superclass, property);
		//		}

		return false;

	}

	/**
	 * Checks if a key for the given control exists in the current Look&Feel. If
	 * no key for the control exits, checks keys for the (optional) style exits.
	 * 
	 * @param control
	 *            UI control
	 * @return {@code true} if latest one key exists; otherwise {@code false}
	 */
	private boolean checkLnfKeys(Control control) {
		Class<? extends Control> controlClass = control.getClass();
		if (checkLnfClassKeys(controlClass)) {
			return true;
		}

		RienaDefaultLnf lnf = LnfManager.getLnf();
		String style = (String) control.getData(UIControlsFactory.KEY_LNF_STYLE);
		return lnf.containsLnfResourcePrefix(style);

	}

	/**
	 * Checks if a key for the given control class exists in the current
	 * Look&Feel.
	 * 
	 * @param controlClass
	 *            class of the UI control
	 * @return {@code true} if latest one key exists; otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	private boolean checkLnfClassKeys(Class<? extends Control> controlClass) {

		String className = getSimpleClassName(controlClass);
		if (className.length() != 0) {
			RienaDefaultLnf lnf = LnfManager.getLnf();
			if (lnf.containsLnfResourcePrefix(className)) {
				return true;
			}
		}

		final Class<?> superclass = controlClass.getSuperclass();
		if (Control.class.isAssignableFrom(superclass)) {
			return checkLnfClassKeys((Class<? extends Control>) superclass);
		}

		return false;

	}

	/**
	 * Returns the simple name of a class.<br>
	 * For anonymous classes the name of the super class is returned.
	 * 
	 * @param controlClass
	 *            class of the UI control
	 * @return simple name of the class or empty string if non existent
	 */
	private String getSimpleClassName(final Class<? extends Control> controlClass) {
		String simpleName = SIMPLE_NAMES.get(controlClass);
		if (simpleName == null) {
			simpleName = getSimpleClassNameBasic(controlClass);
			SIMPLE_NAMES.put(controlClass, simpleName);
		}
		return simpleName;
	}

	private String getSimpleClassNameBasic(final Class<? extends Control> controlClass) {
		String simpleName;
		Class<?> clazz = controlClass;

		while ((simpleName = clazz.getSimpleName()).length() == 0) {
			clazz = clazz.getSuperclass();
			if (!Control.class.isAssignableFrom(clazz)) {
				return EMPTY_STRING;
			}
		}
		return simpleName;
	}

	/**
	 * Compares the default value of the UI control and the current value of the
	 * given property.
	 * 
	 * @param control
	 *            UI control
	 * @param property
	 *            property
	 * @return {@code true} if the current value of the property isn't equals
	 *         the default value; otherwise {@code false}.
	 */
	private boolean hasNoDefaultValue(Control control, PropertyDescriptor property, Object currentValue) {

		Method getter = property.getReadMethod();
		if (getter != null) {
			Object defaultValue = getDefaultPropertyValue(control, property);
			return !valuesEquals(defaultValue, currentValue);
		}

		return false;

	}

	/**
	 * Compares two property values. For font or color the <i>description</i> of
	 * the resource, {@link FontData} or {@link RGB}, is used for comparison.
	 * 
	 * @param value1
	 *            first property value
	 * @param value2
	 *            second property value
	 * @return {@code true} if the values are equals; otherwise {@code false}
	 */
	private boolean valuesEquals(Object value1, Object value2) {

		if (value1 != null) {
			FontData[] fontData1 = getFontData(value1);
			FontData[] fontData2 = getFontData(value2);
			if (fontData1 != null && fontData2 != null) {
				return Arrays.equals(fontData1, fontData2);
			}
			RGB rgb1 = getRgb(value1);
			RGB rgb2 = getRgb(value2);
			if ((rgb1 != null) && (rgb2 != null)) {
				return rgb1.equals(rgb2);
			}
			return value1.equals(value2);
		}

		return true;

	}

	/**
	 * Returns the {@link FontData}s of the given value.
	 * 
	 * @param value
	 *            property value
	 * @return {@link FontData}s or {@code null} if the value has no
	 */
	private FontData[] getFontData(Object value) {

		if (value instanceof FontData[]) {
			return (FontData[]) value;
		}
		if (value instanceof Font) {
			return ((Font) value).getFontData();
		}

		return null;

	}

	/**
	 * Returns the {@link RGB} of the given value.
	 * 
	 * @param value
	 *            property value
	 * @return {@link RGB}s or {@code null} if the value has no
	 */
	private RGB getRgb(Object value) {

		if (value instanceof RGB) {
			return (RGB) value;
		}
		if (value instanceof Color) {
			return ((Color) value).getRGB();
		}

		return null;

	}

	/**
	 * Returns the default value of the given property of the given UI control.
	 * 
	 * @param control
	 *            UI control
	 * @param property
	 *            property
	 * @return default value
	 */
	private Object getDefaultPropertyValue(Control control, PropertyDescriptor property) {

		Class<? extends Control> controlClass = control.getClass();
		Map<String, Object> defaultValues = DEFAULT_PROPERTY_VALUES.get(controlClass);
		if (defaultValues == null) {
			Control defaultControl = createDefaultControl(controlClass, control.getStyle());
			if (defaultControl != null) {
				List<PropertyDescriptor> properties = getProperties(control);
				defaultValues = new Hashtable<String, Object>(properties.size());
				for (PropertyDescriptor defaultProperty : properties) {
					Object value = getPropertyValue(defaultControl, defaultProperty);
					value = getResourceData(value);
					if (value != null) {
						defaultValues.put(defaultProperty.getName(), value);
					}
				}
				defaultControl.dispose();
				DEFAULT_PROPERTY_VALUES.put(controlClass, defaultValues);
			} else {
				LOGGER.log(LogService.LOG_ERROR, "Cannot create an instance of \"" + controlClass.getName() + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		if (defaultValues == null) {
			return null;
		}
		return defaultValues.get(property.getName());

	}

	/**
	 * Extracts the description of the given resource.
	 * <p>
	 * <ul>
	 * <li>for {@code Font} this method returns {@code FontData}</li>
	 * <li>for {@code Color} this method returns {@code RGB}</li>
	 * </ul>
	 * <p>
	 * <i>This descriptions can be used to compare resources (also
	 * disposed).</i>
	 * 
	 * @param object
	 *            the resource
	 * @return description of resource or the resource itself, if no description
	 *         exists
	 */
	private Object getResourceData(final Object object) {

		if (!(object instanceof Resource)) {
			return object;
		}

		Resource resource = (Resource) object;
		if (resource.isDisposed()) {
			return resource;
		}
		if (resource instanceof Font) {
			return ((Font) resource).getFontData();
		} else if (resource instanceof Color) {
			return ((Color) resource).getRGB();
		}
		return resource;

	}

	/**
	 * Returns the value of the given property of the given UI control.
	 * 
	 * @param control
	 *            UI control
	 * @param property
	 *            property
	 * @return value of the property or {@code null} if the property cannot
	 *         read.
	 */
	private Object getPropertyValue(Control control, PropertyDescriptor property) {

		Method getter = property.getReadMethod();
		if (getter == null) {
			return null;
		}
		try {
			return getter.invoke(control);
		} catch (Exception failure) {
			// TODO This is a workaround of a nebula "bug"
			if (control.getClass().getName().equals("org.eclipse.swt.nebula.widgets.compositetable.CompositeTable")) { //$NON-NLS-1$
				return null;
			}
			String message = "Cannot get the value of the property \"" + property.getName() + "\" of the class \"" //$NON-NLS-1$ //$NON-NLS-2$
					+ control.getClass().getName() + "\"."; //$NON-NLS-1$
			LOGGER.log(LogService.LOG_ERROR, message, failure);
			return null;
		}

	}

	/**
	 * Creates the error message for a given class and a given property.
	 * 
	 * @param control
	 *            the control
	 * @param property
	 *            property
	 * @return error message
	 */
	private String getErrorMessage(Control control, PropertyDescriptor property) {

		Class<? extends Control> controlClass = control.getClass();
		StringBuilder sb = new StringBuilder("Cannot update property "); //$NON-NLS-1$
		sb.append("\"" + property.getName() + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		sb.append(" of the class "); //$NON-NLS-1$
		sb.append("\"" + controlClass.getName() + "\""); //$NON-NLS-1$ //$NON-NLS-2$

		return sb.toString();

	}

	/**
	 * Returns the properties of the class of the given control.<br>
	 * The properties of the classes are cached. So introspection is only
	 * necessary for new classes.
	 * 
	 * @param control
	 *            the control
	 * @return properties
	 */
	private List<PropertyDescriptor> getProperties(Control control) {
		final Class<? extends Control> controlClass = control.getClass();
		List<PropertyDescriptor> propertyDescriptors = CONTROL_PROPERTIES.get(controlClass);
		if (propertyDescriptors == null) {
			try {
				PropertyDescriptor[] descriptors = Introspector.getBeanInfo(controlClass).getPropertyDescriptors();
				propertyDescriptors = new ArrayList<PropertyDescriptor>(descriptors.length);
				for (PropertyDescriptor descriptor : descriptors) {
					Method setter = descriptor.getWriteMethod();
					if (setter == null) {
						continue;
					}
					int modifiers = setter.getModifiers();
					if (!Modifier.isPublic(modifiers)) {
						continue;
					}
					Method getter = descriptor.getReadMethod();
					if (getter == null) {
						continue;
					}
					modifiers = getter.getModifiers();
					if (!Modifier.isPublic(modifiers)) {
						continue;
					}
					if (ignoreProperty(controlClass, descriptor)) {
						continue;
					}

					propertyDescriptors.add(descriptor);
				}
			} catch (IntrospectionException e) {
				propertyDescriptors = EMPTY_DESCRIPTORS;
			}
			CONTROL_PROPERTIES.put(controlClass, propertyDescriptors);
		}

		return propertyDescriptors;
	}

	/**
	 * Returns for the given control and the given property the corresponding
	 * value of the LnF.
	 * 
	 * @param control
	 *            the control
	 * @param property
	 *            description of one property
	 * @return value of LnF
	 */
	private Object getLnfValue(Control control, PropertyDescriptor property) {

		Object lnfValue = getLnfStyleValue(control, property);
		if (lnfValue == null) {
			Class<? extends Control> controlClass = control.getClass();
			lnfValue = getLnfValue(controlClass, property);
		}
		return lnfValue;

	}

	/**
	 * Returns for the given control class and the given property the
	 * corresponding value of the LnF.
	 * <p>
	 * This method will use cached values first.
	 * 
	 * @param controlClass
	 *            class of the control
	 * @param property
	 *            description of one property
	 * @return value of LnF
	 */
	@SuppressWarnings("unchecked")
	private Object getLnfValue(final Class<? extends Control> controlClass, final PropertyDescriptor property) {
		final String lnfKey = generateLnfKey(controlClass, property);
		Object lnfValue = RESOURCE_CACHE.get(lnfKey);
		if (lnfValue != null) {
			return lnfValue == NULL_RESOURCE ? null : lnfValue;
		}

		lnfValue = LnfManager.getLnf().getResource(lnfKey);
		if (lnfValue == null) {
			final Class<?> superclass = controlClass.getSuperclass();
			if (Control.class.isAssignableFrom(superclass)) {
				lnfValue = getLnfValueInternal((Class<? extends Control>) superclass, property);
			}
		}

		// Store the lnf value for the given controlClass. Since the lookup starts with the most specific class 
		// and goes upwards the type hierarchy towards more generic types, we store the most specific  result only.
		// This saves the most time at a later look-up AND allows us to operate with a fairly small cache size. 
		// This is implemented by invoking getLnfValue for the 1st lookup and the getLnfValueInternal for the 
		// 2nd - nth levels of the type hierarchy.

		RESOURCE_CACHE.put(lnfKey, lnfValue == null ? NULL_RESOURCE : lnfValue);
		return lnfValue;
	}

	/**
	 * Returns for the given control class and the given property the
	 * corresponding value of the LnF.
	 * <p>
	 * This method does not use any caching.
	 * 
	 * @param controlClass
	 *            class of the control
	 * @param property
	 *            description of one property
	 * @return value of LnF
	 */
	@SuppressWarnings("unchecked")
	private Object getLnfValueInternal(final Class<? extends Control> controlClass, final PropertyDescriptor property) {
		final String lnfKey = generateLnfKey(controlClass, property);
		Object lnfValue = LnfManager.getLnf().getResource(lnfKey);
		if (lnfValue == null) {
			final Class<?> superclass = controlClass.getSuperclass();
			if (Control.class.isAssignableFrom(superclass)) {
				lnfValue = getLnfValueInternal((Class<? extends Control>) superclass, property);
			}
		}
		return lnfValue;
	}

	/**
	 * Generates the LnF key with the given parameters.
	 * 
	 * @param controlClass
	 *            class of the control
	 * @param property
	 *            description of one property
	 * @return LnF key
	 */
	private String generateLnfKey(final Class<? extends Control> controlClass, final PropertyDescriptor property) {

		final String controlName = getSimpleClassName(controlClass);
		StringBuilder lnfKey = new StringBuilder(controlName);
		lnfKey.append('.');
		lnfKey.append(property.getName());

		return lnfKey.toString();

	}

	/**
	 * Returns for the given control and the given property the corresponding
	 * value of the LnF style.
	 * 
	 * @param control
	 *            the control with style "attribute"
	 * @param property
	 *            property
	 * @return value of Lnf or {@code null} if not style exists
	 */
	private Object getLnfStyleValue(final Control control, final PropertyDescriptor property) {

		final String style = (String) control.getData(UIControlsFactory.KEY_LNF_STYLE);
		if (StringUtils.isEmpty(style)) {
			return null;
		}

		final RienaDefaultLnf lnf = LnfManager.getLnf();
		StringBuilder lnfKey = new StringBuilder(style);
		lnfKey.append('.');
		lnfKey.append(property.getName());
		return lnf.getResource(lnfKey.toString());

	}

	/**
	 * Creates an instance of the given control class.
	 * 
	 * @param controlClass
	 *            class of the UI control
	 * @param style
	 *            the style of widget to construct
	 * @return instance of UI control or {@code null} if no instance can be
	 *         created
	 */
	private Control createDefaultControl(final Class<? extends Control> controlClass, int style) {

		Composite parent = SHELL_COMPOSITE;

		// this is the most likely case
		Control defaultControl = getControl(controlClass, parent, style);
		if (defaultControl != null) {
			return defaultControl;
		}

		// this is the second most likely case
		defaultControl = getControl(controlClass, parent);
		if (defaultControl != null) {
			return defaultControl;
		}

		// try hard
		try {
			final Constructor<?>[] constructors = controlClass.getConstructors();
			for (final Constructor<?> constructor : constructors) {
				Class<?>[] paramTypes = constructor.getParameterTypes();
				Object[] params = new Object[paramTypes.length];
				boolean parentAssigned = false;
				boolean styleAssigned = false;
				for (int i = 0; i < paramTypes.length; i++) {
					if (paramTypes[i].isAssignableFrom(Composite.class) && !parentAssigned) {
						params[i] = parent;
						parentAssigned = true;
					} else if (paramTypes[i].isAssignableFrom(Integer.TYPE) && !styleAssigned) {
						params[i] = style;
						styleAssigned = true;
					} else {
						try {
							params[i] = paramTypes[i].newInstance();
						} catch (Exception e) {
							params[i] = null;
						}
					}
				}
				try {
					defaultControl = (Control) constructor.newInstance(params);
				} catch (Exception e) {
					defaultControl = null;
				}
				if (defaultControl != null) {
					break;
				}
			}
		} catch (SecurityException e) {
			LOGGER.log(LogService.LOG_WARNING, "Exception while creating default control the hard way for " //$NON-NLS-1$
					+ controlClass, e);
		}

		return defaultControl;

	}

	private Control getControl(final Class<? extends Control> controlClass, Composite parent, int style) {
		try {
			Constructor<? extends Control> constructor = controlClass.getConstructor(Composite.class, Integer.TYPE);
			return constructor.newInstance(parent, style);
		} catch (NoSuchMethodException e) {
			return null;
		} catch (Exception e) {
			LOGGER.log(LogService.LOG_WARNING, "Exception while creating default control with composite and style for " //$NON-NLS-1$
					+ controlClass, e);
			return null;
		}
	}

	private Control getControl(final Class<? extends Control> controlClass, Composite parent) {
		try {
			Constructor<? extends Control> constructor = controlClass.getConstructor(Composite.class);
			return constructor.newInstance(parent);
		} catch (NoSuchMethodException e) {
			return null;
		} catch (Exception e) {
			LOGGER.log(LogService.LOG_WARNING, "Exception while creating default control with composite for " //$NON-NLS-1$
					+ controlClass, e);
			return null;
		}
	}

	private void setDirtyLayout(boolean dirtyLayout) {
		this.dirtyLayout = dirtyLayout;
	}

	private boolean isDirtyLayout() {
		return dirtyLayout;
	}

}
