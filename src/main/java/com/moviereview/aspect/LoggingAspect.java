package com.moviereview.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "loggingAspect")
@Aspect
public class LoggingAspect {
	public static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
	//pointcuts before all methods in Model Repository and Service packages
	@Pointcut("within(com.moviereview.Model.*)")
	public void allModelPointCut() {
		
	}
	
	@Pointcut("within(com.moviereview.Controller.*)")
	public void allControllerPointCut() {
		
	}
	
	@Pointcut("within(com.moviereview.Repository.*)")
	public void allRepositoryPointCut() {
		
	}
	
	@Pointcut("within(com.moviereview.Service.*)")
	public void allServicePointCut() {
		
	}
	
	@Before("value = allModelPointCut()")
	public void beforeModel(JoinPoint jp) {
		LOG.info("The" + jp.getSignature().getName() + " method is being invoked");
	}
	
	@Before("value = allRepositoryPointCut()")
	public void beforeRepository(JoinPoint jp) {
		LOG.info("The" + jp.getSignature().getName() + " method is being invoked");
	}
	
	@Before("value = allControllerPointCut()")
	public void beforeController(JoinPoint jp) {
		LOG.info("The" + jp.getSignature().getName() + " method is being invoked");
	}
}
