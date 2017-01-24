package com.ddit.ibatis;

import java.sql.SQLException;

import com.ddit.dao.MemberDAO;
import com.ddit.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAO_iBatis implements MemberDAO{
	
	 private SqlMapClient client;
	 public void setClient(SqlMapClient client){
		 this.client=client;
	 }


	@Override
	public int insertMember(MemberVO memberVO) throws SQLException {
		
		int result=-1;//실패
		if(client.insert("insertMember", memberVO) != null){
			result=-1;
		}else{
			result=1; //성공
		}
		return result;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws SQLException {
		client.update("updateMember", memberVO);
		
	}

	@Override
	public int deleteMember(String userid) throws SQLException {
		int result=client.delete("deleteMember", userid);
		return result;
	}


	@Override
	public int confirmID(String userid) throws SQLException {
		int result= -1;
		MemberVO memberVO = (MemberVO)client.queryForObject("confirmID", userid);
		if(memberVO != null){
			result = 1;
		}else{
			result = -1; 
		}
		
		return result;
	}


	@Override
	public MemberVO selectMember(String userid) throws SQLException {
		MemberVO memberVO = (MemberVO) client.queryForObject("selectMember", userid);
		
		return memberVO;
	}

}
