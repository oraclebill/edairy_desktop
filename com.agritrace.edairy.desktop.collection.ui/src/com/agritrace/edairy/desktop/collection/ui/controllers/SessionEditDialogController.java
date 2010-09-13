package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.collection.ui.ViewConstants;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDetailPanelController;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.BindingHelper;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;

public final class SessionEditDialogController extends BaseDialogController<CollectionSession> {
	private final class DetailController extends AbstractDetailPanelController<CollectionSession> {
		@Override
		protected void bindRidgets() {
			BindingHelper<CollectionSession> mapper = getMapper();
			mapper.addMapping(ViewConstants.SESSION_BIND_CODE, DairyPackage.Literals.COLLECTION_SESSION__CODE);
			mapper.addMapping(ViewConstants.SESSION_BIND_DESCRIPTION, DairyPackage.Literals.COLLECTION_SESSION__DESCRIPTION);
			mapper.addMapping(ViewConstants.SESSION_BIND_TIME, DairyPackage.Literals.COLLECTION_SESSION__TIME_OF_DAY);
			
			getRidgetContainer().getRidget(ITextRidget.class, ViewConstants.SESSION_BIND_CODE).setMandatory(true);
		}
	}
	
	private final class Delegate extends AbstractMasterDetailsDelegate {
		private final CollectionSession workingCopy = createWorkingCopy();
		private DetailController detailController;

		public Delegate() {
			detailController = new DetailController();
		}

		@Override
		public Object copyBean(Object source, Object target) {
			final CollectionSession from = source != null ? (CollectionSession) source : createWorkingCopy();
			final CollectionSession to = target != null ? (CollectionSession) target : createWorkingCopy();
			EMFUtil.copy(from, to, 1);
			return to;
		}

		@Override
		public CollectionSession createWorkingCopy() {
			CollectionSession session = DairyFactory.eINSTANCE.createCollectionSession();
			session.setTimeOfDay(new GregorianCalendar(1970, Calendar.JANUARY, 1, 9, 0, 0).getTime());
			return session;
		}

		@Override
		public CollectionSession getWorkingCopy() {
			return workingCopy;
		}
		
		@Override
		public String isValid(IRidgetContainer container) {
			Collection<IMarkableRidget> errors = ContainerValidator.validateContainer(container);
			
			return errors.isEmpty() ? null : "There are errors in the form. Please correct them before pressing Apply.";
		}

		@Override
		public void configureRidgets(IRidgetContainer container) {
			detailController.setModel(getWorkingCopy());
			detailController.setRidgetContainer(container);
			detailController.configureAndBind();
		}
	}
	
	private List<CollectionSession> sessions;
	private IRepository<CollectionSession> repository;
	
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		final String[] headers = new String[] { "Code", "Time of Day", "Description"};
		final String[] properties = new String[] {
				DairyPackage.Literals.COLLECTION_SESSION__CODE.getName(),
				"timeAsString",
				DairyPackage.Literals.COLLECTION_SESSION__DESCRIPTION.getName(),
		};

		final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
		repository = RepositoryFactory.getRepository(CollectionSession.class);
		sessions = new ArrayList<CollectionSession>(repository.all());
		
		if (master != null) {
			master.setDelegate(new Delegate());
			master.bindToModel(new WritableList(sessions, CollectionSession.class), CollectionSession.class,
					properties, headers);
			master.updateFromModel();

			final IActionRidget actionApply = master.getRidget(IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);
			this.addDefaultAction(master, actionApply);
		}

		super.configureButtonsPanel();
		getRidget(DialogConstants.BIND_ID_BUTTON_DELETE).setVisible(false);
	}
	
	@Override
	protected void handleSaveAction() {
		for (CollectionSession session: sessions) {
			if (session.getId() == null) {
				repository.saveNew(session);
			} else {
				repository.save(session);
			}
		}
		
		for (CollectionSession session: repository.all()) {
			if (!sessions.contains(session)) {
				repository.delete(session);
			}
		}
		
		super.handleSaveAction();
	}
}
