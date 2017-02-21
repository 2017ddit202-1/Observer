package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ServerDAO;
import com.ddit.dto.ServerVO;

public class ServerServiceImpl implements ServerService{

	
	
	ServerDAO serverDAO;
	public void setServerDAO(ServerDAO serverDAO){
		this.serverDAO = serverDAO;
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
	public int deleteServer(int server_ip, int server_code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServerVO selectServerVO(String server_ip)
			throws SQLException {
		ServerVO serverVO = 
		serverDAO.selectServerVO(server_ip);
		return serverVO;
	}

	@Override
	public ArrayList<ServerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
