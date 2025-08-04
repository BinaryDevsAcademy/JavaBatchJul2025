package CoreConcepts;

public class ThreadClass1 extends Thread{
	@Override
	public void run() {
		for(int i = 1; i <= 100; i ++) {
			System.out.println(i +" Thread 1 class");
		}
	}
}
