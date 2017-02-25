package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.TrafficVO;

public interface TrafficService {

	public int insertTraffic(TrafficVO TrafficVO) throws SQLException;
	public void updateTraffic(TrafficVO TrafficVO) throws SQLException;
	public int deleteTraffic(int traffic_seq) throws SQLException;
	TrafficVO selectTraffic(int traffic_seq) throws SQLException;
	
	public ArrayList<TrafficVO> listTra(String ip) throws SQLException;
	public ArrayList<TrafficVO> listTraHo(String ip) throws SQLException;
}
