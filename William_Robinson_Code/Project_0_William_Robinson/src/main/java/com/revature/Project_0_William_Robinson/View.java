package com.revature.Project_0_William_Robinson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.internal.*;
import com.revature.Project_0_dao.AccountDao;
import com.revature.Project_0_pojos.Account;

public class View extends Log{
	
	
	//need to connect to database, query all accounts for username, fetch rows from DB,
	// then display all info onto counsel
	{
		List<Account> a = new ArrayList<Account>();
		Account acc = new Account();
		AccountDao dao = new AccountDao();
		a = dao.findByUsername(Log.$$username);
		
	
		for(Account ac: a) {
			System.out.print(ac + " " + "\n");
			//System.out.println();
		}
		
		if(Log.$$username.equals("admin1")) {
		//	findAll2
			List<Account> a1 = new ArrayList<Account>();
			Account acc1 = new Account();
			AccountDao dao1 = new AccountDao();
			a1 = dao1.findAll2();
			for(Account ac: a1) {
				System.out.print(ac + " " + "\n");
			}	
		} else if(Log.$$username.equals("admin")){
			List<Account> a1 = new ArrayList<Account>();
			Account acc1 = new Account();
			AccountDao dao1 = new AccountDao();
			a1 = dao1.findAll1();
			for(Account ac: a1) {
				System.out.print(ac + " " + "\n");
				//System.out.println();
			}
		}
		System.out.println("Menu");
		System.out.println("1. Back to Main Menu");
		System.out.println("2. Exit");
		
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
if ($choice == 1 || $choice == 2) {	
		 switch($choice) {
		 case 1: com.revature.Project_0_William_Robinson.Account b = new com.revature.Project_0_William_Robinson.Account();
		 case 2: Log.$$username = null; App e = new App();

			 default: com.revature.Project_0_William_Robinson.Account d = new com.revature.Project_0_William_Robinson.Account();
			 break;
		 }
	}else {
		// throw ourCustomException;
		App b = new App();
		}
	
	}
}
