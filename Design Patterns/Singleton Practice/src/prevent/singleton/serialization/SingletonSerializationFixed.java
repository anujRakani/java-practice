package prevent.singleton.serialization;
// Java code to remove the effect of 
// Serialization on singleton classes 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInput; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutput; 
import java.io.ObjectOutputStream; 
import java.io.Serializable; 

class SingletonFixed implements Serializable 
{ 
	// public instance initialized when loading the class 
	public static SingletonFixed instance = new SingletonFixed(); 
	
	private SingletonFixed() 
	{ 
		// private constructor 
	} 
	
	// implement readResolve method 
	protected Object readResolve() 
	{ 
		return instance; 
	} 
} 

public class SingletonSerializationFixed 
{ 

	public static void main(String[] args) 
	{ 
		try
		{ 
			SingletonFixed instance1 = SingletonFixed.instance; 
			ObjectOutput out 
				= new ObjectOutputStream(new FileOutputStream("file.txt")); 
			out.writeObject(instance1); 
			out.close(); 
		
			// deserailize from file to object 
			ObjectInput in 
				= new ObjectInputStream(new FileInputStream("file.txt")); 
			SingletonFixed instance2 = (SingletonFixed) in.readObject(); 
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
