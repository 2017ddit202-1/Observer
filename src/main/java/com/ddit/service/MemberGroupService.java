package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemberGroupVO;

public interface MemberGroupService {

	public int insertCpu(MemberGroupVO cpuVO) throws SQLException;
	public void updateCpu(MemberGroupVO cpuVO) throws SQLException;
	public String deleteCpu(String mg_lice) throws SQLException;
	MemberGroupVO selectCpu(String mg_lice) throws SQLException;
	public ArrayList<MemberGroupVO> listAllArticle() throws SQLException;
}
