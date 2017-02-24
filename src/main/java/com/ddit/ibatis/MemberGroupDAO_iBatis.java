package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dao.MemberGroupDAO;
import com.ddit.dto.MemberGroupVO;
import com.ddit.dto.ServerVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberGroupDAO_iBatis implements MemberGroupDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertMemGroup(MemberGroupVO MemGroupVO) throws SQLException {
		System.out.println(MemGroupVO.getMem_id());
				System.out.println(MemGroupVO.getMg_lice());
				System.out.println(MemGroupVO.getMg_nm());
				System.out.println(MemGroupVO.getMg_date());
				
								
		client.insert("insertMemGroupVO", MemGroupVO);
		return 0;
	}

	@Override
	public void updateMemGroup(MemberGroupVO MemGroupVO) throws SQLException {   
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteMemGroup(String mg_lice) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberGroupVO selectMemGroup(String mg_lice) throws SQLException {
		MemberGroupVO mem = new MemberGroupVO();
		mem = (MemberGroupVO)client.queryForObject("selectMemGroup", mg_lice);
		return mem;
	}

	@Override
	public ArrayList<MemberGroupVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
