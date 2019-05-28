package com.doloc.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
	
}
