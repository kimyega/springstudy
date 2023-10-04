package com.gdu.app02.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  public MyJdbcConnection con() {
    return new MyJdbcConnection("oracle.jdbc.OracleDriver", "jdbc:oracle:thin:@127.0.0.1:1521:xe", "GD", "1111");
  }
  
  @Bean
  public MyJdbcDao dao() {
    return new MyJdbcDao();
  }
  
  @Bean
  public MyjdbcService service() {
    return new MyjdbcService(dao());
  }
  
}
