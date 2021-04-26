package serialization.sample;

import java.io.*;

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

	@Serial
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.writeInt(int1);
		out.writeInt(int2);
		out.writeObject(str1);
	}

	@Serial
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		int1 = in.readInt();
		int2 = in.readInt();
		str1 = (String)in.readObject();
	}

	@Override
	public String toString() {
		return int1 + int2 + int3 + int4 + str1 + str2;
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

			// deserialize from file to object
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
