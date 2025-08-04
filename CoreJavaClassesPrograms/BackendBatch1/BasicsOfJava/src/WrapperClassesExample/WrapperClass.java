package WrapperClassesExample;

public class WrapperClass {
	//is java 100% OOP or not?
	//No, - coz of variables
	//convert variables into objects
	/* 
	 * int - Integer
	 * byte - Byte
	 * short - Short
	 * long - Long
	 * char - Character
	 * boolean -Boolean
	 * float - Float
	 * double - Double
	 * 
	 * 
	 * Boxing and UnBoxing
	 * 
	 * autoBoxing and autoUnBoxing
	 *  */
	
	public static void example() {
		String number = "78";
		
		System.out.println(Double.parseDouble(number) + 1);
	}
}
