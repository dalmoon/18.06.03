package com.springapp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import org.springframework.web.servlet.mvc.Controller;<-- ������ ���� Controller �浹
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.dao.MybatisBoardDAO;

@Controller
public class BoardListController {
	// ����� ��ü�� �������� Ŭ����Ÿ������
	// �Ǵ��Ͽ� �ڵ����� ����(���ͺ��ʿ�)
	@Autowired
	private MybatisBoardDAO iboardDao;

	// DAO ����
	/*
	 * public void setBoardDao(IbatisBoardDAO boardDao) { this.boardDao =
	 * boardDao; }
	 */
	// RequestMapping�޼ҵ�: �����ڰ���
	@RequestMapping("/board_list.do")
	public String handleRequest(Model model ) { // DAO�� ����
		List boardList = iboardDao.list(); //boardList�� ��
		model.addAttribute("boardList", boardList);
		return  "list";
		//return new ModelAndView("list", "boardList", boardList);
		
	}
	/*@RequestMapping("/board_list.do")
	public String handleRequest(Model model) { // �𵨰� ����
		List boardList = iboardDao.list();
		model.addAttribute("boardList", boardList);
		return "list";	
		
	}*/
}
