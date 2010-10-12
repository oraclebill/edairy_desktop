package com.agritrace.edairy.desktop.internal.common.persistence;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.osgi.service.log.LogService;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionInterceptor implements MethodInterceptor {
	private static Logger log = Log4r.getLogger(Activator.getDefault(), TransactionInterceptor.class);
	
	@Inject
	private Provider<Session> sessionProvider;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Session session = sessionProvider.get();
		Transaction tx = session.getTransaction();
		
		if (tx != null && tx.isActive()) {
			// Already in a larger transaction context
			return invocation.proceed();
		}
		
		String methodName = invocation.getMethod().getDeclaringClass().getSimpleName() + "." + invocation.getMethod().getName();
		log.log(LogService.LOG_DEBUG, "Starting transaction for method " + methodName);
		tx = session.beginTransaction();
		
		try {
			Object result = invocation.proceed();
			tx.commit();
			log.log(LogService.LOG_DEBUG, "Committed: " + methodName);
			return result;
		} catch (Throwable e) {
			tx.rollback();
			log.log(LogService.LOG_DEBUG, "Rolled back: " + methodName);
			throw e;
		}
	}
}
