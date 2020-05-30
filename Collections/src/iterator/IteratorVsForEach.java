package iterator;
// Java program to demonstrate working of nested iterators 
// may not work as expected and throw exception. 
import java.util.*; 

public class IteratorVsForEach 
{ 
	public static void main(String args[]) 
	{ 
		// Create a link list which stores integer elements 
		List<Integer> l = new LinkedList<Integer>(); 

		// Now add elements to the Link List 
		l.add(2); 
		l.add(3); 
		l.add(4); 

		// Make another Link List which stores integer elements 
		List<Integer> s=new LinkedList<Integer>(); 
		s.add(7); 
		s.add(8); 
		s.add(9); 

		// Iterator to iterate over a Link List 
		for (Iterator<Integer> itr1=l.iterator(); itr1.hasNext(); ) 
		{ 
			for (Iterator<Integer> itr2=s.iterator(); itr2.hasNext(); ) 
			{ 
				if (itr1.next() < itr2.next()) 
				{ 
//					System.out.println(itr1.next()); 
				} 
			} 
		}
		
		
        // Iterator to iterate over a Link List 
        for (int a:l) 
        { 
            for (int b:s) 
            { 
                if (a<b) 
                    System.out.print(a + " "); 
            } 
        } 
	}
} 
