package asia.sejong.web.eazimemo.springconfig.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class LoggingAspect {
	@Before("execution(* asia.sejong.web.eazimemo.service.*.*(..)) || execution(* asia.sejong.web.eazimemo.mapper.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

	   Object[] signatureArgs = joinPoint.getArgs();
	   for (Object signatureArg: signatureArgs) {
	      System.out.println("Arg: " + signatureArg);
	   }
	}
}
