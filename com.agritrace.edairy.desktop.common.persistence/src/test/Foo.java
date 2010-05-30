package test;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;

public class Foo<T extends EObject> {
	
	public Foo() {
		
	}
	
	public static class DLBar extends Foo<DescriptiveLocation> {
		
		public Class getClassType() {
			return DescriptiveLocation.class;
		}
		
	}

}
