package org.egov.property;


import org.springframework.stereotype.Component;

import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

@Aspect
@Component
public class PtPropertyAspectj {

private static final Logger logger=LoggerFactory.getLogger(PtPropertyAspectj.class);

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controller() {
	}

	/*@Pointcut("execution(* org.egov*(..))")
	protected void allMethod() {
	}
*/
	
	
	
	
	/*before -> Any resource annotated with @Controller annotation */
	
	@Before("controller()")
	public void logBefore(JoinPoint joinPoint) {
		
		logger.debug("Entering in Method :  " + joinPoint.getSignature().getName());
		logger.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		logger.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		logger.debug("Target class : " + joinPoint.getTarget().getClass().getName());


	}
	
	
	
	
	/*After -> All method within resource annotated with @Controller annotation and return a  value*/
	
	@AfterReturning(pointcut = " controller()", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		
		String returnValue = this.getValue(result);
	
		logger.debug("LEAVING: " + joinPoint.getSignature().getName() + " WITH: " + returnValue);
	}
	
	
	
	
	//After -> Any method within resource annotated with @Controller annotation 
	// throws an exception ...Log it
	
	@AfterThrowing(pointcut = " controller()", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		logger.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
		logger.error("Cause : " + exception.getCause());
	}
	
	
	//Around -> Any method within resource annotated with @Controller annotation 
	
	@Around("controller()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			logger.debug("Method " + className + "." + methodName + " ()" + " execution time : "
					+ elapsedTime + " ms");
		
		
			return result;
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
	
	
	
	private String getValue(Object result) {
	
		String returnValue = null;
		
		if (null != result) {
			returnValue = result.toString();
		}
		return returnValue;
	}

}
