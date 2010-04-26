/**
 * 
 */
package com.agritrace.edairy.desktop.app;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ApplicationNode;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.navigation.ui.controllers.ApplicationController;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.DesktopActivator;

import com.agritrace.edairy.desktop.modules.dairy.DairyProfileView;


/**
 * @author oraclebill
 *
 */
public class EDMApplication extends SwtApplication {

	public static final String BG_DARK =  "edm_dark_background";
	public static final String BG_LIGHT =  "edm_light_background";


	public EDMApplication() {
		super();
		LnfManager.setLnf(new EDairyManagerLookAndFeel());
	}

	//    @Override
	protected Bundle getBundle() {
		return DesktopActivator.getDefault().getBundle();
	}

	@Override
	protected void initializeNodeDefaultIcon(INavigationNode<?> node) {
		// TODO Auto-generated method stub
		super.initializeNodeDefaultIcon(node);
	}

    /**
     * @see org.eclipse.riena.navigation.ui.swt.application.SwtApplication#createApplicationController(org.eclipse.riena.navigation.IApplicationModel)
     */
    @Override
    protected ApplicationController createApplicationController(
                    IApplicationNode node) {
            ApplicationController controller = super.createApplicationController(node);
            controller.setMenubarVisible(true);
            return controller;
    }

	@Override
	protected IApplicationNode createModel() {

		IApplicationNode applicationNode = super.createModel();
		applicationNode.setLabel("eDairy Manager Desktop");
//		applicationNode.setIcon("path to icon");
		
		
		ISubApplicationNode subApplication = new SubApplicationNode(
				new NavigationNodeId("com.agritrace.edairy.desktop.navigation.subapplication"), 
				"Main");
		WorkareaManager.getInstance().registerDefinition(subApplication, "subapplication.main");
		applicationNode.addChild(subApplication);
		
		IModuleGroupNode groupTopLevel = new ModuleGroupNode(new NavigationNodeId("primary.navgroup"));
		subApplication.addChild(groupTopLevel);

		IModuleNode moduleSystem = NodeFactory.createModule(
				new NavigationNodeId("edm.sysadmin"), "Setup", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSystem.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.info"), "Dairy Profile", moduleSystem, DairyProfileView.ID, 
				com.agritrace.edairy.desktop.modules.dairy.DairyProfileController.class); //$NON-NLS-1$ //$NON-NLS-2$

//		ISubApplicationNode dataEntry = new SubApplicationNode("Data Entry"); //$NON-NLS-1$
//		applicationNode.addChild(dataEntry);
//		ISubApplicationNode reports = new SubApplicationNode("Reports"); //$NON-NLS-1$
//		applicationNode.addChild(reports);

//		ApplicationController ac = (ApplicationController) app.getNavigationNodeController(); 
//		ac.getStatusline().setMessage("Hello World!");

		return applicationNode;

	}
	
	public boolean validateUserLogin(String username, String password) {
		return false;
	}
	
//	EntityManagerFactory factory;
//	
//	private void initPersistence() {
//		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		EntityManager em = factory.createEntityManager();
//
//		// Begin a new local transaction so that we can persist a new entity
//		em.getTransaction().begin();
//
//		// Read the existing entries
//		Query q = em.createQuery("select m from Person m");
//		// Persons should be empty
//
//		// Do we have entries?
//		boolean createNewEntries = (q.getResultList().size() == 0);
//
//		// No, so lets create new entries
//		if (createNewEntries) {
//			assertTrue(q.getResultList().size() == 0);
//			Family family = new Family();
//			family.setDescription("Family for the Knopfs");
//			em.persist(family);
//			for (int i = 0; i < 40; i++) {
//				Person person = new Person();
//				person.setFirstName("Jim_" + i);
//				person.setLastName("Knopf_" + i);
//				em.persist(person);
//				// First we have to persists the job
//				// Now persists the new person
//				family.getMembers().add(person);
//				em.persist(person);
//				em.persist(family);
//			}
//		}
//
//		// Commit the transaction, which will cause the entity to
//		// be stored in the database
//		em.getTransaction().commit();
//
//		// It is always good practice to close the EntityManager so that
//		// resources are conserved.
//		em.close();
//		
//	}

}
