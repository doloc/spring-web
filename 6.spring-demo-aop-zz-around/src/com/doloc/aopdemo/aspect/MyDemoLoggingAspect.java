package com.doloc.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@After("execution(* com.doloc.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
	}
	
	@Around("execution(* com.doloc.aopdemo.service.*.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @Around on method: " + method);
		
		// let begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// get end timestamp
		long end  = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====>>> Duration: " + duration/1000.0 + "seconds");
		
		return result;
	}
	
}
