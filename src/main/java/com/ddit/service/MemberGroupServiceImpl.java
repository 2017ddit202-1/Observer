package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemberGroupDAO;
import com.ddit.dto.MemberGroupVO;

public class MemberGroupServiceImpl implements MemberGroupService{
	
	MemberGroupDAO memberGroupDAO;
	public void setMemberGroupDAO(MemberGroupDAO memberGroupDAO) {
		this.memberGroupDAO = memberGroupDAO;
	}

	@Override
	public int insertMemberGroupVO(MemberGroupVO memberGroupVO)
			throws SQLException {
		memberGroupDAO.insertMemGroup(memberGroupVO);
		return 0;
	}
	@Override
	public void updateMemberGroupVO(MemberGroupVO MemberGroupVO)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String deleteMemberGroupVO(String mg_lice) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberGroupVO selectMemberGroupVO(String mg_lice)
			throws SQLException {
		return memberGroupDAO.selectMemGroup(mg_lice);
	}
	@Override
	public ArrayList<MemberGroupVO> listAllMemberGroup() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberGroupVO selectLice(String userId)
			throws SQLException {
		return memberGroupDAO.selectLice(userId);
				
	}
	
	
}
