package com.revature.Project_0_William_Robinson;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.Project_0_William_Robinson.*;
import com.revature.Project_0_pojos.*;
import com.revature.Project_0_pojos.Account;
import com.revature.Project_0_AccountService.*;
import com.revature.Project_0_dao.*;
import com.revature.Project_0_CustomException.*;

/**
 * Hello world!
 *
 */
public class App extends Log
{
	/*
	 Requirements
Create a Banking app where your user communicates with your app through the console
A user must be able to create an account
A user must be able to log in and log out(end interaction with the app and 
have transaction persisted)
A user must be able to create one or more account(s) of specified types
A user must be able to withdraw and deposit money
There should be validation to make sure that usernames are unique, 
users aren't withdrawing more money than they have in the particular account, 
and that the application will not stop running if a user enters an incompatible 
data type with what your application expects
Tech Stack
Java 1.8
Oracle DB
JDBC
You must include at least one of each: Statement, PreparedStatement, and CallableStatement
You must create a custom exception
	  */
	static void throwingCustom()throws CustomException {
		//risky code
		//something goes wrong
		throw new CustomException();
	}
	
	public static void main( String[] args )
    {
		//Log log = new Log();
		App a = new App();
		
    }
	public static void printHeader() {
    	System.out.println("Welcome to Local Bank Connect");
    	System.out.println("*********************************");
	};
	
	
	 {
	     printHeader();
         Scanner lbc_new_user_welcome = new Scanner(System.in);
         System.out.println("Are you a new user"+"("+"Y"+"/"+"N" +")");          
         String y_n = lbc_new_user_welcome.nextLine();
         if(y_n.equals("Y") || y_n.equals("y") || y_n.equals("Yes") || y_n.equals("yes")) {
       	  System.out.println("Create an account");
       	  System.out.println("Enter a username:"); 
       	 String $username = lbc_new_user_welcome.nextLine();  	 
         UserDao ud = new UserDao();
         User us = new User();
         us = ud.findByUsername($username);
         if (us.getUsername() == null) { boolean answer = false; Log.$$username = $username;}
         else {boolean answer = true;}
      //  System.out.println(us.getUsername());
       //  if (us.getUsername().equals(null)) System.out.println("false");
            String $username2;
            
        boolean answer = true;
       //  AccountService accountservice = new AccountService();
         while(answer) { // && us.getUsername().equals($username)) {// || us.getPassword()== null || us.getFirstname() == null || us.getLastname() == null){   
        	
        	 Log.$$username = null;
        	 System.out.println("Username already exists. Please enter a unique username");
         	  System.out.println("Enter a username:"); 
           	$username2 = lbc_new_user_welcome.nextLine(); 
               
             us = ud.findByUsername($username2);
             if (us.getUsername()==null) { us.setUsername($username2);Log.$$username = $username2;
             answer = false; break;}
          //  System.out.println(us.getUsername());
            if (us.getPassword()== null && us.getFirstname() == null && us.getLastname() == null) {
            us.setUsername($username2);
            Log.$$username = $username2;
              $username = $username2;
              answer = false;
              break;
            }
          //  if (us.getPassword()== null && us.getFirstname() == null && us.getLastname() == null)
          //  $username2 = $username;
         }
        // System.out.println(us.getUsername());
      
         us.setUsername($username);
             
          if ($username == "" || us ==null || !us.getUsername().equals($username)){  
       	   
            	System.out.println("Enter your password:");
                String $password5 = lbc_new_user_welcome.nextLine();
                System.out.println("Please Re-enter your password:");
                String $password6 = lbc_new_user_welcome.nextLine();
         	   while(($password5)!=($password6)){
           		   System.out.println("Sorry. Your passwords did not match.");
           		   System.out.println("Please retry.");
                     	System.out.println("Enter your password:");
                       String $password7 = lbc_new_user_welcome.nextLine();
                       $password5 = $password7;
                       System.out.println("Please Re-enter your password:");
                       String $password8 = lbc_new_user_welcome.nextLine();
                       $password6 = $password8;
                       
           	   }
            	while($username.equals(us.getUsername())) {
                   	System.out.println("The username you entered already exists.");
                   	System.out.println("Please enter a unique username:");
                       String $username1 = lbc_new_user_welcome.nextLine();
                       User user2 = new User();
                       UserDao ud2 = new UserDao();
                     user2 =  ud2.findByUsername($username1);
                     us = user2;
                      // String $sql1 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
                   	}
                System.out.println("Please enter your first name:");
                String $firstname = lbc_new_user_welcome.nextLine();
                System.out.println("Please enter your last name:");
                String $lastname = lbc_new_user_welcome.nextLine();

      			 User user = new User();
    			 user.setUsername($username);
    			 user.setPassword($password5); 
    			 user.setFirstname($firstname);
    			 user.setLastname($lastname);
    			 UserDao ud1 = new UserDao();
    			 ud1.save(user);
    			// Log.$$username = null;
    			 Log.$$username = $username;
    			 System.out.println("Account Created Successfully."); 
    			 com.revature.Project_0_William_Robinson.Account acc = new com.revature.Project_0_William_Robinson.Account();
               } else {
               	while(!$username.equals(us.getUsername())) {
               	System.out.println("The username you entered already exists.");
               	System.out.println("Please enter a unique username:");
                   String $username1 = lbc_new_user_welcome.nextLine();
                   User user2 = new User();
                   UserDao ud2 = new UserDao();
                 user2 =  ud2.findByUsername($username1);
                 us = user2;
                  // String $sql1 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
               	}
              	System.out.println("Enter your password:");
                Scanner accept_password = new Scanner(System.in);
                String $password = accept_password.nextLine();
                System.out.println("Please Re-enter your password:");
                String $password2 = accept_password.nextLine();
            	   while(!($password).equals($password2)){
               		   System.out.println("Sorry. Your passwords did not match.");
               		   System.out.println("Please retry.");
                         	System.out.println("Enter your password:");
                           String $password3 = accept_password.nextLine();
                           $password = $password3;
                           System.out.println("Please Re-enter your password:");
                           String $password4 = accept_password.nextLine();
                           $password2 = $password4;
                           
               	   }
                   System.out.println("Please enter your first name:");
                   String $firstname = lbc_new_user_welcome.nextLine();
                   System.out.println("Please enter your last name:");
                   String $lastname = lbc_new_user_welcome.nextLine();
                   Log.$$username = $username;
        			 User user = new User();
        			 user.setUsername($username);
        			 user.setPassword($password); 
        			 user.setFirstname($firstname);
        			 user.setLastname($lastname);
        			 UserDao ud1 = new UserDao();
        			 ud1.save(user);
        			// Log.$$username = null;
        			 System.out.println("Account Created Successfully."); 
        			 com.revature.Project_0_William_Robinson.Account acc = new com.revature.Project_0_William_Robinson.Account();
            	 //  $sql = "INSERT INTO USER(USERNAME, PASSWORD)VALUES("+ $username +","+ $password +")";
               }
         
       	   printHeader();
       	   System.out.println("Enter your username:");
       	   String $username1 = lbc_new_user_welcome.nextLine();
       	  // String $sql2 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username +";";
      //	while(!$username1.equals($sql2)) {
           User user2 = new User();
           UserDao ud2 = new UserDao();
         user2 =  ud2.findByUsername($username1);
         us = user2;
               	while(!$username1.equals(us.getUsername())) {
               	System.out.println("The username you entered already exists.");
               	System.out.println("Please enter a unique username:");
                   String $username3 = lbc_new_user_welcome.nextLine();
                   $username1 = $username3;
                   User user3 = new User();
                   UserDao ud3 = new UserDao();
                 user3 =  ud3.findByUsername($username1);
                 us = user3;
                  // String $sql1 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
               	}
         	   System.out.println("Enter your password:");
       	   String $password3 = lbc_new_user_welcome.nextLine();
           UserDao ud1 = new UserDao();
           User us1 = new User();
           us1 = ud1.findByPassword($password3);
           ud = ud1;
           us = us1;
       	 //  String $sql3 = "SELECT PASSWORD FROM USER WHERE PASSWORD = " + $password3 +";";
    	   while(!us.getPassword().equals($password3)) {
       	   System.out.println("Incorrect username/password. Please reenter Password:");
       	   String $password4 = lbc_new_user_welcome.nextLine();
       	  // String $sql4 = "SELECT PASSWORD FROM USER WHERE PASSWORD = " + $password3 +";";
       	 //  $sql3 = $sql4;
       	   $password3 = $password4;
       	   
       	  }
    	   Log.$$username = $username1;
      	  //  Log log = new Log();
      	 //  log.$$username = $username1;
       	   com.revature.Project_0_William_Robinson.Account acc = new com.revature.Project_0_William_Robinson.Account();
          }else {
          	   printHeader();
           	   System.out.println("Enter your username:");
           	   String $username1 = lbc_new_user_welcome.nextLine();
           	   
               UserDao ud = new UserDao();
               User us = new User();
               us = ud.findByUsername($username1);
           	   
           	   
           	//   String $sql2 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
   /*       	while(!us.getUsername().equals($username1)) { 
              	System.out.println("The username you entered does not exist. Please try again");
              	System.out.println("Enter your username:");

               String $username2 = lbc_new_user_welcome.nextLine();
                   $username1 = $username2;
                 //  String $sql3 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
                  // $sql2 = $sql3;
                   UserDao ud1 = new UserDao();
                   User us1 = new User();
                   us1 = ud1.findByUsername($username1);
                   ud = ud1;
                   us = us1;
              	}*/
             	   System.out.println("Enter your password:");
           	   String $password3 = lbc_new_user_welcome.nextLine();
               UserDao ud1 = new UserDao();
               User us1 = new User();
               us1 = ud1.findByPassword($password3);
               ud = ud1;
               us = us1;
           	 //  String $sql3 = "SELECT PASSWORD FROM USER WHERE PASSWORD = " + $password3 +";";
//        	   while(!us.getPassword().equals($password3)) {
 //          	   System.out.println("Incorrect username/password. Please reenter Password:");
  //         	   String $password4 = lbc_new_user_welcome.nextLine();
           	  // String $sql4 = "SELECT PASSWORD FROM USER WHERE PASSWORD = " + $password3 +";";
           	 //  $sql3 = $sql4;
             //  us1 = ud1.findByPassword($password4);
              // ud = ud1;
  //             us = ud1.findByPassword($password4);
  //         	   $password3 = $password4;
           	   
  //         	  }
           	   // Log log = new Log();
           	   Log.$$username = $username1;
           	com.revature.Project_0_William_Robinson.Account acc = new com.revature.Project_0_William_Robinson.Account();
           	 //  acc.$$username = log.$$username;
          }
	 }
}

	 
/*	 printHeader();
 	   System.out.println("Enter your username:");
 	   String $username1 = lbc_new_user_welcome.nextLine();
 	   
     UserDao ud = new UserDao();
     User us = new User();
     us = ud.findByUsername($username1);
 	   
	   
 	//   String $sql2 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
	while(!us.getUsername().equals($username1)) { 
    	System.out.println("The username you entered does not exist. Please try again");
    	System.out.println("Enter your username:");

     String $username2 = lbc_new_user_welcome.nextLine();
         $username1 = $username2;
       //  String $sql3 = "SELECT USERNAME FROM USER WHERE USERNAME = " + $username1 +";";
        // $sql2 = $sql3;
         UserDao ud1 = new UserDao();
         User us1 = new User();
         us1 = ud1.findByUsername($username1);
         ud = ud1;
         us = us1;
    	}
   	   System.out.println("Enter your password:");
 	   String $password3 = lbc_new_user_welcome.nextLine();
     UserDao ud1 = new UserDao();
     User us1 = new User();
     us1 = ud1.findByPassword($password3);
     ud = ud1;
     us = us1;
	 
	 
	 
         

                  
                 
          
         
         } */
 
	
	

