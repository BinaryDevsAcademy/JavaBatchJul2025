package initalClasses;

public class FirstJavaProgram {
	public void method1(){
//		System.out.print("Hello World");
//		System.out.println(9 + 1);
//		System.out.println(13 + 5);
		/* variable : temp storage
		 * Data -> Type
		 * Data Types : 
		 * 	primitive (will store only one value) - traditional
		 * 		1. numbers
		 * 			a. integers
		 * 					1. byte 128 
		 * 					2. short - 
		 * 					3. int - 2^32 - (default)
		 * 					4. long
		 * 			b. decimal
		 * 					1. float  
		 * 					2. double (default)
		 * 		2. alphabets
		 * 			a. character - char - 1sp
		 * 		3. yes or no
		 * 			a. boolean - boolean - true or false
		 * 	non primitive - advanced or modern	
		 * 
		 * Declaration Syntax : 
		 * 	dataType variableName;
		 * 
		 * initalization Syntax : 
		 * 	dataType variableName = value;
		 * 
		 * Variables Name Rules : 
		 * 1. You can't use keywords as variable names
		 * 2. You can't start variable name with numbers
		 * 	ex : 9a
		 * 3. We can't use spcl characters except _ and $
		 * 
		 * Best Practices : 
		 * 1. always use meaningful names for variables
		 * 2. follow case notations
		 * 		Ex : 
		 * 			user name - username
		 * 			camel	- userName
		 * 			pascal  - UserName
		 *  */ 
//		int number1 = 23;
//		int number2 = 1;
//		int result;
//		
//		result = number1 + number2;
//		
//		System.out.println(result + 5);
//		operations - task
//			1. assignments
//			2. Math
//			3. comp
//			4. logical 
//			5. increment or decrement
//			6. conditional operations
//			7. bitwise
		
		/*
		 * operators - tools
		 * 1. assignment - =, +=, -=, *=, %=, /=
		 * 2. arth ops - + - / - * %
		 * 3. comp     - ==, !=, <, >, <=, >=
		 * 4. logical  - &&, || , !
		 * 		and
		 * 
		 * 		input1	input2	output
		 * 		false	false	false
		 * 		true	false	false
		 * 		false	true	false
		 * 		true	true	true
		 * 
		 * 		or
		 * 		input1	input2	output
		 * 		false	false	false
		 * 		true	false	true
		 * 		false	true	true
		 * 		true	true	true
		 * 		not
		 * 		input	output
		 * 		true	false
		 * 		false	true
		 * 5. incre or dec - ++ , --
		 * 		value by 1
		 * 		pre  - ++ variable | -- variable 
		 * 		post - variable ++ | variable --
		 * 6. conditional 
		 * 		(condition)? true : false;
		 * 		
		 * 7. bitwise - bit by bit  - &, |, ~, ^, <<, >>,
		 * 		
		 * 		4 bits
		 * 		2^3	2^2	2^1 2^0
		 * 		8	4	2	1
		 * 		0	0	0	1
		 * 		0	0	1	0
		 * 		0	0	1	1
		 * 		0	1	0	0	
		 * 		0	1	0	1
		 * 		0	1	1	0	
		 * 	 
		 * 		5	- 	0	1	0	1
		 * 		4	-	0	1	0	0
		 * 				--------------
		 * 				0	1	0	0
		 * 
		 * <<
		 * 3 << 2
		 * 
		 * 0	0	0	0	0	1	1
		 * ----------------------------
		 * 0	0	0	0	1	1	0 - 1 bit
		 * ----------------------------
		 * 0	0	0	1	1	0	0	- 1 bit
		 * 
		 * 3 >> 2
		 * 
		 * 0	0	0	0	0	1	1 | 
		 * -------------------------- |
		 * 0	0	0	0	0	0	1	1 - 1 bit
		 * ---------------------------
		 * 0	0	0	0	0	0	0	1
		 */
		
		int age = 18;
		int salary = 18000;
//		if a person -> elig - salary = 20000, major
//		System.out.println( !(age >= 18) && salary >= 20000);
//		System.out.println(age ++); // 19	 18 19	
//		System.out.println(age);	// 19	 19	18
//		System.out.println(++ age);	// 19 20 19	20	
//		System.out.println(age);	// 19 20 18	18
//		System.out.println(12 & 6);
//		System.out.println(~-5);
//		System.out.println(3 ^ 5); //6
//		System.out.println(13 << 3); //104 80 103 
//		System.out.println(3 >> 2);
//		System.out.println((age >= 18 && salary >= 20000) ? 
//				"You are eligible for loan" : 
//				"You are not eligible for loan");
	}
}
