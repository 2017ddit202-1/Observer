package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.TrafficDAO;
import com.ddit.dto.TrafficVO;

public class TrafficDAO_iBatis implements TrafficDAO{

	@Override
	public int insertTraffic(TrafficVO TrafficVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TrafficVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
