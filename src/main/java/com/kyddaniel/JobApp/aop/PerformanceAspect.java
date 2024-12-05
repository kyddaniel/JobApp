package com.kyddaniel.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.kyddaniel.JobApp.service.JobService.getAllJobs(..))")
    public void monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        LOGGER.info("Time taken {}() : {}ms", proceedingJoinPoint.getSignature().getName(), endTime - startTime);
    }
}
