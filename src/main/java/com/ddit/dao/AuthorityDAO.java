
package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.Vw_AuthorityVO;

public interface AuthorityDAO {
	
	public void AuthorityInsert(String userid)throws SQLException; //권한신청insert
	public ArrayList<Vw_AuthorityVO> authorityList()throws SQLException; //슈퍼어드민페이지에서 권한리스트 가져오기 

}

