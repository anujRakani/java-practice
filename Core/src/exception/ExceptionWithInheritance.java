package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionWithInheritance {
	public static void main(String[] args) throws IOException {
		A a = new B();
		a.method();
	}
}

//Case 1: both class not throwing exception 			All OK
//Case 2: Class A throws IOException					All OK
//Case 3: class B throws IOException					Compilation fails
//Case 4: class B throws FileNotFoundException			Compilation fails
//Case 5a: class A method throws FileNotFoundException	Compilation fails
//			and Class B throws IOException.
//Case 5b: class A method throws IOException			All OK
//			and Class B throws FileNotFoundException.
//Case 6: class B throws any Runtime Exception			All OK

class A{
	public void method() throws IOException
	{
		System.out.println("in A");
	}
}
class B extends A{
	@Override
	public void method() throws NullPointerException, FileNotFoundException
	{
		System.out.println("in B");
	}
}