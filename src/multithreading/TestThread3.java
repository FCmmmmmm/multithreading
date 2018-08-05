package multithreading;

public class TestThread3 {
	public static void main(String[] args) {
		T1 t1=new T1();
		Thread sThread=new Thread(t1);//把t1赋值到Thread的内部target
		Thread sThread2=new Thread(t1);
		sThread2.start();
		sThread.start();
	}
}

class T1 implements Runnable{
	 int num=100;
	@Override
	public void run() {
		for (;num > 0;num--) {
			if(num%2==0) {
				System.out.println(Thread.currentThread().getName()+":"+num);
			}
		}
	}	
}