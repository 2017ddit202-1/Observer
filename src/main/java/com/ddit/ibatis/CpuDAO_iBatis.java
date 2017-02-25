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

	/**
	 * ip로 cpu_total_pcnt의 가장 최근값 1개를 select 
	 */
	@Override
	public String SelectCpuTotalpcnt(String ip) throws SQLException {
		String cpu_total_pcnt = (String)client.queryForObject("selectTotalCpu", ip);
		return cpu_total_pcnt;
	}
	
	@Override
	public int insertCpu(CpuVO cpuVO) throws SQLException {
		client.insert("insertCpuInfo",cpuVO);
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
	public ArrayList<CpuVO> listCpu(String ip) throws SQLException {
		ArrayList<CpuVO> cpuList =   (ArrayList<CpuVO>) client.queryForList("listAllCpu",ip);
		return cpuList;
	}

	@Override
	public ArrayList<CpuVO> listCpuHo(String ip) throws SQLException {
		ArrayList<CpuVO> cpuList =   (ArrayList<CpuVO>) client.queryForList("ListAllCpuHo",ip);
		return cpuList;
	}

}
