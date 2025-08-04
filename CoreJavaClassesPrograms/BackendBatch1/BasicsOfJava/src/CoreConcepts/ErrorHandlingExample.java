package CoreConcepts;

public class ErrorHandlingExample extends ParentError{
	public static void ExceptionExample() {
		try {
			int[] array1 = {1,2,3,4};
			System.out.println(array1[3]);
			int a = 1;
			int b = 0;
			
			if(b == 0) {
				throw new CustomException("Dividing by zero");
			}
			System.out.println(a/b);
		}catch(Exception error) {
			System.out.println(error);
		}finally {
			System.out.println("Line 6 to 10");
		}
	}
	
	public void check(int a, int b) throws ArithmeticException{
		div(a,b);
	}
	
}
