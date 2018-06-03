package com.springapp.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownController {

	   //���� �ٿ�ε�
    @RequestMapping("/file_download.do")
    public ModelAndView fileDownload1(HttpServletRequest request) throws Exception{
                
        String of = request.getParameter("fileName");
        //�ѱ����ϸ����ڵ�
        //of = new String(of.getBytes("ISO8859_1"),"euc-kr"); //���⼭�� utf-8 X 
        
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fullPath = path+"/"+of;
        
        File downloadFile = new File(fullPath);
         //download : ���������� id �� download �� �� Ŭ������ 
        //downloadFile�̶� ������ downloadFile �� ���� ����
    
        return new ModelAndView("download", "downloadFile", downloadFile);
    }



}
