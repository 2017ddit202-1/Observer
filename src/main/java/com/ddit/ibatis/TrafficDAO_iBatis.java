package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.TrafficDAO;
import com.ddit.dto.TrafficVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TrafficDAO_iBatis implements TrafficDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public int insertTraffic(TrafficVO TrafficVO) throws SQLException {
		int result = -1;
		if(client.insert("insertTrafficInfo", TrafficVO) != null ){
			result = -1;
		}else{
			result = 1;
		}
		return result;
	}

	@Override
	public void updateTraffic(TrafficVO TrafficVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteTraffic(int traffic_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TrafficVO selectTraffic(int traffic_seq) throws SQLException {
		return null;
	}

	@Override
	public ArrayList<TrafficVO> listTra(String ip) throws SQLException {
		ArrayList<TrafficVO> listTra = (ArrayList<TrafficVO>) client.queryForList("listAllTra", ip);
		return listTra;
	}

	@Override
	public ArrayList<TrafficVO> listTraHo(String ip) throws SQLException {
		ArrayList<TrafficVO> listTra = (ArrayList<TrafficVO>) client.queryForList("ListAllTraHo", ip);
		return listTra;
	}

}
