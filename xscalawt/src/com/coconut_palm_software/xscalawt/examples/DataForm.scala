/*******************************************************************************
 * Copyright (c) 2009 David Orme and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Orme - initial API and implementation
 *******************************************************************************/
package com.coconut_palm_software.xscalawt.examples

import com.coconut_palm_software.xscalawt.XScalaWT._
import com.coconut_palm_software.xscalawt.XScalaWTForms._

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets._
import org.eclipse.swt.layout._
import org.eclipse.swt.events._
import org.eclipse.swt.graphics._

import scala.List

object DataForm {
  
  def main(args : Array[String]) : Unit = {
    
    val tasks = List("One", "Two", "Three", "Four", "Five", "Six", "Seven")
    
    val window = shell("Data form example",
      setLayout(new FillLayout()),

      scrolledCompositeVertical (
        compositePreferredWidthFillsParent (
          _.setLayout(new GridLayout()),
          
          dataCompositesForAll(tasks) { 
            (composite, task) =>
            composite.contains (
              _.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL)),
              setLayout(new GridLayout(2, false)),
              
              label(task),
              labelSeparator (
                setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL))
              )
            )
          }
          
        )
      )
      
    )
    runEventLoop(window)
  }
}
