package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.CpuDAO;
import com.ddit.dto.CpuVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CpuDAO_iBatis implements CpuDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertCpu(CpuVO cpuVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCpu(CpuVO cpuVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteCpu(int cpu_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CpuVO selectCpu(int cpu_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CpuVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CpuVO> listCpu() throws SQLException {
		ArrayList<CpuVO> cpuList =   (ArrayList<CpuVO>) client.queryForList("listAllCpu");
		return cpuList;
	}

	@Override
	public ArrayList<CpuVO> listCpuHo() throws SQLException {
		ArrayList<CpuVO> cpuList =   (ArrayList<CpuVO>) client.queryForList("ListAllCpuHo");
		return cpuList;
	}

}
