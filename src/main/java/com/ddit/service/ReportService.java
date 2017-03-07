package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ddit.dto.DiskVO;
import com.ddit.dto.MemoryVO;
import com.ddit.dto.TrafficVO;
import com.ddit.dto.VwMemPosSerVO;

public interface ReportService {
	public ArrayList<VwMemPosSerVO> adminList() throws SQLException;
	public VwMemPosSerVO adminMail(String mem_email) throws SQLException;
	
	ArrayList<VwMemPosSerVO> ipList(String userId)throws SQLException;
	HSSFWorkbook CpuXls(String xls) throws SQLException;
	ArrayList<MemoryVO> memoryXls(String xls) throws SQLException;
	ArrayList<TrafficVO> trafficXls(String xls) throws SQLException;
	
	ArrayList<DiskVO> driverList(String ip) throws SQLException;
	ArrayList<DiskVO> diskList(DiskVO diskVO) throws SQLException;
}
