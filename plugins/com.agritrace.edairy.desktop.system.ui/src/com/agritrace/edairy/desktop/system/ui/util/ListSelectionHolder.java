package com.agritrace.edairy.desktop.system.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListSelectionHolder<T> {
	private final List<T> list = new ArrayList<T>();
	private T selected;

	public static <T> ListSelectionHolder<T> create(Collection<? extends T> list) {
		return new ListSelectionHolder<T>(list);
	}

	public ListSelectionHolder(Collection<? extends T> list) {
		replaceContents(list);
	}

	public void replaceContents(Collection<? extends T> list) {
		this.list.clear();
		selected = null;

		if (list != null) {
			this.list.addAll(list);
		}
	}

	public List<T> getList() {
		return list;
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}
}