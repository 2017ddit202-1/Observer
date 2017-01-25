package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ProcessDAO;
import com.ddit.dto.ProcessVO;

public class ProcessDAO_iBatis implements ProcessDAO{

	@Override
	public int insertProcess(ProcessVO ProcessVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProcess(ProcessVO ProcessVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteProcess(String process_cpu) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProcessVO selectProcess(String process_cpu) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProcessVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
