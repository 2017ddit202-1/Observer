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
	public int insertReference(ReferenceLibrayVO referenceVO) throws SQLException {
		System.out.println("ReferenceLibrayDAO_iBatis"+referenceVO);
		int result = -1;
		if(client.insert("insertReference",referenceVO) != null){
			result=-1;
		}else{
			result=1;
		}
		return result;
	
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


	@Override
	public ReferenceLibrayVO detailReference(int reli_seq) throws SQLException {
		ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();
		referenceVO=(ReferenceLibrayVO)client.queryForObject("detailReference",reli_seq);
		return referenceVO;
	}

	@Override
	public void updateReference(ReferenceLibrayVO referenceVO) throws SQLException {
		client.update("updateReference",referenceVO);
	}

	@Override
	public void updateReferenceFileUp(ReferenceLibrayVO referenceVO)
			throws SQLException {
		client.update("updateReferenceFileUp",referenceVO);
		
	}

	@Override
	public void deleteReference(int reli_seq) throws SQLException {
		client.delete("deleteReference",reli_seq);
		
	}






}
