package serializatin.sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

class SelectiveSerializationWithoutTransient implements Serializable {
	int int1, int2, int3, int4;
	String str1, str2;

	SelectiveSerializationWithoutTransient() {
		int1 = 1;
		int2 = 2;
		int3 = 3;
		int4 = 4;	
		str1 = "one";
		str2 = "two";
	}

	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.writeInt(int1);
		out.writeInt(int2);
		out.writeObject(str1);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		int1 = in.readInt();
		int2 = in.readInt();
		str1 = (String)in.readObject();
	}

	@Override
	public String toString() {
		return Integer.toString(int1) + Integer.toString(int2) + Integer.toString(int3) + Integer.toString(int4) + str1 + str2;
	}
}

public class SerializationSampleWithoutTransient {
	public static void main(String[] args) 
	{ 
		try
		{ 
			SelectiveSerializationWithoutTransient selectiveSerializationWrite = new SelectiveSerializationWithoutTransient(); 
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("selectiveSerialization.txt")); 
			out.writeObject(selectiveSerializationWrite); 
			out.close(); 

			// deserailize from file to object 
			ObjectInput in = new ObjectInputStream(new FileInputStream("selectiveSerialization.txt")); 

			SelectiveSerializationWithoutTransient selectiveSerializationRead = (SelectiveSerializationWithoutTransient) in.readObject(); 
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
