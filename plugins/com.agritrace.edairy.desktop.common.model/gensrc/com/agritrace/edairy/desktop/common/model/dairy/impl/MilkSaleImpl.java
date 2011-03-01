/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.agritrace.edairy.desktop.common.model.dairy.impl;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;

import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType;
import java.math.BigDecimal;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milk Sale</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getReferenceNumber <em>Reference Number</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getSaleDate <em>Sale Date</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getBin <em>Bin</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getSaleType <em>Sale Type</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getGrade <em>Grade</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getUnitPrice <em>Unit Price</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#isRejected <em>Rejected</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getStoreOrRoute <em>Store Or Route</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getSoldBy <em>Sold By</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getSaleAmount <em>Sale Amount</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#isContractSale <em>Contract Sale</em>}</li>
 *   <li>{@link com.agritrace.edairy.desktop.common.model.dairy.impl.MilkSaleImpl#getSalesClerk <em>Sales Clerk</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilkSaleImpl extends EObjectImpl implements MilkSale {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceNumber() <em>Reference Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNumber()
	 * @generated
	 * @ordered
	 */
	protected String referenceNumber = REFERENCE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSaleDate() <em>Sale Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date SALE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSaleDate() <em>Sale Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleDate()
	 * @generated
	 * @ordered
	 */
	protected Date saleDate = SALE_DATE_EDEFAULT;

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
	 * The default value of the '{@link #getSaleType() <em>Sale Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleType()
	 * @generated
	 * @ordered
	 */
	protected static final MilkSaleType SALE_TYPE_EDEFAULT = MilkSaleType.CASH;

	/**
	 * The cached value of the '{@link #getSaleType() <em>Sale Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleType()
	 * @generated
	 * @ordered
	 */
	protected MilkSaleType saleType = SALE_TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getGrade() <em>Grade</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrade()
	 * @generated
	 * @ordered
	 */
	protected MilkGrade grade;

	/**
	 * The default value of the '{@link #getUnitPrice() <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitPrice()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal UNIT_PRICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitPrice() <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitPrice()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal unitPrice = UNIT_PRICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getStoreOrRoute() <em>Store Or Route</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreOrRoute()
	 * @generated
	 * @ordered
	 */
	protected DairyLocation storeOrRoute;

	/**
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer customer;

	/**
	 * The cached value of the '{@link #getSoldBy() <em>Sold By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoldBy()
	 * @generated
	 * @ordered
	 */
	protected Employee soldBy;

	/**
	 * The default value of the '{@link #getSaleAmount() <em>Sale Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleAmount()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal SALE_AMOUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSaleAmount() <em>Sale Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaleAmount()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal saleAmount = SALE_AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isContractSale() <em>Contract Sale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContractSale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTRACT_SALE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContractSale() <em>Contract Sale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContractSale()
	 * @generated
	 * @ordered
	 */
	protected boolean contractSale = CONTRACT_SALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSalesClerk() <em>Sales Clerk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesClerk()
	 * @generated
	 * @ordered
	 */
	protected Employee salesClerk;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilkSaleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DairyPackage.Literals.MILK_SALE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceNumber(String newReferenceNumber) {
		String oldReferenceNumber = referenceNumber;
		referenceNumber = newReferenceNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__REFERENCE_NUMBER, oldReferenceNumber, referenceNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getSaleDate() {
		return saleDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaleDate(Date newSaleDate) {
		Date oldSaleDate = saleDate;
		saleDate = newSaleDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__SALE_DATE, oldSaleDate, saleDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bin getBin() {
		if (bin != null && bin.eIsProxy()) {
			InternalEObject oldBin = (InternalEObject)bin;
			bin = (Bin)eResolveProxy(oldBin);
			if (bin != oldBin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__BIN, oldBin, bin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__BIN, oldBin, bin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkSaleType getSaleType() {
		return saleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaleType(MilkSaleType newSaleType) {
		MilkSaleType oldSaleType = saleType;
		saleType = newSaleType == null ? SALE_TYPE_EDEFAULT : newSaleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__SALE_TYPE, oldSaleType, saleType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade getGrade() {
		if (grade != null && grade.eIsProxy()) {
			InternalEObject oldGrade = (InternalEObject)grade;
			grade = (MilkGrade)eResolveProxy(oldGrade);
			if (grade != oldGrade) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__GRADE, oldGrade, grade));
			}
		}
		return grade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilkGrade basicGetGrade() {
		return grade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrade(MilkGrade newGrade) {
		MilkGrade oldGrade = grade;
		grade = newGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__GRADE, oldGrade, grade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitPrice(BigDecimal newUnitPrice) {
		BigDecimal oldUnitPrice = unitPrice;
		unitPrice = newUnitPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__UNIT_PRICE, oldUnitPrice, unitPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__REJECTED, oldRejected, rejected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation getStoreOrRoute() {
		if (storeOrRoute != null && storeOrRoute.eIsProxy()) {
			InternalEObject oldStoreOrRoute = (InternalEObject)storeOrRoute;
			storeOrRoute = (DairyLocation)eResolveProxy(oldStoreOrRoute);
			if (storeOrRoute != oldStoreOrRoute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__STORE_OR_ROUTE, oldStoreOrRoute, storeOrRoute));
			}
		}
		return storeOrRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DairyLocation basicGetStoreOrRoute() {
		return storeOrRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreOrRoute(DairyLocation newStoreOrRoute) {
		DairyLocation oldStoreOrRoute = storeOrRoute;
		storeOrRoute = newStoreOrRoute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__STORE_OR_ROUTE, oldStoreOrRoute, storeOrRoute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer() {
		if (customer != null && customer.eIsProxy()) {
			InternalEObject oldCustomer = (InternalEObject)customer;
			customer = (Customer)eResolveProxy(oldCustomer);
			if (customer != oldCustomer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__CUSTOMER, oldCustomer, customer));
			}
		}
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(Customer newCustomer) {
		Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__CUSTOMER, oldCustomer, customer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getSoldBy() {
		if (soldBy != null && soldBy.eIsProxy()) {
			InternalEObject oldSoldBy = (InternalEObject)soldBy;
			soldBy = (Employee)eResolveProxy(oldSoldBy);
			if (soldBy != oldSoldBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__SOLD_BY, oldSoldBy, soldBy));
			}
		}
		return soldBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetSoldBy() {
		return soldBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoldBy(Employee newSoldBy) {
		Employee oldSoldBy = soldBy;
		soldBy = newSoldBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__SOLD_BY, oldSoldBy, soldBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaleAmount(BigDecimal newSaleAmount) {
		BigDecimal oldSaleAmount = saleAmount;
		saleAmount = newSaleAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__SALE_AMOUNT, oldSaleAmount, saleAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContractSale() {
		return contractSale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContractSale(boolean newContractSale) {
		boolean oldContractSale = contractSale;
		contractSale = newContractSale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__CONTRACT_SALE, oldContractSale, contractSale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getSalesClerk() {
		if (salesClerk != null && salesClerk.eIsProxy()) {
			InternalEObject oldSalesClerk = (InternalEObject)salesClerk;
			salesClerk = (Employee)eResolveProxy(oldSalesClerk);
			if (salesClerk != oldSalesClerk) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DairyPackage.MILK_SALE__SALES_CLERK, oldSalesClerk, salesClerk));
			}
		}
		return salesClerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetSalesClerk() {
		return salesClerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesClerk(Employee newSalesClerk) {
		Employee oldSalesClerk = salesClerk;
		salesClerk = newSalesClerk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DairyPackage.MILK_SALE__SALES_CLERK, oldSalesClerk, salesClerk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DairyPackage.MILK_SALE__ID:
				return getId();
			case DairyPackage.MILK_SALE__LINE_NUMBER:
				return getLineNumber();
			case DairyPackage.MILK_SALE__REFERENCE_NUMBER:
				return getReferenceNumber();
			case DairyPackage.MILK_SALE__SALE_DATE:
				return getSaleDate();
			case DairyPackage.MILK_SALE__BIN:
				if (resolve) return getBin();
				return basicGetBin();
			case DairyPackage.MILK_SALE__SALE_TYPE:
				return getSaleType();
			case DairyPackage.MILK_SALE__QUANTITY:
				return getQuantity();
			case DairyPackage.MILK_SALE__GRADE:
				if (resolve) return getGrade();
				return basicGetGrade();
			case DairyPackage.MILK_SALE__UNIT_PRICE:
				return getUnitPrice();
			case DairyPackage.MILK_SALE__DESCRIPTION:
				return getDescription();
			case DairyPackage.MILK_SALE__REJECTED:
				return isRejected();
			case DairyPackage.MILK_SALE__STORE_OR_ROUTE:
				if (resolve) return getStoreOrRoute();
				return basicGetStoreOrRoute();
			case DairyPackage.MILK_SALE__CUSTOMER:
				if (resolve) return getCustomer();
				return basicGetCustomer();
			case DairyPackage.MILK_SALE__SOLD_BY:
				if (resolve) return getSoldBy();
				return basicGetSoldBy();
			case DairyPackage.MILK_SALE__SALE_AMOUNT:
				return getSaleAmount();
			case DairyPackage.MILK_SALE__CONTRACT_SALE:
				return isContractSale();
			case DairyPackage.MILK_SALE__SALES_CLERK:
				if (resolve) return getSalesClerk();
				return basicGetSalesClerk();
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
		switch (featureID) {
			case DairyPackage.MILK_SALE__ID:
				setId((Long)newValue);
				return;
			case DairyPackage.MILK_SALE__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case DairyPackage.MILK_SALE__REFERENCE_NUMBER:
				setReferenceNumber((String)newValue);
				return;
			case DairyPackage.MILK_SALE__SALE_DATE:
				setSaleDate((Date)newValue);
				return;
			case DairyPackage.MILK_SALE__BIN:
				setBin((Bin)newValue);
				return;
			case DairyPackage.MILK_SALE__SALE_TYPE:
				setSaleType((MilkSaleType)newValue);
				return;
			case DairyPackage.MILK_SALE__QUANTITY:
				setQuantity((BigDecimal)newValue);
				return;
			case DairyPackage.MILK_SALE__GRADE:
				setGrade((MilkGrade)newValue);
				return;
			case DairyPackage.MILK_SALE__UNIT_PRICE:
				setUnitPrice((BigDecimal)newValue);
				return;
			case DairyPackage.MILK_SALE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DairyPackage.MILK_SALE__REJECTED:
				setRejected((Boolean)newValue);
				return;
			case DairyPackage.MILK_SALE__STORE_OR_ROUTE:
				setStoreOrRoute((DairyLocation)newValue);
				return;
			case DairyPackage.MILK_SALE__CUSTOMER:
				setCustomer((Customer)newValue);
				return;
			case DairyPackage.MILK_SALE__SOLD_BY:
				setSoldBy((Employee)newValue);
				return;
			case DairyPackage.MILK_SALE__SALE_AMOUNT:
				setSaleAmount((BigDecimal)newValue);
				return;
			case DairyPackage.MILK_SALE__CONTRACT_SALE:
				setContractSale((Boolean)newValue);
				return;
			case DairyPackage.MILK_SALE__SALES_CLERK:
				setSalesClerk((Employee)newValue);
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
		switch (featureID) {
			case DairyPackage.MILK_SALE__ID:
				setId(ID_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__REFERENCE_NUMBER:
				setReferenceNumber(REFERENCE_NUMBER_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__SALE_DATE:
				setSaleDate(SALE_DATE_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__BIN:
				setBin((Bin)null);
				return;
			case DairyPackage.MILK_SALE__SALE_TYPE:
				setSaleType(SALE_TYPE_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__GRADE:
				setGrade((MilkGrade)null);
				return;
			case DairyPackage.MILK_SALE__UNIT_PRICE:
				setUnitPrice(UNIT_PRICE_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__REJECTED:
				setRejected(REJECTED_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__STORE_OR_ROUTE:
				setStoreOrRoute((DairyLocation)null);
				return;
			case DairyPackage.MILK_SALE__CUSTOMER:
				setCustomer((Customer)null);
				return;
			case DairyPackage.MILK_SALE__SOLD_BY:
				setSoldBy((Employee)null);
				return;
			case DairyPackage.MILK_SALE__SALE_AMOUNT:
				setSaleAmount(SALE_AMOUNT_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__CONTRACT_SALE:
				setContractSale(CONTRACT_SALE_EDEFAULT);
				return;
			case DairyPackage.MILK_SALE__SALES_CLERK:
				setSalesClerk((Employee)null);
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
		switch (featureID) {
			case DairyPackage.MILK_SALE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DairyPackage.MILK_SALE__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case DairyPackage.MILK_SALE__REFERENCE_NUMBER:
				return REFERENCE_NUMBER_EDEFAULT == null ? referenceNumber != null : !REFERENCE_NUMBER_EDEFAULT.equals(referenceNumber);
			case DairyPackage.MILK_SALE__SALE_DATE:
				return SALE_DATE_EDEFAULT == null ? saleDate != null : !SALE_DATE_EDEFAULT.equals(saleDate);
			case DairyPackage.MILK_SALE__BIN:
				return bin != null;
			case DairyPackage.MILK_SALE__SALE_TYPE:
				return saleType != SALE_TYPE_EDEFAULT;
			case DairyPackage.MILK_SALE__QUANTITY:
				return QUANTITY_EDEFAULT == null ? quantity != null : !QUANTITY_EDEFAULT.equals(quantity);
			case DairyPackage.MILK_SALE__GRADE:
				return grade != null;
			case DairyPackage.MILK_SALE__UNIT_PRICE:
				return UNIT_PRICE_EDEFAULT == null ? unitPrice != null : !UNIT_PRICE_EDEFAULT.equals(unitPrice);
			case DairyPackage.MILK_SALE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DairyPackage.MILK_SALE__REJECTED:
				return rejected != REJECTED_EDEFAULT;
			case DairyPackage.MILK_SALE__STORE_OR_ROUTE:
				return storeOrRoute != null;
			case DairyPackage.MILK_SALE__CUSTOMER:
				return customer != null;
			case DairyPackage.MILK_SALE__SOLD_BY:
				return soldBy != null;
			case DairyPackage.MILK_SALE__SALE_AMOUNT:
				return SALE_AMOUNT_EDEFAULT == null ? saleAmount != null : !SALE_AMOUNT_EDEFAULT.equals(saleAmount);
			case DairyPackage.MILK_SALE__CONTRACT_SALE:
				return contractSale != CONTRACT_SALE_EDEFAULT;
			case DairyPackage.MILK_SALE__SALES_CLERK:
				return salesClerk != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(", referenceNumber: ");
		result.append(referenceNumber);
		result.append(", saleDate: ");
		result.append(saleDate);
		result.append(", saleType: ");
		result.append(saleType);
		result.append(", quantity: ");
		result.append(quantity);
		result.append(", unitPrice: ");
		result.append(unitPrice);
		result.append(", description: ");
		result.append(description);
		result.append(", rejected: ");
		result.append(rejected);
		result.append(", saleAmount: ");
		result.append(saleAmount);
		result.append(", contractSale: ");
		result.append(contractSale);
		result.append(')');
		return result.toString();
	}

} //MilkSaleImpl
