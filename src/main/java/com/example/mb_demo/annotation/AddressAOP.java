package com.example.mb_demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AddressAOP {
    @Around("@annotation(address)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Value address) throws Throwable {
        System.out.println("aop");
        String value = address.value();
        Object proceed = proceedingJoinPoint.proceed(new Object[]{value});
        return proceed;
    }
}
