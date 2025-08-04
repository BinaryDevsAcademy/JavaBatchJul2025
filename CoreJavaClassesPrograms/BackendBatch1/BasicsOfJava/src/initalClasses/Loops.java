package initalClasses;

public class Loops {

	public void method3() {
		/*
		 * Loops are used to iterate or repeat a set of statement 
		 * n number of times
		 * 3 loops
		 * 	1. for loop
		 * 		Syntax : 
		 * 			for(init; condition; update){
		 * 				//block of statements
		 * 			}
		 * 		flow of for loop : 
		 * 			1. init - starting point for the loop
		 * 			2. condition
		 * 			3. execution of block of statements
		 * 			4. update - inc or dec
		 * 	2. while loop
		 * 		init;
		 * 		while(condition){
		 * 			block of statements
		 * 			update;
		 * 		}
		 * 	3. do-while loop
		 * 
		 * asked you run 400 meters circle 4 times
		 * asc - 1 2 3 4
		 * des - 4 3 2 1
		 * 
		 * for loop and while loop -> satisfy the condition - true
		 * 
		 * do while - to run a set of statements for once regardless of
		 * the condition
		 */
		
		
//		for(int i = 1; i <= 10; i ++) {
//			System.out.println(i+" Lines");
//		}
		
//		int i = 1;
//		while(i <= 10) {
//			System.out.println(i);
//			i ++;
//		}
		
//		int i = 1;
//		
//		do {
//			System.out.println("Do while statement");
//			System.out.println(i);
//			
//			i ++;
//		}while(i <= 10);
		
//		write a program to find the even numbers from 1 to 100
//		implement it in for loop, while loop and do while loop
		
//		finding a factorial of a number
//		5 -  5 * 4 * 3 * 2 * 1
		
//		int number = 10;
//		int result = 0;
//		
//		for(int i = 1; i <= number; i ++) {
//			result = result + i;
//		}
//		
//		System.out.println(result);
		
//check if a number is a prime number or not
//check the prime numbers upto 10, 100, 1000		
		
		//variable - at a time can store one value
		//arrays - can hold multiple values of same datatype inside
//		a single variable
		/* homogenous data type values will be stored inside array 
		 * 
		 * - non primitive datatype
		 * - variable - access -> read, update, remove - index value
		 * - index -> 0 - n - 1 (array size - 5 -> 0 1 2 3 4)
		 * - fixed size
		 * Syntax : 
		 * 	int a[] = new int[size of array];
		 * 
		 * 	int a = value;
		 * 
		 * 	int a[] = new int[1,2,3,4,5];
		 * 
		 * */
		
//		int a[] = {1,2,3,4,5};
//		int a[] = new int[10];
		
//		a[0] = 8;
//		a[1] = 9;
//		a[2] = 10;
//		a[3] = 11;
//		
//		a[0] = 88;
		
//		for(int i = 0; i < a.length; i ++)
//			System.out.println(i);
		
//		for(int value : a) {
//			System.out.println(value);
//		}
		
//		find the odd and even numbers inside an array
//		find the prime numbers in an array
//		find the square values of an array
//		find the sum of an array
//		find the min value inside an array
//		find the max value inside an array
		
//		for(int i = 1; i <=  10; i ++) {
//			if(i == 4)
//				break;
//			System.out.println(i);
//		}
		
//		int a[][] = new int[3][2];
//		
//		a[1][0] = 1;
//		
//		System.out.println(a[0].length);
		
		//add the values inside a 2d array and check if the added number
//		is even number or not
		
		/* peform the addition of matrix 
		 * 	
		 * 2 d arrays - 2 -> add -> 
		*	a , b
		*	a(0,0) + b (0,0) 	a(0,1) + b(0,1)
		*	
		*	final out
		*		result1		result2
		*		result3		result4
		 * */
		
//		int array1[] = {1,2,3,-4,5};
//		int min = array1[0];
//		int max = array1[0];
//		
//		for(int number : array1) {
//			if(min > number) {
//				min = number;
//			}
//			
//			if(max < number) {
//				max = number;
//			}
//		}
		
//		System.out.println(min+" "+max);
//		int array2[] = new int[array1.length];
		
//		for(int i = 0; i < array1.length; i ++) {
//			array2[i] = array1[i] * array1[i];
//		}
//		
//		for(int num : array2) {
//			System.out.println(num);
//		}
//		
//		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
//		int[][] b = {{1,3}, {4,6}, {7,9}};
//		
//		int result[][] = new int[a.length][b[0].length];
//		
//		
//		for(int row = 0; row < a.length; row ++) {
//			for(int col = 0; col < b[row].length; col ++) {
//				int sum = 0;
//				for(int reset = 0; reset < b.length; reset ++) {
//					sum += a[row][reset] * b[reset][col];
//				}
//				
//				result[row][col] = sum;
//			}
//		}
//		
//		for(int[] number : result) {
//			for(int n : number) {
//				System.out.print(n+ " ");
//			}
//			System.out.println();
//		}
		
//		for(int array[] : a) {
//			for(int number : array) {
//				System.out.print(number+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("------------------------");
//		for(int array[] : b) {
//			for(int number : array) {
//				System.out.print(number+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("--------------------------");
//		
//		int result[][] = new int[a.length][a[0].length];
//		
//		for(int i = 0; i < a.length; i ++) {
//			for(int j = 0; j < a[i].length; j ++) {
//				result [i][j] = a[i][j] + b[i][j];
//			}
//		}
//		
//		for(int array[] : result) {
//			for(int number : array) {
//				System.out.print(number+" ");
//			}
//			System.out.println();
//		}
		
//		write a program to sort the array - 7,5,6,7,2,3,4
// 		write a program to reverse an array
	}

}
