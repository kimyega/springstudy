package com.gdu.app02.xml02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.gdu.app02.anno02.AppConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class MyjdbcService {
  private MyJdbcDao myJdbcDao;
  
  public MyjdbcService() {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    myJdbcDao = ctx.getBean("myJdbcDao", MyJdbcDao.class);
    ctx.close();
  }
  public void add() {
    myJdbcDao.add();
    
  }
  public void remove() {
    myJdbcDao.remove();
  }
  public void modify() {
    myJdbcDao.modify();
  }
  public void select() {
    myJdbcDao.select();
  }
}
