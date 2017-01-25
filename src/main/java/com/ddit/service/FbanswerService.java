package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FbanswerVO;

public interface FbanswerService {

	public int insertCpu(FbanswerVO cpuVO) throws SQLException;
	public void updateCpu(FbanswerVO cpuVO) throws SQLException;
	public int deleteCpu(int fbans_seq) throws SQLException;
	FbanswerVO selectCpu(int fbans_seq) throws SQLException;
	public ArrayList<FbanswerVO> listAllArticle() throws SQLException;
}
