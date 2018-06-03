package com.springapp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import org.springframework.web.servlet.mvc.Controller;<-- 지우자 기존 Controller 충돌
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.dao.MybatisBoardDAO;

@Controller
public class BoardListController {
	// 사용할 빈객체를 스프링이 클래스타입으로
	// 판단하여 자동으로 주입(세터불필요)
	@Autowired
	private MybatisBoardDAO iboardDao;

	// DAO 주입
	/*
	 * public void setBoardDao(IbatisBoardDAO boardDao) { this.boardDao =
	 * boardDao; }
	 */
	// RequestMapping메소드: 무인자가능
	@RequestMapping("/board_list.do")
	public String handleRequest(Model model ) { // DAO와 연동
		List boardList = iboardDao.list(); //boardList가 모델
		model.addAttribute("boardList", boardList);
		return  "list";
		//return new ModelAndView("list", "boardList", boardList);
		
	}
	/*@RequestMapping("/board_list.do")
	public String handleRequest(Model model) { // 모델과 연동
		List boardList = iboardDao.list();
		model.addAttribute("boardList", boardList);
		return "list";	
		
	}*/
}
