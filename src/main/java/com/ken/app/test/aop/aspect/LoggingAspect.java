package com.ken.app.test.aop.aspect;

import com.ken.app.test.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
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
        System.out.println("\n========>>> Executing @AfterReturning on method: " + method);

        // log the exception
        System.out.println("\n========>>> result is: " + theExc);

    }
}
