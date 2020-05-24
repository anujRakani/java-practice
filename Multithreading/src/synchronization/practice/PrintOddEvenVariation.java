package synchronization.practice;

class TaskEvenOddVariation implements Runnable {
	private int max;
	private PrinterVariation print;
	private boolean isEvenNumber;

	// standard constructor
	TaskEvenOddVariation(PrinterVariation print, int max, boolean isEvenNumber) {
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {
		while (print.getNum() <= max) {
			if (isEvenNumber) {
				print.printEven();
			} else {
				print.printOdd();
			}
		}
	}
}

public class PrintOddEvenVariation {
	public static void main(String[] args) {
		PrinterVariation print = new PrinterVariation();
		int max = 3;
		Thread t1 = new Thread(new TaskEvenOddVariation(print, max, false),"Odd");
		Thread t2 = new Thread(new TaskEvenOddVariation(print, max, true),"Even");

		// BELOW ORDER DOES NOT MATTER
		t2.start();

		// BELOW TIME DELAY ALSO DOES NOT MATTER
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		t1.start();
	}
}


class PrinterVariation {
	private volatile int num;

	PrinterVariation() {
		this.num = 1;
	}

	public synchronized int getNum() {
		return num;
	}

	synchronized void printEven() {
		while ((num % 2) != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(Thread.currentThread().getName() + ":" + num);

		num++;
		notify();
	}

	synchronized void printOdd() {
		while ((num % 2) == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(Thread.currentThread().getName() + ":" + num);

		num++;
		notify();
	}
}
