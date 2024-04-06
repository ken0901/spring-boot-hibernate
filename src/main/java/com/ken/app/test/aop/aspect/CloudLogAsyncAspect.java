package com.ken.app.test.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    @Before("com.ken.app.test.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n=====>>> Logging to Cloud in async fashion");
    }

}
