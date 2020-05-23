package prevent.singleton.serialization;
// Java code to explain effect of 
// Serilization on singleton classes 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInput; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutput; 
import java.io.ObjectOutputStream; 
import java.io.Serializable; 

class Singleton implements Serializable 
{ 
	// public instance initialized when loading the class 
	public static Singleton instance = new Singleton(); 
	
	private Singleton() 
	{ 
		// private constructor 
	} 
} 


public class SingletonSerializationIssue 
{ 

	public static void main(String[] args) 
	{ 
		try
		{ 
			Singleton instance1 = Singleton.instance; 
			ObjectOutput out 
				= new ObjectOutputStream(new FileOutputStream("file.txt")); 
			out.writeObject(instance1); 
			out.close(); 
	
			// deserailize from file to object 
			ObjectInput in 
				= new ObjectInputStream(new FileInputStream("file.txt")); 
			
			Singleton instance2 = (Singleton) in.readObject(); 
			in.close(); 
	
			System.out.println("instance1 hashCode:- "
												+ instance1.hashCode()); 
			System.out.println("instance2 hashCode:- "
												+ instance2.hashCode()); 
		} 
		
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
