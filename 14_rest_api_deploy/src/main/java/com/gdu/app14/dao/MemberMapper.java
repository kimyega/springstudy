package com.gdu.app14.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app14.dto.MemberDto;

@Mapper
public interface MemberMapper {
  public int deleteMember(int memberNo);
  public int updateMember(MemberDto memberDto);
  public MemberDto getMember(int memberNo);
  public int insertMember(MemberDto memberDto);
  public List<MemberDto> getMemberList(Map<String, Object> map);
  public int getMemberCount();
  public int deleteMembers(List<String> list);
}
