package com.gdu.app01.xml03;

import java.util.Map.Entry;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {

    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml03/app-context.xml");
    
    Student s = ctx.getBean("student", Student.class);
    
    for(String subject : s.getSubjects()) {
      System.out.println(subject);
    }
    for(String contact : s.getContacts()) {
      System.out.println(contact);
    }
    for(Entry<String, String> entry : s.getFriends().entrySet()) {
      System.out.println(entry.getKey() + ", " + entry.getValue());
    }
  }

}