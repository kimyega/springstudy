package com.gdu.app12.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app12.service.ContactServiece;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class ContactScheduler {

  private final ContactServiece contactServiece;
  
  @Scheduled(cron = "0 0/1 * * * ?")
  public void doSomething() {
    
    // 한 시간 마다 가장 예전에 등록된 연락처를 삭제하는 스케쥴러
    
    contactServiece.deleteOldestContact();
    log.info("doSomething()");
  }

 
}
