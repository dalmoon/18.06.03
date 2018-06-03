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
	
	
//HttpServletRequest으로 서블릿 API 사용
@RequestMapping("/board_detail.do")
	public ModelAndView handleRequest(@RequestParam("seq") String seq,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		//String seq =arg0.getParameter("seq");
		BoardVO vo = boardDao.findBySeq(seq);
		//엔터 개행문자 \n 을 웹브라우저에서는 <br>로 변환
		// 이기능을 별도의 유틸클래스로 분리 메소드로 정의하는 편이 좋다 
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		
		return new ModelAndView("detail", "boardVO", vo);
	}
}





