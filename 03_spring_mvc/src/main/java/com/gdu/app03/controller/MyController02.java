package com.gdu.app03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController02 {
  
  // Spring 4 버전 이후 사용 가능한 @RequestMapping
  // 1. @GetMapping 
  // 2. @PostMapping
  
  @GetMapping(value="/notice/list.do")   // 똑같은 주소 하나라도 있으면 오류 , 한글 오류, 주소가 똑같아도 메소드가 다르면 다른 요청
  public String boardList() {
    return "notice/list";
  }
  
  // 반환이 없는 경우에는 요청 주소를 Jsp 경로로 인식한다.
  // /member/list.do 요청을 /member/list.jsp 경로로 인식한다. 그냥 list도 가능
  @GetMapping(value = "/member/list.do")
  public void memberList() {
    
  }
}
