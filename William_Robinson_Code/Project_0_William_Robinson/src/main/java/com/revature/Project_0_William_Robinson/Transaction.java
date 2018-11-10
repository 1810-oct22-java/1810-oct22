package com.revature.Project_0_William_Robinson;
import com.revature.Project_0_pojos.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Project_0_CustomException.CustomException;
import com.revature.Project_0_dao.AccountDao;

public class Transaction extends Log{
	static void WithdrawSavings() {
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Savings");
		acc =dao.findByUsernameandType(Log.$$username, "Savings");
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a withdrawal");
		int $id = scanner.nextInt();
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		a1.setId($id);
		
		int $a2 = dao1.findById(Log.$$username, $id);
		
		a1.setUsername(Log.$$username);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a withdrawal");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Savings");
          
          System.out.println("Please enter an amount to withdraw");
  		int $ammount = scanner.nextInt();	
  		 int balance = dao1.findByBalance(Log.$$username, $id);
  		if (balance <= $ammount) {
  			System.out.println("Sorry. You don't have enough money to withdraw.");
  			System.out.println("Please deposit some money into this account first.");
  			Savings();
  		}
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Savings");
          
          System.out.println("Please enter an amount to withdraw");

         
      	balance -= $ammount;
      		AccountDao adao1 = new AccountDao();
      		a1 = adao1.update(a1, balance);
  		
