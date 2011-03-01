package com.agritrace.edairy.desktop.milkops.ui.intake.collectionline;

import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;

public interface ICollectionLineRidget extends IComplexRidget {

	String VALIDATED_VALUE = "validatedValue";


	public void setBinList(List<Bin> binList);
	public List<Bin> getBinList();

	public void addValidator(IValidator vc);
	public void removeValidator(IValidator vc);

	public void createCollectionLine();

	public void setMemberInfoProvider(IMemberLookup provider);
	public IMemberLookup getMemberInfoProvider();
	public void clearValidators();
	void setRouteValidator(IValidator routeValidator);
	public CollectionJournalLine getWorkingCollectionLine();


}
