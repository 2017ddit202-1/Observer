package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.ReferenceLibrayVO;

public interface ReferenceLibrayService {

	public void updateRef(ReferenceLibrayVO RefVO) throws SQLException;
	public int deleteRef(int reli_seq) throws SQLException;
	ReferenceLibrayVO selectRef(int reli_seq) throws SQLException;
	
	public ArrayList<ReferenceLibrayVO> listAllReference()throws SQLException; //자료실공지사항리스트
	public int insertReference(ReferenceLibrayVO referenceVO) throws SQLException; //자료글등록
	public ReferenceLibrayVO detailReference(int reli_seq)throws SQLException; //자료실 상세보기
	public void updateReference(ReferenceLibrayVO referenceVO)throws SQLException;//자료실수정하기
	public void updateReferenceFileUp(ReferenceLibrayVO referenceVO)throws SQLException; //자료실수정하기->파일업로드
	 public void deleteReference(int reli_seq)throws SQLException; //자료글 삭제하기
}
