package com.doloc.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.doloc.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account TheAccount, boolean flag) {
		
		System.out.println(getClass() + ": Doing my db work: adding an account");
		
	}
}
