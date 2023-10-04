package com.gdu.app01.anno01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {
  public static void main(String[] args) {
    
    // AppConfig.java에 등록된 bean 생성하기
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    // bean 가져오기
    Calculator calc = ctx.getBean("calc", Calculator.class);
    
    // 확인 
    calc.add(1, 2);
    calc.sub(3, 4);
    calc.mul(5, 6);
    calc.div(7, 8);
    
    // ctx 닫기
    ctx.close();
    
    AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext("com.gdu.app01.anno01");
    
    Person man = ctx2.getBean("man", Person.class);
    System.out.println(man.getName() + ", " + man.getAge());
    man.getCalculator().add(10, 100);
    
    Person woman = ctx2.getBean("woman", Person.class);
    System.out.println(woman.getName() + ", " + woman.getAge());
    woman.getCalculator().mul(90, 10);
    
    ctx2.close();
    
    
    
    
  }
}
