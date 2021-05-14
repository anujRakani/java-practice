package inheritance.protecteddemo.first;

public class ClassFB {
	public void tmp() {
		ClassA ca = new ClassA();
		System.out.println(ca.protMem);
		System.out.println(ca.defMem);

		ClassFBextA cba = new ClassFBextA();
		System.out.println(cba.protMem);
		System.out.println(cba.defMem);
		System.out.println(cba.protMet());
	}
}
