package general;

//A Java program to show that references are also passed 
//by value. 
class Test 
{ 
	int x; 
	Test(int i) { x = i; } 
	Test()      { x = 0; } 
} 

public class PassByValue {
	public static void main(String[] args) 
	{ 
		int x = 5; 
		change(x); 
		System.out.println(x); 


		// t is a reference 
		Test t = new Test(5); 

		// Reference is passed and a copy of reference 
		// is created in changeNewRef() 
		changeNewRef(t); 

		// Old value of t.x is printed 
		System.out.println(t.x); 
		
		
		
        // Reference is passed and the same reference 
        // is used in changeOldRef() 
        changeOldRef(t); 
  
        // New value of x is printed 
        System.out.println(t.x); 
        
        
        // Copy of reference is passed in swap
        Integer i = Integer.valueOf(10); 
        Integer j = Integer.valueOf(20); 
        swap(i, j); 
        System.out.println("i = " + i + ", j = " + j);
        
        
        
        Test t1 = new Test(10); 
        Test t2 = new Test(20); 
        swap(t1, t2); 
        System.out.println("t1 = " + i + ", t2 = " + j);
	} 





	public static void change(int x) 
	{ 
		x = 10; 
	} 

	public static void changeNewRef(Test t) 
	{ 
		// We changed reference to refer some other location 
		// now any changes made to reference are not reflected 
		// back in main 
		t = new Test(); 

		t.x = 10; 
	}
	
    // This change() doesn't change the reference, it only 
    // changes member of object referred by reference 
    public static void changeOldRef(Test t) 
    { 
        t.x = 10; 
    }
    
    
    
    // swap() doesn't swap i and j 
    public static void swap(Integer i, Integer j)  
    { 
       Integer temp = Integer.valueOf(i); 
       i = j; 
       j = temp; 
    }

    // swap() doesn't swap
    public static void swap(Test t1, Test t2)  
    { 
       Test temp = new Test(t1.x); 
       t1 = t2; 
       t2 = temp; 
    }
}
