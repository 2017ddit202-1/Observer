package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.ss.formula.ptg.MemErrPtg;

import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;

public interface MemberDAO {
	public int insertMember(MemberVO memberVO) throws SQLException;
	public void updateMember(MemberVO memberVO)throws SQLException;
	public int deleteMember(String userid)throws SQLException;
	public int confirmID(String userid) throws SQLException;
	
	
	MemberVO selectMember(String userid) throws SQLException;
	public void deleteuseMember(MemberVO memberVO) throws SQLException;
	public void positionRole(String userid)throws SQLException;
	
	
	public MemberVO idFind(String name , String email) throws SQLException;
	public MemberVO pwdFind(String userid , String email) throws SQLException;
	
	
	public void tempPwd(MemberVO memberVO) throws SQLException; 
	
	public MemberVO confirmID2(String userid) throws SQLException;   //아이디로셀렉
	public void memberEnabled(String userid)throws SQLException; //탈퇴
	public PositionListVO authoritySelect(String userid)throws SQLException; //현재나의권한
	
	public ArrayList<MemberVO> selectMemberAll() throws SQLException; //전체 회원 리스트 검색
	public ArrayList<MemberVO> groupmember(String lice) throws SQLException; //그룹 회원 검색
	public ArrayList<MemberVO> groupmember(int tpage, String lice) throws SQLException; //그룹 리스트 검색(라이선스1)
	public String pageNumberlice(int tpage, String lice) throws SQLException;
	
	public ArrayList<MemberVO> groupmemberlist(int tpage, MemberVO lice) throws SQLException; //그룹 리스트 검색(라이선스1)
	public String pageNumbergrlice(int tpage, MemberVO lice) throws SQLException;
	

	public void updateLice(MemberVO memberVO)throws SQLException;
	public void updatePositionList(PositionListVO positionListVO)throws SQLException;
	public int memberCnt()throws SQLException;
	public int enabledCnt()throws SQLException;
	public int userCnt()throws SQLException;
	public int adminCnt()throws SQLException;
	public int authorityCnt()throws SQLException;
	
	public int joinKeyUp(String mem_id)throws SQLException;

}
