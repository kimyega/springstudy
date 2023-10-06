package com.gdu.app07.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app07.dto.AjaxDto;
import com.gdu.app07.service.AjaxService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/ajax3")
@RequiredArgsConstructor
@Controller
public class AjaxController3 {

  private final AjaxService ajaxService;
 
  @GetMapping(value = "/list.do", produces = "application/json; charset=UTF-8")
  public ResponseEntity<List<AjaxDto>> list(){  // ResponseEntity 는 @ResponseBody를 작성 ㄴ 포함되어있어서
    return new ResponseEntity<List<AjaxDto>>(ajaxService.getDtoList(), HttpStatus.OK); // 실제 응답 데이터, 응답코드 (200)
  } 
  
  @PostMapping(value = "/detail.do")
  public ResponseEntity<AjaxDto> detail(@RequestBody AjaxDto ajaxDto){
    HttpHeaders header = new HttpHeaders();
    header.add("Content-Type", "application/json; charset=UTF-8");
    return new ResponseEntity<AjaxDto>(ajaxService.getDto(ajaxDto.getName()), header, HttpStatus.OK);
  }
  
      
}
