package com.agritrace.edairy.desktop.internal.common.services;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.common.services.IImageEntryRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public final class ImageEntryRepository extends HibernateRepository<ImageEntry> implements IImageEntryRepository {
	@Inject
	public ImageEntryRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		super(sessionProvider, auditProvider);
	}

	@Override
	protected Class<?> getClassType() {
		return ImageEntry.class;
	}

	@Override
	public ImageEntry findByKey(final String key) {
		final SessionRunnable<ImageEntry> runnable = new SessionRunnable<ImageEntry>() {
			@Override
			public void run(Session session) {
				setResult((ImageEntry) session.get("ImageEntry", key));
			}
		};
		
		run(runnable);
		return runnable.getResult();
	}
}