package com.agritrace.edairy.riena.ui.controllers.members;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IColumnFormatter;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.ridgets.ISelectableRidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.riena.ui.views.ViewWidgetId;
import com.agritrace.edairy.riena.ui.views.data.SimpleFormattedDateBean;
import com.agritrace.edairy.riena.ui.views.members.AddContainerDialog;
import com.agritrace.edairy.riena.ui.views.members.MemberSearchSelectionListener;
import com.agritrace.edairy.riena.ui.views.members.MemberSearchSelectionManager;

public class MemberSearchViewController extends SubModuleController implements MemberSearchSelectionListener, ISelectionListener{

	private Membership workingCopy;
	private Membership selectedMember;
	
	//upper panel fields
	private ITextRidget memberIdRidget;
	private IComboRidget comboStatus;
	private ITextRidget phoneRidget;
	private ITextRidget nameRidget;
	private ITextRidget appliedDate;
	private ITextRidget effectiveDate;
	
	private ITextRidget addressTxt;
	private ITextRidget sectionTxt;
	private ITextRidget estateTxt;
	private ITextRidget locationTxt;
	private ITextRidget subLocationTxt;
	private ITextRidget villageTxt;
	private ITextRidget divisionTxt;
	private ITextRidget districtTxt;
	private ITextRidget provinceTxt;
	private ITextRidget postalCodeTxt;
	
	//container tab
	private ITableRidget containerTable;
	private IActionRidget containerAddButton;
	private IActionRidget containerRemoveButton;
	
	public static final String containerRemoveTitle="Remove Containers";
	public static final String containerRemoveMessage="Do you want to remove selected containers?";
	
	private List<Container>input = new ArrayList<Container>();

	public MemberSearchViewController(){
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}
	
	@Override
	public void configureRidgets(){
		configureUpperPanel();
		configureContainerTab();
		
		if(selectedMember != null){
			updateBindings();
		}
		
		//save button
		((IActionRidget)getRidget(ViewWidgetId.memberInfo_saveButton)).addListener(new IActionListener() {

			public void callback() {
				saveMember();
			}
		});
	}
	
	private void configureUpperPanel(){
		memberIdRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_id);
		appliedDate=getRidget(ITextRidget.class,ViewWidgetId.memberInfo_applicationDate);
		effectiveDate=getRidget(ITextRidget.class,ViewWidgetId.memberInfo_effectiveDate);
		comboStatus = (IComboRidget) getRidget(IComboRidget.class,ViewWidgetId.memberInfo_status);
		comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class, null, new WritableValue()); //$NON-NLS-1$ //$NON-NLS-2$
		comboStatus.updateFromModel();
		comboStatus.addSelectionListener(this);
		phoneRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_phone); 
		nameRidget = getRidget(ITextRidget.class,ViewWidgetId.memberInfo_firstName);
		
		addressTxt=getRidget(ITextRidget.class,ViewWidgetId.ADDRESS_TXT);
		sectionTxt=getRidget(ITextRidget.class,ViewWidgetId.SECTION_TXT);
		estateTxt=getRidget(ITextRidget.class,ViewWidgetId.ESTATE_TXT);
		locationTxt=getRidget(ITextRidget.class,ViewWidgetId.LOCATION_TXT);
		subLocationTxt=getRidget(ITextRidget.class,ViewWidgetId.SUBLOCATION_TXT);
		villageTxt=getRidget(ITextRidget.class,ViewWidgetId.VILLAGE_TXT);
		divisionTxt=getRidget(ITextRidget.class,ViewWidgetId.DIVISION_TXT);
		districtTxt=getRidget(ITextRidget.class,ViewWidgetId.DISTRICT_TXT);
