package com.ddit.dto;

import java.util.List;

import lombok.Data;

@Data
public class DataVO {
	private String name;
	private List<String> data;
	private String unit;
	private String type;
	private int valueDecimal;
}
