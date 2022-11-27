package com.tech.sharedapp.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {

    @Pointcut("execution(* org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations.*(..)) || execution(* org.springframework.jdbc.core.namedparam.JdbcOperations.*(..))")
    private void around() {}

    @Around("around()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        Object o = jp.proceed();

        Object[] args = jp.getArgs();
        String sql = (String) args[0];

        // TODO: put audit in table
        return o;
    }

}
