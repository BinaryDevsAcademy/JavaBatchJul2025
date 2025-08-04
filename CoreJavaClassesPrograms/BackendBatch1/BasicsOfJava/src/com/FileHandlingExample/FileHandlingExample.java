package com.FileHandlingExample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingExample {
	private static final String filePath = "C:\\Users\\Dell\\Downloads\\";
	
	public static void handlingExample() throws IOException {
		System.out.println("File Handling Example");
		File file = new File(filePath+"sample.txt");

		if(!file.exists()) {
			file.createNewFile();
			System.out.println("File created at the given path");
		}
		
//		FileWriter fw = new FileWriter(file, true);
//		
//		fw.append("\n This is a second line added when created the file");
//		
//		fw.close();
		
//		FileReader fr = new FileReader(file);
//		Scanner read = new Scanner(fr);
//		
//		while(read.hasNext()) {
//			System.out.println(read.nextLine());
//		}
		
		/*
		 * create a Dairy project
		 * 
		 * 1. creating a file and writing data in it 
		 * 2. reding a file 
		 * 3. Delete a file
		 * 
		 * Enter the name of the file if file is exists then continue writing in that
		 * file if not create a new file
		 */
		
		
	}
}
