package com.gdu.app05.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.app05.dto.BoardDto;

@Repository       // Dao 전용 컴포넌트, 자신의 객체(빈)를 스프링 컨테이너에 생성
public class BoardDao {
  
  public List<BoardDto> getBoardList(){
    return Arrays.asList(
        new BoardDto("셜록홈즈", "아서코난도일"),
        new BoardDto("어린왕자", "생텍쥐페리"),
        new BoardDto("홍길동전", "익명")        
        );
        
  }
}
