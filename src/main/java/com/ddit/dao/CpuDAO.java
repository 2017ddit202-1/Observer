package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.CpuVO;

public interface CpuDAO {

	public int insertCpu(CpuVO cpuVO) throws SQLException;
	public void updateCpu(CpuVO cpuVO) throws SQLException;
	public int deleteCpu(int cpu_seq) throws SQLException;
	CpuVO selectCpu(int cpu_seq) throws SQLException;
	
	public ArrayList<CpuVO> listCpu(String ip) throws SQLException;
	public ArrayList<CpuVO> listCpuHo(String ip) throws SQLException;
	public String SelectCpuTotalpcnt(String ip) throws SQLException;
	
	
}
