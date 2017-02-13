package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("position_list")
@Data
public class PositionListVO {

	private String posl_id;
	private String posl_pos;
	
}
