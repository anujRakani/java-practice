package lambda;
// Java code to print the elements of Stream 
// without using double colon operator 

import java.util.stream.*; 

class MethodReference { 
	public static void main(String[] args) 
	{ 

		// Get the stream 
		Stream<String> stream 
		= Stream.of("Geeks", "For", 
				"Geeks", "A", 
				"Computer", 
				"Portal"); 

		// Print the stream 
		stream.forEach(s -> System.out.println(s)); 

		System.out.println("=================");

		// Get the stream 
		Stream<String> stream2 
		= Stream.of("Geeks", "For", 
				"Geeks", "A", 
				"Computer", 
				"Portal"); 

		// Print the stream 
		// using double colon operator 
		stream2.forEach(System.out::println);
		
		System.out.println("=================");

		IntStream.range(0, 5).forEach(user -> System.out.println(user));
	} 
} 
