package com.agritrace.edairy.desktop.common.ui.editingsupport;

import org.eclipse.core.databinding.conversion.IConverter;

import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;

public class ContactTypeColumnEditingSupport extends ColumnEditingSupport {

	@Override
	public IConverter getModelToUIControlConverter() {
		return new IConverter() {

			@Override
			public Object convert(Object fromObject) {
				if (fromObject instanceof ContactMethodType) {
					return ContactMethodType.VALUES.indexOf(fromObject);
				}
				return null;
			}

			@Override
			public Object getFromType() {
				return ContactMethodType.class;
			}

			@Override
			public Object getToType() {
				return Integer.class;
			}
		};
	}

	@Override
	public IConverter getUIControlToModelConverter() {
		return new IConverter() {

			@Override
			public Object convert(Object fromObject) {
				if ((fromObject instanceof Integer) && (((Integer) fromObject) > -1)) {
					return ContactMethodType.VALUES.get((Integer) fromObject);
				}
				return ContactMethodType.EMAIL;
			}

			@Override
			public Object getFromType() {

				return Integer.class;
			}

			@Override
			public Object getToType() {
				return ContactMethodType.class;
			}
		};
	}

}
