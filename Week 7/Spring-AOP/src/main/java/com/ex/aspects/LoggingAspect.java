package com.ex.aspects;

import java.text.SimpleDateFormat;

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
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
	
	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	
	//pointcut
					//ret  //methods  //params
	@Before("execution(* com.ex.*.*.*(..) )")
	public void testBefore(JoinPoint jp) {
		logger.info("executing a method: " + jp.getSignature());
		logger.info(jp.getSourceLocation());
		logger.info(jp.getKind());
		logger.info(jp.getThis());
	}
	
	@After("execution(* com.ex.*.*.*(..) )")
	public void testAfter(JoinPoint jp) {
		logger.info("after method: " + jp.getSignature());
	}
	
	@AfterThrowing(pointcut = "execution(* com.ex.*.*.*(..) )", throwing = "e")
	public void testAfterThrowing(JoinPoint jp, RuntimeException e) {
		logger.info("Exception thrown in: " + jp.getSignature());
		logger.info(jp.getSourceLocation());
		logger.error(e.getMessage());
	}
	
	@AfterReturning("allMethods()")
	public void testAfterReturning(JoinPoint jp) {
		logger.info("Returned successfully from method: " + jp.getSignature());
	}
	
	@Around("allMethods()")
	public Object testAround(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch timer = new StopWatch();
		timer.start();
		Object o = pjp.proceed();
		//more tasks to execute
		timer.stop();
		logger.info(pjp.getSignature() + "time: " + timer.getTotalTimeSeconds());
		return o;
		
	}
	
	@Pointcut("execution(* com.ex.*.*.*(..) )")
	public void allMethods() {}

}
