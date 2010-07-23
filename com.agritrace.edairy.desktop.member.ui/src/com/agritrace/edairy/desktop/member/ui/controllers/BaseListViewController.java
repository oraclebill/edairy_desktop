package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.List;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public abstract class BaseListViewController extends SubModuleController {

	private final IMemberRepository membershipRepository;

	protected BaseListViewController() {
		membershipRepository = DairyRepository.getInstance();
	}

	@Override
	public void configureRidgets() {
		configureFilterRidgets();
		configureTableRidgets();
	}

	protected abstract void configureFilterRidgets();

	protected abstract void configureTableRidgets();

	protected List<Membership> getMemberships() {
		return membershipRepository.getMemberships();
	}

}
