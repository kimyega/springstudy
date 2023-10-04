
package com.gdu.app02.anno02;

import java.sql.Connection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class MyJdbcDao {
  private Connection con;
  private MyJdbcConnection myJdbcConnection;
  
  public Connection getConnection() {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    myJdbcConnection = ctx.getBean("con", MyJdbcConnection.class);
    con = myJdbcConnection.getConnection();
    ctx.close();
    return con;
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
