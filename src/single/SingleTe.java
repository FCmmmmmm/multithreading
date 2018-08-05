package single;

public class SingleTe {
	private SingleTe() {

	}

	private static SingleTe gSingleTe = null;

	public static SingleTe getInstance() {
		if (gSingleTe == null) {
			synchronized (SingleTe.class) {
				if (gSingleTe == null) {

					gSingleTe = new SingleTe();
				}
			}
		}
		return gSingleTe;
	}
}
