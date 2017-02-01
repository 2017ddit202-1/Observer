package com.ddit.file.upload;

import org.springframework.web.multipart.MultipartFile;

public class FileCommand {
	
	private String title;
	private MultipartFile uploadfile;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	


	

}
