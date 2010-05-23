package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class DirectionsGroupWidget {
	private Group directonsGroup;
	
	public static final String DIRECTIONS_GROUP_TXT="Directions";
	public static final String LANDMARK_LABEL_TXT="Landmark:";
	public static final String DIRECTIONS_LABEL_TXT="Directions:";
	
	private Text landMarkText;
	private Text directionsText;
	
	public DirectionsGroupWidget(Composite parent){
		directonsGroup = UIControlsFactory.createGroup(parent, DIRECTIONS_GROUP_TXT);
		creatDirectonsGroup();
	}

	private void creatDirectonsGroup() {
		directonsGroup.setLayout(new GridLayout(2,false));
		Label landMarkLabel = UIControlsFactory.createLabel(directonsGroup, LANDMARK_LABEL_TXT);
		landMarkText = UIControlsFactory.createText(directonsGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.LANDMARK_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(landMarkText);
		
		Label directionLabel = UIControlsFactory.createLabel(directonsGroup, DIRECTIONS_LABEL_TXT);
		directionsText = UIControlsFactory.createText(directonsGroup, SWT.SINGLE|SWT.BORDER, ViewWidgetId.DIRECTIONS_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL,SWT.FILL).grab(true,false).applyTo(directionsText);
	}
	public Group getGroup() {
		return directonsGroup;
	}
}