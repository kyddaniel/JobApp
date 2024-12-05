package com.kyddaniel.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before("execution(* com.kyddaniel.JobApp.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method called {}", joinPoint.getSignature().getName());
    }
}