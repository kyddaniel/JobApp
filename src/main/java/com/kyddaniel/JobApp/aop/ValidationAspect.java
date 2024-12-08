package com.kyddaniel.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.kyddaniel.JobApp.service.JobService.getJob(..)) && args(postId)")
    public void validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {

        if (postId < 0) {
            LOGGER.info("PostId is negative, updating it...");
            postId = -postId;
        }

        proceedingJoinPoint.proceed(new Object[]{postId});
    }
}
