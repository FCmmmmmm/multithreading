package multithreading;

public class TestThread4 {
	public static void main(String[] args) {
		T2 t1 = new T2();
		Thread sThread = new Thread(t1);// 把t1赋值到Thread的内部target
		Thread sThread2 = new Thread(t1);
		sThread2.start();
		sThread.start();
	}
}

class A {

}

class T2 implements Runnable {
	int num = 100;
	A a = new A();

	@Override
	public void run() {
		for (; num > 0; num--) {
			synchronized (a) {//以实现接口的形式创建线程比直接继承thread 如方法同步
				if (num % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + ":" + num);
				}
			}
		}
	}
}