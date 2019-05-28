package com.doloc.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doloc.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// close the context
		context.close();
	}

}
