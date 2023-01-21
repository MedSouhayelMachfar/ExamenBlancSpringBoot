package com.axam.springrestapi.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut("execution(* com.axam.springrestapi.service.*.get*(..))")
    public void loggingPointCut(){ }

    @After("loggingPointCut()")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Bon courage !");
    }
}