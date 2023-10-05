package com.gdu.app07.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app07.dto.AjaxDto;
import com.gdu.app07.service.AjaxService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/ajax1")
@RequiredArgsConstructor
@Controller
public class AjaxController1 {

  private final AjaxService ajaxService;
  
  
  @ResponseBody   // 메소드가 반환한 값이 응답 데이터이다.
  @RequestMapping(value = "/list.do", method = RequestMethod.GET, produces = "application/json; charset-UTF-8")
  public List<AjaxDto> list(){
    return ajaxService.getDtoList();   // jackson이 리스트를 자동으로 json으로 변환시켜줌
  }
  
  @ResponseBody
  @RequestMapping(value = "/detail.do", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
  public AjaxDto detail(@RequestParam(value = "name") String name) {
    return ajaxService.getDto(name);
  }
}
