package com.agritrace.edairy.desktop.common.services;

import com.agritrace.edairy.desktop.common.model.base.ImageEntry;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface IImageEntryRepository extends IRepository<ImageEntry> {
	ImageEntry findByKey(String key);
}
