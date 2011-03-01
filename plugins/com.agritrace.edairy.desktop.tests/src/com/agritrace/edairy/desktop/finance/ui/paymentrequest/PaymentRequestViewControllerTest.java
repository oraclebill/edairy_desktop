package com.agritrace.edairy.desktop.finance.ui.paymentrequest;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;

public class PaymentRequestViewControllerTest extends AbstractSubModuleControllerTest<PaymentRequestViewController> {

	private IMilkCollectionRepository mockRepository;

	@Override
	protected PaymentRequestViewController createController(ISubModuleNode node) {
		mockRepository = createMock(IMilkCollectionRepository.class);
		PaymentRequestViewController controller = new PaymentRequestViewController(mockRepository);
		controller.setNavigationNode(node);
		return controller;
	}

	@Test
	public void testPeriodComboSetup() {
		IComboRidget periodCombo = getController().getRidget(IComboRidget.class,
				PaymentRequestViewController.PAYMENT_PERIOD_COMBO);

		// test empty selection
		periodCombo.setSelection(-1);
		assertEquals(periodCombo.getEmptySelectionItem(), periodCombo.getSelection());

		// test 12 periods displayed
		assertEquals(12, periodCombo.getObservableList().size());

		// test periods are of type PaymentPeriod
// assertEquals(PaymentPeriod.class, periodCombo.getObservableList().getElementType());
	}

	@SuppressWarnings("deprecation")
	public void testCalculateGrossCollectionsWhenPeriodChanges() throws Exception {
		List<CollectionJournalLine> collections = generateTestCollections();
		int count = collections.size();
		BigDecimal expectedSum = BigDecimal.valueOf(count * 12.4); // each delivery is 12.4 kg..

		mockRepository.filter(isA(Class.class), isA(FilterParameter.class), isA(FilterParameter.class));
		expectLastCall().andStubReturn(collections);

		replay(mockRepository);

		// test behaviour
		IComboRidget periodCombo = getController().getRidget(IComboRidget.class,
				PaymentRequestViewController.PAYMENT_PERIOD_COMBO);
		periodCombo.setSelection(0);

		ITextRidget grossCollectionsText = getController().getRidget(ITextRidget.class,
				PaymentRequestViewController.GROSS_COLLECTIONS_TEXT);
		assertEquals(expectedSum.floatValue(),
				new BigDecimal(grossCollectionsText.getText().replace(",", "")).floatValue());
	}

	public void testCalculatePayments() throws Exception {

		PaymentRequestViewController controller = getController();
		IDecimalTextRidget grossCollectionsText = controller.getRidget(IDecimalTextRidget.class,
				PaymentRequestViewController.GROSS_COLLECTIONS_TEXT);
		IDecimalTextRidget paymentRateText = controller.getRidget(IDecimalTextRidget.class,
				PaymentRequestViewController.PAYMENT_RATE_TEXT);
		IActionRidget calculateButton = controller.getRidget(IActionRidget.class,
				PaymentRequestViewController.CALCULATE_BUTTON);
		ITableRidget rateTable = controller.getRidget(ITableRidget.class, PaymentRequestViewController.RATE_TABLE);

		BigDecimal testRate = new BigDecimal("23");
		BigDecimal grossCollections = new BigDecimal("199");

		// should update model immediately
		paymentRateText.setText(testRate.toPlainString());
		grossCollectionsText.setText(grossCollections.toPlainString());

		// simulate button push
		calculateButton.fireAction();

		// validate table is updated
		assertEquals(5, rateTable.getOptionCount());
		RateEntry centerEntry = (RateEntry) rateTable.getOption(2);
		assertEquals(testRate, centerEntry.getRate());
		assertEquals(testRate.multiply(grossCollections), centerEntry.getGross());
	}

	public void testPrintResults() throws Exception {
		IActionRidget printButton = getController().getRidget(IActionRidget.class,
				PaymentRequestViewController.CALCULATE_BUTTON);
		printButton.fireAction();

		// saveAs dialog appears

		// user enters save location

		// user clicks 'OK' button

		// pdf report file is created
		fail("not implemented");
	}

