package com.springapp.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownController {

	   //파일 다운로드
    @RequestMapping("/file_download.do")
    public ModelAndView fileDownload1(HttpServletRequest request) throws Exception{
                
        String of = request.getParameter("fileName");
        //한글파일명인코딩
        //of = new String(of.getBytes("ISO8859_1"),"euc-kr"); //여기서는 utf-8 X 
        
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fullPath = path+"/"+of;
        
        File downloadFile = new File(fullPath);
         //download : 설정파일의 id 가 download 인 뷰 클래스로 
        //downloadFile이란 변수에 downloadFile 을 저장 리턴
    
        return new ModelAndView("download", "downloadFile", downloadFile);
    }



}
