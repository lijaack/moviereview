package com.moviereview.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "loggingAspect")
@Aspect
public class LoggingAspect {
	
	Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Pointcut("within(com.moviereview.controller.*)")
	public void allControllerPointCut() {
		
	}
	
	@Pointcut("within(com.moviereview.Service.*)")
	public void allServicePointCut() {
		
	}
	
	
	@Before(value = "allControllerPointCut()")
	public void beforeController(JoinPoint jp) {
		logger.info("The controller method " +  jp.getSignature().getName() + " is being invoked");
	}
	@AfterThrowing(value = "allControllerPointCut()", throwing = "thrownException")
	public void throwController(JoinPoint jp, Exception thrownException) {
		logger.info("The controller method " + jp.getSignature().getName() + " threw " + thrownException);
	}
	@AfterReturning(value = "allControllerPointCut()", returning = "returnedValue")
	public void returnController(JoinPoint jp, Object returnedValue) {
		logger.info("The controller method " + jp.getSignature().getName() + " returned " + returnedValue);
	}
	
	@Before(value = "allServicePointCut()")
	public void beforeService(JoinPoint jp) {
		logger.info("The service method " +  jp.getSignature().getName() + " is being invoked");
	}
	@AfterThrowing(value = "allServicePointCut()", throwing = "thrownException")
	public void throwService(JoinPoint jp, Exception thrownException) {
		logger.info("The service method " + jp.getSignature().getName() + " threw " + thrownException);
	}
	@AfterReturning(value = "allServicePointCut()", returning = "returnedValue")
	public void returnService(JoinPoint jp, Object returnedValue) {
		logger.info("The service method " + jp.getSignature().getName() + " returned " + returnedValue);
	}
}
