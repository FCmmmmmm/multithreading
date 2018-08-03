package multithreading;


//1.创建thread子类
public class TestThread extends Thread {
	//2.重写run方法
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Ko:"+i++);
		}
	}
}
/*
 * public private protect 不能修饰它
 */

class Test{
	public static void main(String[] args) {
		//3.创建对象
		TestThread thread=new TestThread();
		//4.调用start方法
		thread.start();
		//thread.run(); 区别 run调用的直接是TestThread.run();不会创建新的线程
		for (int i = 0; i < 100; i++) {
			//Thread.currentThread().getName()
			System.out.println("我是主线程中的："+i++);
		}
		//单核  他们会在cpu中快速切换
	}
}
