package testup;

public class ProductionAndConsumption {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer producer = new Producer(clerk);
		Constumer constumer = new Constumer(clerk);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(constumer);
		t1.start();
		t2.start();
	}
}

class Clerk {
	int number=0;

	public synchronized void produce() {
		if (number >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			number++;
			System.out.println("生产了第\"" + number);
			notifyAll();
		}

	}

	public synchronized void consume() {
		if (number <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			//number--;
			System.out.println("消费了第\"" + number--);
			notifyAll();
		}
	}
}

class Producer implements Runnable {
	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产ING");
		while (true) {
			clerk.produce();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Constumer implements Runnable {
	Clerk clerk;

	public Constumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("消费ING");
		while (true) {
			clerk.consume();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
