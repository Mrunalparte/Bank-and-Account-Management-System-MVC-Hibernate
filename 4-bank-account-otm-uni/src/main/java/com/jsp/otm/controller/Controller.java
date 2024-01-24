package com.jsp.otm.controller;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.otm.model.Account;
import com.jsp.otm.model.Bank;

public class Controller {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static boolean addBankAndAccounts(Bank bank, List<Account> accounts) {
		if(bank != null && accounts != null) {
			entityTransaction.begin();
			entityManager.persist(bank);
			for (Account account : accounts) {
				entityManager.persist(account);
			}
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public Bank findBank(int bank_id) {
		return entityManager.find(Bank.class, bank_id);
	}
	public boolean updateBankName(int bank_id, String updatedName) {
		Bank bank = findBank(bank_id);
		if (bank != null) {
			bank.setBank_name(updatedName);
			entityTransaction.begin();
			entityManager.merge(bank);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
		public boolean removeBank(int bank_id) {
	
			Bank bank = entityManager.find(Bank.class, bank_id);
			if (bank != null) {
				List<Account>accounts= bank.getAccount();
				entityTransaction.begin();
				entityManager.remove(bank);
				for (Account account : accounts) {
					entityManager.remove(account);		
				}
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
		public void deleteParticularAccount() {
			
		}
}