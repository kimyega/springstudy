package com.gdu.app10.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TransactionAfterAop {
  
  
  // 포인트컷 : 언제 동작하는가?
  @Pointcut("execution(* com.gdu.app10.service.*Impl.*(..))")
  public void setPointCut() {}
  
  // 어드바이스 : 무슨 동작을 하는가?
  
  @After("setPointCut()")
  public void afterAdvice(JoinPoint joinpoint) {
    /*
     * After 어드바이스
     * 1. 반환타입 : void
     * 2. 메소드명 ; 마음대로
     * 3. 매개변수 : JoinPoint
     */
    log.info("==================================================================");
    
    
    
    
  }
  
}
