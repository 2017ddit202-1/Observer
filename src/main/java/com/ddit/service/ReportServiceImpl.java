package com.ddit.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ddit.dto.CpuVO;
import com.ddit.dto.DiskVO;
import com.ddit.dto.MemoryVO;
import com.ddit.dto.TrafficVO;
import com.ddit.dto.VwMemPosSerVO;
import com.ddit.ibatis.ReportDAO_iBatis;

public class ReportServiceImpl implements ReportService {

	private ReportDAO_iBatis reportDAO_iBatis;

	public void setReportDAO_iBatis(ReportDAO_iBatis reportDAO_iBatis) {
		this.reportDAO_iBatis = reportDAO_iBatis;
	}

	@Override
	public ArrayList<VwMemPosSerVO> adminList() throws SQLException {
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
		int rowNum1 = 1;
		int rowNum2 = 1;
		int rowNum3 = 1;
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = createFirstDheet(workbook);
		createColumnLabel(sheet);
		
		HSSFSheet sheet2 = createFirstSheet(workbook);
		createColumnLabel2(sheet2);
		
		HSSFSheet sheet3 = createFirstFheet(workbook);
		createColumnLabel3(sheet3);
		
		HSSFSheet sheet4 = createFirstLheet(workbook);
		createColumnLabel4(sheet4);
		
		List<CpuVO> cpuList = reportDAO_iBatis.CpuXls(xls);
		
		List<MemoryVO> memoryList = memoryXls(xls);
		
		List<TrafficVO> trafficList = trafficXls(xls);
		
		List<DiskVO> diskList = driverList(xls);
		creatCpuListRow(sheet, rowNum++, cpuList);
		creatMemoryListRow(sheet2, rowNum1++, memoryList);
		creatTrafficListRow(sheet3, rowNum2++, trafficList);
		creatDiskListRow(sheet4, rowNum3++, diskList);

		return workbook;
	}

