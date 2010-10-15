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
package org.eclipse.riena.ui.ridgets;

/**
 * An {@link IComplexRidget} describing a row for the
 * {@link ICompositeTableRidget}.
 * <p>
 * The ICompositeTableRidget manages a list of composites, one for each row. It
 * will also create a matching IRowRidget for each row. The developer has to
 * provide the row composite and the row ridget. See
 * SnippetCompositeTableRidgetNNN for examples.
 * <p>
 * Implemementors should subclass {@link AbstractCompositeRidget} and provide a
 * zero argument public constructor.
 * 
 * @see ICompositeTableRidget
 * @see AbstractCompositeRidget
 * @see IComplexRidget
 */
public interface IRowRidget extends IComplexRidget {

	/**
	 * Injects the data for this row.
	 * <p>
	 * This method will be called before {@link #configureRidgets()}, so that
	 * the data is available at that time.
	 * 
	 * @param rowData
	 *            an object with the data for this row
	 */
	void setData(Object rowData);
}
