package com.doloc.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.doloc.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account TheAccount, boolean flag) {
		
		System.out.println(getClass() + ": Doing my db work: adding an account");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("John", "Gold");
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		return myAccounts;
	}
}
