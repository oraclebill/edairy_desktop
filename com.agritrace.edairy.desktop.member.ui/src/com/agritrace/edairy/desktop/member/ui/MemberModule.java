package com.agritrace.edairy.desktop.member.ui;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.ViewMemberDialogController;
import com.google.inject.AbstractModule;

public class MemberModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(ViewMemberDialogController.class);
	}
}
