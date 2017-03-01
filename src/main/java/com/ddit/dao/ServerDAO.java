package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dto.ServerVO;

public interface ServerDAO {


	public int insertServer(ServerVO ServerVO) throws SQLException;
	public void updateServer(ServerVO ServerVO) throws SQLException;
	ServerVO selectServerVO(String server_ip) throws SQLException;
	public ArrayList<ServerVO> listAllArticle() throws SQLException;
	//
	public String selectServerIP(String ip) throws SQLException;
	public List<ServerVO> selectServerList(String id) throws SQLException;
	public List<String> selectServerIpList(String id) throws SQLException;
	public ServerVO SelectServerInfo(String ip) throws SQLException;
	public void updateServerIp(String ip) throws SQLException;
	public void deleteServerIp(String ip) throws SQLException; 
    public String selectServercode_Info(String ip)throws SQLException;
    
    public ServerVO selectCode(String ip) throws SQLException; 
    
}
