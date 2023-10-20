package com.gdu.app14.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.app14.dto.MemberDto;
import com.gdu.app14.service.MemberService;

import lombok.RequiredArgsConstructor;

/*
 * REST(REpresentational State Transfer)
 * 1. 요청 주소를 작성하는 새로운 방식이다.
 * 2. 변수를 파라미터롤 추가하는 Query String 방식이 아니다.
 * 3. 변수를 주소에 포함시키는 Path Variable 방식을 사용한다.
 * 4. "요청 주소(URL) + 요청 방식(Method)"을 합쳐서 요청을 구분한다.
 * 5. 예시
 *       URL           Method
 * 1) 목록 /members      GET
 * 2) 상세 /members/1    GET
 * 3) 삽입 /members      POST
 * 4) 수정 /members      PUT
 * 5) 삭제 /members/1    DELETE  
 */




@RequiredArgsConstructor
@RestController     // 모든 메소드에 @ResponseBody를 추가한다.
public class MemberController {

  private final MemberService memberService;
  
  @RequestMapping(value = "/members", method = RequestMethod.POST, produces = "application/json")
  public Map<String, Object> registerMember(@RequestBody MemberDto memberDto, HttpServletResponse response){
    return memberService.register(memberDto, response);
  }
  
  // 경로에 포함되어 있는 변수 {page}는 @pathVariable을 이용해서 가져올 수 있다.
  @RequestMapping(value = "/members/page/{p}", method = RequestMethod.GET, produces = "application/json")
  public Map<String, Object> getMembers(@PathVariable(value = "p", required = false) Optional<String> opt){    // value 값 = 주소 {}안의 값
    int page = Integer.parseInt(opt.orElse("1"));
    return memberService.getMembers(page);
  }
  
  @RequestMapping(value = "/members/{mNo}", method = RequestMethod.GET, produces = "application/json")
  public Map<String, Object> getMember(@PathVariable(value = "mNo") int memberNo) {
    return memberService.getMember(memberNo); 
  }

  @RequestMapping(value = "/members", method = RequestMethod.PUT, produces = "application/json")
  public Map<String, Object> modifyMember(@RequestBody MemberDto memberDto){
    return memberService.modifyMember(memberDto);
  }
  
  @RequestMapping(value = "/member/{memNo}", method = RequestMethod.DELETE, produces = "application/json")
  public Map<String, Object> removeMember(@PathVariable(value = "memNo") int memberNo){
    return memberService.removeMember(memberNo);
  }
  
  @RequestMapping(value = "/members/{memNoList}", method = RequestMethod.DELETE, produces = "application/json")
  public Map<String, Object> removeMembers(@PathVariable(value = "memNoList") String memberNoList){
    System.out.println(memberNoList);
    return memberService.removeMembers(memberNoList);
  }
}
