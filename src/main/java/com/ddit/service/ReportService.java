package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ddit.dto.VwMemPosSerVO;

public interface ReportService {
	public ArrayList<VwMemPosSerVO> adminList() throws SQLException;
	public VwMemPosSerVO adminMail(String mem_email) throws SQLException;
	
	ArrayList<VwMemPosSerVO> ipList(String userId)throws SQLException;
	HSSFWorkbook CpuXls(String xls) throws SQLException;
}
