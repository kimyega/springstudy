package com.gdu.app05.dao;

import java.util.Arrays;
import java.util.List;

import com.gdu.app05.dto.BoardDto;

public class BoardDao {
  
  public List<BoardDto> getBoardList(){
    return Arrays.asList(
        new BoardDto("셜록홈즈", "아서코난도일"),
        new BoardDto("어린왕자", "생텍쥐페리"),
        new BoardDto("홍길동전", "익명")        
        );
        
  }
}
