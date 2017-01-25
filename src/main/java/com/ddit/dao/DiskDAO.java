package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.DiskVO;

public interface DiskDAO {
	
	public int insertDisk(DiskVO diskVO) throws SQLException;
	public void updateDisk(DiskVO diskVO) throws SQLException;
	public int deleteDisk(int disk_seq) throws SQLException;
	DiskVO selectDisk(int disk_seq) throws SQLException;
	public ArrayList<DiskVO> listAllArticle() throws SQLException;
}
