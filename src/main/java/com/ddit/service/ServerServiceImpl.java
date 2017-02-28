package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dao.ServerDAO;
import com.ddit.dto.ServerVO;

public class ServerServiceImpl implements ServerService {

	

	ServerDAO serverDAO;

	public void setServerDAO(ServerDAO serverDAO) {
		this.serverDAO = serverDAO;
	}

	
	@Override
	public void updateServerIp(String ip) throws SQLException {
		serverDAO.updateServerIp(ip);
		
	}

	
	
	@Override
	public void deleteServerIp(String ip) throws SQLException {
		serverDAO.deleteServerIp(ip);
		
	}
	
	/*
	 * selectServerIpList 질의를 수행하기 위한 service
	 */
	@Override
	public List<String> selectServerIpList(String id) throws SQLException {
		List<String> ipList = new ArrayList<String>();
		ipList = serverDAO.selectServerIpList(id);
		return ipList;
	}

	@Override
	public ServerVO SelectServerInfo(String ip) throws SQLException {
		ServerVO serverVO = serverDAO.SelectServerInfo(ip);
		return serverVO;
	}

	@Override
	public int insertServer(ServerVO ServerVO) throws SQLException {
		serverDAO.insertServer(ServerVO);
		return 0;
	}

	@Override
	public String selectServerIP(String ip) throws SQLException {
		String DBip = serverDAO.selectServerIP(ip);
		return DBip;
	}

	@Override
	public void updateServer(ServerVO ServerVO) throws SQLException {
		serverDAO.updateServer(ServerVO);

	}

	@Override
	public List<ServerVO> selectServerList(String id) throws SQLException {
		List<ServerVO> serverList = new ArrayList<ServerVO>();
		serverList = serverDAO.selectServerList(id);
		return serverList;
	}

	@Override
	public int deleteServer(int server_ip, int server_code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServerVO selectServerVO(String server_ip) throws SQLException {
		ServerVO serverVO = serverDAO.selectServerVO(server_ip);
		return serverVO;
	}

	@Override
	public ArrayList<ServerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String selectServercode_Info(String ip) throws SQLException {
		return serverDAO.selectServercode_Info(ip);
	}

}
