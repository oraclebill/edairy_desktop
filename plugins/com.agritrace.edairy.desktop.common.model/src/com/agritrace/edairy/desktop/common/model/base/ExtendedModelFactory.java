package com.agritrace.edairy.desktop.common.model.base;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.internal.common.model.Activator;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExtendedModelFactory extends ModelFactoryImpl implements EFactory
{
	@Inject
	Dairy cachedDairy;
	
	public ExtendedModelFactory()
	{
		super();
		BundleContext context = Activator.getDefault().getContext();
		Assert.isNotNull(context);
		
		ServiceReference injectorService = context.getServiceReference(Injector.class.getName());
		Assert.isNotNull(injectorService);
		
		Injector injector = (Injector) context.getService(injectorService);
		injector.injectMembers(this);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#createPostalLocation()
	 */
	@Override
	public PostalLocation createPostalLocation()
	{
		PostalLocation postLocation = super.createPostalLocation();
		return postLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#createMapLocation()
	 */
	@Override
	public MapLocation createMapLocation()
	{
		MapLocation mapLocation = super.createMapLocation();
		return mapLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#createStatutoryLocation()
	 */
	@Override
	public StatutoryLocation createStatutoryLocation()
	{
		StatutoryLocation statLocation = super.createStatutoryLocation();
		return statLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#createDescriptiveLocation()
	 */
	@Override
	public DescriptiveLocation createDescriptiveLocation()
	{
		// TODO Auto-generated method stub
		return super.createDescriptiveLocation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#createLocation()
	 */
	@Override
	public Location createLocation()
	{
		Location location = super.createLocation();
		location.setDescriptiveLocation(createDescriptiveLocation());
		location.setMapLocation(createMapLocation());
		location.setPostalLocation(createPostalLocation());
		location.setStatutoryLocation(createStatutoryLocation());
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.agritrace.edairy.desktop.common.model.base.impl.ModelFactoryImpl#convertPermissionTToString(org.eclipse.emf
	 * .ecore.EDataType, java.lang.Object)
	 */
	@Override
	public String convertPermissionTToString(	EDataType eDataType,
												Object instanceValue)
	{
		return instanceValue == null ? null : ((UIPermission) instanceValue).name();
	}

}
