package com.doloc.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice

	// match any addAccount() method in any class
	// if want to match exact method, need to declare fully qualified class name. ex: com.doloc.aopdemo.dao.AccountDAO.addAccount()
	// @Before("execution(public void com.doloc.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(* *())")
	// @Before("execution(public void addAccount())")
	
	// @Before("execution(* add*(com.doloc.aopdemo.Account))")
	// @Before("execution(* add*(com.doloc.aopdemo.Account, *))")
	@Before("execution(* add*(..))")
	public void beforeAddAccountAdvice() {

		System.out.println("\n======>>> Executing @Before advice on addAccount()");
	}

//	@AfterReturning("execution(public void addAccount())")
//	public void afterAddAccountAdvice() {
//
//		System.out.println("\n======>>> Executing @AfterReturning advice on addAccount()");
//	}
	
}
