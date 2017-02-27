package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.DiskVO;
import com.ddit.ibatis.DiskDAO_iBatis;

public class DiskServiceImpl implements DiskService{
	
	private DiskDAO_iBatis diskDAO_iBatis;
	public void setDiskDAO_iBatis(DiskDAO_iBatis diskDAO_iBatis){
		this.diskDAO_iBatis = diskDAO_iBatis;
	}

	@Override
	public int insertCpu(DiskVO diskVO) throws SQLException {
		int result = diskDAO_iBatis.insertDisk(diskVO);
		return result;
	}

	@Override
	public void updateCpu(DiskVO diskVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteCpu(int disk_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DiskVO selectCpu(int disk_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DiskVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
