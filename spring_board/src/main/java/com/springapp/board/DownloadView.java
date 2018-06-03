package com.springapp.board;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//�ٿ�ε�â�� 

//View �������̽� �����ϱ⺸�ٴ�  AbstractView ��ӹ޾Ƽ�
//renderMergedOutputModel() ������
public class DownloadView extends AbstractView{

    
    public DownloadView() {
        //���� �ٿ�ε带 ���� ������ Ÿ���� " application/download "�� ����
    	////���� �����Ͱ� streamó���� �� ���ڼ� ����
        setContentType("application/download; charset=utf-8");
    }
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//Controller���� �Ѿ�� ���� ������ ����
    	//���� Map model��ü�� Controller���� 
    	//ModelAndView��ü�� ����� ��(��°��) ���޵�

        File file = (File) model.get("downloadFile");
        
        response.setContentType(getContentType());
        response.setContentLength((int) file.length()); 
        //�������� ũ�⸦ ������ ũ��� ����
        
        String userAgent = request.getHeader("User-Agent");
        logger.debug("User-Agent:"+userAgent);
        
        boolean ie = userAgent.indexOf("MSIE") > -1;
       
        String fileName = null;
         if (ie) {
            fileName = URLEncoder.encode(file.getName(), "utf-8");
        } else {
            fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
        }
        System.out.println("fila=" +fileName);
        ////�ٿ�ε� ��ȭ���� ó��
        //Content-Disposition����� �̿��ؼ� ���۵Ǵ� ������ �̸��� ���
        response.setHeader("Content-Disposition", "attachment; filename=\""
                                + fileName +"\";");
        //���۵Ǵ� �������� ���ڵ��� ���̳ʸ� Ÿ���̶�°��� ���
        response.setHeader("Content-Transfer-Encoding","binary");
        //// ��û�� ������ ������ ����
		// ��Ʈ���� response�� ���ؼ� ����.
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } finally {
            if(fis != null) 
                try { fis.close(); } catch (IOException ex) {}
        }
        out.flush();
    }
    
}
