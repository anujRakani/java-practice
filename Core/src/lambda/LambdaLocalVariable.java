package lambda;

import java.util.function.Consumer;


class LambdaTest {

	public int x = 1;

	class FirstLevel {

		public int x = 2;

		void methodInFirstLevel(int x) {
			int z = 3;
			
			Consumer<Integer> myConsumer = (y) -> {   // Lambda Expression
				System.out.println("x = " + x); 
				System.out.println("y = " + y);
				System.out.println("z = " + z);
//				z = 4;	// Gives error: Local variable z defined in an enclosing scope must be final or effectively final
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaTest.this.x = " + LambdaTest.this.x);
			};
			
//			z = 4;	// Gives error: Local variable z defined in an enclosing scope must be final or effectively final

			myConsumer.accept(x);
		}
	}
}




public class LambdaLocalVariable {
	public static void main(String args[]) {
		final LambdaTest outerClass = new LambdaTest();
		final LambdaTest.FirstLevel firstLevelClass = outerClass.new FirstLevel();
		firstLevelClass.methodInFirstLevel(10);
	}
}