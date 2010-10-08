package com.agritrace.edairy.desktop.common.model.dairy.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PrincipalManager {
	private static final class InstanceHolder {
		static final PrincipalManager INSTANCE = new PrincipalManager();
	}

	private IPrincipal principal;

	public static PrincipalManager getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * For internal use by AuthController
	 */
	public void setPrincipal(IPrincipal principal) {
		this.principal = principal;
	}

	/**
	 * Get the user logged into the system.
	 *
	 * @return the principal
	 */
	public IPrincipal getPrincipal() {
		return principal;
	}

	public boolean hasPermission(Permission perm) {
		return principal == null ? false : principal.hasPermission(perm);
	}

	/**
	 * Converts a password string (UTF-8 encoded) into a hexadecimal hash string.
	 * Example output: <code>ba21767ae494afe5a2165dcb3338c5323e9907050e34542c405d575cc31bf527</code>.
	 *
	 * @param raw Password string
	 * @return Hexadecimal hash
	 */
	public String hashPassword(String raw) {
		if (raw == null) {
			throw new NullPointerException ("Expected non-null password to hash");
		}

		byte[] bytes = null;

		try {
			bytes = MessageDigest.getInstance("SHA-256").digest(raw.getBytes("UTF-8"));
		} catch (final NoSuchAlgorithmException e) {
			// Cannot happen: Algorithm is built-in
			throw new AssertionError();
		} catch (final UnsupportedEncodingException e) {
			// Cannot happen: Encoding is built-in
			throw new AssertionError();
		}

		final String hexes = "0123456789abcdef";
		final StringBuilder hex = new StringBuilder(2 * bytes.length);

		for (final byte b : bytes) {
	      hex.append(hexes.charAt((b & 0xf0) >> 4)).append(hexes.charAt(b & 0x0f));
	    }

	    return hex.toString();
	}
}
