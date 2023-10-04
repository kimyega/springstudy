package com.gdu.app02.anno01;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public Calculator calc() {
    return new Calculator();
  }
  
  @Bean
  public Member member() {
    
    Member m = new Member();
    m.setName("이광수");
    m.setHeight(190);
    m.setWeight(80);
    m.setCalc(calc());
    
    double height = m.getHeight();
    double weight = m.getWeight();
    Calculator calc = m.getCalc();
    m.setBmi(calc.div(weight, calc.div(calc.mul(height, height), 10000)));
    
    double bmi = m.getBmi();
    if(bmi < 20) {
      m.setStatus("저체중");
    } else if(bmi < 30) {
      m.setStatus("정상");
    } else if (bmi < 40) {
      m.setStatus("과체중");
    } else {
      m.setStatus("비만");
    }
    return m;
  }
  
  @Bean
  public Fitness fitness() {
    Fitness fitness = new Fitness();
    fitness.setName("가산피트니스");
    fitness.setMembers(Arrays.asList(member()));
    return fitness;
  }
  
  
  
}
