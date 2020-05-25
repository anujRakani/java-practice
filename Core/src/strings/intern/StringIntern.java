package strings.intern;
// Java program to illustrate 
// intern() method 
class StringIntern { 
	public static void main(String[] args) 
	{ 
		// S1 refers to Object in the Heap Area 
		String s1 = new String("GFG"); // Line-1 

		// S2 refers to Object in SCP Area 
		String s2 = s1.intern(); // Line-2 

		// Comparing memory locations 
		// s1 is in Heap 
		// s2 is in SCP 
		System.out.println("s1 == s2 | " + (s1 == s2)); 

		// Comparing only values 
		System.out.println("s1.equals(s2) | " + s1.equals(s2)); 

		// S3 refers to Object in the SCP Area 
		String s3 = "GFG"; // Line-3 

		System.out.println("s2 == s3 | " + (s2 == s3)); 


		System.out.println("=======================");


		// S21 refers to Object in the Heap Area  
		String s21 = new String("GFG"); // Line-1  

		// S22 now refers to Object in SCP Area  
		String s22 = s21.concat("GFG"); // Line-2  

		/* 
		 * !!! ANY ONE OF BELOW LINES AFFECT THE OUTPUT AS THEY ADD "GFGGFG" TO STRING POOL !!!
		 * If the line is uncommented, s22.intern() will have "GFGGFG" in pool and 
		 * ONLY s23 is assigned with reference from pool. So, s22 == s23 become false.
		 * 
		 * If the line is commented, s22.intern() will not have "GFGGFG" in pool and 
		 * BOTH s22 and s23 are assigned with reference from pool. So, s22 == s23 become true.
		 * 
		 * 
		 * https://dzone.com/articles/string-interning-what-why-and
		 * 
		 * When the intern() method is invoked on a String object it looks the string contained by this 
		 * String object in the pool, if the string is found there then the string from the pool is returned.
		 * Otherwise, this String object is added to the pool and a reference to this String object is returned.
		 */
//		System.out.println("s22 == GFGGFG | " + (s22 == "GFGGFG"));  
//		System.out.println("GFGGFG == s22 | " + ("GFGGFG" == s22)); 

		// S23 refers to Object in SCP Area 
		String s23 = s22.intern(); // Line-3  

		System.out.println("GFGGFG == s22 | " + ("GFGGFG" == s22));
		System.out.println("GFGGFG == s23 | " + ("GFGGFG" == s23));
		System.out.println("s22 == s23 | " + (s22 == s23));  

		// S4 refers to Object in the SCP Area  
		String s24 = "GFGGFG"; // Line-4  

		System.out.println("s23 == s24 | " + (s23 == s24)); 
	} 
} 
