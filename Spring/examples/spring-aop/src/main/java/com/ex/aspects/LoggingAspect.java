package com.ex.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	// returntype methodname paramlist

	@Before("execution(* com.ex.*.*.*(..))")
	public void testBefore(JoinPoint jp) {
		logger.info("Executing method: " + jp.getSignature());
		logger.info(jp.getTarge());
		logger.info(jp.getKind());

	}

	@After("execution(* com.ex.*.*.*(..))")
	public void testAfter(JoinPoint jp) {
		logger.info("after method: " + jp.getSignature());
	}

	@AfterThrowing(pointcut = "execution(* com.ex.*.*.*(..))", throwing = "e")
	public void testAfterThrowing(JoinPoint jp) {
		logger.info("after Throwing method: " + jp.getSignature());
		logger.error(e.getMessage());
	}

	@AfterReturning(pointcut = "execution(* com.ex.*.*.*(..))")
	public void testAfterReturning(JoinPoint jp) {
		logger.info("after Returning method: " + jp.getSignature());

	}

	@Around("allMethods()")
	public Object TestAround(ProceedingJointPoint pjp){
		Object o = null;

		try{
			pjp.proceed();
			logger.info("Returning ") + o;
		}
		catch (Throwable e){
			e.printStackTrace();
		}
	}@Pointcut("execution(* com.ex.*.*.*(..))")

}
