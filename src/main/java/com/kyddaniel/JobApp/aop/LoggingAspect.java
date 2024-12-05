package com.kyddaniel.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)
    /*@Before("execution(* com.kyddaniel.JobApp.service.JobService.*(..))")
    public void logMethodCall() {
        LOGGER.info("Method called");
    }*/

    @Before("execution(* com.kyddaniel.JobApp.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method called : {}()", joinPoint.getSignature().getName());
    }

    @After("execution(* com.kyddaniel.JobApp.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method executed : {}()", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.kyddaniel.JobApp.service.JobService.*(..))")
    public void logMethodExecuteSuccess(JoinPoint joinPoint) {
        LOGGER.info("Method {}() executed successfully", joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.kyddaniel.JobApp.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint joinPoint) {
        LOGGER.info("Method has some issues : {}()", joinPoint.getSignature().getName());
    }
}
