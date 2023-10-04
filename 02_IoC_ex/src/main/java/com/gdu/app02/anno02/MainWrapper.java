package com.gdu.app02.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyjdbcService service = ctx.getBean("service", MyjdbcService.class);
    service.add();
    service.remove();
    service.modify();
    service.select();
    ctx.close();
  }

}
