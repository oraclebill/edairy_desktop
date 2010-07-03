package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Mechanism;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.reference.LivestockValues;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class ViewLiveStockDialogController extends BaseDialogController<RegisteredAnimal> implements ISelectionListener {

	private class AddPropertyChangedListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			if (arg0.getSource() == nameText) {
				titleLabel.setText("Animal " + nameText.getText());
			}
			enableSaveButton(validate());
		}

	}

	public static final String DIALOG_TITLE = "Livestock";

	private List<Farm> farmList;

	private Map<IRidget, FeaturePath> liveStockBindings;

	private RegisteredAnimal selectedNode;
	// identification tab
	ITextRidget acquisionDate;
	IComboRidget acquisionTypeCombo;
	ITextRidget antibioticsTxt;
	ITextRidget awardText;
	ITextRidget birthDayTxt;
	IComboRidget breedCombo;
	ITextRidget certificateTxt;
	IComboRidget farmCombo;
	IComboRidget farmingTypeCombo;
	ITextRidget featureTxt;
	ITextRidget feedBrand;
	IComboRidget feedCombo;
	IToggleButtonRidget femaleButton;
	// rearing tab
	IComboRidget habitsCombo;
	ITextRidget idNumberTxt;
	IComboRidget idTypeCombo;
	ITextRidget insuranceNumberTxt;
	ITextRidget insuranceTxt;
	IToggleButtonRidget maleButton;
	ITextRidget ministryId;
	ITextRidget nameText;
	ITextRidget notesText;
	IComboRidget purposeCombo;
	IComboRidget sireBreed;
	IComboRidget sireSpecies;
	IComboRidget statusCombo;
	ITextRidget supplementsTxt;
	// upperPanel
	ILabelRidget titleLabel;
	// general tab
	IComboRidget typeCombo;
	// other tab
	ITextRidget verterinaryTxt;

	ITextRidget veterinaryTxt;

	public ViewLiveStockDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		setWorkingCopy((RegisteredAnimal) getContext(ControllerContextConstant.DIALOG_CONTXT_SELECTED));
		if (getContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST) != null) {
			farmList = (List<Farm>) getContext(ControllerContextConstant.LIVESTOCK_DIALOG_CONTXT_FARM_LIST);
		} else {
			farmList = new ArrayList<Farm>();
		}

		configureUpperPanel();
		configureGeneralTab();
		configureIdentificationTab();
		configureRearingTab();
		configureOtherTab();
		if (getWorkingCopy() != null) {
			initBindings();
			updateBindings();
		}
		configureButtonsPanel();
		addPropertyChangedListener();
		enableSaveButton(validate());

	}

	@Override
	public RegisteredAnimal getWorkingCopy() {
		return selectedNode;
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (selectedNode == null) {
			return;
		}
		if (event.getSource() == farmCombo) {
			selectedNode.setLocation((Farm) event.getNewSelection().get(0));
		}
		if (event.getSource() == typeCombo) {
			if (selectedNode.getAnimalType() != null) {
				selectedNode.getAnimalType().setSpecies((String) event.getNewSelection().get(0));
			}
		} else if (event.getSource() == breedCombo) {
			if (selectedNode.getAnimalType() != null) {
				selectedNode.getAnimalType().setBreed((String) event.getNewSelection().get(0));
			}
		} else if (event.getSource() == sireSpecies) {

			if (selectedNode.getSireType() != null) {
				selectedNode.getSireType().setSpecies((String) event.getNewSelection().get(0));
			}
		} else if (event.getSource() == breedCombo) {
			if (selectedNode.getSireType() != null) {
				selectedNode.getSireType().setBreed((String) event.getNewSelection().get(0));
			}
		} else if (event.getSource() == idTypeCombo) {
			if (selectedNode.getIdentifiers().size() > 0) {
				selectedNode.getIdentifiers().get(0).setIssuer(((Mechanism) event.getNewSelection().get(0)).toString());
			}
		} else if (event.getSource() == feedCombo) {
			selectedNode.setFeedType(((String) event.getNewSelection().get(0)));
		} else if (event.getSource() == habitsCombo) {
			selectedNode.setFeedingHabit(((String) event.getNewSelection().get(0)));

		}
	}

	@Override
	public void setWorkingCopy(RegisteredAnimal liveStock) {
		selectedNode = liveStock;
	}

	private void bindReferenceAnimal(IComboRidget speciesCombo, IComboRidget breedsCombo, ReferenceAnimalType animalType) {
		if (animalType != null) {
			speciesCombo.bindToModel(Observables.staticObservableList(LivestockValues.getSpecies()), String.class,
					null, new WritableValue());
			speciesCombo.updateFromModel();
			if (animalType.getSpecies() != null) {
				speciesCombo.setSelection(animalType.getSpecies());
				speciesCombo.addSelectionListener(this);
			}
			breedsCombo.bindToModel(Observables.staticObservableList(LivestockValues.getBreeds()), String.class, null,
					new WritableValue());
			breedsCombo.updateFromModel();
			if (animalType.getBreed() != null) {
				breedsCombo.addSelectionListener(this);
				breedsCombo.setSelection(animalType.getBreed());
			}
		}
	}

	private Map<IRidget, FeaturePath> initBindingMap() {
		final Map<IRidget, FeaturePath> aMap = new HashMap<IRidget, FeaturePath>();

		aMap.put(titleLabel, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__GIVEN_NAME)); // uses
		aMap.put(nameText, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__GIVEN_NAME)); // uses
		aMap.put(insuranceNumberTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__INSURANCE_NUMBER)); // uses
		aMap.put(featureTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__IDENTIFYING_FEATURES)); // uses
		aMap.put(certificateTxt,
				FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__BIRTH_CERTIFICATE_NUMBER));
		aMap.put(veterinaryTxt,
				FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__VETERINARY_CERTIFICATE_NUMBER));
		aMap.put(ministryId, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__MINISTRY_ID));
		aMap.put(insuranceTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__INSURANCE_COMPANY));
		aMap.put(feedBrand, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__FEED_BRAND));
		aMap.put(supplementsTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__SUPPLEMENTS));
		aMap.put(antibioticsTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__ANTIBIOTICS));
		aMap.put(verterinaryTxt, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__VETERINARY));
		aMap.put(awardText, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__AWARDS));
		aMap.put(notesText, FeaturePath.fromList(TrackingPackage.Literals.REGISTERED_ANIMAL__NOTES));

		return aMap;
	}

	private void updateBindings() {
		Assert.isLegal(null != selectedNode);
		if (selectedNode != null) {
			// loop through the text ridgets
			for (final IRidget r : liveStockBindings.keySet()) {
				if (r instanceof IValueRidget) {

					final IObservableValue oberservModel = EMFProperties.value(liveStockBindings.get(r)).observe(
							selectedNode);
					// need to bind model to UI control converter again, because
					// the fromType instance changes every time
					((IValueRidget) r).bindToModel(oberservModel);
					((IValueRidget) r).updateFromModel();

				}
			}
			updateComboBindings();
		}

	}

	private void updateComboBindings() {
		if (selectedNode != null) {
			// farmCombo
			farmCombo.bindToModel(new WritableList(farmList, Farm.class), Farm.class, "getName", new WritableValue());
			farmCombo.updateFromModel();
			if (selectedNode.getLocation() != null) {
				farmCombo.setSelection(selectedNode.getLocation());
			}
			farmCombo.addSelectionListener(this);

			// purposeCombo
			purposeCombo.bindToModel(
					Observables.staticObservableList(Purpose.VALUES),
					Purpose.class,
					null,
					PojoObservables.observeValue(selectedNode,
							TrackingPackage.Literals.REGISTERED_ANIMAL__PURPOSE.getName()));
			purposeCombo.updateFromModel();
			// gender buttons
			final Gender gender = selectedNode.getGender();
			maleButton.setSelected(gender == Gender.MALE);
			maleButton.addListener(new IActionListener() {

				@Override
				public void callback() {
					if (maleButton.isSelected()) {
						selectedNode.setGender(Gender.MALE);
					}
				}
			});
			femaleButton.setSelected(gender == Gender.FEMALE);
			femaleButton.addListener(new IActionListener() {
				@Override
				public void callback() {
					if (femaleButton.isSelected()) {
						selectedNode.setGender(Gender.FEMALE);
					}
				}
			});
			// birthDayTxt and acquisionDate
			final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
			if (selectedNode.getDateOfBirth() != null) {
				bean.setDate(selectedNode.getDateOfBirth());
				birthDayTxt.setText(bean.getFormattedDate());
			}
			if (selectedNode.getDateOfAcquisition() != null) {
				bean.setDate(selectedNode.getDateOfAcquisition());
				acquisionDate.setText(bean.getFormattedDate());

			}

			// acquisionTypeCombo
			acquisionTypeCombo.bindToModel(Observables.staticObservableList(AcquisitionType.VALUES),
					AcquisitionType.class, null, PojoObservables.observeValue(selectedNode,
							TrackingPackage.Literals.REGISTERED_ANIMAL__ACQUISITION_TYPE.getName()));
			acquisionTypeCombo.setMandatory(true);
			acquisionTypeCombo.updateFromModel();
			// idTypeCombo
			idTypeCombo.bindToModel(Observables.staticObservableList(Mechanism.VALUES), Mechanism.class, null,
					new WritableValue());
			idTypeCombo.updateFromModel();

			// todo, only show the first identifier.
			AnimalIdentifier identifier = null;
			if (selectedNode.getIdentifiers().size() > 0) {
				identifier = selectedNode.getIdentifiers().get(0);

			} else {
				identifier = DairyUtil.createAnimalIdentifier("", "");
				selectedNode.getIdentifiers().add(identifier);
			}

			final String issure = identifier.getIssuer();
			final Mechanism issureType = Mechanism.get(issure);
			idTypeCombo.setSelection(issureType);
			idTypeCombo.addSelectionListener(this);
			idNumberTxt.bindToModel(EMFObservables.observeValue(identifier,
					TrackingPackage.Literals.ANIMAL_IDENTIFIER__VALUE));
			idNumberTxt.updateFromModel();

			// ReferencedAnimal
			bindReferenceAnimal(typeCombo, breedCombo, selectedNode.getAnimalType());
			typeCombo.setMandatory(true);
			breedCombo.setMandatory(true);
			bindReferenceAnimal(sireSpecies, sireBreed, selectedNode.getSireType());

			// habitsCombo
			habitsCombo.bindToModel(Observables.staticObservableList(LivestockValues.getFeedHabits()), String.class,
					null, new WritableValue());
			habitsCombo.updateFromModel();
			habitsCombo.setSelection(selectedNode.getFeedingHabit());
			habitsCombo.addSelectionListener(this);
			// farmingTypeCombo (RearingMode)
			farmingTypeCombo.bindToModel(
					Observables.staticObservableList(RearingMode.VALUES),
					RearingMode.class,
					null,
					PojoObservables.observeValue(selectedNode,
							TrackingPackage.Literals.REGISTERED_ANIMAL__REARING_MODE.getName()));
			farmingTypeCombo.updateFromModel();

			// feedCombo
			feedCombo.bindToModel(Observables.staticObservableList(LivestockValues.getFeedTypes()), String.class, null,
					new WritableValue());
			feedCombo.updateFromModel();
			feedCombo.setSelection(selectedNode.getFeedType());
			feedCombo.addSelectionListener(this);

		}
	}

	protected void addPropertyChangedListener() {
		final AddPropertyChangedListener propertyChangedListener = new AddPropertyChangedListener();
		final Iterator<IRidget> ridgetIterator = (Iterator<IRidget>) getRidgets().iterator();
		while (ridgetIterator.hasNext()) {
			final IRidget ridget = ridgetIterator.next();
			if (ridget instanceof ITextRidget) {
				ridget.addPropertyChangeListener("text", propertyChangedListener);
			} else if (ridget instanceof IComboRidget) {
				ridget.addPropertyChangeListener("selection", propertyChangedListener);
			} else if (ridget instanceof IMarkable) {
				ridget.addPropertyChangeListener("marker", propertyChangedListener);
			}
		}
	}

	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
	}

	protected void configureGeneralTab() {
		typeCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_TYPE_COBMO);
		breedCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_BREED_COBMO);

		maleButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_MALE);
		femaleButton = getRidget(IToggleButtonRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_FEMALE);

		birthDayTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY);
		birthDayTxt.setOutputOnly(true);
		birthDayTxt.setMandatory(true);

		final IActionRidget birthDayBtn = getRidget(IActionRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_BIRTHDAY_BUTTON);
		birthDayBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (selectedNode != null) {
					final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
					final Date birthDay = selectedNode.getDateOfBirth();
					if (birthDay != null) {
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(birthDay));
					} else {
						// By default it will be today
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(Calendar.getInstance().getTime()));
					}

					final int ret = calDialog.open();
					if (ret == AbstractWindowController.OK) {
						final Date selectedDate = (Date) calDialog.getController().getContext(
								SimpleFormattedDateBean.DATE_PROR);
						selectedNode.setDateOfBirth(selectedDate);
						final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
						bean.setDate(selectedDate);
						birthDayTxt.setText(bean.getFormattedDate());
					}
				}

			}
		});

		certificateTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_BIRTH_CERTIFICATE);
		veterinaryTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_VERTERINARY);
		sireSpecies = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_SPECIES);
		sireBreed = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_GENERAL_SIRE_BREED);

	}

	protected void configureIdentificationTab() {
		acquisionDate = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE);
		acquisionDate.setMandatory(true);
		acquisionDate.setOutputOnly(true);
		final IActionRidget acquisionDateButton = getRidget(IActionRidget.class,
				ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_DATE_BTN);
		acquisionDateButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (selectedNode != null) {
					final CalendarSelectionDialog calDialog = new CalendarSelectionDialog();
					final Date acqusionDay = selectedNode.getDateOfAcquisition();
					if (acqusionDay != null) {
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(acqusionDay));
					} else {
						// By default it will be today
						calDialog.getController().setContext(SimpleFormattedDateBean.FORMATTED_DATE_VALUE_PROP,
								DateTimeUtils.DATE_FORMAT.format(Calendar.getInstance().getTime()));
					}

					final int ret = calDialog.open();
					if (ret == AbstractWindowController.OK) {
						final Date selectedDate = (Date) calDialog.getController().getContext(
								SimpleFormattedDateBean.DATE_PROR);
						selectedNode.setDateOfAcquisition(selectedDate);
						final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
						bean.setDate(selectedDate);
						acquisionDate.setText(bean.getFormattedDate());
					}
				}

			}
		});

		acquisionTypeCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ACQUISION_TYPE);
		idTypeCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ID_TYPE);
		idNumberTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_ID_NUMBER);
		ministryId = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_MINISTRY_ID);
		insuranceTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_COMPANY);
		insuranceNumberTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_INSURANCE_NUMBER);
		featureTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_IDENTIFICATION_UNIQUE_FEATURE);

		idTypeCombo.setMandatory(true);
		idNumberTxt.setMandatory(true);
		idNumberTxt.setDirectWriting(true);

	}

	protected void configureOtherTab() {
		verterinaryTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_OTHER_VERTERINARY);
		awardText = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_OTHER_AWARDS);
		notesText = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_OTHER_NOTES);

	}

	protected void configureRearingTab() {

		habitsCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_REARING_HABITS);
		farmingTypeCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_REARING_FAMILY);
		feedCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_REARING_FEED);
		feedBrand = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_REARING_FEED_BRAND);
		supplementsTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_REARING_SUPPLIERS);
		antibioticsTxt = getRidget(ITextRidget.class, ViewWidgetId.LIVESTOCK_REARING_ANTIBIOTICS);
	}

	protected void configureUpperPanel() {
		titleLabel = getRidget(ILabelRidget.class, ViewWidgetId.LIVE_STOCK_NAME);
		nameText = getRidget(ITextRidget.class, ViewWidgetId.LIVE_STOCK_NameText);
		nameText.setDirectWriting(true);
		nameText.setMandatory(true);
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVE_STOCK_FARM_COMBO);
		farmCombo.setMandatory(true);
		purposeCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVE_STOCK_PURPOSE_COMBO);
		statusCombo = getRidget(IComboRidget.class, ViewWidgetId.LIVE_STOCK_STATUS_COMBO);
	}

	protected void initBindings() {
		liveStockBindings = initBindingMap();
	}

	@Override
	protected boolean validate() {
		for (final IRidget ridget : getRidgets()) {
			IMarkableRidget markable;
			if (ridget instanceof IMarkableRidget) {
				markable = (IMarkableRidget) ridget;
				if (markable.isErrorMarked()) {
					return false;
				}
				if (markable.isMandatory()) {
					if (ridget instanceof ITextRidget) {
						if (((ITextRidget) ridget).getText().isEmpty()) {
							return false;
						}
					} else if (ridget instanceof IComboRidget) {
						if (((IComboRidget) ridget).getSelection() == null) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}

}
