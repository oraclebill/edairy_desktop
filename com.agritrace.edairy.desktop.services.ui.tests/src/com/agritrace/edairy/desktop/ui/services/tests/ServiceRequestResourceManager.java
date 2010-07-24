package com.agritrace.edairy.desktop.ui.services.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;

/**
 * Service Request resource manager
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestResourceManager {

	public static ServiceRequestResourceManager INSTANCE = new ServiceRequestResourceManager();



	private ServiceRequestResourceManager() {

	}

	private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId)
			throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		for (int i = 0; i < containerNumber; i++) {
			final Container container = TrackingFactory.eINSTANCE.createContainer();
//			container.setType(ContainerType.BIN);
			// final int id = containerId + i;
			// container.setContainerId(id);
			container.setOwner(farm);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setCapacity(50);
			farm.getCans().add(container);
		}

		for (int i = 0; i < animalNumber; i++) {
			final RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
			animal1.setRegistrationId(10001);
			animal1.setGivenName("animal_" + i);
			animal1.setLocation(farm);
			final int n = (int) (10.0 * Math.random());
			final int m = n < 3 ? 10 + n : n + 3;
			final String date = m > 9 ? "0" + n + "/" + m + "/200" + n : "0" + n + "/0" + m + "/200" + n;
			final Date effectedDate = sdf.parse(date);
			animal1.setDateOfAcquisition(effectedDate);
			animal1.setPurpose(Purpose.DAIRY);
			if (i % 2 == 0) {
				animal1.setGender(Gender.FEMALE);
			} else {
				animal1.setGender(Gender.MALE);
			}
			final int rearingModelValue = i % 7;
			animal1.setRearingMode(RearingMode.get(rearingModelValue));
			final int acquisionType = i % 5;
			animal1.setAcquisitionType(AcquisitionType.get(acquisionType));

			final ReferenceAnimalType animal1_type = TrackingFactory.eINSTANCE.createReferenceAnimalType();
			// animal1_type.setAnimalTypeId(animalId + i);
			animal1_type.setSpecies("Cow");
			animal1_type.setSpecies("jersey");
			animal1.setAnimalType(animal1_type);
			farm.getAnimals().add(animal1);

		}
	}
}
