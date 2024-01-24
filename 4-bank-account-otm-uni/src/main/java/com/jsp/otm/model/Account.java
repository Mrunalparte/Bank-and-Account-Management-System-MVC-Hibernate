package com.jsp.otm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int account_id;
	private String account_holder_name;
	private double balance;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void add(Account account) {
		// TODO Auto-generated method stub
		
	}

	
	
}
