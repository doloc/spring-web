package com.doloc.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.doloc.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice

	@Pointcut("execution(* com.doloc.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.doloc.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	
	@Pointcut("execution(* com.doloc.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n======>>> Executing @Pointcut advice on addAccount()");
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.doloc.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// modify "result" list: add, remove, update, etc ...
		if (!result.isEmpty()) {
			Account tempAccount = result.get(0);
			tempAccount.setName("David");
		}
		
		// print out the results of the method call
		System.out.println("\n=====>>> Result is: " + result);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.doloc.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
		System.out.println("\n=====>>> The exception is: " + theExc);
	}
	
}
