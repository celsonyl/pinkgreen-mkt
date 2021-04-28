package br.com.pinkgreen.mkt.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class AspectLoggerConfiguration {

    @Around("execution(* br.com.pinkgreen.mkt.controller.*.*(..))" +
            "|| execution(* br.com.pinkgreen.mkt.gateway.*.*(..))" +
            "|| execution(* br.com.pinkgreen.mkt.usecase.*.*(..))")
    public Object around(ProceedingJoinPoint jointPoint) throws Throwable {
        Class clazz = jointPoint.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(clazz);
        try {
            logger.info("[START ] {}", clazz);
            Object retVal = jointPoint.proceed();
            logger.info("[END   ] {}", clazz);
            return retVal;
        } catch (Exception e) {
            logger.error("[ERROR] {}", e.getMessage(), e);
            throw e;
        }
    }
}
