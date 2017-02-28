package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dto.DiskVO;
import com.ddit.ibatis.DiskDAO_iBatis;

public class DiskServiceImpl implements DiskService{
	
	private DiskDAO_iBatis diskDAO_iBatis;
	public void setDiskDAO_iBatis(DiskDAO_iBatis diskDAO_iBatis){
		this.diskDAO_iBatis = diskDAO_iBatis;
	}

	@Override
	public int insertDisk(DiskVO diskVO) throws SQLException {
		return diskDAO_iBatis.insertDisk(diskVO);
	}

	@Override
	public void updateDisk(DiskVO diskVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteDisk(int disk_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DiskVO selectDisk(int disk_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DiskVO> diskList(DiskVO diskVO) throws SQLException {
		return diskDAO_iBatis.diskList(diskVO);
	}

	@Override
	public List<DiskVO> driverList(String ip) throws SQLException {
		return diskDAO_iBatis.driverList(ip);
	}

	@Override
	public ArrayList<DiskVO> diskListHo(DiskVO diskVO) throws SQLException {
		return diskDAO_iBatis.diskListHo(diskVO);
	}


}
