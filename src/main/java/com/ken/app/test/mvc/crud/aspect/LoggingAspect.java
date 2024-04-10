package com.ken.app.test.mvc.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    // set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.ken.app.test.mvc.crud.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.ken.app.test.mvc.crud.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("execution(* com.ken.app.test.mvc.crud.dao.*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======>>> in @Before: calling method: "+theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through and display args
        for(Object tmpArg: args){
            myLogger.info("======>>> argument: " + tmpArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======>>> in @afterReturning: calling method: "+theMethod);

        // display data returned
        myLogger.info("======>>> result: "+theResult);
    }
}
