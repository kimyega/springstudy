package com.gdu.app10.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AroundAop {

  @Pointcut("execution(* com.gdu.app10.controller.*Controller.*(..))")
  public void setPointCut() {}
  
  @Around("setPointCut()")
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    
    /*
     * Around 어드바이스
     * 1. 반환타입 : Object
     * 2. 메소드명 : 마음대로
     * 3. 매개변수 : ProceedingJoinPoint
     */
    log.info("================================================");                        // @Before 이전에 동작
    Object obj = proceedingJoinPoint.proceed();                                          // 포인트컷이 실행되는 시점
    log.info("{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));  // @After 이전에 동작
    
    return obj;
  }
}
