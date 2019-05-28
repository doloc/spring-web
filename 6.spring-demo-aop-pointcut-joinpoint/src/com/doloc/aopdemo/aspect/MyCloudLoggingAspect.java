package com.doloc.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLoggingAspect {
	@Before("com.doloc.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
	public void logToCloudAsysnc() {
		
		System.out.println("\n======>>> Logging to cloud in async fashion");
	}
}
