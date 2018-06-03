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
////SessionAttribut��� ���� �𵨾�Ʈ������ ���ڿ� 
//������ boardVO�� ����(���� ������ ���� ����)
@SessionAttributes("boardVO")
public class BoardUpdateActionCommandController { //���������� �̵�
	@Autowired
private MybatisBoardDAO boardDao;

	@ModelAttribute
	public void printBoardVO(HttpServletRequest request){
		BoardVO vo = (BoardVO)request.getSession().getAttribute("boardVO");
		System.out.println("���ǿ��� " + vo);
	}
	
	@RequestMapping("/board_update_action.do")
	public ModelAndView handle(@ModelAttribute BoardVO boardVO,  SessionStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		boardDao.update(boardVO);
		status.setComplete();//������ ������ ����
//return new ModelAndView("redirect:/board_list.do"); //�׼��±׷ε� ����
			return new ModelAndView(new RedirectView("board_list.do"));//�̵��� �������� ���� �丮������ľƴ϶� �����(/����)

	}




}

