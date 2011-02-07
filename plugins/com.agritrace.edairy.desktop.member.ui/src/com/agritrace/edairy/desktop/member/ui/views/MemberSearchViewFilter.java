package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class MemberSearchViewFilter extends ViewerFilter {

	public final static int FILTER_ADDRESS = 2;
	public final static int FILTER_ID = 0;
	public final static int FILTER_NAME = 1;
	public final static int SHOW_ALL = -1;

	private int searchColumn;

	/**
	 *
	 */
	private String searchValue;

	public MemberSearchViewFilter() {
		searchColumn = SHOW_ALL;
	}

	public MemberSearchViewFilter(int column_index, String filterString) {
		this.searchColumn = column_index;
		this.searchValue = filterString;
	}

	public int getSearchColumn() {
		return searchColumn;
	}

	public String getSearchValue() {
		return searchValue;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchValue == null || searchValue.length() == 0) {
			return true;
		}
		if (element == null) {
			return false;
		}
		final Membership member = (Membership) element;
		// searchColumn == -1 to select all
		switch (searchColumn) {
		case SHOW_ALL:
			return true;
		case FILTER_ID:
			return member.getMemberNumber().equals(searchValue);

		case FILTER_NAME:
			final String compareString = member.getFarmer().getGivenName() + " " + member.getFarmer().getFamilyName();
			return compareString.matches(searchValue);
		}
		return false;
	}

	public void setSearchColumn(int searchColumn) {
		this.searchColumn = searchColumn;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

}
