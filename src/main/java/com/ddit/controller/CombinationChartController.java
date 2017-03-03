package com.ddit.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.DataVO;

public class CombinationChartController {
	@RequestMapping(value="/chartdata.do", produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<Object, Object> test(){
		Map<Object, Object> finalData = new HashMap<Object, Object>();
		finalData.put("xData", new int[]{1,23});
		DataVO vo1 = new DataVO();
		DataVO vo2 = new DataVO();
		DataVO vo3 = new DataVO();
		
		finalData.put("datasets", Arrays.asList(vo1, vo2, vo3));
		return finalData;
	}
}

//$.ajax({
//	url:"",
//	data:"",
//	dataType:"",
//	method:"get",
//	success:function(){},
//	error:function(){}
//	
//});
//$.getJson("주소", function(responBody){
//	
//})



