package com.agritrace.edairy.riena.ui.views.members;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.ContainerType;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.model.tracking.UnitOfMeasure;
import com.agritrace.edairy.model.tracking.Farm;

public class AddContainerDialog extends TitleAreaDialog implements ModifyListener{


	private Container newContainer = TrackingFactory.eINSTANCE.createContainer();
	
	private Text idText;
	private Text numberText;
	private Text capacityText;
	private ControlDecoration unitsDecorator ;
	private ControlDecoration capacityDecorator ;
	private Membership memberShip;
	/**
	 * MyTitleAreaDialog constructor
	 * 
	 * @param shell the parent shell
	 */
	public AddContainerDialog(Shell shell) {
		super(shell);

	}
	
	public AddContainerDialog(Shell shell, Membership selectedMembership) {
		super(shell);
		this.memberShip = selectedMembership;

	}

	/**
	 * Closes the dialog box Override so we can dispose the image we created
	 */
	public boolean close() {

		return super.close();
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Add Container Record");
		setMessage("Please input container details");
		return contents;
	}
	
	 protected void configureShell(Shell newShell) {
	        super.configureShell(newShell);
	        newShell.setSize(550, 450);
	    }


	

	/**
	 * Creates the gray area
	 * 
	 * @param parent the parent composite
	 * @return Control
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite dialogArea = UIControlsFactory.createComposite(composite);
		dialogArea.setLayout(new GridLayout(2,false));
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		Label id = UIControlsFactory.createLabel(dialogArea,"ID:");
		
		idText = UIControlsFactory.createText(dialogArea, SWT.BORDER|SWT.SINGLE);
		idText.setTextLimit(10);
		idText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		idText.addModifyListener(this);
		
		Label typeLabel = UIControlsFactory.createLabel(dialogArea,"Container Type:");
		Combo containerCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer containerComboViewer = new ComboViewer(containerCombo);
		containerComboViewer.setContentProvider(new ArrayContentProvider());
		containerComboViewer.setInput(ContainerType.values());
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				String value = (String)((IStructuredSelection)event.getSelection()).getFirstElement();
				newContainer.setContainerId(value);
				
			}
		});
		containerComboViewer.getControl().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));

		Label unitsLabel = UIControlsFactory.createLabel(dialogArea, "Units:");
		numberText = new Text(dialogArea, SWT.BORDER|SWT.SINGLE);
		numberText.setTextLimit(10);
		numberText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		numberText.addModifyListener(this);
		unitsDecorator = createDecorator(numberText, "");
		unitsDecorator.hide();

		
		Label measureLabel = UIControlsFactory.createLabel(dialogArea, "Unit Of Measure:");
		Combo measureCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer measureComboViewer = new ComboViewer(measureCombo);
		measureComboViewer.setContentProvider(new ArrayContentProvider());
		measureComboViewer.setInput(UnitOfMeasure.values());
		measureComboViewer.getControl().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		measureComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				UnitOfMeasure value = (UnitOfMeasure)((IStructuredSelection)event.getSelection()).getFirstElement();
				newContainer.setMeasureType(value);
				
			}
		});
		
		Label capacityLabel =  UIControlsFactory.createLabel(dialogArea, "Capacity:");
		
		capacityText = new Text(dialogArea, SWT.BORDER|SWT.SINGLE);
		capacityText.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false));
		capacityText.addModifyListener(this);
		capacityDecorator  = createDecorator(numberText, "");
		capacityDecorator.hide();
		
		Label farmLabel = UIControlsFactory.createLabel(dialogArea, "Farm:");
		Combo farmCombo = UIControlsFactory.createCombo(dialogArea);
		ComboViewer farmComboViewer = new ComboViewer(farmCombo);
		farmComboViewer.setContentProvider(new ArrayContentProvider());
		if(memberShip != null){
			farmComboViewer.setInput(memberShip.getFarms());
			farmComboViewer.setLabelProvider(new LabelProvider(){
				public String getText(Object element) {
					if(element instanceof Farm){
						return ((Farm)element).getName();
					}
					return super.getText(element);
				}
			});
			
		}
		
		farmComboViewer.getControl().setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		farmComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Farm value = (Farm)((IStructuredSelection)event.getSelection()).getFirstElement();
				newContainer.setOwner(value);
				
			}
		});
		
		if(memberShip != null && memberShip.getFarms().size()>0){
			farmComboViewer.setSelection(new StructuredSelection(memberShip.getFarms().get(0)));	
		}
		containerComboViewer.getCombo().select(0);
		measureComboViewer.getCombo().select(0);
		return composite;
	}

	/**
	 * Creates the buttons for the button bar
	 * 
	 * @param parent the parent composite
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		Button okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);

	}

	//@Override
	public void modifyText(ModifyEvent e) {
		if(e.getSource() == idText){
			newContainer.setContainerId(idText.getText().trim());
		}else if(e.getSource() == numberText){
			String value = numberText.getText();
			if(value != null && !value.trim().equals("")){
				try{
					double unitsValue  = new Double(value).doubleValue();
					newContainer.setUnits(unitsValue);
					if(unitsDecorator.isVisible()){
						setErrorMessage(null);
						unitsDecorator.hide();	
					}
					
				}catch(NumberFormatException ex){
					newContainer.setUnits(0);
					unitsDecorator.show();
					setErrorMessage("Invalid number format");
				}
				
			}
		}else if(e.getSource() == capacityText){
			String value = capacityText.getText();
			if(value != null && !value.trim().equals("")){
				try{
					double unitsValue  = new Double(value).doubleValue();
					newContainer.setCapacity(unitsValue);
					capacityDecorator.hide();
				}catch(NumberFormatException ex){
					newContainer.setCapacity(0);
					capacityDecorator.show();
					setErrorMessage("Invalid number format");
				}

			}		
		}
		if(validate()){
			setErrorMessage(null);
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}else{
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
		
		
	}
	private boolean validate(){
		return newContainer.getContainerId() != null && newContainer.getType() != null && newContainer.getUnits() != 0 && newContainer.getMeasureType() != null && newContainer.getCapacity() != 0;
	}

	private ControlDecoration createDecorator(Text text, String message) {
		ControlDecoration controlDecoration = new ControlDecoration(text,
				SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText(message);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		controlDecoration.setImage(fieldDecoration.getImage());
		return controlDecoration;
	}

	public Container getNewContainer() {
		return newContainer;
	}

	public void setNewContainer(Container newContainer) {
		this.newContainer = newContainer;
	}

	public Membership getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(Membership memberShip) {
		this.memberShip = memberShip;
	}

	protected boolean isResizable() {
		return true;
	}
}




