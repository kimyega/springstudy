package com.gdu.app01.anno03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Student student() {
    Student student = new Student();
    student.setSubjects(Arrays.asList("국어", "영어", "수학"));
    student.setContacts(new HashSet<String>(Arrays.asList("010-7824-0938", "031-7552-3233")));
    student.setFriends(Map.of("동네누나", "나미", "동네친구", "우솝", "동네동생", "프랑키"));
    return student;
  }
  
}
