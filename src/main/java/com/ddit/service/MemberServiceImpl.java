package com.ddit.service;

import java.sql.SQLException;

import com.ddit.dto.MemberVO;
import com.ddit.ibatis.MemberDAO_iBatis;

public class MemberServiceImpl implements MemberService{

	private MemberDAO_iBatis memberIbatis;
	public void setMemberIbatis(MemberDAO_iBatis memberIbatis){
		this.memberIbatis = memberIbatis;
	}
	
	@Override
	public int insertMember(MemberVO memberVO) throws SQLException {
		int result = memberIbatis.insertMember(memberVO);
		return result;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws SQLException {
		memberIbatis.updateMember(memberVO);
	}

	@Override
	public int deleteMember(String userid) throws SQLException {
		int result = memberIbatis.deleteMember(userid);
		return result;
	}

	@Override
	public int confirmID(String userid) throws SQLException {
		int result =memberIbatis.confirmID(userid);
		return result;
	}

	@Override
	public MemberVO selectMember(String userid) throws SQLException {
		return memberIbatis.selectMember(userid);
	}

	@Override
	public void deleteuseMember(MemberVO memberVO) throws SQLException {
		memberIbatis.deleteuseMember(memberVO);
		
	}

	@Override
	public void positionRole(String userid) throws SQLException {
		memberIbatis.positionRole(userid);
		
	}
	
	

}
