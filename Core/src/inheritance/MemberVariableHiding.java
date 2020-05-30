package inheritance;

public class MemberVariableHiding {
	public static void main (String[] args) {
		Super superSub = new Sub();
		System.out.println(superSub.variable);
		
		Super superSuper = new Super();
		System.out.println(superSuper.variable);
		
		Sub subSub = new Sub();
		System.out.println(subSub.variable);	
	}
}

class Super {
	public int variable = 5;
}

class Sub extends Super {
	public int variable = 10;
}