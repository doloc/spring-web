package com.doloc.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.doloc.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account TheAccount, boolean flag) {
		
		System.out.println(getClass() + ": Doing my db work: adding an account");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
}
