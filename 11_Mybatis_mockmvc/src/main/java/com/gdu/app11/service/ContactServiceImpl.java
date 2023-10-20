package com.gdu.app11.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app11.dao.ContactDao;
import com.gdu.app11.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactServiece {

  private final ContactDao contactDao;
  
  
  @Override
  public int addContact(ContactDto contactDto) {
    int addResult = contactDao.insert(contactDto);
    return addResult;

  }

  @Override
  public int modifyContact(ContactDto contactDto) {
    int modifyResult = contactDao.update(contactDto);
    return modifyResult;

  }

  @Override
  public int deleteContact(int contactNo) {
    int deleteResult = contactDao.delete(contactNo);
    return deleteResult;
    
  }
  @Transactional(readOnly = true)
  @Override
  public List<ContactDto> getContactList() {
    return contactDao.selectList();

  }
  
  @Transactional(readOnly = true)
  @Override
  public ContactDto getContactByNo(int contactNo) {
    return contactDao.selectContactByNo(contactNo);
  }
  
  
  @Override
  public void txTest() {
    
    // @Transactional 활용한 트랜잭션 처리 테스트 메소드
    
    // 성공1개 + 실패1개 DB처리를 동시에 수행했을 때 모두 실패로 되는지 확인하기
    
    // 성공
    contactDao.insert(new ContactDto(0, "이름", "전화번호", "이메일", "주소", null));
    // 실패
    contactDao.insert(new ContactDto());    // NotNull인 Name 칼럼에 null 전달해 Exception 발생시킴
  }

}