//		provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
		postalCodeTxt=getRidget(ITextRidget.class,ViewWidgetId.POSTAL_CODE_TXT);
	}
	
	private void configureContainerTab(){
		containerTable = getRidget(ITableRidget.class, ViewWidgetId.CONTAINER_TABLE);
		containerAddButton = getRidget(IActionRidget.class,ViewWidgetId.CONTAINER_ADD);
		containerAddButton.addListener(new IActionListener() {
			
			@Override
			public void callback() {
				Shell shell = new Shell(Display.getDefault(),SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX| SWT.APPLICATION_MODAL);
				shell.setSize(550, 450);
				AddContainerDialog dialog = new AddContainerDialog(shell);
				dialog.setMemberShip(selectedMember);
				if(dialog.open()==Window.OK){
					Container newContainer = dialog.getNewContainer();
					newContainer.getOwner().getCans().add(newContainer);
					input.add(newContainer);
					containerTable.updateFromModel();
				}
			}
		});
		
		containerRemoveButton = getRidget(IActionRidget.class,ViewWidgetId.CONTAINER_Remove);
		containerRemoveButton.setEnabled(false);
		containerRemoveButton.addListener(new IActionListener(){

			@Override
			public void callback() {
				if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), containerRemoveTitle , containerRemoveMessage)){
					List<Object> selections = containerTable.getSelection();
					if(selectedMember != null){
						for(Object selObject : selections ){
							((Container)selObject).getOwner().getCans().remove(selObject);
							input.remove(selObject);
						}
						containerTable.updateFromModel();
					}
				}
				
				
			}
			
		});
	}
	
	private void updateBindings(){
		updateUpperPanelBinding();
		updateContainerBinding();
	}
	
	private void updateUpperPanelBinding(){
		memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdRidget.updateFromModel();
  	    comboStatus = (IComboRidget) getRidget(IComboRidget.class,ViewWidgetId.memberInfo_status); //$NON-NLS-1$
  	    comboStatus.updateFromModel();
  	    comboStatus.setSelection(selectedMember.getStatus().getValue());
		phoneRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),ModelPackage.Literals.PARTY__PHONE_NUMBER));
		phoneRidget.updateFromModel();
		nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),ModelPackage.Literals.PARTY__NAME));
		nameRidget.updateFromModel();
		
		SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		if(workingCopy.getApplicationDate() != null){
			bean.setDate(selectedMember.getApplicationDate());
		}
		appliedDate.setText(bean.getFormattedDate());

		if(workingCopy.getEffectiveDate() != null){
			bean.setDate(selectedMember.getEffectiveDate());
		}else{
			bean.setFormattedDate("");
		}
		effectiveDate.setText(bean.getFormattedDate());
		
		if(!selectedMember.getMember().getLocation().isEmpty()){
			Location location = selectedMember.getMember().getLocation().get(0);
			addressTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__ADDRESS));
			addressTxt.updateFromModel();
		    sectionTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__SECTION));
		    sectionTxt.updateFromModel();
			estateTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__ESTATE));
			estateTxt.updateFromModel();
			locationTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__LOCATION));
			locationTxt.updateFromModel();
			subLocationTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__SUB_LOCATION));
			subLocationTxt.updateFromModel();
			villageTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__VILLAGE));
			villageTxt.updateFromModel();
			divisionTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__DIVISION));
			divisionTxt.updateFromModel();
			districtTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__DISTRICT));
			districtTxt.updateFromModel();
//			provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
			postalCodeTxt.bindToModel(EMFObservables.observeValue(location,ModelPackage.Literals.LOCATION__POSTAL_CODE));
			postalCodeTxt.updateFromModel();
		}
	}

	@Override
	public void memberSelectionChanged(Membership selectedMember) {
		if(this.selectedMember != selectedMember){
			this.selectedMember = selectedMember;
			copySelectedMember();
		}
		updateBindings();
	}

	@Override
	public void memberModified(Membership modifiedMember) {
		// TODO Auto-generated method stub
		
	}
	
	private void copySelectedMember(){
		if(selectedMember != null){
			workingCopy = (Membership)EcoreUtil.copy(selectedMember);	
		}
		
		
		
	}
	private void saveMember(){
		if(selectedMember != null){
			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);	
		}
	}
	
	private void updateContainerBinding(){
		List<Farm> farms = selectedMember.getFarms();
		
		for(Farm farm :farms){
			input.addAll( farm.getCans());	
		}
		
			String[] columnPropertyNames = { "containerId", "owner","type", "units", "measureType","capacity"};
			String[] columnHeaders = { "ID", "Farm","Container Type", "Units","Units Of Measure","Capacity" }; 
			containerTable.setColumnFormatter(1, new ColumnFormatter() {
				
				@Override
				public String getText(Object element) {
					if(element instanceof Container){
						return ((Container)element).getOwner().getName();
					}
					return null;
				}
				
				
			});
			containerTable.bindToModel(new WritableList(input, Container.class), Container.class, columnPropertyNames, columnHeaders);
			containerTable.updateFromModel();
			containerTable.setSelectionType(ISelectableRidget.SelectionType.MULTI);
			containerTable.addSelectionListener(this);
		
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if(event.getSource() == comboStatus){
		  if(selectedMember != null){
			  selectedMember.setStatus((MembershipStatus)event.getNewSelection().get(0));
		  }
		}else if(event.getSource() == containerTable){
			List<Object> selection =  event.getNewSelection();
			if(selection.size() > 0){
				containerRemoveButton.setEnabled(true);
			}else{
				containerRemoveButton.setEnabled(false);
			}
		}
		
	}

}
