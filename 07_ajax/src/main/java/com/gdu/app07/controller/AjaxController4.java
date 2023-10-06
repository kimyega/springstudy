package com.gdu.app07.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/ajax4")
@Controller
public class AjaxController4 {

  @GetMapping(value = "/display.do", produces = "application/octet-stream") // 파일 자체의 데이터 타입
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
