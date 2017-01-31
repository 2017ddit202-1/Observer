package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ReferenceLibrayDAO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ReferenceLibrayDAO_iBatis implements ReferenceLibrayDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertRef(ReferenceLibrayVO RefVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRef(ReferenceLibrayVO RefVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReferenceLibrayVO selectRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<ReferenceLibrayVO> listAllReference() throws SQLException {
		ArrayList<ReferenceLibrayVO> referenceList = (ArrayList<ReferenceLibrayVO>)client.queryForList("listReference");
		return referenceList;
	}

}
