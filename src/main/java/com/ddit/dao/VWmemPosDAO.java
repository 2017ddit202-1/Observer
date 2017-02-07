package com.ddit.dao;

import java.sql.SQLException;

import com.ddit.dto.VWmemPosVO;

public interface VWmemPosDAO {
	public VWmemPosVO memposVO(String id) throws SQLException;
}
