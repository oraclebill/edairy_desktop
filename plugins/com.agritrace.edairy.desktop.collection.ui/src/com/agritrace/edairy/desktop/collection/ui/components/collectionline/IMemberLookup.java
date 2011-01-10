package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import com.agritrace.edairy.desktop.collection.ui.dialogs.CachingMemberLookup;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.google.inject.ImplementedBy;

@ImplementedBy(CachingMemberLookup.class)
public interface IMemberLookup {
	Membership getMember( String memberNumber );
}
