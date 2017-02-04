package com.ddit.dao;

import java.sql.SQLException;

import com.ddit.dto.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws SQLException;
	public void updateMember(MemberVO memberVO)throws SQLException;
	public int deleteMember(String userid)throws SQLException;
	public int confirmID(String userid) throws SQLException;
	
	
	MemberVO selectMember(String userid) throws SQLException;
	public void deleteuseMember(MemberVO memberVO) throws SQLException;
	public void positionRole(String userid)throws SQLException;
	
	
	public MemberVO idFind(String name , String email) throws SQLException;
	public MemberVO pwdFind(String userid , String email) throws SQLException;
	
	
	public void tempPwd(MemberVO memberVO) throws SQLException; 
	
	public MemberVO confirmID2(String userid) throws SQLException;   //아이디로셀렉
	public void memberEnabled(String userid)throws SQLException; //탈퇴

}
