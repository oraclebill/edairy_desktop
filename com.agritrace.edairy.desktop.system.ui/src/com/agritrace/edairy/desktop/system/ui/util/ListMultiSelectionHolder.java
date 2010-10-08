package com.agritrace.edairy.desktop.system.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListMultiSelectionHolder<T> {
	private final List<T> list = new ArrayList<T>();
	private List<T> selected = new ArrayList<T>();

	public static <T> ListMultiSelectionHolder<T> create(Collection<? extends T> list) {
		return new ListMultiSelectionHolder<T>(list);
	}

	public ListMultiSelectionHolder(Collection<? extends T> list) {
		replaceContents(list);
	}

	public void replaceContents(Collection<? extends T> list) {
		this.list.clear();
		selected.clear();

		if (list != null) {
			this.list.addAll(list);
		}
	}

	public List<T> getList() {
		return list;
	}

	public List<T> getSelected() {
		return selected;
	}

	public void setSelected(List<T> selected) {
		this.selected = selected;
	}
}