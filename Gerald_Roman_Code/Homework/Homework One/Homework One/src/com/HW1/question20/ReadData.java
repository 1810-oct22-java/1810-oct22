package com.HW1.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadData {
	static String dataFilePath = "src/com/HW1/question20/Data.txt"; // must change file path to work on your computer system

	public static void main(String[] args) {
		getData();
	}

	static String getData() {
		/*
		 * Reads in the file.
		 * If it doesn't exist, then it will return an exception.
		 * 
		 * If it exist, then it will read the each line
		 * separating each word by ":" and print out each word
		 * Since the first word in the file is the first name, we make a string 
		 * where the first value is store so that we can call it in the print statement.
		 */
		ArrayList<String> names = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(dataFilePath));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				names.add(line);
				String[] splitLine= line.split(":");
				String firstName = splitLine[0];
				String lastName = splitLine[1];
				String age = splitLine[2];
				String state = splitLine[3];
				
				System.out.println("Name: " + firstName + " "+ lastName);
				System.out.println("Age: " + age + " years");
				System.out.println("State: " + state + " State"+"\n");
			}

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}