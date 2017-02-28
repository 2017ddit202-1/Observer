package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemberDAO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
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
		int result=-1;//실패
		if(client.queryForObject("confirmID",userid) != null){
			result=-1;
		}else{
			result=1; //성공
		}
		return result;
	}


	@Override
	public MemberVO selectMember(String userid) throws SQLException {
		MemberVO memberVO = (MemberVO) client.queryForObject("selectMember", userid);
		
		return memberVO;
	}


	@Override
	public void deleteuseMember(MemberVO memberVO) throws SQLException {
		client.update("deleteuseMember", memberVO.getMem_pwd());
		
	}


	@Override
	public void positionRole(String userid) throws SQLException {
		client.insert("positionRole",userid);
		
	}


	@Override
	public MemberVO idFind(String name, String email) throws SQLException {
		MemberVO idFind = new MemberVO();
		idFind.setMem_nm(name);
		idFind.setMem_email(email);
		
		MemberVO member = (MemberVO) client.queryForObject("idFind",idFind);
		
		return member;
	}


	@Override
	public MemberVO pwdFind(String userid, String email) throws SQLException {
		MemberVO pwdFind = new MemberVO();
		pwdFind.setMem_id(userid);
		pwdFind.setMem_email(email);
		
		MemberVO member = (MemberVO) client.queryForObject("pwdFind",pwdFind);
		
		return member;
	}


	@Override
	public void tempPwd(MemberVO memberVO) throws SQLException {
		client.update("pwdUpdate",memberVO);
		
	}


	@Override
	public MemberVO confirmID2(String userid) throws SQLException {
		return (MemberVO) client.queryForObject("confirmID",userid);
		
	}


	@Override
	public void memberEnabled(String userid) throws SQLException {
	  client.update("memberEnabled", userid);
		
	}


	@Override
	public PositionListVO authoritySelect(String userid) throws SQLException {
		return (PositionListVO) client.queryForObject("authoritySelect",userid);
		
	}


	@Override
	public ArrayList<MemberVO> selectMemberAll() throws SQLException {
		return (ArrayList<MemberVO>) client.queryForList("selectMemberAll");
	}


	@Override
	public ArrayList<MemberVO> groupmember(String lice) throws SQLException {	
		return (ArrayList<MemberVO>) client.queryForList("groupmember",lice);
	}


	@Override
	public void updateLice(MemberVO memberVO) throws SQLException {
		client.update("updateLice", memberVO);
		
	}


	@Override
	public void updatePositionList(PositionListVO positionListVO)
			throws SQLException {
		client.update("updatePositionList",positionListVO);
	}


	@Override
	public int memberCnt() throws SQLException {
		return (int) client.queryForObject("memberCnt");
	}


	@Override
	public int enabledCnt() throws SQLException {
		return (int) client.queryForObject("enabledCnt");
	}


	@Override
	public int userCnt() throws SQLException {
		return (int) client.queryForObject("userCnt");
	}


	@Override
	public int adminCnt() throws SQLException {
		return (int) client.queryForObject("adminCnt");
	}


	@Override
	public int authorityCnt() throws SQLException {
		return (int) client.queryForObject("authorityCnt");
	}


	

}
