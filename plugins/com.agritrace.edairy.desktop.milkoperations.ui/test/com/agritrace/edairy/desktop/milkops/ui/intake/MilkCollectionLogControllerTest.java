package com.agritrace.edairy.desktop.milkops.ui.intake;

import static org.easymock.EasyMock.createMock;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.milkops.ui.intake.BulkCollectionsEntryDialog;
import com.agritrace.edairy.desktop.milkops.ui.intake.MilkCollectionLogController;
import com.agritrace.edairy.desktop.milkops.ui.intake.NewMilkCollectionJournalDialog;
import com.google.inject.Provider;

public class MilkCollectionLogControllerTest extends AbstractSubModuleControllerTest<MilkCollectionLogController> {

	IMilkCollectionRepository journalRepo;
	IDairyRepository dairyRepo;
	IRepository<CollectionSession> sessionRepo;
	IActionListener scaleImportAction;

	Provider<NewMilkCollectionJournalDialog> newDialogProvider;
	Provider<BulkCollectionsEntryDialog> entryDialogProvider;
	Provider<Session> sessionProvider;

	@Before
	@SuppressWarnings("unchecked")
	public void setUp() throws Exception {
		journalRepo = createMock(IMilkCollectionRepository.class);
		dairyRepo = createMock(IDairyRepository.class);
		scaleImportAction = createMock(IActionListener.class);

		sessionRepo = createMock(IRepository.class);
		newDialogProvider = createMock(Provider.class);
		newDialogProvider = createMock(Provider.class);
		sessionProvider = createMock(Provider.class);

		super.setUp();
	}

	@Override
	protected MilkCollectionLogController createController(ISubModuleNode node) {
//		return new MilkCollectionLogController(sessionProvider, newDialogProvider, entryDialogProvider);
		throw new UnknownError();
// journalRepo,
// dairyRepo,
// sessionRepo,
// newDialogProvider,
// entryDialogProvider);
	}

	@Test
	public void testEnterCollectionJournalButton() {
		// get tnew new button and push it.
		IActionRidget enterJournalButton = getController().getRidget(IActionRidget.class,
				AbstractDirectoryView.BIND_ID_NEW_BUTTON);
		enterJournalButton.fireAction();
		// dialog provider get should have been called..

		fail("Not yet implemented");
	}

	@Test
	public void testAddCollection() {
		fail("Not yet implemented");
	}

}
