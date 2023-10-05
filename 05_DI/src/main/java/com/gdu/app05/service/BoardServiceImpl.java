package com.gdu.app05.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app05.dao.BoardDao;
import com.gdu.app05.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // final field 전용 @Autowired 생성자 주입 위해서 추가
@Service    // 서비스 전용 컴포넌트, 스프링 컨테이너에 impl 객체 생성
public class BoardServiceImpl implements BoardService {

  
  private final BoardDao boardDao;
  


  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }
  
}
