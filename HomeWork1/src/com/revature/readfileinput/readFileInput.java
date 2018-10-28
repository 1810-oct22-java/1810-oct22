package com.revature.readfileinput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Write a program that would read from the file and print it out to the screen
 * @author thienle
 *
 */
public class readFileInput {
	
	public static void main(String[] args) {
		
		//Scanner scan = new Scanner("Mickey:Mouse:35");
		
		String line = readInputFile();
		
		Scanner scan = new Scanner(line);
		
		
		
		while(scan.hasNext()) {
			formatName(scan.nextLine());
		}
		
	}
	
	public static void formatName(String line) {
		
		Scanner scan = new Scanner(line);
		scan.useDelimiter(":");
		
		String firstName="";
		String lastName = "";
		String age = "";
		String state = "";
		
		while(scan.hasNext()) {
			firstName = scan.next();
			lastName = scan.next();
			age = scan.next();
			state = scan.next();
		}
		
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Age: " + age + " years");
		System.out.println("State: " + state + " state" + "\n");
	}
	
public static void write(String text) {
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true));) {
			
			bw.write(text + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static String readInputFile() {
		
		String text = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/revature/readfileinput/text.txt"));) {
			
			String line = null;
			while((line = br.readLine())!=null) {
				
				text += line + "\n";
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println("IO exception");
		}
		
		return text;
	}

}
