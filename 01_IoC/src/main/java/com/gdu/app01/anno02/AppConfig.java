package com.gdu.app01.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
   // Bean에 name 속성으로 bean 이름을 등록할 수 있다.
   @Bean(name = "user")
   public User sansation() {    // name을 정해주면 메소드 이름 의미 X
     return new User(1, "admin");
   }
   
   @Bean(name = "board")
   public Board generation() {
     return new Board("공지사항", sansation());
   }
}
