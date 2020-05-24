package sequential;
// Java code for thread creation by implementing 
// the Runnable Interface 
class SequentialRunnable implements Runnable 
{ 
	private int num;

	SequentialRunnable(int num) {
		this.num = num;
	}

	public void run() 
	{ 
		try
		{
			// Displaying the thread that is running 
			System.out.println ("Thread: id=" + 
					Thread.currentThread().getId() + 
					" & num=" + num + " is running"); 
		} 
		catch (Exception e) 
		{ 
			// Throwing an exception 
			System.out.println ("Exception is caught"); 
		} 
	} 
} 

// Main Class 
public class MultithreadingJoin 
{ 
	public static void main(String[] args) 
	{ 
		int n = 10; // Number of threads 
		for (int i=0; i<n; i++) 
		{ 
			Thread object = new Thread(new SequentialRunnable(i)); 
			object.start(); 
			try {
				object.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	} 
} 
