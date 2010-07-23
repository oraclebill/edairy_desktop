package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberDirectoryView extends AbstractDirectoryView {
	
	public static final String ID = MemberDirectoryView.class.getName();

	public static final String FILTER_GROUP_TEXT = "Search for a Member";

	@Override
	protected void createFilterConditions(Composite parent) {
		// group
		final Group filterGroup = UIControlsFactory.createGroup(parent, FILTER_GROUP_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterGroup);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(filterGroup);
		// character panel
//		final Composite charPanel = UIControlsFactory.createComposite(filterGroup);
		final Composite charPanel = new Composite(filterGroup, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(charPanel);
		GridLayoutFactory.fillDefaults().numColumns(27).equalWidth(false).applyTo(charPanel);

		final Label allLabel = UIControlsFactory.createLabel(charPanel, "All");
		addUIControl(allLabel, allLabel.getText());

		final char AChar = 'A';
		final char ZChar = 'Z';
		for (char i = AChar; i < ZChar; i++) {
			final Label charLabel = new Label(charPanel, SWT.NONE);
			charLabel.setText(new String(new char[] { i }));
//			final Label charLabel = UIControlsFactory.createLabel(charPanel, new String(new char[] { i }));
			addUIControl(charLabel, charLabel.getText());
		}

		// search text
		final Text searchText = UIControlsFactory.createText(filterGroup, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.MEMBERLIST_SEARCHTEXT);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).hint(250, -1).grab(false, false).applyTo(searchText);
		searchText.setText("Type filter text");
		searchText.setTextLimit(200);

//		// search cancel button
//		final Composite searchPanel = UIControlsFactory.createComposite(filterGroup);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(searchPanel);
//		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(searchPanel);
//
//		final Button searchButton = UIControlsFactory.createButton(searchPanel, "Search",
//				ViewWidgetId.memberInfo_searchButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(searchButton);
//
//		final Button cancelButton = UIControlsFactory.createButton(searchPanel, "Clear",
//				ViewWidgetId.memberInfo_clearButton);
//		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(cancelButton);
	}

}
