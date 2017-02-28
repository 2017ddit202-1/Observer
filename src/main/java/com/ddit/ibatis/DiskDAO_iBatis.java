package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dao.DiskDAO;
import com.ddit.dto.DiskVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DiskDAO_iBatis implements DiskDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertDisk(DiskVO diskVO) throws SQLException {
		int result = -1;
		if(client.insert("insertDiskInfo", diskVO) != null ){
			result = -1;
		}else{
			result = 1;
		}
		return result;
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
		ArrayList<DiskVO> listVO = (ArrayList<DiskVO>) client.queryForList("listAllDisk", diskVO);
		return listVO;
	}

	@Override
	public List<DiskVO> driverList(String ip) throws SQLException {
		List<DiskVO> driList = client.queryForList("driverList", ip);
		return driList;
	}

	@Override
	public ArrayList<DiskVO> diskListHo(DiskVO diskVO) throws SQLException {
		ArrayList<DiskVO> listVO = (ArrayList<DiskVO>) client.queryForList("ListAllDiskHo", diskVO);
		return listVO;
	}


}
