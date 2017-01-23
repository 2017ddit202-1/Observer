package com.ddit.service;

import java.sql.SQLException;

import com.ddit.dto.MemberVO;

public interface MemberService {
	
	public int insertMember(MemberVO memberVO) throws SQLException;
	public void updateMember(MemberVO memberVO)throws SQLException;
	public int deleteMember(String userid)throws SQLException;
}
