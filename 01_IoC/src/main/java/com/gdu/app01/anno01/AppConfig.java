package com.gdu.app01.anno01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration    // IocContainer에 bean을 등록하는 클래스이다.
public class AppConfig {
  
  // 메소드를 bean으로 등록하기 위해서 @Bean을 추가한다.
  @Bean
  public Calculator calc() {
    return new Calculator();
  }
  
  @Bean
  public Person man() {
    return new Person("뽀로로", 20, calc());
  }
  
  @Bean
  public Person woman() {
    return new Person("나미", 24, calc());
  }
  
  
}
