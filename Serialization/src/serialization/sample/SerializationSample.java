package serialization.sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SelectiveSerialization implements Serializable {
	String str1, str2;
	transient String str3, str4;
	
	SelectiveSerialization() {
		str1 = "one";
		str2 = "two";
		str3 = "three";
		str4 = "four";	
	}
	
	@Override
	public String toString() {
		return str1 + str2 + str3 + str4;
	}
}

public class SerializationSample {
	public static void main(String[] args) 
	{ 
		try
		{ 
			SelectiveSerialization selectiveSerializationWrite = new SelectiveSerialization(); 
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("selectiveSerialization.txt")); 
			out.writeObject(selectiveSerializationWrite); 
			out.close(); 

			// deserailize from file to object 
			ObjectInput in = new ObjectInputStream(new FileInputStream("selectiveSerialization.txt")); 

			SelectiveSerialization selectiveSerializationRead = (SelectiveSerialization) in.readObject(); 
			in.close(); 

			System.out.println("selectiveSerializationWrite: "
					+ selectiveSerializationWrite); 
			System.out.println("selectiveSerializationRead: "
					+ selectiveSerializationRead); 
		} 

		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	} 

}
