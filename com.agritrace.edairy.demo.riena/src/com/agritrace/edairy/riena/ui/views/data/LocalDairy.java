package com.agritrace.edairy.riena.ui.views.data;

import org.eclipse.core.runtime.Assert;
import org.eclipse.riena.beans.common.AbstractBean;

public class LocalDairy extends AbstractBean {

	/**
	 * Property name of the first name property ("firstname").
	 */
	public static final String PROPERTY_FIRSTNAME = "firstname"; //$NON-NLS-1$
	/**
	 * Property name of the first name property ("lastname").
	 */
	public static final String PROPERTY_LASTNAME = "lastname"; //$NON-NLS-1$

	/**
	 * Property name of the gender property ("{@value} ").
	 */
	public static final String PROPERTY_GENDER = "gender"; //$NON-NLS-1$

	public final static String PROPERTY_ID = "id"; //$NON-NLS-1$

	public final static String PROPERTY_DEPARTMENT = "farm";

	public final static String PROPERTY_PHONENUMBER = "phoneNumber"; //$NON-NLS-1$
	
	public final static String PROPERTY_ADDRESS = "address"; //$NON-NLS-1$
	public final static String PROPERTY_MIDDLENAME = "middlename"; //$NON-NLS-1$


	/*
	 * Constant for <code>MALE</code> gender value ("male").
	 */
	public final static String MALE = "male"; //$NON-NLS-1$
	/**
	 * Constant for <code>FEMALE</code> gender value ("female").
	 */
	public final static String FEMALE = "female"; //$NON-NLS-1$

	/**
	 * Property name of the birthday property ("birthday").
	 */
	public static final String PROPERTY_BIRTHDAY = "birthday"; //$NON-NLS-1$

	private Integer id;
	private String lastname;
	private String middlename;
	private String firstname;
	private String gender;
	
	private String birthday;
	private String address;
//	private Address address;
	private String farm;
	private String phoneNumber;
	
	public static enum TITLE{
		MR,MRS,MS
	}

	/**
	 * constructor.
	 * 
	 * @param lastname
	 * @param firstname
	 */
	public LocalDairy(String lastname, String firstname) {
		super();

		this.lastname = lastname;
		this.firstname = firstname;
		id = 0;
		birthday = ""; //$NON-NLS-1$
		gender = MALE;
		//address = new Address();
		address = "";
	}

	/**
	 * @return last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return first name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		String oldLastname = this.lastname;
		this.lastname = lastname;
		firePropertyChanged(PROPERTY_LASTNAME, oldLastname, lastname);
	}

	/**
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		String oldFirstname = this.firstname;
		this.firstname = firstname;

		firePropertyChanged(PROPERTY_FIRSTNAME, oldFirstname, firstname);
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		String oldMiddleName = this.middlename;
		this.middlename = middlename;
		firePropertyChanged(PROPERTY_FIRSTNAME, oldMiddleName, middlename);
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		Assert.isLegal(MALE.equals(gender) || FEMALE.equals(gender));
		if (gender != this.gender) {
			String oldValue = this.gender;
			this.gender = gender;
			firePropertyChanged(PROPERTY_GENDER, oldValue, this.gender);
		}
	}

	@Override
	public String toString() {
		return lastname + ", " + firstname; //$NON-NLS-1$
	}

	/**
	 * Return object for presentation in a list.
	 * 
	 * @return a string representing object as list entry.
	 */
	public String getListEntry() {
		return lastname + " - " + firstname; //$NON-NLS-1$
	}

	/**
	 * @return Returns the birthday.
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            The birthday to set.
	 */
	public void setBirthday(String birthday) {
		Object oldValue = this.birthday;
		this.birthday = birthday;
		firePropertyChanged(PROPERTY_BIRTHDAY, oldValue, birthday);
	}

//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public Address getAddress() {
//		return address;
//	}

	public void setId(Integer number) {
		Object oldValue = this.id;
		this.id = number;
		firePropertyChanged(PROPERTY_ID, oldValue, number);
	}

	public Integer getId() {
		return id;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String department) {
		Object oldValue = this.farm;
		this.farm = department;
		firePropertyChanged(PROPERTY_DEPARTMENT, oldValue, department);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		Object oldValue = this.phoneNumber;
		this.phoneNumber = phoneNumber;
		firePropertyChanged(PROPERTY_PHONENUMBER, oldValue, phoneNumber);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Object oldValue = this.address;
		this.address = address;
		firePropertyChanged(PROPERTY_ADDRESS, oldValue, address);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((farm == null) ? 0 : farm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LocalDairy other = (LocalDairy) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (birthday == null) {
			if (other.birthday != null) {
				return false;
			}
		} else if (!birthday.equals(other.birthday)) {
			return false;
		}

		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}

		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		return true;
	}

}
