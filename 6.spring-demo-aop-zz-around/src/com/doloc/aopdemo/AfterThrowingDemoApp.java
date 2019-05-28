package com.doloc.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doloc.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain program: " + e);
		}
		
		// display the accounts
		System.out.println(theAccounts);
		
		// close the context
		context.close();
	}

}
