package com.gdu.app03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app03.dto.BlogDto;

@Controller
public class MyController03 {
  
  /*
   * 1. HttpServletRequest request를 이용한 요청 파라미터 처리
   *  1) Java EE 표준 방식이다.
   *  2) 파라미터뿐만 아니라 HttpSession session, String contextPath와 같은 정보도 꺼낼 수 있으므로 여전히 강력한 도구이다.
   */
  // @RequestMapping("/blog/detail.do")    // Get 방식의 method는 생략 가능. value만 작성하는 경우에는 value=도 생략 가능.
  public String blogDetail(HttpServletRequest request, Model model) {
    String blogNo = request.getParameter("blogNo");
    model.addAttribute("blogNo", blogNo);
    return "blog/detail";               // 기본적으로 forward 한다.
  }
  /*
   * 2. @RequestParam을 이용한 요청 파라미터 처리
   *  1) 파라미터의 개수가 적은 경우에 유용하다.
   *  2) 주요 메소드
   *    (1) value         : 요청 파라미터의 이름
   *    (2) required      : 요청 파라미터의 필수 여부(디폴트 true - 요청 파라미터가 없으면 오류 발생)
   *    (3) defaultValue  : 요청 파라미터가 없는 경우에 사용할 값
   *  3) @RequestParam을 생략할 수 있다.
   */
  //@RequestMapping("/blog/detail.do")
  public String blogDetail2(int blogNo, Model model) {
    model.addAttribute("blogNo", blogNo);
    return "blog/detail";
  }
  
  /*
   * 3. 커멘드 객체를 이용한 요청 파라미터 처리
   *  1) 요청 파라미터를 필드로 가지고 있는 객체를 커맨드 객체라고 한다.
   *  2) 요청 파라미터를 필드에 저장할 때 Setter가 사용된다.
   *  3) 요청 파라미터가 많은 경우에 유용하다.
   *  4) 커맨드 객체는 자동으로 Model에 저장된다. 저장될 때 객체명(dto)이 아닌 클래스명(BlogDto)으로 저장된다. (클래스명을 LowerCamelCase로 바꿔서 저장한다.)
   */
  //@RequestMapping("/blog/detail.do")
  public String blogDetail3(BlogDto blogDto) {
    return "blog/detail";
  }
  
  @RequestMapping("/blog/detail.do")
  public String blogDetail4(@ModelAttribute("dto") BlogDto blogDto) {
    return "blog/detail";
  }
}
