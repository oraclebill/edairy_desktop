package com.agritrace.edairy.desktop.common.services;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.services.ImageEntryRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(ImageEntryRepository.class)
public interface IImageEntryRepository extends IRepository<ImageEntry> {
	ImageEntry findByKey(String key);
}
