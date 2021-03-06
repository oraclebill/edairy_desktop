/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;

import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Journal Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getRecordedMember <em>Recorded Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#isFlagged <em>Flagged</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#isNotRecorded <em>Not Recorded</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getValidatedMember <em>Validated Member</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#isOffRoute <em>Off Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getFrom <em>From</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getFarmContainer <em>Farm Container</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#isRejected <em>Rejected</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getRejectionReason <em>Rejection Reason</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getMilkFatPercentage <em>Milk Fat Percentage</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#getAlcoholPercentage <em>Alcohol Percentage</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.CollectionJournalLineImpl#isWaterAdded <em>Water Added</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionJournalLineImpl extends EObjectImpl implements CollectionJournalLine {
	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecordedMember() <em>Recorded Member</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordedMember()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORDED_MEMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecordedMember() <em>Recorded Member</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordedMember()
	 * @generated
	 * @ordered
	 */
	protected String recordedMember = RECORDED_MEMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal QUANTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isFlagged() <em>Flagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlagged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLAGGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlagged() <em>Flagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlagged()
	 * @generated
	 * @ordered
	 */
	protected boolean flagged = FLAGGED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final UnitOfMeasure UNIT_OF_MEASURE_EDEFAULT = UnitOfMeasure.LITRE;

	/**
	 * The cached value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected UnitOfMeasure unitOfMeasure = UNIT_OF_MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNotRecorded() <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotRecorded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NOT_RECORDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNotRecorded() <em>Not Recorded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNotRecorded()
	 * @generated
	 * @ordered
	 */
	protected boolean notRecorded = NOT_RECORDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValidatedMember() <em>Validated Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidatedMember()
	 * @generated
	 * @ordered
	 */
	protected Membership validatedMember;

	/**
	 * The default value of the '{@link #isOffRoute() <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOffRoute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OFF_ROUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOffRoute() <em>Off Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOffRoute()
	 * @generated
	 * @ordered
	 */
	protected boolean offRoute = OFF_ROUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Farm from;

	/**
	 * The cached value of the '{@link #getFarmContainer() <em>Farm Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmContainer()
	 * @generated
	 * @ordered
	 */
	protected Container farmContainer;

	/**
	 * The cached value of the '{@link #getBin() <em>Bin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBin()
	 * @generated
	 * @ordered
	 */
	protected Bin bin;

	/**
	 * The default value of the '{@link #isRejected() <em>Rejected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRejected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REJECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRejected() <em>Rejected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRejected()
	 * @generated
	 * @ordered
	 */
	protected boolean rejected = REJECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getRejectionReason() <em>Rejection Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRejectionReason()
	 * @generated
	 * @ordered
	 */
	protected static final String REJECTION_REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRejectionReason() <em>Rejection Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRejectionReason()
	 * @generated
	 * @ordered
	 */
	protected String rejectionReason = REJECTION_REASON_EDEFAULT;

	/**
	 * The default value of the '{@link #getMilkFatPercentage() <em>Milk Fat Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMilkFatPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal MILK_FAT_PERCENTAGE_EDEFAULT = new BigDecimal("0.0");

	/**
	 * The cached value of the '{@link #getMilkFatPercentage() <em>Milk Fat Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMilkFatPercentage()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal milkFatPercentage = MILK_FAT_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlcoholPercentage() <em>Alcohol Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlcoholPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal ALCOHOL_PERCENTAGE_EDEFAULT = new BigDecimal("0.0");

	/**
	 * The cached value of the '{@link #getAlcoholPercentage() <em>Alcohol Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlcoholPercentage()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal alcoholPercentage = ALCOHOL_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isWaterAdded() <em>Water Added</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaterAdded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WATER_ADDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWaterAdded() <em>Water Added</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaterAdded()
	 * @generated
	 * @ordered
	 */
	protected boolean waterAdded = WATER_ADDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionJournalLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.COLLECTION_JOURNAL_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordedMember() {
		return recordedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordedMember(String newRecordedMember) {
		String oldRecordedMember = recordedMember;
		recordedMember = newRecordedMember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER, oldRecordedMember, recordedMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(BigDecimal newQuantity) {
		BigDecimal oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlagged() {
		return flagged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlagged(boolean newFlagged) {
		boolean oldFlagged = flagged;
		flagged = newFlagged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED, oldFlagged, flagged));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOfMeasure(UnitOfMeasure newUnitOfMeasure) {
		UnitOfMeasure oldUnitOfMeasure = unitOfMeasure;
		unitOfMeasure = newUnitOfMeasure == null ? UNIT_OF_MEASURE_EDEFAULT : newUnitOfMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE, oldUnitOfMeasure, unitOfMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNotRecorded() {
		return notRecorded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotRecorded(boolean newNotRecorded) {
		boolean oldNotRecorded = notRecorded;
		notRecorded = newNotRecorded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED, oldNotRecorded, notRecorded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership getValidatedMember() {
		if (validatedMember != null && validatedMember.eIsProxy())
		{
			InternalEObject oldValidatedMember = (InternalEObject)validatedMember;
			validatedMember = (Membership)eResolveProxy(oldValidatedMember);
			if (validatedMember != oldValidatedMember)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER, oldValidatedMember, validatedMember));
			}
		}
		return validatedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Membership basicGetValidatedMember() {
		return validatedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidatedMember(Membership newValidatedMember) {
		Membership oldValidatedMember = validatedMember;
		validatedMember = newValidatedMember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER, oldValidatedMember, validatedMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOffRoute() {
		return offRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffRoute(boolean newOffRoute) {
		boolean oldOffRoute = offRoute;
		offRoute = newOffRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE, oldOffRoute, offRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farm getFrom() {
		if (from != null && from.eIsProxy())
		{
			InternalEObject oldFrom = (InternalEObject)from;
			from = (Farm)eResolveProxy(oldFrom);
			if (from != oldFrom)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_LINE__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Farm basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(Farm newFrom) {
		Farm oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getFarmContainer() {
		if (farmContainer != null && farmContainer.eIsProxy())
		{
			InternalEObject oldFarmContainer = (InternalEObject)farmContainer;
			farmContainer = (Container)eResolveProxy(oldFarmContainer);
			if (farmContainer != oldFarmContainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER, oldFarmContainer, farmContainer));
			}
		}
		return farmContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetFarmContainer() {
		return farmContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFarmContainer(Container newFarmContainer) {
		Container oldFarmContainer = farmContainer;
		farmContainer = newFarmContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER, oldFarmContainer, farmContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bin getBin() {
		if (bin != null && bin.eIsProxy())
		{
			InternalEObject oldBin = (InternalEObject)bin;
			bin = (Bin)eResolveProxy(oldBin);
			if (bin != oldBin)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.COLLECTION_JOURNAL_LINE__BIN, oldBin, bin));
			}
		}
		return bin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bin basicGetBin() {
		return bin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBin(Bin newBin) {
		Bin oldBin = bin;
		bin = newBin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__BIN, oldBin, bin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionGroup getGroup() {
		if (eContainerFeatureID() != DairyPackage.COLLECTION_JOURNAL_LINE__GROUP) return null;
		return (CollectionGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroup(CollectionGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGroup, DairyPackage.COLLECTION_JOURNAL_LINE__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(CollectionGroup newGroup) {
		if (newGroup != eInternalContainer() || (eContainerFeatureID() != DairyPackage.COLLECTION_JOURNAL_LINE__GROUP && newGroup != null))
		{
			if (EcoreUtil.isAncestor(this, newGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGroup != null)
				msgs = ((InternalEObject)newGroup).eInverseAdd(this, DairyPackage.COLLECTION_GROUP__ENTRIES, CollectionGroup.class, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__GROUP, newGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRejected() {
		return rejected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRejected(boolean newRejected) {
		boolean oldRejected = rejected;
		rejected = newRejected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED, oldRejected, rejected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRejectionReason(String newRejectionReason) {
		String oldRejectionReason = rejectionReason;
		rejectionReason = newRejectionReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__REJECTION_REASON, oldRejectionReason, rejectionReason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getMilkFatPercentage() {
		return milkFatPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMilkFatPercentage(BigDecimal newMilkFatPercentage) {
		BigDecimal oldMilkFatPercentage = milkFatPercentage;
		milkFatPercentage = newMilkFatPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE, oldMilkFatPercentage, milkFatPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getAlcoholPercentage() {
		return alcoholPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlcoholPercentage(BigDecimal newAlcoholPercentage) {
		BigDecimal oldAlcoholPercentage = alcoholPercentage;
		alcoholPercentage = newAlcoholPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE, oldAlcoholPercentage, alcoholPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWaterAdded() {
		return waterAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaterAdded(boolean newWaterAdded) {
		boolean oldWaterAdded = waterAdded;
		waterAdded = newWaterAdded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.COLLECTION_JOURNAL_LINE__WATER_ADDED, oldWaterAdded, waterAdded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGroup((CollectionGroup)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				return basicSetGroup(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				return eInternalContainer().eInverseRemove(this, DairyPackage.COLLECTION_GROUP__ENTRIES, CollectionGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER:
				return getLineNumber();
			case DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER:
				return getRecordedMember();
			case DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY:
				return getQuantity();
			case DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED:
				return isFlagged();
			case DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE:
				return getUnitOfMeasure();
			case DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED:
				return isNotRecorded();
			case DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER:
				if (resolve) return getValidatedMember();
				return basicGetValidatedMember();
			case DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE:
				return isOffRoute();
			case DairyPackage.COLLECTION_JOURNAL_LINE__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER:
				if (resolve) return getFarmContainer();
				return basicGetFarmContainer();
			case DairyPackage.COLLECTION_JOURNAL_LINE__BIN:
				if (resolve) return getBin();
				return basicGetBin();
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				return getGroup();
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED:
				return isRejected();
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTION_REASON:
				return getRejectionReason();
			case DairyPackage.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE:
				return getMilkFatPercentage();
			case DairyPackage.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE:
				return getAlcoholPercentage();
			case DairyPackage.COLLECTION_JOURNAL_LINE__WATER_ADDED:
				return isWaterAdded();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER:
				setRecordedMember((String)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY:
				setQuantity((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED:
				setFlagged((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE:
				setUnitOfMeasure((UnitOfMeasure)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED:
				setNotRecorded((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER:
				setValidatedMember((Membership)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE:
				setOffRoute((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FROM:
				setFrom((Farm)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER:
				setFarmContainer((Container)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__BIN:
				setBin((Bin)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				setGroup((CollectionGroup)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED:
				setRejected((Boolean)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTION_REASON:
				setRejectionReason((String)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE:
				setMilkFatPercentage((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE:
				setAlcoholPercentage((BigDecimal)newValue);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__WATER_ADDED:
				setWaterAdded((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER:
				setRecordedMember(RECORDED_MEMBER_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED:
				setFlagged(FLAGGED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE:
				setUnitOfMeasure(UNIT_OF_MEASURE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED:
				setNotRecorded(NOT_RECORDED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER:
				setValidatedMember((Membership)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE:
				setOffRoute(OFF_ROUTE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FROM:
				setFrom((Farm)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER:
				setFarmContainer((Container)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__BIN:
				setBin((Bin)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				setGroup((CollectionGroup)null);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED:
				setRejected(REJECTED_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTION_REASON:
				setRejectionReason(REJECTION_REASON_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE:
				setMilkFatPercentage(MILK_FAT_PERCENTAGE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE:
				setAlcoholPercentage(ALCOHOL_PERCENTAGE_EDEFAULT);
				return;
			case DairyPackage.COLLECTION_JOURNAL_LINE__WATER_ADDED:
				setWaterAdded(WATER_ADDED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case DairyPackage.COLLECTION_JOURNAL_LINE__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__RECORDED_MEMBER:
				return RECORDED_MEMBER_EDEFAULT == null ? recordedMember != null : !RECORDED_MEMBER_EDEFAULT.equals(recordedMember);
			case DairyPackage.COLLECTION_JOURNAL_LINE__QUANTITY:
				return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
			case DairyPackage.COLLECTION_JOURNAL_LINE__FLAGGED:
				return flagged != FLAGGED_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__UNIT_OF_MEASURE:
				return unitOfMeasure != UNIT_OF_MEASURE_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__NOT_RECORDED:
				return notRecorded != NOT_RECORDED_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__VALIDATED_MEMBER:
				return validatedMember != null;
			case DairyPackage.COLLECTION_JOURNAL_LINE__OFF_ROUTE:
				return offRoute != OFF_ROUTE_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FROM:
				return from != null;
			case DairyPackage.COLLECTION_JOURNAL_LINE__FARM_CONTAINER:
				return farmContainer != null;
			case DairyPackage.COLLECTION_JOURNAL_LINE__BIN:
				return bin != null;
			case DairyPackage.COLLECTION_JOURNAL_LINE__GROUP:
				return getGroup() != null;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTED:
				return rejected != REJECTED_EDEFAULT;
			case DairyPackage.COLLECTION_JOURNAL_LINE__REJECTION_REASON:
				return REJECTION_REASON_EDEFAULT == null ? rejectionReason != null : !REJECTION_REASON_EDEFAULT.equals(rejectionReason);
			case DairyPackage.COLLECTION_JOURNAL_LINE__MILK_FAT_PERCENTAGE:
				return MILK_FAT_PERCENTAGE_EDEFAULT == null ? milkFatPercentage != null : !MILK_FAT_PERCENTAGE_EDEFAULT.equals(milkFatPercentage);
			case DairyPackage.COLLECTION_JOURNAL_LINE__ALCOHOL_PERCENTAGE:
				return ALCOHOL_PERCENTAGE_EDEFAULT == null ? alcoholPercentage != null : !ALCOHOL_PERCENTAGE_EDEFAULT.equals(alcoholPercentage);
			case DairyPackage.COLLECTION_JOURNAL_LINE__WATER_ADDED:
				return waterAdded != WATER_ADDED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lineNumber: ");
		result.append(lineNumber);
		result.append(", recordedMember: ");
		result.append(recordedMember);
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", flagged: ");
		result.append(flagged);
		result.append(", unitOfMeasure: ");
		result.append(unitOfMeasure);
		result.append(", notRecorded: ");
		result.append(notRecorded);
		result.append(", offRoute: ");
		result.append(offRoute);
		result.append(", rejected: ");
		result.append(rejected);
		result.append(", rejectionReason: ");
		result.append(rejectionReason);
		result.append(", milkFatPercentage: ");
		result.append(milkFatPercentage);
		result.append(", alcoholPercentage: ");
		result.append(alcoholPercentage);
		result.append(", waterAdded: ");
		result.append(waterAdded);
		result.append(')');
		return result.toString();
	}

} //CollectionJournalLineImpl
