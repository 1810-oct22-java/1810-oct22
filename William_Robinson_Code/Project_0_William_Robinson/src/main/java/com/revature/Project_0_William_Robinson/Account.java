package com.revature.Project_0_William_Robinson;
import com.revature.Project_0_CustomException.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.Project_0_William_Robinson.ConnectionFactory;
import com.revature.Project_0_William_Robinson.*;
import com.revature.Project_0_pojos.*;
import com.revature.Project_0_AccountService.*;
import com.revature.Project_0_dao.*;

public class Account extends Log{
	
	 
	 
	{
		
	System.out.println("**************Menu*******************");
	System.out.println();
	System.out.println("1. Open a savings account");
	System.out.println("2. Open a credit account");
	System.out.println("3. Open a debit account");
	System.out.println("4. Withdraw/deposit money into your account(s)");
	System.out.println("5. View your current balances.");
	System.out.println("6. Exit");
	
	Scanner scanner = new Scanner(System.in);
	int $choice = scanner.nextInt();
	
	// Need Exception handling capabilities here.
	 if ($choice == 1 || $choice == 2 || $choice == 3|| $choice == 4||$choice == 5||$choice == 6) {
	 switch($choice) {
	 case 1: Savings sav = new Savings(); break;
	 case 2: Credit cred = new Credit(); break;
	 case 3: Debit deb = new Debit(); break;
	 case 4: Transaction tran = new Transaction(); break;
	 case 5: View view = new View(); break;
	 case 6:Log.$$username = null; App a = new App(); break;
		 default: App b = new App();
		 break;
	   } 
	 }else {
		   // throw ourCustomException
		 try{
		 throw new CustomException();
	   }catch (Exception e) {
		   e.printStackTrace();
		   Log.$$username = null;
		   App a = new App();
	   }
	
     }
}
	}
