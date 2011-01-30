package com.agritrace.edairy.desktop.milkops.ui.components.collectionline;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.milkops.ui.dialogs.CachingMemberLookup;
import com.google.inject.ImplementedBy;

@ImplementedBy(CachingMemberLookup.class)
public interface IMemberLookup {
	Membership getMember( String memberNumber );
}
