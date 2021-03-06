package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.PositionListVO;

public interface PositionListDAO {


	public int insertPositionList(PositionListVO PositionListVO) throws SQLException;
	public void updatePositionList(PositionListVO PositionListVO) throws SQLException;
	public int deletePositionList(String posl_id) throws SQLException;
	PositionListVO selectPositionList(String posl_id) throws SQLException;
	public ArrayList<PositionListVO> listAllArticle() throws SQLException;
}
