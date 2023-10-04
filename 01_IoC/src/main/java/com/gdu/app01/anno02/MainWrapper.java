package com.gdu.app01.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {
  
  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    
    Board board = ctx.getBean("board", Board.class);
    
    System.out.println(board.getTitle() + ", " + board.getEditor().getUserNo() + ", " + board.getEditor().getUserId());
    
    ctx.close();
    
  }
}
