/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.databinding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Creates {@link IConverter}s that translate from type {@code K} to type
 * {@code L} and back. Conversion is done by mapping pairs of values of each
 * type to each other.
 * <p>
 * The factory is initially configured by invoking {@link #add(Object, Object)}
 * one or more times. This introduces the matching pairs of values. Afterwards
 * {@link #createFromToConverter()} will return an K-to-L converter and
 * {@link #createToFromConverter()} will return a L-to-K converter.
 * <p>
 * Here is an example that used the {@link ConverterFactory} to convert {@code
 * enum}-values to human-readable Strings:
 * 
 * <pre>
 * private enum Answer {
 *   YES, NO, MAYBE
 * }
 * // ...
 * ConverterFactory<?, ?> factory 
 *   = new ConverterFactory<Answer, String>(Answer.class, String.class);
 * fac.add(Answer.YES, "Yes")
 *   .add(Answer.NO, "No")
 *   .add(Answer.MAYBE, "Maybe")
 *   .add(null, "");
 * ridget.setModelToUIControlConverter(factory.createFromToConverter());
 * ridget.setUIControlToModelConverter(factory.createToFromConverter());
 * </pre>
 * 
 * @see IConverter
 * @since 1.2
 */
public final class ConverterFactory<K, L> {

	private final Class<K> fromType;
	private final Class<L> toType;
	private final Map<K, L> modelToUI;

	/**
	 * Create a converter factory between two types
	 * 
	 * @param fromType
	 *            the origin-type
	 * @param toType
	 *            the destination-type
	 */
	public ConverterFactory(Class<K> fromType, Class<L> toType) {
		this.fromType = fromType;
		this.toType = toType;
		modelToUI = new HashMap<K, L>();
	}

	/**
	 * Create a conversion rule, mapping the {@code fromValue} to the {@code
	 * toValue} and back.
	 * 
	 * @param fromValue
	 *            the origin value
	 * @param toValue
	 *            the destination value
	 * @return this instance (fluent API)
	 */
	public ConverterFactory<K, L> add(K fromValue, L toValue) {
		modelToUI.put(fromValue, toValue);
		return this;
	}

	/**
	 * Returns an {@link IConverter} that maps values of the origin-type {@code
	 * K} to the destination-type {@code L}.
	 * <p>
	 * Value pairs must be introduced via the {@link #add(Object, Object)}
	 * method. Unknown origin-values are mapped to {@code null}.
	 * 
	 * @return an {@link IConverter}; never null
	 */
	public IConverter createFromToConverter() {
		return new Converter(fromType, toType) {
			public Object convert(Object fromObject) {
				return modelToUI.get(fromObject);
			}
		};
	}

	/**
	 * Returns an {@link IConverter} that maps values of the destination-type
	 * {@code L} to the origin-type {@code K}.
	 * <p>
	 * Value pairs must be introduced via the {@link #add(Object, Object)}
	 * method. Unknown destination-values are mapped to {@code null}.
	 * 
	 * @return an {@link IConverter}; never null
	 */
	public IConverter createToFromConverter() {
		return new Converter(toType, fromType) {
			public Object convert(Object fromObject) {
				K result = null;
				Iterator<Entry<K, L>> iter = modelToUI.entrySet().iterator();
				while (result == null && iter.hasNext()) {
					Entry<K, L> entry = iter.next();
					if (entry.getValue().equals(fromObject)) {
						result = entry.getKey();
					}
				}
				return result;
			}
		};
	}

}
