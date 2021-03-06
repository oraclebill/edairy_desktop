package com.agritrace.edairy.desktop.common.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Preference;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceKey;
import com.agritrace.edairy.desktop.common.model.dairy.PreferenceType;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.google.inject.Inject;

/**
 * An implementation of <code>IPreferenceStore</code> backed by the database. Used for user and system settings.
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class DBPreferenceStore implements IPersistentPreferenceStore {
	private final Set<IPropertyChangeListener> listeners = new HashSet<IPropertyChangeListener>();
	private final Map<String, Preference> values = new HashMap<String, Preference>();
	private final Map<String, PreferenceKey> keys = new HashMap<String, PreferenceKey>();
	private boolean needsSaving = false;

	private final IRepository<PreferenceKey> keyRepo;
	private final IRepository<Preference> valueRepo;

	/* Load and store */
	@Inject
	public DBPreferenceStore(final IRepository<PreferenceKey> keyRepo, final IRepository<Preference> valueRepo) {
		this.keyRepo = keyRepo;
		this.valueRepo = valueRepo;

		for (final PreferenceKey key: keyRepo.all()) {
			keys.put(key.getName(), key);
		}

		for (final Preference value: valueRepo.all()) {
			values.put(value.getKey().getName(), value);
		}
	}

	@Override
	public void save() throws IOException {
		try {
			if (!needsSaving()) {
				return;
			}

			// First save...

			for (final PreferenceKey key: keys.values()) {
				if (key.getId() == null) {
					keyRepo.saveNew(key);
				} else {
					keyRepo.save(key);
				}
			}

			for (final Preference value: values.values()) {
				if (value.getId() == null) {
					valueRepo.saveNew(value);
				} else {
					valueRepo.save(value);
				}
			}

			// Then delete unused objects

			for (final Preference value: valueRepo.all()) {
				if (!values.containsKey(value.getKey().getName())) {
					valueRepo.delete(value);
				}
			}

			for (final PreferenceKey key: keyRepo.all()) {
				if (!keys.containsKey(key.getName())) {
					keyRepo.delete(key);
				}
			}

			needsSaving = false;
		} catch (final RuntimeException e) {
			throw new IOException(e);
		}
	}

	/* Internal helper functions */

	private String getValue(String key, PreferenceType type) {
		final Preference value = values.get(key);

		if (value == null) {
			return getDefaultValue(key, type);
		}

		if (value.getKey().getType() != type || value.getValue() == null) {
			throw new NumberFormatException("Internal exception to be caught by getXXX");
		}

		return value.getValue();
	}

	private String getDefaultValue(String key, PreferenceType type) {
		PreferenceKey keyObject = keys.get(key);

		if (keyObject == null) {
			// Create setting upon first access
			keyObject = setDefaultValue(key, type, getDefaultDefaultValue(type));
		} else if (keyObject.getType() != type || keyObject.getDefaultValue() == null) {
			throw new NumberFormatException("Internal exception to be caught by getXXX");
		}

		return keyObject.getDefaultValue();
	}

	private void setValue(String key, PreferenceType type, String value, boolean firePropertyChange) {
		Preference valueObject = values.get(key);

		if (valueObject == null) {
			PreferenceKey keyObject = keys.get(key);

			if (keyObject == null) {
				// Create setting upon first access
				keyObject = setDefaultValue(key, type, getDefaultDefaultValue(type));
			} else if (type != keyObject.getType()) {
				throw new IllegalArgumentException("Attempting to set property to an invalid type");
			}

			valueObject = DairyFactory.eINSTANCE.createPreference();
			valueObject.setKey(keyObject);
			valueObject.setValue(value);

			if (!value.equals(keyObject.getDefaultValue())) {
				values.put(key, valueObject);
			}

			needsSaving = true;

			if (firePropertyChange) {
				firePropertyChangeEvent(valueObject, keyObject.getDefaultValue());
			}
		} else {
			if (type != valueObject.getKey().getType()) {
				throw new IllegalArgumentException("Attempting to set property to an invalid type");
			}

			final String oldValue = valueObject.getValue();
			valueObject.setValue(value);

			if (value.equals(valueObject.getKey().getDefaultValue())) {
				values.remove(value);
			}

			if (!value.equals(oldValue)) {
				needsSaving = true;

				if (firePropertyChange) {
					firePropertyChangeEvent(valueObject, oldValue);
				}
			}
		}
	}

	private PreferenceKey setDefaultValue(String key, PreferenceType type, String value) {
		PreferenceKey keyObject = keys.get(key);

		if (keyObject == null) {
			keyObject = DairyFactory.eINSTANCE.createPreferenceKey();
			keyObject.setName(key);
			keyObject.setType(type);
			keys.put(key, keyObject);
		} else if (type != keyObject.getType()) {
			throw new IllegalArgumentException("Attempting to set default value to an invalid type");
		}

		keyObject.setDefaultValue(value);
		needsSaving = true;
		return keyObject;
	}

	private static String getDefaultDefaultValue(PreferenceType type) {
		switch (type) {
		case BOOLEAN:
			return Boolean.toString(BOOLEAN_DEFAULT_DEFAULT);
		case DOUBLE:
			return Double.toString(DOUBLE_DEFAULT_DEFAULT);
		case FLOAT:
			return Float.toString(FLOAT_DEFAULT_DEFAULT);
		case INT:
			return Integer.toString(INT_DEFAULT_DEFAULT);
		case LONG:
			return Long.toString(LONG_DEFAULT_DEFAULT);
		case STRING:
			return STRING_DEFAULT_DEFAULT;
		default:
			throw new AssertionError();
		}
	}

	private static Object toType(PreferenceType type, String value) {
		switch (type) {
		case BOOLEAN:
			return Boolean.valueOf(value);
		case DOUBLE:
			return Double.valueOf(value);
		case FLOAT:
			return Float.valueOf(value);
		case INT:
			return Integer.valueOf(value);
		case LONG:
			return Long.valueOf(value);
		case STRING:
			return value;
		default:
			throw new AssertionError();
		}
	}

	private void firePropertyChangeEvent(Preference pref, String oldValue) {
		final PreferenceKey key = pref.getKey();
		firePropertyChangeEvent(key.getName(), toType(key.getType(), oldValue), toType(key.getType(), pref.getValue()));
	}

	/* API implementation follows */

	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void firePropertyChangeEvent(String property, Object oldValue, Object newValue) {
		for (final IPropertyChangeListener listener: listeners) {
			listener.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	@Override
	public boolean contains(String key) {
		return values.containsKey(key) || keys.containsKey(key);
	}

	@Override
	public boolean isDefault(String key) {
		return keys.containsKey(key) && !values.containsKey(key);
	}

	@Override
	public boolean needsSaving() {
		return needsSaving;
	}

	@Override
	public void putValue(String key, String value) {
		setValue(key, PreferenceType.STRING, value, false);
	}

	@Override
	public void setToDefault(String key) {
		if (values.containsKey(key)) {
			needsSaving = true;
		}

		values.remove(key);
	}

	@Override
	public boolean getDefaultBoolean(String key) {
		try {
			return Boolean.parseBoolean(getDefaultValue(key, PreferenceType.BOOLEAN));
		} catch (final NumberFormatException e) {
			return BOOLEAN_DEFAULT_DEFAULT;
		}
	}

	@Override
	public double getDefaultDouble(String key) {
		try {
			return Double.parseDouble(getDefaultValue(key, PreferenceType.DOUBLE));
		} catch (final NumberFormatException e) {
			return DOUBLE_DEFAULT_DEFAULT;
		}
	}

	@Override
	public float getDefaultFloat(String key) {
		try {
			return Float.parseFloat(getDefaultValue(key, PreferenceType.FLOAT));
		} catch (final NumberFormatException e) {
			return FLOAT_DEFAULT_DEFAULT;
		}
	}

	@Override
	public int getDefaultInt(String key) {
		try {
			return Integer.parseInt(getDefaultValue(key, PreferenceType.INT));
		} catch (final NumberFormatException e) {
			return INT_DEFAULT_DEFAULT;
		}
	}

	@Override
	public long getDefaultLong(String key) {
		try {
			return Long.parseLong(getDefaultValue(key, PreferenceType.LONG));
		} catch (final NumberFormatException e) {
			return LONG_DEFAULT_DEFAULT;
		}
	}

	@Override
	public String getDefaultString(String key) {
		try {
			return getDefaultValue(key, PreferenceType.STRING);
		} catch (final NumberFormatException e) {
			return STRING_DEFAULT_DEFAULT;
		}
	}

	@Override
	public boolean getBoolean(String key) {
		try {
			return Boolean.parseBoolean(getValue(key, PreferenceType.BOOLEAN));
		} catch (final NumberFormatException e) {
			return BOOLEAN_DEFAULT_DEFAULT;
		}
	}

	@Override
	public double getDouble(String key) {
		try {
			return Double.parseDouble(getValue(key, PreferenceType.DOUBLE));
		} catch (final NumberFormatException e) {
			return DOUBLE_DEFAULT_DEFAULT;
		}
	}

	@Override
	public float getFloat(String key) {
		try {
			return Float.parseFloat(getValue(key, PreferenceType.FLOAT));
		} catch (final NumberFormatException e) {
			return FLOAT_DEFAULT_DEFAULT;
		}
	}

	@Override
	public int getInt(String key) {
		try {
			return Integer.parseInt(getValue(key, PreferenceType.INT));
		} catch (final NumberFormatException e) {
			return INT_DEFAULT_DEFAULT;
		}
	}

	@Override
	public long getLong(String key) {
		try {
			return Long.parseLong(getValue(key, PreferenceType.LONG));
		} catch (final NumberFormatException e) {
			return LONG_DEFAULT_DEFAULT;
		}
	}

	@Override
	public String getString(String key) {
		try {
			return getValue(key, PreferenceType.STRING);
		} catch (final NumberFormatException e) {
			return STRING_DEFAULT_DEFAULT;
		}
	}

	@Override
	public void setDefault(String key, boolean value) {
		setDefaultValue(key, PreferenceType.BOOLEAN, Boolean.toString(value));
	}

	@Override
	public void setDefault(String key, double value) {
		setDefaultValue(key, PreferenceType.DOUBLE, Double.toString(value));
	}

	@Override
	public void setDefault(String key, float value) {
		setDefaultValue(key, PreferenceType.FLOAT, Float.toString(value));
	}

	@Override
	public void setDefault(String key, int value) {
		setDefaultValue(key, PreferenceType.INT, Integer.toString(value));
	}

	@Override
	public void setDefault(String key, long value) {
		setDefaultValue(key, PreferenceType.LONG, Long.toString(value));
	}

	@Override
	public void setDefault(String key, String value) {
		setDefaultValue(key, PreferenceType.STRING, (value == null ? "" : value));
	}

	@Override
	public void setValue(String key, boolean value) {
		setValue(key, PreferenceType.BOOLEAN, Boolean.toString(value), true);
	}

	@Override
	public void setValue(String key, double value) {
		setValue(key, PreferenceType.DOUBLE, Double.toString(value), true);
	}

	@Override
	public void setValue(String key, float value) {
		setValue(key, PreferenceType.FLOAT, Float.toString(value), true);
	}

	@Override
	public void setValue(String key, int value) {
		setValue(key, PreferenceType.INT, Integer.toString(value), true);
	}

	@Override
	public void setValue(String key, long value) {
		setValue(key, PreferenceType.LONG, Long.toString(value), true);
	}

	@Override
	public void setValue(String key, String value) {
		setValue(key, PreferenceType.STRING, (value == null ? "" : value), true);
	}
}
