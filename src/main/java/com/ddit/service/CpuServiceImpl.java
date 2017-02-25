package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.CpuVO;
import com.ddit.ibatis.CpuDAO_iBatis;

public class CpuServiceImpl implements CpuService{
	
	

	private CpuDAO_iBatis cpuDAO_iBatis;
	public void setCpuDAO_iBatis(CpuDAO_iBatis cpuDAO_iBatis){
		this.cpuDAO_iBatis = cpuDAO_iBatis;
	}

	/**
	 * cpu_total_pcnt를 가져오기 위한 서비스
	 */
	@Override
	public String SelectCpuTotalpcnt(String ip) throws SQLException {
		String cpu =  cpuDAO_iBatis.SelectCpuTotalpcnt(ip);
		return cpu;
	}
	
	
	
	@Override
	public int insertCpu(CpuVO cpuVO) throws SQLException {
		cpuDAO_iBatis.insertCpu(cpuVO);
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
		return cpuDAO_iBatis.listCpu();
	}

	@Override
	public ArrayList<CpuVO> listCpuHo() throws SQLException {
		return cpuDAO_iBatis.listCpuHo();
	}

}
