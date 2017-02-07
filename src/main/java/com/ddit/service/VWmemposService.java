package com.ddit.service;

import java.sql.SQLException;

import com.ddit.dto.VWmemPosVO;

public interface VWmemposService {
	public VWmemPosVO memposVO(String id) throws SQLException;
}
