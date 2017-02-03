package com.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.service.ReferenceLibrayService;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;
	private String uploadPath = "C:\\dev\\file\\"; // 경로

	@Autowired
	ReferenceLibrayService referenceService;

	@RequestMapping("/file/{fileId}")
	public ModelAndView download(@PathVariable String fileId,
			HttpServletResponse response) throws IOException {
		File downloadFile = getFile(fileId);
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ModelAndView("download", "downloadFile", downloadFile); // download
																			// =
																			// view
																			// "downloadFile",
																			// downloadFile
																			// =
																			// model
	}

	private File getFile(String fileId) {
		String baseDir = context.getServletContext().getRealPath(
				"/WEB-INF/files");
		if (fileId.equals("menu")) {
			return new File(baseDir, "observer.pdf");

		} else if (fileId.equals("installer")) {
			return new File(baseDir, "installerTest.pdf");
		}
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;

	}

	// //////////////////////////////////////////////////////////////////////////////////

	@RequestMapping("/filee/{filestore}")  //filestore->시퀀스번호
	public ModelAndView downloadFile(@PathVariable String filestore,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		ReferenceLibrayVO reference = new ReferenceLibrayVO();

		try {
			reference = referenceService.detailReference(Integer
					.parseInt(filestore));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//파일이름 받아옴
		String reli_stored_filenm = reference.getReli_stored_filenm();

		File downloadFile = getFile2(reli_stored_filenm); //경로와 이름으로 파일을 가져옴
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ModelAndView("download", "downloadFile", downloadFile); //뷰아이디이름,이름,값
	}

	private File getFile2(String filestore) {
		String baseDir = uploadPath; //"C:\\dev\\file\\";

		return new File(baseDir, filestore);  //경로,파일이름
	}

}