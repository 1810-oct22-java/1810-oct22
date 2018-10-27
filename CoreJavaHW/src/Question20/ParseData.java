package Question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ParseData {
	
	// Q20. Create a notepad file called Data.txt and enter the following:
	//		Mickey:Mouse:35:Arizona 
	//		Hulk:Hogan:50:Virginia 
	//		Roger:Rabbit:22:California 
	//		Wonder:Woman:18:Montana
	//		
	//		Write a program that would read from the file and print it 
	//		out to the screen in the following format:
	//		
	//		Name: Mickey Mouse 
	//		Age: 35 years
	//		State: Arizona State
	
	public static void main(String[] args) {
		
		String data = "Data.txt";
		parseData(data);
		
	}

	public static void parseData(String data) {
		
		//initialize strings to store the data
		String firstName, lastName, age, state;
		String line = null;
		int count = 0;

		//validate data and create a scanner to read the text file
		try (Scanner readData = new Scanner (new File("src/Question20/"+data))) {
			
			//while loop to parse through each line in the text file
			while (readData.hasNextLine()) {
				
				//create a delimiter using ':'
				String[] parseLine = readData.nextLine().split("\\:");
				
				
				//assign the strings to their corresponding values in the text file
				firstName = parseLine[0];
				lastName = parseLine[1];
				age = parseLine[2];
				state = parseLine[3];
				
				//print statements
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Age: " + age);
				System.out.println("State: " + state + " State" + "\n");
				
			}
			
		
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
	}

}
