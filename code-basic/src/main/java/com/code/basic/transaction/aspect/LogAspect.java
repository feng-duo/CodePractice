package com.code.basic.transaction.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author FengDuo
 * @date 2023/4/23 10:16
 */

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.code.basic.transaction.controller.*.*(..))")
    private void pointCutMethod() {
    }

    @Before("pointCutMethod()")
    public void doBefore(JoinPoint joinPoint){
        log.info("before:{}", joinPoint.getSignature().toString());
    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around start");
        Object result = joinPoint.proceed();
        log.info("around end");
        return result;
    }

    @AfterReturning(value = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result){
        log.info("AfterReturning:{}", result);
    }

    @AfterThrowing(value = "pointCutMethod()", throwing = "exception")
    public void doAfterThrowing(Exception exception){
        log.warn("AfterThrowing:{}", exception.getMessage());
    }

    /**
     * this method execute after {@link LogAspect#doAfterReturning(String)}
     */
    @After("pointCutMethod()")
    public void doAfter(){
        log.info("aspect after");
    }

}
