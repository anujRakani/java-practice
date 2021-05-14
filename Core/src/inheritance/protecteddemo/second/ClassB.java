package inheritance.protecteddemo.second;

import inheritance.protecteddemo.first.ClassA;

public class ClassB {
	public void tmp() {
		ClassA ca = new ClassA();
		/* Unccomment to see errors
		System.out.println(ca.protMem);
		System.out.println(ca.defMem);
		System.out.println(ca.protMet());
		
		ClassBextA cba = new ClassBextA();
		System.out.println(cba.protMem);
		System.out.println(cba.defMem);
		System.out.println(cba.protMet());
		 */
	}
}