		List<Account> acc2 = new ArrayList<Account>();
		AccountDao dao2 = new AccountDao();
		a1.setUsername(Log.$$username);
		a1.setType("Savings");
		acc2 =dao2.findByUsernameandType(a1.getUsername(), a1.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
  		Savings();
  		
		
	}
	static void DepositSavings() {
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Savings");
		acc =dao.findByUsernameandType(a.getUsername(), a.getType());
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a deposit");
		int $id = scanner.nextInt();
		int $a2 = dao.findById(Log.$$username, $id);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a deposit");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		
		//int $a3 = dao.findById(Log.$$username, $id);
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Savings");
		
          System.out.println("Please enter an amount to deposit");
  	//	System.out.println("Please enter an account id to make a deposit");
  		int $ammount = scanner.nextInt();
  		int balance = dao1.findByBalance(Log.$$username, $id);
  	    balance += $ammount;
  		// a1.setBalance($deposit);
  		AccountDao adao1 = new AccountDao();
  		a1 = adao1.update(a1, balance);
		
		List<Account> acc2 = new ArrayList<Account>();
		Account a2 = new Account();
		AccountDao dao2 = new AccountDao();
		a2.setUsername(Log.$$username);
		a2.setType("Savings");
		acc2 =dao2.findByUsernameandType(a2.getUsername(), a2.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
	//	System.out.println($ammount);
	//	System.out.println(balance);
		//System.out.println($total);
		
  		Savings();
  		
	}
	static void DepositCredit() {
		
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Credit");
		acc =dao.findByUsernameandType(a.getUsername(), a.getType());
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a deposit");
		int $id = scanner.nextInt();
		int $a2 = dao.findById(Log.$$username, $id);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a deposit");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Credit");
		
          System.out.println("Please enter an amount to deposit");
  		int $ammount = scanner.nextInt();
  		int balance = dao1.findByBalance(Log.$$username, $id);
  	    balance += $ammount;
  		AccountDao adao1 = new AccountDao();
  		a1 = adao1.update(a1, balance);
		
		List<Account> acc2 = new ArrayList<Account>();
		Account a2 = new Account();
		AccountDao dao2 = new AccountDao();
		a2.setUsername(Log.$$username);
		a2.setType("Credit");
		acc2 =dao2.findByUsernameandType(a2.getUsername(), a2.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		//System.out.println($ammount);
		//System.out.println(balance);
		
  		Credit();
		
		
	}
	
	
	static void WithdrawCredit() {
		
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Credit");
		acc =dao.findByUsernameandType(Log.$$username, "Credit");
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a withdrawal");
		int $id = scanner.nextInt();
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		a1.setId($id);
		
		int $a2 = dao1.findById(Log.$$username, $id);
		
		a1.setUsername(Log.$$username);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a withdrawal");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Credit");
          
          System.out.println("Please enter an amount to withdraw");
  		int $ammount = scanner.nextInt();	
  		 int balance = dao1.findByBalance(Log.$$username, $id);
  		if (balance <= $ammount) {
  			System.out.println("Sorry. You don't have enough money to withdraw.");
  			System.out.println("Please deposit some money into this account first.");
  			Credit();
  		}
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Credit");
          
          System.out.println("Please enter an amount to withdraw");

         
      	balance -= $ammount;
      		AccountDao adao1 = new AccountDao();
      		a1 = adao1.update(a1, balance);
  		
		List<Account> acc2 = new ArrayList<Account>();
		AccountDao dao2 = new AccountDao();
		a1.setUsername(Log.$$username);
		a1.setType("Credit");
		acc2 =dao2.findByUsernameandType(a1.getUsername(), a1.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
  		Credit();
  		
		
		
	}
	
	static void WithdrawDebit() {
		
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Debit");
		acc =dao.findByUsernameandType(Log.$$username, "Debit");
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a withdrawal");
		int $id = scanner.nextInt();
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		a1.setId($id);
		
		int $a2 = dao1.findById(Log.$$username, $id);
		
		a1.setUsername(Log.$$username);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a withdrawal");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Debit");
          
          System.out.println("Please enter an amount to withdraw");
  		int $ammount = scanner.nextInt();	
  		 int balance = dao1.findByBalance(Log.$$username, $id);
  		if (balance <= $ammount) {
  			System.out.println("Sorry. You don't have enough money to withdraw.");
  			System.out.println("Please deposit some money into this account first.");
  			Credit();
  		}
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Debit");
          
          System.out.println("Please enter an amount to withdraw");

         
      	balance -= $ammount;
      		AccountDao adao1 = new AccountDao();
      		a1 = adao1.update(a1, balance);
  		
		List<Account> acc2 = new ArrayList<Account>();
		AccountDao dao2 = new AccountDao();
		a1.setUsername(Log.$$username);
		a1.setType("Debit");
		acc2 =dao2.findByUsernameandType(a1.getUsername(), a1.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
  		Debit();
  		
		
		
	}
	
	static void DepositDebit() {
		
		List<Account> acc = new ArrayList<Account>();
		Account a = new Account();
		AccountDao dao = new AccountDao();
		a.setUsername(Log.$$username);
		a.setType("Debit");
		acc =dao.findByUsernameandType(a.getUsername(), a.getType());
		
		for(Account aa: acc) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an account id to make a deposit");
		int $id = scanner.nextInt();
		int $a2 = dao.findById(Log.$$username, $id);
		while (($id!=$a2)) {
			if ($id ==$a2) break;
			System.out.println($a2);
			System.out.println("Please enter an id for one of your accounts");
			System.out.println("Please enter an account id to make a deposit");
			int $id1 = scanner.nextInt();
			$id = $id1;
		}
		int $a3 = dao.findById(Log.$$username, $id);
		$id = $a3;
		List<Account> acc1 = new ArrayList<Account>();
		Account a1 = new Account();
		AccountDao dao1 = new AccountDao();
		
		a1.setId($id);
		a1.setUsername(Log.$$username);
		a1.setType("Debit");
		
          System.out.println("Please enter an amount to deposit");
  		int $ammount = scanner.nextInt();
  		int balance = dao1.findByBalance(Log.$$username, $id);
  	    balance += $ammount;
  		AccountDao adao1 = new AccountDao();
  		a1 = adao1.update(a1, balance);
		
		List<Account> acc2 = new ArrayList<Account>();
		Account a2 = new Account();
		AccountDao dao2 = new AccountDao();
		a2.setUsername(Log.$$username);
		a2.setType("Debit");
		acc2 =dao2.findByUsernameandType(a2.getUsername(), a2.getType());
		
		for(Account aa: acc2) {
			System.out.print(aa + " " + "\n");
			System.out.println();
		}
		//System.out.println($ammount);
		//System.out.println(balance);
		
  		Debit();
		
		
	}
	
	static void Debit() {
		
		System.out.println("Withdraw/Deposit Money");
		System.out.println("***********************");
		System.out.println("From Debit");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Back to Main Menu");
		
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
		
		 if ($choice == 1 || $choice == 2 || $choice == 3) {		
		 switch($choice) {
		 case 1: WithdrawDebit(); break; //Savings sav = new Savings(); break;
		 case 2: DepositDebit(); break; //Credit cred = new Credit(); break;
		 case 3: com.revature.Project_0_William_Robinson.Account a = new com.revature.Project_0_William_Robinson.Account(); break; //Debit deb = new Debit(); break;
		 default: com.revature.Project_0_William_Robinson.Account b = new com.revature.Project_0_William_Robinson.Account();
			 break;
		 }
	}else {
		 try{
		 throw new CustomException();
	   }catch (Exception e) {
		   e.printStackTrace();
		   Log.$$username = null;
		   scanner.close();
		   App a = new App();
	   }
		}
		
		
	}
	
	static void Credit() {
		
		
		System.out.println("Withdraw/Deposit Money");
		System.out.println("***********************");
		System.out.println("From Credit");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Back to Main Menu");
		
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
		
		 if ($choice == 1 || $choice == 2 || $choice == 3) {		
		 switch($choice) {
		 case 1: WithdrawCredit(); break; //Savings sav = new Savings(); break;
		 case 2: DepositCredit(); break; //Credit cred = new Credit(); break;
		 case 3: com.revature.Project_0_William_Robinson.Account a = new com.revature.Project_0_William_Robinson.Account(); break; //Debit deb = new Debit(); break;
		 default: com.revature.Project_0_William_Robinson.Account b = new com.revature.Project_0_William_Robinson.Account();
			 break;
		 }
	}else {
		 try{
		 throw new CustomException();
	   }catch (Exception e) {
		   e.printStackTrace();
		   Log.$$username = null;
		   scanner.close();
		   App a = new App();
	   }
		}

	}
	
	static void Savings(){
		System.out.println("Withdraw/Deposit Money");
		System.out.println("***********************");
		System.out.println("From Savings");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Back to Main Menu");
		
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
		
		 if ($choice == 1 || $choice == 2 || $choice == 3) {		
		 switch($choice) {
		 case 1: WithdrawSavings(); break; //Savings sav = new Savings(); break;
		 case 2: DepositSavings(); break; //Credit cred = new Credit(); break;
		 case 3: com.revature.Project_0_William_Robinson.Account a = new com.revature.Project_0_William_Robinson.Account(); break; //Debit deb = new Debit(); break;
		 default: com.revature.Project_0_William_Robinson.Account b = new com.revature.Project_0_William_Robinson.Account();
			 break;
		 }
	}else {
		 try{
		 throw new CustomException();
	   }catch (Exception e) {
		   e.printStackTrace();
		   Log.$$username = null;
		   scanner.close();
		   App a = new App();
	   }
		}
	  }
	{
		
		
		System.out.println("Withdraw/Deposit Money");
		System.out.println("***********************");
		System.out.println("Menu");
		System.out.println("1. Withdraw/Deposit from Savings");
		System.out.println("2. Withdraw/Deposit from Credit");
		System.out.println("3. Withdraw/Deposit from Debit");
		System.out.println("4. Back to Main Menu");
		
		Scanner scanner = new Scanner(System.in);
		int $choice = scanner.nextInt();
		
		// Need Exception handling capabilities here.
		
		 if ($choice == 1 || $choice == 2 || $choice == 3|| $choice == 4) {		
		 switch($choice) {
		 case 1: Savings(); break; //Savings sav = new Savings(); break;
		 case 2: Credit(); break; //Credit cred = new Credit(); break;
		 case 3: Debit(); break; //Debit deb = new Debit(); break;
		 case 4:com.revature.Project_0_William_Robinson.Account b = new com.revature.Project_0_William_Robinson.Account(); break;
			 default: com.revature.Project_0_William_Robinson.Account c = new com.revature.Project_0_William_Robinson.Account();
			 break;
		 }
	}else {
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
