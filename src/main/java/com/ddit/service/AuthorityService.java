
package com.ddit.service;

import java.sql.SQLException;

public interface AuthorityService {
	
	public void AuthorityInsert(String userid)throws SQLException; //권한신청insert

}
=======
package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.Vw_AuthorityVO;

public interface AuthorityService {
	
	public void AuthorityInsert(String userid)throws SQLException; //권한신청insert
	public ArrayList<Vw_AuthorityVO> authorityList()throws SQLException; //슈퍼어드민페이지에서 권한리스트 가져오기 

}

