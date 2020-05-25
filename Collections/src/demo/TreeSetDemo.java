package demo;
/* Java program to print frequencies of all elements using 
TreeMap */
import java.util.*; 

class TreeSetDemo 
{ 
	// This function prints frequencies of all elements 
	static void addArrayToTreeSet(int arr[]) 
	{ 
		// Creates an empty TreeMap 
		TreeSet<Integer> tset = 
				new TreeSet<Integer>(); 

		// Traverse through the given array 
		for (int i = 0; i < arr.length; i++) 
		{
			// If this is first occurrence of element
			if(tset.add(arr[i])) {
				System.out.println("Element " + arr[i] + " successfully added to TreeSet!");
			}
			// If elements already exists in hash map 
			else {
				System.out.println("Element " + arr[i] + " was already present TreeSet!");
			}
		} 

		System.out.println("\nTreeSet Elements:");
		// Print result 
		Iterator<Integer> itr = tset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	} 

	// Driver method to test above method 
	public static void main (String[] args) 
	{ 
		int arr[] = {10, 34, 5, 10, 3, 5, 10}; 
		addArrayToTreeSet(arr); 
	} 
} 
