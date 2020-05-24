package serialization.inheritance;
// Java program to demonstrate 
// the case if superclass need 
// not to be serializable 
// while serializing subclass 

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.Serializable;; 

// superclass A 
// A class doesn't implement Serializable 
// interface. 
class C 
{ 
	int i; 
	
	// parameterized constructor 
	public C(int i) 
	{ 
		this.i = i; 
	} 
	
	// default constructor 
	// this constructor must be present 
	// otherwise we will get runtime exception 
	public C() 
	{ 
		i = 50; 
		System.out.println("C's no argument constructor called"); 
	} 
	
} 

// subclass B 
// implementing Serializable interface 
class D extends C implements Serializable 
{ 
	int j; 
	
	// parameterized constructor 
	public D(int i,int j) 
	{ 
		super(i); 
		this.j = j; 
	} 
} 

// Driver class 
public class ChildSerializable 
{ 
	public static void main(String[] args) 
			throws Exception 
	{ 
		D b1 = new D(10,20); 
		
		System.out.println("i = " + b1.i); 
		System.out.println("j = " + b1.j); 
		
		// Serializing B's(subclass) object 
		
		//Saving of object in a file 
		FileOutputStream fos = new FileOutputStream("abc.ser"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
		// Method for serialization of B's class object 
		oos.writeObject(b1); 
			
		// closing streams 
		oos.close(); 
		fos.close(); 
			
		System.out.println("Object has been serialized"); 
		
		// De-Serializing B's(subclass) object 
		
		// Reading the object from a file 
		FileInputStream fis = new FileInputStream("abc.ser"); 
		ObjectInputStream ois = new ObjectInputStream(fis); 
			
		// Method for de-serialization of B's class object 
		D b2 = (D)ois.readObject(); 
			
		// closing streams 
		ois.close(); 
		fis.close(); 
			
		System.out.println("Object has been deserialized"); 
		
		System.out.println("i = " + b2.i); 
		System.out.println("j = " + b2.j); 
	} 
} 
