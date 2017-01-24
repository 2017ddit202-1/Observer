package com.ddit.dao;

import java.sql.SQLException;

import com.ddit.dto.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws SQLException;
	public void updateMember(MemberVO memberVO)throws SQLException;
	public int deleteMember(String userid)throws SQLException;
	public int confirmID(String userid) throws SQLException;
	MemberVO selectMember(String userid) throws SQLException;
	

}
