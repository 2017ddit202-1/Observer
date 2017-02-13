package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.CpuVO;

public interface CpuService {

	public int insertCpu(CpuVO cpuVO) throws SQLException;
	public void updateCpu(CpuVO cpuVO) throws SQLException;
	public int deleteCpu(int cpu_seq) throws SQLException;
	CpuVO selectCpu(int cpu_seq) throws SQLException;
	public ArrayList<CpuVO> listAllArticle() throws SQLException;
	
	public ArrayList<CpuVO> listCpu() throws SQLException;
	public ArrayList<CpuVO> listCpuHo() throws SQLException;
	
}
