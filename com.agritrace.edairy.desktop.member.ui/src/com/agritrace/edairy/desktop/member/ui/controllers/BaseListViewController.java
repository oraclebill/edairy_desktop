package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.Collection;
import java.util.List;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;

public abstract class BaseListViewController extends SubModuleController{
	
	
	private final IMemberRepository membershipRepository;
	
	protected BaseListViewController() {
		membershipRepository = new MemberRepository();
	}
	
	
	@Override
	public void configureRidgets() {
		configureFilterGroup();
		configureListGroup();
	}
	
	protected abstract void configureFilterGroup();
	
	protected abstract void configureListGroup();

	protected List<Membership> getMemberships() {
		return membershipRepository.getMemberships();
	}

}