	/**
	 * CPU Sheet
	 */
	private HSSFSheet createFirstDheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "CPU 사용량");
		sheet.setColumnWidth(0, 200 * 30);
		sheet.setColumnWidth(1, 200 * 30);
		sheet.setColumnWidth(2, 200 * 30);
		sheet.setColumnWidth(3, 200 * 30);
		sheet.setColumnWidth(4, 200 * 30);
		sheet.setColumnWidth(5, 200 * 30);
		sheet.setColumnWidth(6, 200 * 30);

		return sheet;
	}

	/**
	 * CPU sheet 
	 */
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String[] colName = { "전체 사용량", "현재 사용량", "전체량", "휴먼 사용량","날짜" };
		for (int i = 0; i < colName.length; i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(colName[i]);
		}
	}

	/**
	 * CPU Sheet 내용
	 */
	private void creatCpuListRow(HSSFSheet sheet, int rowName,
			List<CpuVO> cpuList) {
		HSSFCell cell = null;
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		for (int i = 0; i < cpuList.size(); i++) {
			HSSFRow row = sheet.createRow(rowName); // 행 추가
			cell = row.createCell(0);
			cell.setCellValue(cpuList.get(i).getCpu_pcnt());

			cell = row.createCell(1);
			cell.setCellValue(cpuList.get(i).getCpu_user_pcnt());

			cell = row.createCell(2);
			cell.setCellValue(cpuList.get(i).getCpu_total_pcnt());

			cell = row.createCell(3);
			cell.setCellValue(cpuList.get(i).getCpu_idle());
			
			cell = row.createCell(4);
			cell.setCellValue(simple.format(cpuList.get(i).getCpu_date()));
			rowName++;
		}
	}

	@Override
	public ArrayList<MemoryVO> memoryXls(String xls) throws SQLException {
		ArrayList<MemoryVO> memoryList = reportDAO_iBatis.memoryXls(xls);
		return memoryList;
	}
	/**
	 * memory
	 */
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet memorySheet = workbook.createSheet();
		workbook.setSheetName(1, "Memory 사용량");
		memorySheet.setColumnWidth(0, 200 * 30);
		memorySheet.setColumnWidth(1, 200 * 30);
		memorySheet.setColumnWidth(2, 200 * 30);
		memorySheet.setColumnWidth(3, 200 * 30);
		memorySheet.setColumnWidth(4, 200 * 30);
		memorySheet.setColumnWidth(5, 200 * 30);
		memorySheet.setColumnWidth(6, 200 * 30);

		return memorySheet;
	}
	/**
	 * memorySheet
	 */
	private void createColumnLabel2(HSSFSheet memorySheet) {
		HSSFRow firstRow = memorySheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String[] colName2 = { "전체 메모리", "메모리 사용량", "휴먼 사용량", "메모리 사용률","날짜" };
		for (int i = 0; i < colName2.length; i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(colName2[i]);
		}
	}
	/**
	 * memorySheet 내용
	 */
	private void creatMemoryListRow(HSSFSheet memorySheet, int rowName1,
			List<MemoryVO> memoryList) {
		HSSFCell cell = null;
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for (int i = 0; i < memoryList.size(); i++) {
			HSSFRow row = memorySheet.createRow(rowName1); // 행 추가
			cell = row.createCell(0);
			cell.setCellValue(memoryList.get(i).getMemory_total());

			cell = row.createCell(1);
			cell.setCellValue(memoryList.get(i).getMemory_using());

			cell = row.createCell(2);
			cell.setCellValue(memoryList.get(i).getMemory_idle());

			cell = row.createCell(3);
			cell.setCellValue(memoryList.get(i).getMemory_total_used());
			
			cell = row.createCell(4);
			cell.setCellValue(simple.format(memoryList.get(i).getMemory_date()));
			rowName1++;
		}
	}

	@Override
	public ArrayList<TrafficVO> trafficXls(String xls) throws SQLException {
		ArrayList<TrafficVO> trafficList = reportDAO_iBatis.trafficXls(xls);
		return trafficList;
	}
	/**
	 * TrafficSheet
	 */
	private HSSFSheet createFirstFheet(HSSFWorkbook workbook) {
		HSSFSheet trafficSheet = workbook.createSheet();
		workbook.setSheetName(2, "Traffic 사용량");
		trafficSheet.setColumnWidth(0, 200 * 30);
		trafficSheet.setColumnWidth(1, 200 * 30);
		trafficSheet.setColumnWidth(2, 200 * 30);
		trafficSheet.setColumnWidth(3, 200 * 30);
		trafficSheet.setColumnWidth(4, 200 * 30);
		trafficSheet.setColumnWidth(5, 200 * 30);
		trafficSheet.setColumnWidth(6, 200 * 30);

		return trafficSheet;
	}
	/**
	 * TrafficSheet
	 */
	private void createColumnLabel3(HSSFSheet trafficSheet) {
		HSSFRow firstRow = trafficSheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String[] colName3 = { "총 사용량", "수신량", "통신량","날짜" };
		for (int i = 0; i < colName3.length; i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(colName3[i]);
		}
	}
	/**
	 * TrafficSheet 내용
	 */
	private void creatTrafficListRow(HSSFSheet trafficSheet, int rowName2,
			List<TrafficVO> trafficList) {
		HSSFCell cell = null;
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for (int i = 0; i < trafficList.size(); i++) {
			HSSFRow row = trafficSheet.createRow(rowName2); // 행 추가
			cell = row.createCell(0);
			cell.setCellValue(trafficList.get(i).getTraffic_use());

			cell = row.createCell(1);
			cell.setCellValue(trafficList.get(i).getTraffic_rece());

			cell = row.createCell(2);
			cell.setCellValue(trafficList.get(i).getTraffic_trans());

			cell = row.createCell(3);
			cell.setCellValue(simple.format(trafficList.get(i).getTraffic_date()));
			rowName2++;
		}
	}

	@Override
	public ArrayList<DiskVO> driverList(String ip) throws SQLException {
		ArrayList<DiskVO> listDriver = reportDAO_iBatis.driverList(ip);
		ArrayList<DiskVO> driList = null;
		ArrayList<DiskVO> totalDriverList = new ArrayList<DiskVO>();
		for(DiskVO list : listDriver){
			list.setDisk_ip(ip);
			driList = reportDAO_iBatis.diskList(list);
			for(DiskVO x : driList){
				totalDriverList.add(x);
			}
		}
		return totalDriverList;
	}

	@Override
	public ArrayList<DiskVO> diskList(DiskVO diskVO) throws SQLException {
		ArrayList<DiskVO> list = reportDAO_iBatis.diskList(diskVO);
		return list;
	}
	
	private HSSFSheet createFirstLheet(HSSFWorkbook workbook) {
		HSSFSheet diskSheet = workbook.createSheet();
		workbook.setSheetName(3, "Disk 사용량");
		diskSheet.setColumnWidth(0, 200 * 30);
		diskSheet.setColumnWidth(1, 200 * 30);
		diskSheet.setColumnWidth(2, 200 * 30);
		diskSheet.setColumnWidth(3, 200 * 30);
		diskSheet.setColumnWidth(4, 200 * 30);
		diskSheet.setColumnWidth(5, 200 * 30);
		diskSheet.setColumnWidth(6, 200 * 30);

		return diskSheet;
	}
	private void createColumnLabel4(HSSFSheet diskSheet) {
		HSSFRow firstRow = diskSheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String[] colName4 = { "드라이버", "총 드라이버 용량", "드라이버 사용량","휴먼 사용량","드라이버 사용률","날짜" };
		for (int i = 0; i < colName4.length; i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(colName4[i]);
		}
	}
	private void creatDiskListRow(HSSFSheet trafficSheet, int rowName3,
			List<DiskVO> diskList) {
		HSSFCell cell = null;
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for (int i = 0; i < diskList.size(); i++) {
			HSSFRow row = trafficSheet.createRow(rowName3); // 행 추가
			cell = row.createCell(0);
			cell.setCellValue(diskList.get(i).getDisk_nm());

			cell = row.createCell(1);
			cell.setCellValue(diskList.get(i).getDisk_total());

			cell = row.createCell(2);
			cell.setCellValue(diskList.get(i).getDisk_using());
			
			cell = row.createCell(3);
			cell.setCellValue(diskList.get(i).getDisk_idle());

			cell = row.createCell(4);
			cell.setCellValue(diskList.get(i).getDisk_pcnt());
			
			cell = row.createCell(5);
			cell.setCellValue(simple.format(diskList.get(i).getDisk_date()));
			rowName3++;
		}
	}


}