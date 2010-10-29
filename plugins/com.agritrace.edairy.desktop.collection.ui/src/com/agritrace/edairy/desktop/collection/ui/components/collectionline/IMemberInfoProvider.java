package com.agritrace.edairy.desktop.collection.ui.components.collectionline;

import com.agritrace.edairy.desktop.collection.ui.dialogs.MemberLookupProvider;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.google.inject.ImplementedBy;

@ImplementedBy(MemberLookupProvider.class)
public interface IMemberInfoProvider {
	Membership getMember( String memberNumber );
}
