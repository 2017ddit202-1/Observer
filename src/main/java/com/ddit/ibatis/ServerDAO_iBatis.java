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
	public void deleteServerIp(String ip) throws SQLException {
		client.delete("serverRemove", ip);
		
	}
	
	/**
	 * ip를 이용하여 update
	 */
	@Override
	public void updateServerIp(String ip) throws SQLException {
		client.update("updateIpSaveyn",ip );
		
	}
	
	
	/**
	 * ip로 server_host, server_os_name, server_ip 를 select
	 */
	@Override
	public ServerVO SelectServerInfo(String ip) throws SQLException {
		 ServerVO serverVO= (ServerVO)client.queryForObject("selectServerInfo", ip);
		return serverVO;
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
			
		/**
		 * admin계정의 아이디를 이용해서 해당 서버에 등록되어있는 ip를 리스트로 가져온다
		 */
	@Override
	public List<String> selectServerIpList(String id) throws SQLException {
		List<String> ipList = new ArrayList<String>();
		
		ipList = client.queryForList("selectSeverIpList", id);
		return ipList;
	}



		@Override
		public String selectServercode_Info(String ip) throws SQLException {
			return (String) client.queryForObject("selectServercode_Info",ip);
		}



		@Override
		public ServerVO selectCode(String ip) throws SQLException {
			ServerVO serverVO = (ServerVO) client.queryForObject("serverCode", ip);
			return serverVO;
		}
	

}
