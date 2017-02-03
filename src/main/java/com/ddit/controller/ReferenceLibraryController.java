package com.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.service.ReferenceLibrayService;

@Controller
@RequestMapping("/rf")
public class ReferenceLibraryController {
   
   private WebApplicationContext context = null;

   private String uploadPath = "C:\\dev\\file\\"; // 경로

   @Autowired
   ReferenceLibrayService referenceService;

   // 자료실리스트
   @RequestMapping("/rfList")
   public String rfList(Model model) {

      String url = "reference/rfList";
      ArrayList<ReferenceLibrayVO> referenceList = null;
      try {
         referenceList = referenceService.listAllReference();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      model.addAttribute("referenceList", referenceList);
      return url;
   }

   // 자료실 리스트에서 글쓰기 버튼
   @RequestMapping("/referenceWrite")
   public String referenceWrite() {
      String url = "reference/referenceWrite";
      return url;
   }

   // 글쓰기완료->파일업로드 ?????????????????????아직몰라몰라
   @RequestMapping(value = "/referenceFileUpload", method = RequestMethod.POST)
   public String referenceFileUpload(
         @RequestParam("uploadfile") MultipartFile multipartFile,
         HttpServletRequest request, HttpServletResponse response,
         Model model) throws IllegalStateException, IOException {

      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      String url = "reference/rfList";

      String name = multipartFile.getOriginalFilename();// 파일이름
      Long size = multipartFile.getSize();// 파일사이즈

      String reli_stored = System.currentTimeMillis() + "$$"
            + multipartFile.getOriginalFilename(); // 가공파일이름

      /*String upload = request.getSession().getServletContext()
            .getRealPath(uploadPath);*/
      
      File file = new File(uploadPath);

           if(file.exists() == false){ //파일이 없으면

               file.mkdirs(); //없으면 파일을 만들어준다.

           }
       file = new File(uploadPath, reli_stored);

      ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();
      referenceVO.setMem_id(request.getParameter("mem_id"));
      referenceVO.setReli_subject(request.getParameter("reli_subject"));
      referenceVO.setReli_content(request.getParameter("reli_content"));
      referenceVO.setReli_file_nm(name);
      referenceVO.setReli_stored_filenm(reli_stored);
      referenceVO.setReli_size(size);

      ArrayList<ReferenceLibrayVO> referenceList = null;
      
      
      try {
         referenceService.insertReference(referenceVO);
         referenceList=referenceService.listAllReference();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   
      multipartFile.transferTo(file);

      request.setAttribute("referenceList", referenceList);

      return url;
   }

   // 자료글 디테일
   @RequestMapping(value = "/referenceDetail", method = RequestMethod.GET)
   public String referenceDetail(HttpServletRequest request,
         HttpServletResponse response, HttpSession session) {
      String url = "reference/referenceDetail";

      int reli_seq = Integer.parseInt(request.getParameter("reli_seq"));
      ReferenceLibrayVO referenceVO = null;
      try {
         referenceVO = referenceService.detailReference(reli_seq);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      request.setAttribute("referenceVO", referenceVO);
      return url;
   }

   // 자료글 수정하기
   @RequestMapping(value = "/referenceDetail", method = RequestMethod.POST)
   public String referenceDetailupdate(
         @RequestParam("uploadfile") MultipartFile multipartFile,
         HttpServletRequest request, HttpServletResponse response,
         Model model) throws IllegalStateException, IOException {
	   
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      String url = "reference/rfList";

      ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();

      int reli_seq = Integer.parseInt(request.getParameter("reli_seq"));

      referenceVO.setReli_subject(request.getParameter("reli_subject"));
      referenceVO.setReli_content(request.getParameter("reli_content"));
      referenceVO.setReli_seq(reli_seq);
      
      ArrayList<ReferenceLibrayVO> referenceList = null;

      if (multipartFile.isEmpty()) { // 파일이 비어있을때
         try {
            referenceService.updateReference(referenceVO);
            referenceList = referenceService.listAllReference();
            
            request.setAttribute("referenceList", referenceList);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } else { // 파일을 새로 등록했을때

         String name = multipartFile.getOriginalFilename();// 파일이름
         Long size = multipartFile.getSize();// 파일사이즈 

         String reli_stored = System.currentTimeMillis() + "$$"
               + multipartFile.getOriginalFilename(); // 가공파일이름

       /*  String upload = request.getSession().getServletContext()
               .getRealPath(uploadPath);*/

         File file = new File(uploadPath, reli_stored);
         
         referenceVO.setMem_id(request.getParameter("mem_id"));
         referenceVO.setReli_subject(request.getParameter("reli_subject"));
         referenceVO.setReli_content(request.getParameter("reli_content"));
         referenceVO.setReli_file_nm(name);
         referenceVO.setReli_stored_filenm(reli_stored);
         referenceVO.setReli_size(size);
         
         try {
            referenceService.updateReferenceFileUp(referenceVO);
            referenceList=referenceService.listAllReference();
            
            request.setAttribute("referenceList", referenceList);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         multipartFile.transferTo(file); //업로드 한 파일 데이터를 지정한 파일에 저장한다

         request.setAttribute("referenceVO", referenceVO);

      }

      return url;
   }
  
   
   
   //자료글삭제하기
   @RequestMapping(value="/referenceDelete", method = RequestMethod.POST)
   public String referenceDelete(HttpServletRequest request, HttpServletResponse response){
      String url ="reference/rfList";
      
   int reli_seq = Integer.parseInt(request.getParameter("reli_seq"));
   ArrayList<ReferenceLibrayVO> referenceList = null;
   
   try {
      referenceService.deleteReference(reli_seq);
      referenceList=referenceService.listAllReference();
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
         
   request.setAttribute("referenceList", referenceList);
      
      
      return url;
   }
   
   
   
   /*@RequestMapping("/referenceFileDW")
   public ModelAndView referenceFileDW(@RequestParam("reli_file_nm1") String reli_file_nm1, HttpServletResponse response){

      String url = "";
      
      File downloadFile = getFile(reli_file_nm1);
      
      if(downloadFile == null){
         try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return null;
      }
      return new ModelAndView("download", "downloadFile", downloadFile); // download = view "downloadFile", downloadFile = model
   }
      
   

   private File getFile(String fileId){
      String baseDir =  context.getServletContext().getRealPath("/resources/upload");
      if(fileId.equals("menu")){
         return new File(baseDir,"observer.pdf");
         
      }else if(fileId.equals("installer")){
         return new File(baseDir,"installerTest.pdf");
      }
      return null;
   }*/

}