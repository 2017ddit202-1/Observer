package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemberGroupVO;

public interface MemberGroupDAO {

	public int insertMemGroup(MemberGroupVO MemGroupVO) throws SQLException;
	public void updateMemGroup(MemberGroupVO MemGroupVO) throws SQLException;
	public int deleteMemGroup(String mg_lice) throws SQLException;
	MemberGroupVO selectMemGroup(String mg_lice) throws SQLException;
	public ArrayList<MemberGroupVO> listAllArticle() throws SQLException;
}
