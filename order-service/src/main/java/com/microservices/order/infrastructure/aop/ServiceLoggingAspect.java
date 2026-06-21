package com.microservices.order.infrastructure.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Order(1)
@Component
public class ServiceLoggingAspect {

    //For methods
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceClassMethods() {}

    @Before("serviceClassMethods()")
    public void logBefore(JoinPoint jp) {
        log.info("Calling: {}.{} with args={}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                jp.getArgs());
    }

    @AfterReturning(pointcut = "serviceClassMethods()", returning = "result")
    public void logAfter(JoinPoint jp, Object result) {
        log.info("Completed: {}.{} → result={}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                result);
    }

    @AfterThrowing(pointcut = "serviceClassMethods()", throwing = "ex")
    public void logException(JoinPoint jp, Throwable ex) {
        log.error("Exception in {}.{} → {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                ex.getMessage());
    }
}

