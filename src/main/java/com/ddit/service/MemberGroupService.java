package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemberGroupVO;

public interface MemberGroupService {

	public int insertMemberGroupVO(MemberGroupVO memberGroupVO) throws SQLException;
	public void updateMemberGroupVO(MemberGroupVO MemberGroupVO) throws SQLException;
	public String deleteMemberGroupVO(String mg_lice) throws SQLException;
	MemberGroupVO selectMemberGroupVO(String mg_lice) throws SQLException;
	public ArrayList<MemberGroupVO> listAllMemberGroup() throws SQLException;
}
