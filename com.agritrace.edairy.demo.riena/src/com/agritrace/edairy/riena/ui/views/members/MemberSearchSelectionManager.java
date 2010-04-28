package com.agritrace.edairy.riena.ui.views.members;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.model.dairy.Membership;

public class MemberSearchSelectionManager {
	
	public static MemberSearchSelectionManager INSTANCE = new MemberSearchSelectionManager();
	
	private List<MemberSearchSelectionListener> listeners;
	
	
	
	private MemberSearchSelectionManager (){
		listeners = new ArrayList();
	}
	
	public synchronized void addSearchSelectionListener(MemberSearchSelectionListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}		
	}
	
	
	public synchronized void removeSearchSelectionListener(MemberSearchSelectionListener listener){
		if(!listeners.contains(listener)){
			listeners.remove(listener);
		}
	}
	
	public void notifySelectionChanged(MemberSearchSelectionListener source,Membership member){
		for(MemberSearchSelectionListener listener : listeners){
			if(listener != source){
				listener.memberSelectionChanged(member);
			}
		}
		
	}
	
	public void notifySelectionModified(MemberSearchSelectionListener source,Membership member){
		for(MemberSearchSelectionListener listener : listeners){
			if(listener != source){
				listener.memberModified(member);
			}
		}
		
	}
	

	public void clearListeners(){
		listeners.clear();
	}
	

}
