package prevent.singleton.reflection;
// Java code to explain effect of Reflection 
// on Singleton property 

import java.lang.reflect.Constructor; 

// Singleton Enum
enum SingletonEnum
{ 
	INSTANCE; 
} 

public class SingletonReflectionFixed 
{ 

	public static void main(String[] args) 
	{ 
		SingletonEnum instance1 = SingletonEnum.INSTANCE; 
		SingletonEnum instance2 = null; 
		try
		{ 
			Constructor[] constructors = 
					SingletonEnum.class.getDeclaredConstructors(); 
			for (Constructor constructor : constructors) 
			{ 
				// Below code will destroy the singleton pattern 
				constructor.setAccessible(true); 
				// Below code throws exception at runtime
//				instance2 = (SingletonEnum) constructor.newInstance(); 
				break; 
			} 
		} 

		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 

		System.out.println("instance1.hashCode(): "
				+ instance1.hashCode()); 
	} 
} 
