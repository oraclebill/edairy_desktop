package com.agritrace.edairy.desktop.milkops.ui.intake.collectionline;

import org.eclipse.core.databinding.conversion.Converter;

final class InlineInputFlagConverter extends Converter {
	/**
	 *
	 */
	private final CollectionLineRidget collectionLineRidget;

	InlineInputFlagConverter(CollectionLineRidget collectionLineRidget, Object fromType, Object toType) {
		super(fromType, toType);
		this.collectionLineRidget = collectionLineRidget;
	}

	@Override
	public Object convert(Object fromObject) {
		if (fromObject instanceof String && !((String) fromObject).isEmpty()) {
			String text = (String) fromObject;
			final String firstChar = text.substring(0, 1);
			if (firstChar.equalsIgnoreCase("N")) {
				text = text.substring(1);
				this.collectionLineRidget.setMPRMissing(true);
				return text;
			} else if (firstChar.equalsIgnoreCase("R")) {
				text = text.substring(1);
				this.collectionLineRidget.setRejected(true);
				return text;
			}
		}
		return fromObject;
	}
}