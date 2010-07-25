package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public interface IMemberInfoProvider {
	
	
	Membership getMember( String memberNumber );
}
