package com.agritrace.edairy.desktop.install;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

/**
 * Create a dairy configuration by importing excel data in standard format.
 * 
 * @author bjones
 * 
 */
public class MemberTransactionImportTool extends AbstractImportTool {

	public static final String CREDIT_SALE 			= "Credit Sale";
	public static final String STORE_PREFIX 		= "Stores:";
	public static final String CLINICAL_PREFIX 		= "Vet Services:Clinical Services";
	public static final String AI_PREFIX 			= "Vet Services:A.I.";
	
	public static final int BASE = 0;
	public static final int TX_TYPE = 		BASE;
	public static final int TX_DATE = 		BASE + 1;
	public static final int TX_REFNO = 		BASE + 2;
	public static final int TX_MEMBERNO = 	BASE + 3;
	public static final int TX_CLASS = 		BASE + 4;
	public static final int TX_AMOUNT = 	BASE + 5;

		
	private static final Entry[] fieldMap = {
			new Entry(TX_TYPE, AccountPackage.Literals.TRANSACTION__TRANSACTION_TYPE),
			new Entry(TX_DATE, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE),
			new Entry(TX_REFNO, AccountPackage.Literals.ACCOUNT_TRANSACTION__REFERENCE_NUMBER),
			new Entry(TX_MEMBERNO, AccountPackage.Literals.TRANSACTION__ACCOUNT), // 
			new Entry(TX_CLASS, AccountPackage.Literals.ACCOUNT_TRANSACTION__SOURCE),
			new Entry(TX_AMOUNT,
					AccountPackage.Literals.TRANSACTION__AMOUNT), 
	};

	private static final int[] mandatoryFields = { TX_TYPE, TX_DATE, TX_REFNO, TX_CLASS, TX_AMOUNT };

	final private Map<String, Account> memberAccountCache = new HashMap<String, Account>();
	final private Map<String, DairyLocation> locationCache = new HashMap<String, DairyLocation>();
	private Map<String, List<String[]>> failedRecords;
	private List<AccountTransaction> transactions;
	
	private final IDairyRepository dairyRepo;
	private final IMemberRepository memberRepo;

	private int count = 0, errCount = 0;
	private SimpleDateFormat dateFormat;

	@Inject
	public MemberTransactionImportTool(final IDairyRepository dairyRepo, final IMemberRepository memberRepo) {
		this.dairyRepo = dairyRepo;
		this.memberRepo = memberRepo;
	}
	
	public void processFile(InputStream input, List<AccountTransaction> transactions,
			Map<String, List<String[]>> errors, IProgressMonitor monitor) throws IOException {
		setReader(new InputStreamReader(input));
		setMonitor(monitor);
		
		setMonitorDelta(100);
		this.transactions = transactions;
		this.failedRecords = errors;
		this.dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for (DairyLocation location : dairyRepo.getLocalDairyLocations()) {
			locationCache.put(location.getCode(), location);
		}
		
		//List<Account> accounts = RepositoryFactory.getRepository(Account.class).all();
		List<Account> accounts = memberRepo.allAccounts();
		System.err.println("======== retrieved allaccounts ============");
		for (Account account : accounts) {
			memberAccountCache.put(account.getAccountNumber().substring(1), account);
		}
		
		super.processFile();
	}
	
	@Override
	protected String[] getExpectedHeaders() {
		return new String[] { "Type", "Date", "Reference", "Member No.", "Class", "Amount" };
	}

	@Override
	protected void processRecord(String[] values) {
		validateRecord(values);
		EObject entity = createEntityFromRecord(values);
		saveImportedEntity(entity);
	}

	protected void validateRecord(String[] values) {
		super.validateRecord(values);		
		// check for valid member number, and account.
		String memberNo = values[TX_MEMBERNO];		
		Account account = memberAccountCache.get(memberNo);
		if (account == null) {
//			account = RepositoryFactory.getDairyRepository().findAccountByMemberNo(memberNo);
//			if ( account != null ) {
//				memberAccountCache.put(memberNo, account);
//			}
//			else {
				throw new ValidationException("Unable to find member " + memberNo);
//			}
		}
		String source = values[TX_CLASS];
		if ( !source.startsWith(AI_PREFIX) && !source.startsWith(CLINICAL_PREFIX) && !source.startsWith( STORE_PREFIX)) {
			throw new ValidationException("Unknown transaction class " + source);
		}
	}
	
	/**
	 * Create an AccountTransaction based on values array.
	 * 
	 * We will create a transaction and set the account by lookup in memberAccountCache, 
	 * as well as parse the 'class' field to determine the proper 'source'.
	 * 
	 * If the source is 'store', then we will attempt to parse the store code from the
	 * 'class' field, trying both 'S' and 'R' based prefixes for the route number.
	 * 
	 * There is no error checking here as it is assumed the record has been validated
	 * already in the 'validateRecord' method.
	 */
	@Override protected EObject createEntityFromRecord(String[] values) {
		AccountTransaction tx = AccountFactory.eINSTANCE.createAccountTransaction();
		System.err.println("Creating transaction for account V" + values[TX_MEMBERNO]);
		
		tx.setAccount(memberAccountCache.get(values[TX_MEMBERNO]));
		try {
			Number num = NumberFormat.getInstance().parse(values[TX_AMOUNT]);
			tx.setAmount(new BigDecimal(num.doubleValue()));
		} catch (ParseException e) {
			throw new ValidationException("Unable to parse transaction amount: " + values[TX_AMOUNT] );
		}
		try {
			Date transactionDate = dateFormat.parse(values[TX_DATE]);
			tx.setTransactionDate(transactionDate);			
		}
		catch( Exception e) {
			throw new ValidationException("Unable to parse transaction date: " + values[TX_DATE]);
		}
		tx.setReferenceNumber(values[TX_REFNO]);
		
		if ( CREDIT_SALE.equals(values[TX_TYPE]) ) { 
			tx.setTransactionType(TransactionType.CREDIT);
		}
		
		if ( values[TX_CLASS].startsWith(STORE_PREFIX)) {
			tx.setSource(TransactionSource.STORE_CREDIT);
			String storeNumber = values[TX_CLASS].substring(STORE_PREFIX.length());
			DairyLocation location = locationCache.get(storeNumber);
			if ( location == null && storeNumber.startsWith("R") ) {
				location = locationCache.get("S"+storeNumber.substring(1));  // replace 'R' with 'S'
			}
			tx.setRelatedLocation(location);			
		}
		else if (values[TX_CLASS].startsWith(AI_PREFIX)) {
			tx.setSource(TransactionSource.CLINICAL_SERVICES);
		}
		else if (values[TX_CLASS].startsWith(CLINICAL_PREFIX)) {
			tx.setSource(TransactionSource.CLINICAL_SERVICES);
		}
		
		System.err.println("New transaction created ");
		return tx;
	}
	
	protected int[] getMandatoryFieldIndexes() {
		return mandatoryFields;
	}

	@Override
	protected void saveImportedEntity(Object entity) {
		count++;
		transactions.add((AccountTransaction)entity);
	}

	protected void doImportRecordFailed(String[] values, Exception e) {
		errCount++;
		String message = e.getMessage();
		List<String[]> records = failedRecords.get(message);
		if (records == null) {
			records = new LinkedList<String[]>();
			failedRecords.put(message, records);
		}
		records.add(values);
	}


	@Override
	protected EObject createBlankEntity() {
		return AccountFactory.eINSTANCE.createAccountTransaction();
	}

	@Override
	protected List<Entry> getFields() {
		return Arrays.asList(fieldMap);
	}

	@Override
	protected void doImportComplete(int okCount, int failCount) {

	}


}
