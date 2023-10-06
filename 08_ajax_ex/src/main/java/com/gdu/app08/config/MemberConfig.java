package com.gdu.app08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app08.dto.MemberDto;

@Configuration
public class MemberConfig {
  
  @Bean
  public MemberDto member1() {
    return new MemberDto(1, "거북이", 150, 60);
  }
  @Bean
  public MemberDto member2() {
    return new MemberDto(2, "토끼", 180, 40);
  }
  @Bean
  public MemberDto member3() {
    return new MemberDto(3, "고래", 200, 100);
  }
}
