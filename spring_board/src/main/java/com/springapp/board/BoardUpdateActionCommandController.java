package com.springapp.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;

@Controller
////SessionAttribut명과 같은 모델애트리뷰의 인자에 
//세션의 boardVO를 저장(이전 페이지 상태 유지)
@SessionAttributes("boardVO")
public class BoardUpdateActionCommandController { //수정폼으로 이동
	@Autowired
private MybatisBoardDAO boardDao;

	@ModelAttribute
	public void printBoardVO(HttpServletRequest request){
		BoardVO vo = (BoardVO)request.getSession().getAttribute("boardVO");
		System.out.println("세션에서 " + vo);
	}
	
	@RequestMapping("/board_update_action.do")
	public ModelAndView handle(@ModelAttribute BoardVO boardVO,  SessionStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		boardDao.update(boardVO);
		status.setComplete();//세션의 데이터 삭제
//return new ModelAndView("redirect:/board_list.do"); //액션태그로도 가능
			return new ModelAndView(new RedirectView("board_list.do"));//이동할 페이지로 기존 뷰리졸버방식아니라 상대경로(/생략)

	}




}

