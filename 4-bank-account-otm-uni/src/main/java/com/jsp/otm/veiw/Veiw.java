package com.jsp.otm.veiw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.otm.controller.Controller;
import com.jsp.otm.model.Account;
import com.jsp.otm.model.Bank;

public class Veiw {
	static Scanner sc = new Scanner(System.in);
	static Controller controller = new Controller();
	static Bank bank = new Bank();
	static Account account = new Account();
	static ArrayList<Account> accounts = new ArrayList();
	public static void main(String[] args) {
		
		System.out.println("------WELCOME------");
		System.out.println("\n1.Add Bank And Account \n2.Add Account To  Existing Bank \n3.Find Bank And Acoount \n4.Update Bank And Account \n5.Remove Bank \n6.Remove Account \n7.Exit ");
		System.out.println("Enter Number to Select Option");
		int userChoice = sc.nextInt();
		sc.nextLine();
		 switch (userChoice) {
		case 1:
			System.out.println("Enter Bank Id : ");
			bank.setBank_id(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter Bank Name : ");
			bank.setBank_name(sc.nextLine());
			System.out.println("Enter Bank Location : ");
			bank.setBank_location(sc.nextLine());
			boolean addMoreAccount;
			do {
				

			System.out.println("Enter Account Id : ");
			account.setAccount_id(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter Accoount Holder Name : ");
			account.setAccount_holder_name(sc.nextLine());
			System.out.println("Enter Account Balance : ");
			account.setBalance(sc.nextDouble());
			
			accounts.add(account);
			
			System.out.println("\n1.Add One More Account \n2. Move Ahead To Add All Details ");
			int addAccount = sc.nextInt();
			sc.nextLine();
			
			if (addAccount == 1) {
				addMoreAccount = true;
				
			} else {
				addMoreAccount = false;
			}
			
			} while (addMoreAccount);
			bank.setAccount(accounts);
			
			boolean verifyAdd = Controller.addBankAndAccounts(bank, accounts);
			
			if (verifyAdd) {
				System.out.println("Data Inserted to Database");
			} else {
				System.out.println("Data Insertion failed");
			}
			break;
			
		case 2:
			
			break;
			
		case 3:
			
			System.out.println("Enter Bank Id : ");
			int Bank_id = sc.nextInt();
			sc.nextLine();
			Bank findBank = controller.findBank(Bank_id);
			
			System.out.println("Bank Id : "+findBank.getBank_id());
			System.out.println("Bank Name : "+findBank.getBank_name());
			System.out.println("Bank Location :"+findBank.getBank_location());
			
			List<Account> findAccounts = findBank.getAccount();
			
			for (Account account : findAccounts) {
				System.out.println("Account Id : "+account.getAccount_id());
				System.out.println("Account Holder Name : "+account.getAccount_holder_name());
				System.out.println("Account Balance : "+account.getBalance());
			}
			break;
			
		case 4:
			
			System.out.println("Enter Bank Id To Update : ");
			int bankIdToUpdate = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Bank Name To Update");
			String bankNameToUpdate = sc.nextLine();
			
			if (controller.updateBankName(bankIdToUpdate, bankNameToUpdate)) {
				System.out.println("Bank Data Updated");
			} else {
				System.out.println("Bank Data Updated Failed");
			}
			break;
			
		case 5:
			System.out.println("Enter Bank Id To Remove : ");
			int bankIdToRemove = sc.nextInt();
			
			if (controller.removeBank(bankIdToRemove)) {
				System.out.println("Bank Data Removed ");
			} else {
				System.out.println("Bnak Data Removed Failed ");
			}
			
			break;
			
		case 6:
			
			break;
			
		case 7:
			
			break;
			
			
		default:
			break;
		}
//		Bank sbi = new Bank();
//		sbi.setBank_id(1);
//		sbi.setBank_name("SBI");
//		sbi.setBank_location("Mnmbai");
//		
//		Account account1 = new Account();
//		account1.setAccount_id(11);
//		account1.setAccount_holder_name("Shubham");
//		account1.setBalance(420);
//		
//		Account account2 = new Account();
//		account2.setAccount_id(22);
//		account2.setAccount_holder_name("Vaibhav");
//		account2.setBalance(6000);
//		
//		Account account3 = new Account();
//		account3.setAccount_id(33);
//		account3.setAccount_holder_name("Akash");
//		account3.setBalance(10);
//		
//		ArrayList<Account> accounts = new ArrayList();
//		accounts.add(account1);
//		accounts.add(account2);
//		accounts.add(account3);
//		
//		sbi.setAccount(accounts);
//		
//		if (controller.addBankAndAccounts(sbi, accounts)) {
//			System.out.println("Data Inserted");
//		} else {
//			System.out.println("Unable to insert data");
//		}
//		
////		System.out.println("Enter to Bank id : ");
////		int bank_id = sc.nextInt();
////		
////		Bank bank = controller.findBank(1);
////		
////		if (bank != null) {
////			System.out.println("Bank Details : ");
////			System.out.println(bank.getBank_id());
////			System.out.println(bank.getBank_name());
////			System.out.println(bank.getBank_location());
////			
////			List<Account> account = bank.getAccount();
////			
////			for (Account account11 : account) {
////				System.out.println(account11.getAccount_id());
////				System.out.println(account11.getAccount_holder_name());
////				System.out.println(account11.getBalance());
////
////			}
////		} else {
////			System.out.println("No records found with given id");
////		}
	}
}

