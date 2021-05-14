package inheritance.protecteddemo.second;

import inheritance.protecteddemo.first.ClassA;

public class ClassBextA extends ClassA {
	public void tmp() {
		ClassA ca = new ClassA();
		/* Unccomment to see errors
		System.out.println(ca.protMem);
		System.out.println(ca.defMem);
		System.out.println(ca.protMet());



		System.out.println(protMem);
		System.out.println(defMem);
		System.out.println(protMet());

		
		ClassBextA cba = new ClassBextA();
		System.out.println(cba.protMem);
		System.out.println(cba.defMem);
		System.out.println(cba.protMet());
		*/
	}
}
