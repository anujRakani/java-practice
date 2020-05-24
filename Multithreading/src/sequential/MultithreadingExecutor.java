package sequential;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Java code for thread creation by implementing 
// the Runnable Interface 
class SequentialExecRunnable implements Runnable 
{ 
	private int num;

	SequentialExecRunnable(int num) {
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
public class MultithreadingExecutor 
{ 
	public static void main(String[] args) 
	{ 
		int n = 10; // Number of threads 
		ExecutorService executorService = Executors.newFixedThreadPool(1); // Thread pool size is 1


		for (int i=0; i<n; i++) 
		{ 
			executorService.execute(new SequentialExecRunnable(i));
		}

		executorService.shutdown();
	} 
} 
