package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("alert")
@Data

public class AlertVO {
	private String al_authority; 
	private String al_id;
}

