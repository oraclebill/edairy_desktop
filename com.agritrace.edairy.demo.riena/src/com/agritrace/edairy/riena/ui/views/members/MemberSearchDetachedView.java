package com.agritrace.edairy.riena.ui.views.members;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.UnitOfMeasure;


public class MemberSearchDetachedView extends SubModuleView implements MemberSearchSelectionListener, ISelectionChangedListener, SelectionListener {

	public static final String LOOKUP_FIELD="Column";
	public static final String LOOKUP_BUTTON="Filter";

	private TableViewer tableView;
	
	//show all checkbox
	private Button showAllButton;
	//filter group
	private Group filterGroup;
	private Label filterlabel;
	private Combo combo;
	private Combo filterCombo;
	private Text filterText;
	private Button lookupButton;
	
	public MemberSearchDetachedView(){
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}
	
	@Override
	protected void basicCreatePartControl(Composite parent) {
		setPartName("Search Member");

		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		Composite dialogArea = UIControlsFactory.createComposite(parent);
		dialogArea.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		dialogArea.setLayout(new GridLayout(1,false));
		

		showAllButton = UIControlsFactory.createButtonCheck(dialogArea);
		showAllButton.setText("Show All Members");
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.TOP).grab(true,false).applyTo(showAllButton);
		showAllButton.addSelectionListener(this);
		
