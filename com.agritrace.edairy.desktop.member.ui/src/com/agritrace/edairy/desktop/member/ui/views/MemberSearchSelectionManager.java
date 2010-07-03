package com.agritrace.edairy.desktop.member.ui.views;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.member.ui.views.CreateMemberView.MemberSearchNodeListener;

public class MemberSearchSelectionManager {

	public static MemberSearchSelectionManager INSTANCE = new MemberSearchSelectionManager();

	private final List<MemberSearchSelectionListener> listeners;

	private MemberSearchNodeListener searchNode;

	private MemberSearchSelectionManager() {
		listeners = new ArrayList<MemberSearchSelectionListener>();
	}

	public synchronized void addSearchSelectionListener(MemberSearchSelectionListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void clearListeners() {
		listeners.clear();
	}

	public MemberSearchNodeListener getSearchNode() {
		return searchNode;
	}

	public void notifySelectionChanged(MemberSearchSelectionListener source, Membership member) {
		for (final MemberSearchSelectionListener listener : listeners) {
			if (listener != source) {
				listener.memberSelectionChanged(member);
			}
		}

	}

	public void notifySelectionModified(MemberSearchSelectionListener source, Membership member) {
		for (final MemberSearchSelectionListener listener : listeners) {
			if (listener != source) {
				listener.memberModified(member);
			}
		}

	}

	public void refreshView(String viewId) {
		for (final MemberSearchSelectionListener listener : listeners) {
			listener.refreshView(viewId);
		}
	}

	public synchronized void removeSearchSelectionListener(MemberSearchSelectionListener listener) {
		if (!listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}

	public void setSearchNode(MemberSearchNodeListener searchNode) {
		this.searchNode = searchNode;
	}

}
