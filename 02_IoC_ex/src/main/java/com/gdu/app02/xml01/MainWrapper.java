package com.gdu.app02.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/appCtx.xml");
    
    Person person = ctx.getBean("person", Person.class);
    Contact contact = ctx.getBean("contact", Contact.class);
    Address address = ctx.getBean("address", Address.class);
    
    System.out.println(person);
    System.out.println(contact);
    System.out.println(address);
     
    ctx.close();
     
  }

}
