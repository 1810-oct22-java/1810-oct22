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
	           //returntype methodname paramlist
	
	@Before("execution(* com.ex.*.*.*(..))")
	public void testBefore(JoinPoint jp) {
		logger.info("Executing method: " + jp.getSignature());
	}

}
