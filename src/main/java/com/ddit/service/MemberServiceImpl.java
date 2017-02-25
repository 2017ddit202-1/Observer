package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
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
	public int confirmID(String userid) throws SQLException{
		int result = memberIbatis.confirmID(userid);
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

	@Override
	public MemberVO idFind(String name, String email) throws SQLException {
		return memberIbatis.idFind(name, email);
	}

	@Override
	public MemberVO pwdFind(String userid, String email) throws SQLException {
		return memberIbatis.pwdFind(userid, email);
	}

	@Override
	public void tempPwd(MemberVO memberVO) throws SQLException {
		 memberIbatis.tempPwd(memberVO);
		
	}

	@Override
	public MemberVO confirmID2(String userid) throws SQLException {
		return memberIbatis.confirmID2(userid);
		
	}

	@Override
	public void memberEnabled(String userid) throws SQLException {
		memberIbatis.memberEnabled(userid);
		
	}

	@Override
	public PositionListVO authoritySelect(String userid) throws SQLException {
		return memberIbatis.authoritySelect(userid);
		
	}

	@Override
	public ArrayList<MemberVO> selectMemberAll() throws SQLException {
		return memberIbatis.selectMemberAll();
	}

	@Override
	public ArrayList<MemberVO> groupmember(String lice) throws SQLException {
		return memberIbatis.groupmember(lice);
	}

	@Override
	public void updateLice(MemberVO memberVO) throws SQLException {		
		memberIbatis.updateLice(memberVO);
	}

	@Override
	public void updatePositionList(PositionListVO positionListVO)
			throws SQLException {
		memberIbatis.updatePositionList(positionListVO);
	}


	
	

}
