package com.jsp.otm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {

	@Id
	private int bank_id;
	private String bank_name; 
	private String bank_location;
	
	@OneToMany
	List<Account> account;

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_location() {
		return bank_location;
	}

	public void setBank_location(String bank_location) {
		this.bank_location = bank_location;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
}

