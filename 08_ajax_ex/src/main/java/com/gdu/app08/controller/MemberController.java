package com.gdu.app08.controller;

import java.io.File;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app08.service.MemberService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/member")
@RequiredArgsConstructor
@Controller
public class MemberController {

  private final MemberService memberService;
  
  @ResponseBody
  @GetMapping(value = "/health.check", produces = "application/json; charset=UTF-8")
  public Map<String, Object> bmiInfo(@RequestParam("memberNo") int memberNo){
    return memberService.getBmiInfo(memberNo);
  }
  
  @ResponseBody
  @GetMapping(value = "/image.do", produces = "application/octet-stream") 
  public ResponseEntity<byte[]> display(@RequestParam("path") String path, @RequestParam("filename") String filename){
    
    ResponseEntity<byte[]> responseEntity = null;
    try {
      
      File file = new File(path, filename);
      byte[] b = FileCopyUtils.copyToByteArray(file);
      responseEntity = new ResponseEntity<byte[]>(b, HttpStatus.OK);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return responseEntity;
  }
}
