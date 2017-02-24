package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ReportDAO;
import com.ddit.dto.CpuVO;
import com.ddit.dto.VwMemPosSerVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ReportDAO_iBatis implements ReportDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public ArrayList<VwMemPosSerVO> adminList() throws SQLException {
		ArrayList<VwMemPosSerVO> adList = (ArrayList<VwMemPosSerVO>) client.queryForList("adminList");
		return adList;
	}
	@Override
	public VwMemPosSerVO adminMail(String mem_email) throws SQLException {
		VwMemPosSerVO vwMpsVo = new VwMemPosSerVO();
		vwMpsVo.setMem_email(mem_email);
		return vwMpsVo;
	}
	@Override
	public ArrayList<CpuVO> CpuXls(String xls) throws SQLException {
		ArrayList<CpuVO> cpuXls = (ArrayList<CpuVO>) client.queryForList("cpuReport", xls);
		return cpuXls;
	}
	@Override
	public ArrayList<VwMemPosSerVO> ipList(String userId) throws SQLException {
		ArrayList<VwMemPosSerVO> ipList = (ArrayList<VwMemPosSerVO>) client.queryForList("ipSerarch",userId);
		return ipList;
	}

}
