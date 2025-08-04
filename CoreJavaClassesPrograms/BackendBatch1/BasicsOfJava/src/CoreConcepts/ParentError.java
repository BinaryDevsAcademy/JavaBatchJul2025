package CoreConcepts;

public class ParentError {
	
	public void div(int a, int b) {
		try {
			System.out.println(a/b);
		}catch(ArithmeticException error) {
			System.out.println(error);
		}
	}
}
