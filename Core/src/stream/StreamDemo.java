package stream;
//a simple program to demonstrate the use of stream in java 
import java.util.*; 
import java.util.stream.*; 

class StreamDemo 
{ 
	public static void main(String args[]) 
	{ 
		// create a list of integers
		List<Integer> number = Arrays.asList(2,3,4,5); 

		// demonstration of map method 
		List<Integer> square = number.stream().map(x -> x*x). 
				collect(Collectors.toList()); 
		System.out.println("Squares: " + square); 

		// create a list of strings
		List<String> strings = Arrays.asList("  Reflection  ","  Collection  ","   Stream   "); 

		// demonstration of map method using method reference 
		List<String> trimmedStrings = strings.stream().map(String::trim). 
				collect(Collectors.toList()); 
		System.out.println("Trimmed Strings: " + trimmedStrings); 

		// create a list of String 
		List<String> names = 
				Arrays.asList("Reflection","Collection","Stream"); 

		// demonstration of filter method 
		List<String> result = names.stream().filter(s->s.startsWith("S")). 
				collect(Collectors.toList()); 
		System.out.println("Filtered: " + result); 

		// demonstration of sorted method 
		List<String> show = 
				names.stream().sorted().collect(Collectors.toList()); 
		System.out.println("Sorted: " + show); 

		// create a list of integers 
		List<Integer> numbers = Arrays.asList(2,3,4,5,2); 

		// collect method returns a set 
		Set<Integer> squareSet = 
				numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
		System.out.println("Squares stored as Set: " + squareSet); 

		// demonstration of forEach method
		System.out.println("forEach() demo:");
		number.stream().map(x->x*x).forEach(System.out::print); 

		// demonstration of reduce method
		System.out.println("\nreduce() demo:");

		int even = 
				number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 

		System.out.println(even); 



		System.out.println("Distinct demo:"); 

		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("one");

		Stream<String> stream = stringList.stream();

		List<String> distinctStrings = stream
				.distinct()
				.collect(Collectors.toList());

		System.out.println(distinctStrings);




		List<String> stringList1 = new ArrayList<String>();

		stringList1.add("One flew over the cuckoo's nest");
		stringList1.add("To kill a muckingbird");
		stringList1.add("Gone with the wind");

		Stream<String> stream1 = stringList1.stream();

		stream1.flatMap((value) -> {
			String[] split = value.split(" ");
			return (Stream<String>) Arrays.asList(split).stream();
		})
		.forEach((value) -> System.out.println(value))
		;
	} 
} 
