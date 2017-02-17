package com.ddit.dto;

import com.google.gson.Gson;


import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Data
public class MessageVO {
	private String id;
	
	
	public static MessageVO converMessage(String source){
		MessageVO message = new MessageVO();
		Gson gson = new Gson();
		message = gson.fromJson(source, MessageVO.class);

		return message;
	}

}
