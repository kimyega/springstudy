package com.gdu.myhome.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.myhome.service.UserService;

import lombok.RequiredArgsConstructor;
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserService userService;
  
  @GetMapping("/login.form")
  public String loginForm(HttpServletRequest request, Model model) {
    // referer : 이전 주소가 저장되는 요청 header 값
    String referer = request.getHeader("referer");
    model.addAttribute("referer", referer == null ? request.getContextPath() + "/main.do" : referer);
    return "user/login";
  }
  
  @PostMapping("/login.do")
  public void login(HttpServletRequest request, HttpServletResponse response) {
    userService.login(request, response);
  }
  
  @GetMapping("/logout.do")
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    userService.logout(request, response);
  }
  
  @GetMapping("/agree.form")
  public String agreeForm() {
    return "user/agree";
  }
  
  @GetMapping("/join.form")
  public String joinForm(@RequestParam(value = "service", required = false, defaultValue = "off") String service, 
                         @RequestParam(value = "event", required = false, defaultValue = "off") String event, 
                         Model model) {
    String rtn = null;
    if(service.equals("off")) {
      rtn = "redirect:/main.do";
    } else {
      model.addAttribute("event", event);
      rtn = "user/join";
    }
    
    return rtn;
  }
  
  @GetMapping(value = "/checkEmail.do", produces = "application/json")
  public ResponseEntity<Map<String, Object>> checkEmail(@RequestParam String email){
    return userService.checkEmail(email);
  }
  
  @GetMapping(value = "/sendCode.do",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> sendCode(@RequestParam String email){
    return userService.sendCode(email);
  }
  
  @PostMapping("/join.do")
  public void join(HttpServletRequest request, HttpServletResponse response) {
    userService.join(request, response);
  }
  
  @GetMapping("/mypage.form")
  public String mypage() {
    return "user/mypage";
  }
  @PostMapping("/modify.do")
  public ResponseEntity<Map<String, Object>> modify(HttpServletRequest request){
    return userService.modify(request);
  }
  
  @GetMapping("/modifyPw.form")
  public void modifyPw(HttpServletRequest request, HttpServletResponse response) {
    userService.modifyPw(request, response);
  }
  
}
