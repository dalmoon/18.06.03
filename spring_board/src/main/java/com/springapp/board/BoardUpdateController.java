package com.springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;




import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;

@Controller
//SessionAttribut��� ���� ���� boardVO�� ���� ����(���������� ���� ����)
@SessionAttributes("boardVO") 
public class BoardUpdateController  {
	@Autowired
	private MybatisBoardDAO boardDao;
	
	@RequestMapping(value="/board_update.do",method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam String seq,Model model){
		// TODO Auto-generated method stub
	    //������ ���� ��ȸ
		BoardVO vo = boardDao.findBySeq(seq);
		model.addAttribute( "boardVO", vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update");
		return mav;
	}
}

