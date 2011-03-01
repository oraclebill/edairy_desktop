package com.agritrace.edairy.desktop.testdata;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

public class TestDataGeneratorConfig {
	private int memberCount = 100;
	private BigDecimal collectionsPerMember = new BigDecimal(3.0d);
	private int employeeCount = 10;
	private int collectionCenterCount = 8;
	private int storeCount = 4;
	private int routeCount = 2;
	private Date startDate;
	private Date endDate;


	/**
	 * 
	 */
	public TestDataGeneratorConfig() {
		initDates();
	}


	/**
	 * @param args
	 * @param memberCount
	 * @param collectionsPerMember
	 * @param employeeCount
	 * @param collectionCenterCount
	 * @param storeCount
	 * @param routeCount
	 * @param startDate
	 * @param endDate
	 * @param empSequence
	 * @param binSequence
	 * @param referenceCounter
	 */
	public TestDataGeneratorConfig(String[] args) {
		initDates();
		processArgs(args);
	}
	
	public TestDataGeneratorConfig(int memberCount, BigDecimal collectionsPerMember, int employeeCount,
			int collectionCenterCount, int storeCount, int routeCount, Date startDate, Date endDate) {
		this.memberCount = memberCount;
		this.collectionsPerMember = collectionsPerMember;
		this.employeeCount = employeeCount;
		this.collectionCenterCount = collectionCenterCount;
		this.storeCount = storeCount;
		this.routeCount = routeCount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @param args
	 *            the args to set
	 */
	void setArgs(String[] args) {
		processArgs(args);
	}


	/**
	 * 
	 */
	private void processArgs(String[] args) {
		for (String arg : args) {
			String[] split = arg.split("=");
			try {
				BeanUtils.setProperty(this, split[0], split[1]);
			} catch (Exception e) {
				System.err.println(e.getMessage() + ": Failed to set property: " + split[0] + " to " + split[1]);
			}
		}		
	}

	private void initDates() {
		Calendar cal = Calendar.getInstance();
		endDate = new Date();
		cal.setTime(endDate);
		
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		endDate = cal.getTime();

		cal.add(Calendar.DAY_OF_YEAR, -30);
		startDate = cal.getTime();
	}


	/**
	 * @return the collectionCenterCount
	 */
	int getCollectionCenterCount() {
		return collectionCenterCount;
	}

	/**
	 * @return the collectionsPerMember
	 */
	BigDecimal getCollectionsPerMember() {
		return collectionsPerMember;
	}


	/**
	 * @return the employeeCount
	 */
	int getEmployeeCount() {
		return employeeCount;
	}

	/**
	 * @return the endDate
	 */
	Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the memberCount
	 */
	int getMemberCount() {
		return memberCount;
	}


	/**
	 * @return the routeCount
	 */
	int getRouteCount() {
		return routeCount;
	}

	/**
	 * @return the startDate
	 */
	Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the storeCount
	 */
	int getStoreCount() {
		return storeCount;
	}


	/**
	 * @param collectionCenterCount
	 *            the collectionCenterCount to set
	 */
	void setCollectionCenterCount(int collectionCenterCount) {
		this.collectionCenterCount = collectionCenterCount;
	}

	/**
	 * @param collectionsPerMember
	 *            the collectionsPerMember to set
	 */
	void setCollectionsPerMember(BigDecimal collectionsPerMember) {
		this.collectionsPerMember = collectionsPerMember;
	}

	/**
	 * @param employeeCount
	 *            the employeeCount to set
	 */
	void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}


	/**
	 * @param endDate
	 *            the endDate to set
	 */
	void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param memberCount
	 *            the memberCount to set
	 */
	void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * @param routeCount
	 *            the routeCount to set
	 */
	void setRouteCount(int routeCount) {
		this.routeCount = routeCount;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param storeCount
	 *            the storeCount to set
	 */
	void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}

}