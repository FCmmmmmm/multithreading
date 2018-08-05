package testclass;

public class Dome2 {

	public static void main(String[] args) {
		Acconunt1 acconunt = new Acconunt1();
		Custumer1 c1 = new Custumer1(acconunt);
		Custumer1 c2 = new Custumer1(acconunt);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.setName("用户1");
		t2.setName("用户2");
		t1.start();
		t2.start();
	}
}

class Custumer1 implements Runnable {

	Acconunt1 acconunt;

	public Custumer1(Acconunt1 acconunt) {
		this.acconunt = acconunt;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			acconunt.reciveMoney((float) 100.0, Thread.currentThread().getName());
		}
	}
}

class Acconunt1 {
	private float monet = 0;

	public float getMonet() {
		return monet;
	}

	private void setMonet(float monet) {
		this.monet = monet;
	}

	public synchronized void reciveMoney(float money, String name) {
		notify();//实现按秩序依次汇钱
		monet += money;
		System.out.println(name + "向我存了" + money + "元");
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我的余额为：" + monet);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}