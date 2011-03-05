package com.agritrace.edairy.desktop.internal.common.persistence;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.osgi.service.log.LogService;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionInterceptor implements MethodInterceptor {
	private static Logger LOGGER = Log4r.getLogger(PersistenceActivator.getDefault(), TransactionInterceptor.class);
	
	@Inject
	private Provider<Session> sessionProvider;

	public TransactionInterceptor() {
		LOGGER.log(LogService.LOG_DEBUG, "TRACE: CONSTRUCT transaction interceptor @ " + this.hashCode());
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		LOGGER.log(LogService.LOG_DEBUG, "TRACE: INVOKE transaction interceptor @ " + this.hashCode());
		Session session = sessionProvider.get();
		Transaction tx = session.getTransaction(); 
		
		if (tx != null && tx.isActive()) {
			LOGGER.log(LogService.LOG_DEBUG, "TRACE: PROCEED (with current tx) transaction interceptor @ " + this.hashCode());
			return invocation.proceed();
		}
		
		String methodName = invocation.getMethod().getDeclaringClass().getSimpleName() + "." + invocation.getMethod().getName();
		LOGGER.log(LogService.LOG_DEBUG, "Starting new transaction in method " + methodName);
		tx = session.beginTransaction();
		LOGGER.log(LogService.LOG_DEBUG, this.hashCode() + " : TX["+tx+"] started.");

		Object result = null;
		try {
			result = invocation.proceed();
			tx.commit();
			LOGGER.log(LogService.LOG_DEBUG, this.hashCode() + " : TX["+tx+"] Committed for: " + methodName);
			return result;
		}
		catch (TransactionException te) {
			// this is how we manage rollbacks..
			tx.rollback();
			session.close();
			LOGGER.log(LogService.LOG_DEBUG, this.hashCode() + " : TX["+tx+"] Rolled back by request in: " + methodName);
			return result;
		}
		catch (Throwable e) {
			tx.rollback();
			session.clear();
			LOGGER.log(LogService.LOG_DEBUG, this.hashCode() + " : TX["+tx+"] Rolled back in: " + methodName);
			throw e;
		}
	}
}
