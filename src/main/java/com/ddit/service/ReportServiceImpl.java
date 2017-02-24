package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ddit.dto.CpuVO;
import com.ddit.dto.VwMemPosSerVO;
import com.ddit.ibatis.ReportDAO_iBatis;

public class ReportServiceImpl implements ReportService{
	
	private ReportDAO_iBatis reportDAO_iBatis;
	public void setReportDAO_iBatis(ReportDAO_iBatis reportDAO_iBatis){
		this.reportDAO_iBatis = reportDAO_iBatis;
	}
	@Override
	public ArrayList<VwMemPosSerVO> adminList()
			throws SQLException {
		return reportDAO_iBatis.adminList();
	}
	@Override
	public VwMemPosSerVO adminMail(String mem_email) throws SQLException {
		return reportDAO_iBatis.adminMail(mem_email);
	}
	@Override
	public ArrayList<VwMemPosSerVO> ipList(String userId) throws SQLException {
		return reportDAO_iBatis.ipList(userId);
	}
	@Override
	public HSSFWorkbook CpuXls(String xls) throws SQLException {
		int rowNum = 1;
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet sheet = createFirstDheet(workbook);
		createColumnLabel(sheet);
		List<CpuVO> cpuList = reportDAO_iBatis.CpuXls(xls);
			creatCpuListRow(sheet,rowNum++,cpuList);
		
			
		return workbook;
	}
	private HSSFSheet createFirstDheet(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "주간 보고서");
		sheet.setColumnWidth(0, 200*30);
		sheet.setColumnWidth(1, 200*30);
		sheet.setColumnWidth(2, 200*30);
		sheet.setColumnWidth(3, 200*30);
		sheet.setColumnWidth(4, 200*30);
		sheet.setColumnWidth(5, 200*30);
		sheet.setColumnWidth(6, 200*30);
		
		return sheet;
	}
	private void createColumnLabel(HSSFSheet sheet){
		HSSFRow firstRow = sheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String [] colName = {"전체 사용량","현재 사용량","전체량","휴먼 사용량"};
		for(int i = 0; i<colName.length; i++){
			cell = firstRow.createCell(i);
			cell.setCellValue(colName[i]);
		}
	}
	private void creatCpuListRow(HSSFSheet sheet , int rowName,List<CpuVO> cpuList){
		HSSFCell cell = null;
		for(int i =0; i<cpuList.size(); i++){
			HSSFRow row = sheet.createRow(rowName); // 행 추가
			cell = row.createCell(0);
			cell.setCellValue(cpuList.get(i).getCpu_pcnt());
			
			cell = row.createCell(1);
			cell.setCellValue(cpuList.get(i).getCpu_user_pcnt());
			
			cell = row.createCell(2);
			cell.setCellValue(cpuList.get(i).getCpu_total_pcnt());
			
			cell = row.createCell(3);
			cell.setCellValue(cpuList.get(i).getCpu_idle());
			rowName++;
		}
	}
	
}
