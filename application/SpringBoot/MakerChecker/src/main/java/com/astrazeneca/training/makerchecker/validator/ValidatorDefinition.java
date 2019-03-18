package com.astrazeneca.training.makerchecker.validator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ValidatorDefinition {

    @Pointcut("execution(* com.astrazeneca.training.makerchecker.controller.*.*(..))")
    public void ControllerLayer() {
    }
}