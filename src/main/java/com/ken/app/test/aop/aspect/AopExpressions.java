package com.ken.app.test.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.ken.app.test.aop.dao..*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.ken.app.test.aop.dao..*.*())")
    public void forDaoPackageNoParam(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.ken.app.test.aop.dao..*.get*(..))")
    public void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.ken.app.test.aop.dao..*.set*(..))")
    public void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
