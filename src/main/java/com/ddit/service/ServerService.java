package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.ServerVO;

public interface ServerService {


	public int insertServer(ServerVO ServerVO) throws SQLException;
	public void updateServer(ServerVO ServerVO) throws SQLException;
	public int deleteServer(int server_ip , int server_code) throws SQLException;
	ServerVO selectServer(int server_ip , int server_code) throws SQLException;
	public ArrayList<ServerVO> listAllArticle() throws SQLException;
}
