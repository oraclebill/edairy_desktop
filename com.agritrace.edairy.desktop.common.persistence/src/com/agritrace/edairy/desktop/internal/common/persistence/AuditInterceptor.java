/**
 * 
 */
package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.agritrace.edairy.desktop.common.model.audit.AuditFactory;
import com.agritrace.edairy.desktop.common.model.audit.AuditRecord;
import com.agritrace.edairy.desktop.common.model.audit.ChangeType;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.google.inject.Inject;
import com.google.inject.Provider;

public final class AuditInterceptor extends EmptyInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7085321141066042938L;
	
	private final @Audit Provider<Session> auditProvider;
	
	@Inject
	public AuditInterceptor(final @Audit Provider<Session> auditProvider) {
		this.auditProvider = auditProvider;
	}

	private static boolean equals(Object o1, Object o2) {
		if (o1 == null)
			return o2 == null;
		
		return o1.equals(o2);
	}
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			String name = propertyNames[i];
			Object newValue = state[i];
			
			logChange(entity, ChangeType.SAVE, name, null, newValue);
		}
		
		return false;
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			String name = propertyNames[i];
			Object oldValue = previousState[i];
			Object newValue = currentState[i];
			
			if (!equals(oldValue, newValue)) {
				logChange(entity, ChangeType.SAVE, name, oldValue, newValue);
			}
		}
		
		return false;
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		logChange(entity, ChangeType.DELETE, null, null, null);
	}
	
	private void logChange(Object entity, ChangeType type, String name, Object oldValue, Object newValue) {
		final Session session = auditProvider.get();
		final Transaction transaction = session.getTransaction();
		final AuditRecord rec = AuditFactory.eINSTANCE.createAuditRecord();
		
		rec.setDate(new Date());
		rec.setChangeType(type);
		rec.setContent(entity.toString());
		rec.setEntity("");
		
		if (entity instanceof EObject) {
			rec.setEntity(((EObject) entity).eClass().getName());
		}
		
		IPrincipal principal = PrincipalManager.getInstance().getPrincipal();
		
		if (principal != null) {
			rec.setUser(principal.getName());
		}
		
		if (transaction != null) {
			
		}
		
		session.save(rec);
	}
}