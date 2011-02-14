package com.agritrace.edairy.desktop.ui.controllers;

import java.util.List;

import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.navigation.ApplicationNodeManager;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.security.DefaultPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.model.dairy.security.SystemPrincipal;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.google.inject.Inject;

public final class AuthController {
	private static final Logger LOGGER = Log4r.getLogger(AuthController.class);
	
	private final IRepository<SystemUser> repo;
	private boolean developerMode = false;

	@Inject
	public AuthController(final IRepository<SystemUser> repo) {
		this.repo = repo;
		String testval = System.getenv("EDAIRY_DEVELOPER_MODE");
		if (null != testval && testval.equalsIgnoreCase("true")) {
			developerMode = true;
		}
	}

	private void setPrincipal(IPrincipal principal) {
		PrincipalManager.getInstance().setPrincipal(principal);

		try {
			ApplicationNodeManager.getApplicationNode().setLabel(
					String.format("Welcome, %s!", principal.getDisplayName()));
		} catch (final NullPointerException e) {
			// This is normal, we haven't created the window yet
		}
	}

	public boolean authenticate(String username, String password) {
//		// TODO: Developer version hack for empty username/password
//		if (StringUtils.isEmpty(username) && developerMode) {
//			final boolean valid = StringUtils.isEmpty(username);
//
//			if (valid) {
//				setPrincipal(new DefaultPrincipal());
//			}
//
//			return valid;
//		}
		if (null == username || null == password) {
			LOGGER.log(LogService.LOG_ERROR, "Invalid username("+username+") or password is null!");
			return false;
		}
		
		final List<SystemUser> users = repo.all();
		SystemUser validUser = null;
		for (SystemUser user : users) {
			if (null == user) {
				LOGGER.log(LogService.LOG_ERROR, "Invalid SystemUser record - null");
				continue;
			}			
			String uName = user.getUsername();
			if (null == uName) {
				LOGGER.log(LogService.LOG_ERROR, "Invalid SystemUser record: null name: user: " + user);
				continue;				
			}
			String uPass = user.getUsername();
			if (null == uPass) {
				LOGGER.log(LogService.LOG_ERROR, "Invalid SystemUser record: null password: user: " + user);
				continue;				
			}
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				validUser = user;
				break;
			}
		}

		if (validUser != null) {
			setPrincipal(new SystemPrincipal(validUser));
			return true;
		}

		return false;
	}
}
