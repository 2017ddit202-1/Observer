package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.DiskDAO;
import com.ddit.dto.DiskVO;

public class DiskDAO_iBatis implements DiskDAO{

	@Override
	public int insertDisk(DiskVO diskVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
	public ArrayList<DiskVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
