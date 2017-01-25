package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ServerDAO;
import com.ddit.dto.ServerVO;

public class ServerDAO_iBatis implements ServerDAO{

	@Override
	public int insertServer(ServerVO ServerVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateServer(ServerVO ServerVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteServer(int server_ip, int server_code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServerVO selectServer(int server_ip, int server_code)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ServerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
