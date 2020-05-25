package demo;
/* Java program to print frequencies of all elements using 
TreeMap */
import java.util.*; 

class TreeMapDemo 
{ 
	// This function prints frequencies of all elements 
	static void printFreq(int arr[]) 
	{ 
		// Creates an empty TreeMap 
		TreeMap<Integer, Integer> tmap = 
				new TreeMap<Integer, Integer>(); 

		// Traverse through the given array 
		for (int i = 0; i < arr.length; i++) 
		{ 
			// If this is first occurrence of element 
			if (tmap.get(arr[i]) == null) {
				tmap.put(arr[i], 1); 
			}
			// If elements already exists in hash map 
			else {
				Integer c = tmap.get(arr[i]); 
				tmap.put(arr[i], ++c); 
			}
		} 

		// Print result 
		for (Map.Entry<Integer,Integer> m:tmap.entrySet()) {
			System.out.println("Frequency of " + m.getKey() + 
					" is " + m.getValue()); 
		}
	} 

	// Driver method to test above method 
	public static void main (String[] args) 
	{ 
		int arr[] = {10, 34, 5, 10, 3, 5, 10}; 
		printFreq(arr); 
	} 
} 
