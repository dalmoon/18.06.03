package com.springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;


@Controller

public class BoardDetailController  {
	@Autowired
	private MybatisBoardDAO boardDao;
	
	
//HttpServletRequest���� ���� API ���
@RequestMapping("/board_detail.do")
	public ModelAndView handleRequest(@RequestParam("seq") String seq,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		//String seq =arg0.getParameter("seq");
		BoardVO vo = boardDao.findBySeq(seq);
		//���� ���๮�� \n �� �������������� <br>�� ��ȯ
		// �̱���� ������ ��ƿŬ������ �и� �޼ҵ�� �����ϴ� ���� ���� 
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		
		return new ModelAndView("detail", "boardVO", vo);
	}
}





