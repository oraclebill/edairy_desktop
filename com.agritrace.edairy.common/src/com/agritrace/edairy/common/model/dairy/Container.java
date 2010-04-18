package com.agritrace.edairy.common.model.dairy;

import javax.persistence.*;

@Entity
public class Container {
	public enum Type { BIN, CAN }
	public enum UnitOfMeasure { LITRE, KILOGRAM, UNKNOWN }
	
	private Long containerId;
	
	private double capacity;
	private double units;
	
	
	@Id
	@GeneratedValue
	public Long getContainerId() {
		return containerId;
	}
	
	public void setContainerId(Long containerId) {
		this.containerId = containerId;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

}
