
package com.ddit.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.AlertVO;
import com.ddit.dto.AuthorityVO;
import com.ddit.dto.Vw_AuthorityVO;

public interface AuthorityDAO {
	
	public void AuthorityInsert(String userid)throws SQLException; //권한신청insert
	public ArrayList<Vw_AuthorityVO> authorityList()throws SQLException; //슈퍼어드민페이지에서 권한리스트 가져오기 
	public String authoritySelect1(String userid)throws SQLException; //권한가져오기
	public void adminAuthority(String userid)throws SQLException; //admin으로 권한 업데이트
	public void userAuthority(String userid)throws SQLException; //user으로 권한 업데이트
	public void authorityDelete(String userid)throws SQLException; //업데이트한 id authority에서 삭제
	public AuthorityVO authorityYN(String userid)throws SQLException;//'n'값 가져와 진행중!!
	public void alertY_insert(AlertVO alertVO)throws SQLException; //권한신청 수락일때 -> 아이디,변경된권한 insert
	public void authorityRejection(String userid)throws SQLException; //권한거절시 알림테이블에 '거절' insert
}