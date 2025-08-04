package CoreConcepts;

public class ThreadClass2 extends Thread{
	@Override
	public void run() {
		for(int i = 1; i <= 100; i ++) {
			System.err.println(i +" Thread 2 class");
		}
	}
}
