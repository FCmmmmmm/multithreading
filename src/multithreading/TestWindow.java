package multithreading;

public class TestWindow {
	static int ticket=100;
	public static void main(String[] args) {
		
		new Thread() {
			@Override
			public void run() {
				while(ticket>0) {
				System.out.println("窗口1："+ticket--);
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while(ticket>0) {
					System.out.println("窗口2："+ticket--);
					}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while(ticket>0) {
					System.out.println("窗口3："+ticket--);
					}
			}
		}.start();
	}
}
