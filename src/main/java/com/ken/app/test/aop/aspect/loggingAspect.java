package com.ken.app.test.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    @Pointcut("execution(* com.ken.app.test.aop.dao..*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.ken.app.test.aop.dao..*.*())")
    private void forDaoPackageNoParam(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.ken.app.test.aop.dao..*.get*(..))")
    private void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.ken.app.test.aop.dao..*.set*(..))")
    private void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");
    }
}
