package multithreading;

public class TestThread2 extends Thread {

	/*
	 * Thread方法
	 * run()
	 * start() 开始线程
	 * currentThread() 获取当前线程
	 * yield() 释放当前cpu执行权
	 * setName() 为当前线程设置名字
	 * getName() 获取当前线程名字
	 * join() 在A线程中调用B线程的join方法 表示当遇见此方法 A线程停止执行先执行B线程 在b完成后a再继续
	 * isAlive() 判断当前线程是否存活
	 * sleep(long mills) 让当前线程睡觉
	 * wait() notify() notifyAll() 多线程调度方法 线程通信
	 * setPriority() getPriority() 线程优先级 主线程默认为5 子线程默认为10 线程级别数越大得到资源的概率越大
	 * 守护线程级别数非常低
	 * 
	 * */
	@Override
	public void run() {
		Long start=System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			try {
				this.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Ko:"+i++);
		}
		Long end=System.currentTimeMillis();
		System.out.println("运行时间："+(end-start));
	}
}
/*
 * public private protect 不能修饰它
 */

class Test1{
	public static void main(String[] args) {
		TestThread2 thread=new TestThread2();
		thread.start();
		try {
			//Thread.currentThread().wait(300);
			Thread.currentThread().sleep(300);
			//区别 主线程能sleep但是不能wait
			// wait会释放资源 sleep不会释放
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
	}
}
