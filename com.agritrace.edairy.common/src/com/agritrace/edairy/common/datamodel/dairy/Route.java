package com.agritrace.edairy.common.datamodel.dairy;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Route
 * 
 */
@Entity
public class Route  {

	private Long routeId;
	private String name;
	private String description;

	public Route() {
		super();
	}

	@Id
	@GeneratedValue
	public Long getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
