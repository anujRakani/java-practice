package inheritance.protecteddemo.first;

//import sample.first.ClassA;

public class ClassFBextA extends ClassA {
	public void tmp() {
		System.out.println(protMem);
		System.out.println(defMem);
		System.out.println(protMet());
		
		ClassA ca = new ClassA();
		System.out.println(ca.protMem);
		System.out.println(ca.defMem);
		System.out.println(ca.protMet());
		
		
		ClassFBextA cba = new ClassFBextA();
		System.out.println(cba.protMem);
		System.out.println(cba.defMem);
		System.out.println(cba.protMet());
	}
}
