package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.TrafficVO;
import com.ddit.ibatis.TrafficDAO_iBatis;

public class TrafficServiceImpl implements TrafficService{
	
	private TrafficDAO_iBatis trafficDAO_iBatis;
	public void setTraaticDAO_iBatis(TrafficDAO_iBatis trafficDAO_iBatis){
		this.trafficDAO_iBatis = trafficDAO_iBatis;
	}

	@Override
	public int insertTraffic(TrafficVO TrafficVO) throws SQLException {
		return trafficDAO_iBatis.insertTraffic(TrafficVO);
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
		return trafficDAO_iBatis.listTra(ip);
	}

	@Override
	public ArrayList<TrafficVO> listTraHo(String ip) throws SQLException {
		return trafficDAO_iBatis.listTraHo(ip);
	}


}
