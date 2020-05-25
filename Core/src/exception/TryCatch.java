package exception;

//import java.io.IOException;

public class TryCatch {
	public static void main (String[] args) {
		try {
			System.out.println(fun());
		} catch (Exception e) { // If any checked exception is used, it will give compilation error
			System.out.println("Error");
		}
	}

	public static String fun() {
		try {
			//throw new NullPointerException();
			return "fun";
		} catch (Exception e) {
			System.out.println("in catch of fun");
			System.exit(0);
		}
		
		return "no fun";
	}
}