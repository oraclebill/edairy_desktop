package com.agritrace.edairy.desktop.dairy.profile.api;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;

public interface DairyProfileService {
	/**
	 * Get the local dairy.
	 * 
	 * @return
	 */
	public Dairy getLocalDairy();
	
	/**
	 * Get a dairy by ID.
	 * 
	 * @param id
	 * @return
	 */
	public Dairy getDairyById(long id);
	
	/**
	 * Save a dairy.
	 * 
	 * @param dairy
	 */
	public void saveDairy(Dairy dairy);
	
	
}
