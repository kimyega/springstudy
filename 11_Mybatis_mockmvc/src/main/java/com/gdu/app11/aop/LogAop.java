package com.gdu.app11.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LogAop {
  
  // 포인트 컷 (어떤 메소드에서 동작하는지 표현식으로 작성)
  @Pointcut("execution(* com.gdu.app11.controller.*Controller.*(..))")
  public void setPointCut() {}
  
  @Before("setPointCut()")
  public void doLog(JoinPoint joinpoint) {    // Advice로 전달되는 메소드 JoinPoint
    log.info(null);
  }
}