		filterGroup = UIControlsFactory.createGroup(dialogArea, "Filter Expression");
		filterGroup.setLayout(new GridLayout(5,false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true,false).applyTo(filterGroup);
		
		filterlabel = UIControlsFactory.createLabel(filterGroup,LOOKUP_FIELD);
		filterlabel.setLayoutData(new GridData(SWT.BEGINNING,SWT.BEGINNING,true,false));
		combo = UIControlsFactory.createCombo(filterGroup);
		combo.setItems(new String[]{"ID","Name","Address"});
		combo.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,false,false));

		filterCombo = UIControlsFactory.createCombo(filterGroup);
		filterCombo.setItems(new String[]{"IS","Starts With","Contains","Ends With"});
		filterCombo.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,false,false));
		
		filterText = UIControlsFactory.createText(filterGroup);
		filterText.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,true,false));

		lookupButton = UIControlsFactory.createButton(filterGroup,LOOKUP_BUTTON);
		lookupButton.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,false,false));
		lookupButton.addSelectionListener(this);

		Composite panel = UIControlsFactory.createComposite(dialogArea, SWT.NULL);
		panel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		Table table=UIControlsFactory.createTable(panel, SWT.FULL_SELECTION | SWT.BORDER|SWT.SINGLE);
		tableView = new TableViewer(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tableView.addSelectionChangedListener(this);



		// Create two columns and show
		TableColumn id = new TableColumn(table, SWT.LEFT);
		id.setText("ID");

		TableColumn name = new TableColumn(table, SWT.LEFT);
		name.setText("Name");

		TableColumn location = new TableColumn(table, SWT.LEFT);
		location.setText("Address");


		TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(id, new ColumnWeightData(20));
		layout.setColumnData(name, new ColumnWeightData(30));
		layout.setColumnData(location, new ColumnWeightData(50));

		tableView.setContentProvider(new ArrayContentProvider());
		tableView.setLabelProvider(new MemberLabelProvider());
			
		panel.setLayout(layout);

		init();
	}
	
	private void init(){
		tableView.setInput(createMemberShip());
		showAllButton.setSelection(true);
		enableFilterGroup(false);
		combo.select(0);
		filterCombo.select(0);

	}

	public class MemberLabelProvider implements ITableLabelProvider{


		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}


		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}


		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}


		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof Membership){
				switch(columnIndex){
				case 0:
					return ((Membership)element).getMemberId();
				case 1:
					return ((Membership)element).getMember().toString();
				case 2:
					return 
					((Membership)element).getDefaultRoute().getName();
				}
			}
			return null;
		}

	}



	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object selectedObject = selection.getFirstElement();
		if(selectedObject != null && selectedObject instanceof Membership){
			MemberSearchSelectionManager.INSTANCE.notifySelectionChanged(this, (Membership)selectedObject);
		}
	}

	@Override
	public void memberSelectionChanged(Membership selectedMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberModified(Membership modifiedMember) {
		tableView.refresh();
		
	}
	
	private void enableFilterGroup(boolean enabled){
		filterGroup.setEnabled(enabled);
		filterlabel.setEnabled(enabled);
		combo.setEnabled(enabled);
		filterCombo.setEnabled(enabled);
		filterText.setEnabled(enabled);
		lookupButton.setEnabled(enabled);
	}
	
	public List<Membership> createMemberShip(){
		List<Membership> members = new ArrayList();
		Membership member1 = DairyFactory.eINSTANCE.createMembership();
		member1.setMemberId("1001");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");

		try {
			Date appliedDate = sdf.parse("02/12/2009");
			member1.setApplicationDate(appliedDate);
			
			Date effectedDate  = sdf.parse("02/18/2009");
			member1.setEffectiveDate(effectedDate);
			
			member1.setStatus(MembershipStatus.ACTIVE);
			
			Person member = ModelFactory.eINSTANCE.createPerson();
//			member.set("Joseph Limuru");
			member.setPhoneNumber("609-356-3421");
			member1.setMember(member);
			
			Route defaultRoute = DairyFactory.eINSTANCE.createRoute();
			defaultRoute.setName("2 - Ngeche");
			
			DairyLocation stop1 = DairyFactory.eINSTANCE.createDairyLocation();
			stop1.setName("stop 1");
			defaultRoute.getStops().add(stop1);
			
			DairyLocation stop2 = DairyFactory.eINSTANCE.createDairyLocation();
			stop2.setName("stop 2");
			defaultRoute.getStops().add(stop2);
			
			member1.setDefaultRoute(defaultRoute);
			
			PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
			defaultLocation.setAddress("2 - Ngeche");
			defaultLocation.setSection("Section A");
			defaultLocation.setEstate("Building B");
			defaultLocation.setVillage("West Windosr");
			defaultLocation.setSubLocation("Princeton Junction");
			defaultLocation.setLocation("Princeton");
			defaultLocation.setDivision("Mercer");
			defaultLocation.setDistrict("Central");
			defaultLocation.setProvince("Jersey");
			defaultLocation.setPostalCode("08550");
			member.getLocation().setPostalLocation(defaultLocation);
			
			Farm farm = TrackingFactory.eINSTANCE.createFarm();
			farm.setName("Green Farm");
			member1.getFarms().add(farm);
			
			Container container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(com.agritrace.edairy.model.ContainerType.BIN);
			container.setContainerId("1001");
			container.setOwner(farm);
			container.setMeasureType(com.agritrace.edairy.model.UnitOfMeasure.LITRE);
			container.setUnits(50);
			container.setCapacity(50);
			farm.getCans().add(container);
			
			container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(ContainerType.BIN);
			container.setContainerId("1002");
			container.setOwner(farm);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setUnits(50);
			container.setCapacity(40);
			farm.getCans().add(container);
			
			Farm farm1 = TrackingFactory.eINSTANCE.createFarm();
			farm1.setName("Harvest Farm");
			member1.getFarms().add(farm1);

			container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(ContainerType.BIN);
			container.setContainerId("1003");
			container.setOwner(farm1);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setUnits(50);
			container.setCapacity(40);
			farm1.getCans().add(container);
			
		    container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(ContainerType.BIN);
			container.setContainerId("1004");
			container.setOwner(farm1);
			container.setMeasureType(UnitOfMeasure.LITRE);
			container.setUnits(50);
			container.setCapacity(30);
			farm1.getCans().add(container);
			
			members.add(member1);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return members;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == showAllButton){
			if(showAllButton.getSelection()){
				enableFilterGroup(false);
			}else{
				enableFilterGroup(true);
			}
		}
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
		
	}
}
