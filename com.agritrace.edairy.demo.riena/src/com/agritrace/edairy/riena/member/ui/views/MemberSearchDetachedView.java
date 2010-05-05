package com.agritrace.edairy.riena.member.ui.views;

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
import org.eclipse.riena.ui.core.marker.DisabledMarker;
import org.eclipse.riena.ui.swt.EmbeddedTitleBar;
import org.eclipse.riena.ui.swt.IEmbeddedTitleBarListener;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.renderer.EmbeddedTitlebarRenderer;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
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

import com.agritrace.edairy.model.Gender;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.dairy.DairyLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.dairy.MembershipStatus;
import com.agritrace.edairy.model.dairy.Route;
import com.agritrace.edairy.model.tracking.AcquisitionType;
import com.agritrace.edairy.model.tracking.Container;
import com.agritrace.edairy.model.ContainerType;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.Purpose;
import com.agritrace.edairy.model.tracking.RearingMode;
import com.agritrace.edairy.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.model.tracking.TrackingFactory;
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
	private Combo columnFilterCombo;
	private Combo filterCombo;
	private Text filterText;
	private Button lookupButton;
	
	private MemberSearchViewFilter filter; 
	
	public MemberSearchDetachedView(){
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}
	
	@Override
	protected void basicCreatePartControl(Composite parent) {
		setPartName("Search Member");

		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));
		
//	    RienaDefaultLnf lnf = LnfManager.getLnf();
//	    String key = LnfKeyConstants.EMBEDDED_TITLEBAR_CLOSE_ICON;
//	    Image closeImage = lnf.getImage(key);
//	    
//	    ImageButton closeIcon = UIControlsFactory.createImageButton(parent, SWT.NULL);
//	    closeIcon.setImage(closeImage);
//		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false,false).applyTo(closeIcon);
//		closeIcon.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//			 MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(false);
//				
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				widgetSelected(e);
//			}
//		});

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
		columnFilterCombo = UIControlsFactory.createCombo(filterGroup);
		columnFilterCombo.setItems(new String[]{"ID","Name","Address"});
		columnFilterCombo.setLayoutData(new GridData(SWT.FILL,SWT.BEGINNING,false,false));

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
		filter = new MemberSearchViewFilter();
		tableView.addSelectionChangedListener(this);
		tableView.addFilter(filter);

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
		columnFilterCombo.select(0);
		filterCombo.select(0);

	}

	public class MemberLabelProvider implements ITableLabelProvider{


		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}


		public void dispose() {
			// TODO Auto-generated method stub

		}


		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}


		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}


		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}


		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof Membership){
				switch(columnIndex){
				case 0:
					return ((Membership)element).getMemberId();
				case 1:
					return ((Membership)element).getMember().getName();
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
		columnFilterCombo.setEnabled(enabled);
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
			member.setName("Joseph Limuru");
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
			Location memberLocation = ModelFactory.eINSTANCE.createLocation();
			
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
			memberLocation.setPostalLocation(defaultLocation);
			member.setLocation(memberLocation);
			
			Farm farm = TrackingFactory.eINSTANCE.createFarm();
//			farm.(1001);
			farm.setName("Green Farm");
			member1.getFarms().add(farm);
			
			
			Container container= TrackingFactory.eINSTANCE.createContainer();
			container.setType(ContainerType.BIN);
			container.setContainerId("1001");
			container.setOwner(farm);
			container.setMeasureType(UnitOfMeasure.LITRE);
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
			
			RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
			animal1.setAnimnalRegistrationId(10001);
			animal1.setGivenName("animal1");
			animal1.setLocation(farm);
			animal1.setDateOfAcquisition(effectedDate);
			animal1.setPurpose(Purpose.DAIRY);
			animal1.setGender(Gender.FEMALE);
			animal1.setRearingMode(RearingMode.GRAZE);
			animal1.setAcquisitionType(AcquisitionType.PURCHASE);			
			
			ReferenceAnimalType animal1_type = TrackingFactory.eINSTANCE.createReferenceAnimalType();
			animal1_type.setAnimalTypeId(10001);
			animal1_type.setSpecies("Cow");
			animal1_type.setSpecies("jersey");
			animal1.setAnimalType(animal1_type);
			farm.getAnimals().add(animal1);
			
			Farm farm1 = TrackingFactory.eINSTANCE.createFarm();
//			farm1.setFarmId(1002);
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
				
				filter.setSearchColumn(-1);
				filter.setSearchValue("");
				tableView.refresh();
			}else{
				enableFilterGroup(true);
			}
		}else if(e.getSource() == lookupButton){
			int column = columnFilterCombo.getSelectionIndex();
			filter.setSearchColumn(column);
			int filterFormat = filterCombo.getSelectionIndex();
			String filterStr = filterText.getText();
			if(filterStr == null || filterStr.isEmpty()){
				return;
			}
			switch (filterFormat){
			case 0:
				//IS
				filter.setSearchValue(filterStr);
				break;
			case 1:
				//Starts with
				filter.setSearchValue(filterStr+".*");
				break;
			case 2:
				//contains
				filter.setSearchValue(".*"+filterStr+".*");
				break;
			case 3:
				//ends
				filter.setSearchValue(".*"+filterStr);
				break;
			}
			tableView.refresh();
			
		}
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
		
	}
	
	protected void addUIControl(Object uiControl, String bindingId) {
		if(uiControl instanceof EmbeddedTitleBar){
			((EmbeddedTitleBar)uiControl).setCloseable(true);
			((EmbeddedTitleBar)uiControl).addMouseListener(new TitlebarMouseListener(((EmbeddedTitleBar)uiControl)));
			
		}
		super.addUIControl(uiControl,bindingId);
	}
	
	private class TitlebarMouseListener implements MouseListener, MouseTrackListener, MouseMoveListener {
		
		EmbeddedTitleBar embededTitleBar;
		
		TitlebarMouseListener(EmbeddedTitleBar titleBar){
			this.embededTitleBar = titleBar;
		}

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseUp(MouseEvent e) {
			
			if (!shouldIgnore(e)) {
				Point point = new Point(e.x, e.y);
				
				EmbeddedTitlebarRenderer renderer = (EmbeddedTitlebarRenderer) LnfManager.getLnf().getRenderer(
						LnfKeyConstants.SUB_MODULE_VIEW_TITLEBAR_RENDERER);
				if(renderer != null && renderer.isInsideCloseButton(point)){
					 MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(false);

				}
			}
		
		}

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDown(MouseEvent e) {
			
			if (!shouldIgnore(e)) {
				embededTitleBar.setPressed(true);
			}
		
		}

		/**
		 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do
		}

		/**
		 * Ignore mouse events if the component is null, not enabled, or the
		 * event is not associated with the left mouse button.
		 */
		protected boolean shouldIgnore(MouseEvent e) {
			return e.button != 1;
		}

		@Override
		public void mouseMove(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExit(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseHover(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}

}
