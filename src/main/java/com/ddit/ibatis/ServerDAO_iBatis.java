package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dao.ServerDAO;
import com.ddit.dto.ServerVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ServerDAO_iBatis implements ServerDAO{



	

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	
	
	@Override
	public int insertServer(ServerVO ServerVO) throws SQLException {
		client.insert("insertServerVO", ServerVO);
		return 0;
	}
	
	@Override
	public String selectServerIP(String ip) throws SQLException {
		String DBip = null;
		if(client.queryForObject("selectServerIP",ip)!=null){
			DBip = (String) client.queryForObject("selectServerIP",ip);
		}
		return DBip;
	}
	

	@Override
	public void updateServer(ServerVO ServerVO) throws SQLException {
		client.update("updateServerVO",ServerVO);
		
	}

	@Override
	public List<ServerVO> selectServerList(String id) throws SQLException {
		
		List<ServerVO> serverList = new ArrayList<ServerVO>();
		serverList = (ArrayList<ServerVO>)client.queryForList("selectServerList", id);
		return serverList;
	}
	
	
	
	@Override
	public int deleteServer(int server_ip, int server_code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServerVO selectServerVO(String server_ip)
			throws SQLException {
	 	ServerVO serverVO = (ServerVO)client.queryForObject("selectServerVO", server_ip);
		return serverVO;
	}

	@Override
	public ArrayList<ServerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
