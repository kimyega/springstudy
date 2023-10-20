package com.gdu.app10.aop;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class BeforeAop {
  
  // 포인트컷 : 언제 동작하는가?
  @Pointcut("execution(* com.gdu.app10.controller.*Controller.*(..))")
  public void setPointCut() { }  // 이름만 제공하는 메소드(이름은 마음대로 본문도 필요 없다.)
  
  // 어드바이스 : 무슨 동작을 하는가?
  @Before("setPointCut()")
  public void beforeAdvice(JoinPoint joinPoint) {
    /*
     * Before 어드바이스
     * 1. 반환타입 : void
     * 2. 메소드명 : 마음대로
     * 3. 매개변수 : JoinPoint
     */
   ServletRequestAttributes servletRequestAttributes  = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
   HttpServletRequest request = servletRequestAttributes.getRequest();
   
   Map<String, String[]> map = request.getParameterMap();
  
   String params = "";
   
   if(map.isEmpty()) {
     params += "[No Parameter]";
   } else {
     for(Map.Entry<String, String[]> entry : map.entrySet()) {
       params += entry.getKey() + ":" + Arrays.toString(entry.getValue()) + " ";
     }
     log.info("{} {}", request.getMethod(), request.getRequestURI());
     log.info("{}", params);
   }
  
  }
  
}
