package com.ken.app.test.aop.aspect;

import com.ken.app.test.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

//@Aspect
//@Component
//@Order(2)
public class LoggingAspect {

    @Before("com.ken.app.test.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for(Object tmpArg: args){
            System.out.println(tmpArg);

            if(tmpArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tmpArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

    // add new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.ken.app.test.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n========>>> result is: " + result);

        // let's post-process the data... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for(Account tmpAccount: result){
            // get uppercase version of name
            String theUpperName = tmpAccount.getName().toUpperCase();

            // update the name on the account
            tmpAccount.setName(theUpperName);
        }

    }

    @AfterThrowing(
            pointcut = "execution(* com.ken.app.test.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n========>>> result is: " + theExc);

    }

    @After("execution(* com.ken.app.test.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.ken.app.test.aop.service.*.getFortune(..))")
    public Object aroundGetfortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        }catch (Exception ex){
            // log the exception
            System.out.println(ex.getMessage());

            // rethrow exception
            throw ex;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n======> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }
}
