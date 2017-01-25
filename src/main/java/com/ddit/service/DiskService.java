package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.DiskVO;

public interface DiskService {

	public int insertCpu(DiskVO diskVO) throws SQLException;
	public void updateCpu(DiskVO diskVO) throws SQLException;
	public int deleteCpu(int disk_seq) throws SQLException;
	DiskVO selectCpu(int disk_seq) throws SQLException;
	public ArrayList<DiskVO> listAllArticle() throws SQLException;
}
