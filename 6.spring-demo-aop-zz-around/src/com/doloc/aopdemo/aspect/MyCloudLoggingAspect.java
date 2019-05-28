package com.doloc.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.doloc.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyCloudLoggingAspect {
	@Before("com.doloc.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
	public void logToCloudAsysnc(JoinPoint theJoinPoint) {
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object obj : args) {
			System.out.println("\\n======>>> Logging to cloud in async fashion: "+obj);
			
			if (obj instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) obj;
				System.out.println("Account name: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());
			}
		}
	}
}
