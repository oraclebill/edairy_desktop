package com.agritrace.edairy.desktop.install.dbsetup;

import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;

public class DairySeedData
{
	private String		dairyLicenseeName;
	private String		dairyRegistrationID;
	private Long		dairyId;
	private MilkGrade	baseGrade;

	public DairySeedData(String dairyLicenseeName, String dairyRegistrationID, Long dairyId)
	{
		this.dairyLicenseeName = dairyLicenseeName;
		this.dairyRegistrationID = dairyRegistrationID;
		this.dairyId = dairyId;
	}

	public String getDairyLicenseeName()
	{
		return dairyLicenseeName;
	}

	public void setDairyLicenseeName(String dairyLicenseeName)
	{
		this.dairyLicenseeName = dairyLicenseeName;
	}

	public String getDairyRegistrationID()
	{
		return dairyRegistrationID;
	}

	public void setDairyRegistrationID(String dairyRegistrationID)
	{
		this.dairyRegistrationID = dairyRegistrationID;
	}

	public Long getDairyId()
	{
		return dairyId;
	}

	public void setDairyId(Long dairyId)
	{
		this.dairyId = dairyId;
	}

	public MilkGrade getBaseGrade()
	{
		return baseGrade;
	}

	public void setBaseGrade(MilkGrade baseGrade)
	{
		this.baseGrade = baseGrade;
	}
}