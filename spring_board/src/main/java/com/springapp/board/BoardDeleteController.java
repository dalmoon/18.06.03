package com.springapp.board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.StandardContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;









import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;

@Controller
public class BoardDeleteController {
@Autowired
	private MybatisBoardDAO boardDao;
	//답글 삭제, 원글삭제시 답글들도 함께 삭제
	@RequestMapping("/board/board_delete.do")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String seq=arg0.getParameter("seq");
		String blevel=arg0.getParameter("blevel");
		boardDao.delete(seq, blevel);
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("list");
		return new ModelAndView("redirect:/board_list.do"); //인서트후에 리스트페이지 이동
		
	}

	
}





