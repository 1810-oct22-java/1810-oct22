package com.revature.Project_0_William_Robinson;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.revature.Project_0_CustomException.CustomException;
import com.revature.Project_0_dao.AccountDao;
import com.revature.Project_0_pojos.Account;


public class Credit extends Log{
	
	{
        System.out.println("Your Credit Accounts:");
    	System.out.println("**********************");
// String	$sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_TYPE = 'Credit' AND USER = " + $username;
    	System.out.println("1. Create another account");
    	System.out.println("2. Back to main menu");

    	
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
		
		// Need Exception handling capabilities here.
		
		 if ($choice == 1 || $choice == 2) {
			 int $anum = ThreadLocalRandom.current().nextInt(100000000, 299999999 + 1);
		 switch($choice) {
		
		 case 1: //break;  INSERT INTO ACCOUNT (USERNAME, ACCOUNT_TYPE, BALANCE, ACCOUNT_NUMBER) 
			 Account account = new Account();
			 account.setUsername(Log.$$username);
			 account.setBalance(0); 
			 account.setType("Credit");
			 AccountDao ad = new AccountDao();
			 ad.save(account);
			// Log.$$username = null;
			 System.out.println("Account Created Successfully."); com.revature.Project_0_William_Robinson.Account c = new com.revature.Project_0_William_Robinson.Account(); break;
			 
			 case 2: com.revature.Project_0_William_Robinson.Account d = new com.revature.Project_0_William_Robinson.Account(); break;
				 default:com.revature.Project_0_William_Robinson.Account e = new com.revature.Project_0_William_Robinson.Account();
				 break;
		 }
	}else {
		// throw ourCustomException;
		 try{
		 throw new CustomException();
	   }catch (Exception e) {
		   e.printStackTrace();
		   App a = new App();
	   }
		}
    }
}