	/**
	 * @return
	 * @throws ParseException
	 */
	private List<CollectionJournalLine> generateTestCollections() throws ParseException {
		Date startDate, endDate;
		DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
		startDate = df.parse("1/1/2011");
		endDate = df.parse("1/31/2011");
		return generateTestCollections(startDate, endDate);
	}

	private List<CollectionJournalLine> generateTestCollections(Date startDate,
			Date endDate) throws ParseException {
		List<CollectionJournalLine> collections;

		// setup mock..
		collections = new ArrayList<CollectionJournalLine>();
		for (CollectionGroup group : generateTestCollectionGroups(10, startDate, endDate)) {
			collections.addAll(group.getJournalEntries());
		}
		return collections;
	}

	private Dairy createDairy() {
		Dairy dairy;
		dairy = DairyFactory.eINSTANCE.createDairy();
		return dairy;
	}

	private DairyLocation createCollectionCenter(Dairy dairy,
			String code) {
		DairyLocation center;

		center = DairyFactory.eINSTANCE.createDairyLocation();
		center.setCode("L001");
		center.setId(1L);
		center.setName("Location 001");
		center.setPhone("123-123-1234");
		center.setDescription("A description of L001");
		center.setDateOpened(new Date());
		center.getFunctions().add(DairyFunction.MILK_COLLECTION);

		dairy.getBranchLocations().add(center);

		return center;
	}

	private CollectionGroup createCollectionGroup(DairyLocation center,
			Date collectionDate,
			CollectionSession session) {
		CollectionGroup group;

		group = DairyFactory.eINSTANCE.createCollectionGroup();
		group.setJournalId(Long.valueOf(group.hashCode()));
		group.setJournalDate(collectionDate);
		group.setCollectionCenter(center);
		group.setSession(session);
		group.setType(CollectionGroupType.JOURNAL_GROUP);

// group.setDriver(value);
// group.setDriverTotal(value);
// group.setReferenceNumber(value);

		return group;
	}

	private CollectionJournalLine createCollectionEntry(CollectionGroup group,
			Bin bin,
			Membership member,
			BigDecimal amount) {
		CollectionJournalLine entry = DairyFactory.eINSTANCE.createCollectionJournalLine();

		entry.setCollectionJournal(group);
		entry.setBin(bin);
		entry.setRecordedMember(member.getMemberNumber());
		entry.setValidatedMember(member);
		entry.setQuantity(BigDecimal.valueOf(124, 1));
		entry.setFlagged(false);
		return entry;
	}

	private Membership createMember(String memberNumber) {
		Membership member = DairyUtil
				.createMembership(
						new Date(2000, 10, 1),
						new Date(2000, 10, 15),
						DairyUtil.createFarmer("Hal", "2000", "2001", "123-123-1234",
								DairyUtil.createFarm("Hals' Farm", null)));
		return member;
	}

	private List<CollectionGroup> generateTestCollectionGroups(int numMembers,
			Date startDate,
			Date endDate) {
		Membership[] members;
		members = new Membership[numMembers];
		for (int count = 0; count < numMembers; count++) {
			members[count] = createMember(String.format("%05d", count));
		}
		return generateTestCollectionGroups(members, startDate, endDate);
	}

	private List<CollectionGroup> generateTestCollectionGroups(Membership[] members,
			Date startDate,
			Date endDate) {
		List<CollectionGroup> groups;

		CollectionSession session;
		Bin bin;

		session = DairyFactory.eINSTANCE.createCollectionSession();
		session.setCode("AM");

		bin = DairyFactory.eINSTANCE.createBin();
		bin.setTrackingNumber("B0001");
		bin.setCapacity(125.0d);

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);

		groups = new ArrayList<CollectionGroup>();
		for (; cal.before(end); cal.add(Calendar.DAY_OF_YEAR, 1)) {
			CollectionGroup group = createCollectionGroup(null, cal.getTime(), session);
			for (Membership member : members) {
				CollectionJournalLine entry = createCollectionEntry(group, bin, member, BigDecimal.ONE);
				group.getJournalEntries().add(entry);
			}
			groups.add(group);
		}

		return groups;
	}

}
