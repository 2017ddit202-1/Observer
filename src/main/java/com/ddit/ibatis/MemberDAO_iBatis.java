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

}
