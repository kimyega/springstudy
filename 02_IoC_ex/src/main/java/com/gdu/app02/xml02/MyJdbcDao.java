
package com.gdu.app02.xml02;

import java.sql.Connection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.gdu.app02.anno02.AppConfig;
import com.gdu.app02.anno02.MyJdbcConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MyJdbcDao {
  private Connection con;
  
  
  private Connection getConnection() {    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyJdbcConnection myJdbcConnection = ctx.getBean("MyJdbcConnection", MyJdbcConnection.class);
    ctx.close();
    return myJdbcConnection.getConnection();
  }
  private void close() {
    try {
      if(con != null) {
        con.close();
        System.out.println("GD 접속해제");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void add() {
   con = getConnection();
   System.out.println("add() 호출");
   close();
  }
  public void remove() {
  con = getConnection();
  System.out.println("remove() 호출");
  close();  
  }
  public void modify() {
    con = getConnection();
    System.out.println("modify() 호출");
    close();
  }
  public void select() {
    con = getConnection();
    System.out.println("select() 호출");
    close();
  }
  
}
