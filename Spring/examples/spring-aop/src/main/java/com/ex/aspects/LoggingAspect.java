package com.ex.aspects;

import org.apache.log4j.Logger;
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

@Aspect
@Component
public class LoggingAspect {
	
	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	           //returntype methodname paramlist
	
	@Before("execution(* com.ex.*.*.*(..))")
	public void testBefore(JoinPoint jp) {
		logger.info("Executing method: " + jp.getSignature());
		logger.info(jp.getTarget());
		logger.info(jp.getKind());
		logger.info(jp.getThis());
	}
	
	@After("execution(* com.ex.*.*.*(..))")
	public void testAfter(JoinPoint jp) {
		logger.info("after method: " + jp.getSignature());
	}
	
	@AfterThrowing(pointcut = "execution(* com.ex.*.*.*(..))" , throwing = "e")
	public void testAfterThrowing(JoinPoint jp, RuntimeException e) {
		logger.info("EXCEPTION THROWN IN: " + jp.getSignature());
		logger.info(jp.getSourceLocation());
		logger.error(e.getMessage());
	}
	
	@AfterReturning("allMethods()")
	public void testAfterReturning(JoinPoint jp) {
		logger.info("Returned successfully from method " + jp.getSignature());
	}
	
	@Around("allMethods()")
	public Object testAround(ProceedingJoinPoint pjp) {
		//tasks to execute
		//join point to execute 
		Object o = null;
		try {
			o = pjp.proceed();
			logger.info("RETURNING " + o);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//more tasks to execute
		
		return null;
	}
	
	@Pointcut("execution(* com.ex.*.*.*(..))")
	public void allMethods() {}

}
