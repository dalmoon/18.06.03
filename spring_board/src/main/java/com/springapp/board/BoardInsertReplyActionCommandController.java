package com.springapp.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;

import utils.BoardEntryValidator;

@Controller
@RequestMapping("/board_insert_reply.do")
public class BoardInsertReplyActionCommandController {
	private String formViewName = "insert_reply";
	@Autowired
	private MybatisBoardDAO boardDao;

	// @ModelAttribute("�̸�")�� ����� �Լ� ���� ����
	// �Լ��� @ModelAttribute("�̸�")�� ���� @ModelAttribute("�̸�")
	// ���� �̸��� ��ġ�ϸ� �Լ��� �����ϴ� ��ü�� ���ڿ� ����
	// ���� ���޹��� �ڸ�� ��ü �ʱ�ȭ�ϰ����ϴ� ��� ����
	// �� ���(get��û) �� �� ���(post��û)
	@ModelAttribute("board")
	// ó�� get ��û ȭ����� bean name 'board' available as request attribute �� ������
	public BoardVO formBacking(HttpServletRequest request) { // �ڸ�� ��ü �ʱ�ȭ
		BoardVO boardVO = new BoardVO();
		if (request.getMethod().equalsIgnoreCase("get")) {
			boardVO.setTitle("�亯�����Է�");// �信�� ���� ���� �信 ���� �ʱⰪ
		} else {// post
			boardVO.setHitcount(10); // db ��Ʈī��Ʈ 100���� ����
		}
		return boardVO;// onSubmit()�� boardVO ���ڿ� ����
	}

	//����� ��û
	//seq =�۹�ȣ
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(@RequestParam String seq,Model model){
		// TODO Auto-generated method stub
	    //�־��� �۹�ȣ��  ���� VO ��ü
		BoardVO vo = boardDao.findBySeq(seq);
		model.addAttribute( "board", vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(formViewName);
		return mav;
	}

	// ��ȿ�� �˻����� ���� errors ��ü�� BindingResult �� ����
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request,
			@Valid @ModelAttribute("board") BoardVO boardVO,
			BindingResult result) {
		// TODO Auto-generated method stub
		// @InitBinder ���
		// new BoardEntryValidator().validate(boardVO, result);
		if (result.hasErrors())
			return new ModelAndView(formViewName);
		try {
			// BoardVO vo = boardVO;
			// vo.setHitcount(0);
			
			// ���Ͼ��ε� ����
			MultipartFile mfile = boardVO.getMfile();
			// ���ϸ��� VO��  ����
			boardVO.setUploadPath(mfile.getOriginalFilename());
			boardDao.insertReply(boardVO);
			System.out.println("mfile=" + mfile); //���Ϲ̼��õ� ��ü ����
			if (mfile != null && mfile.getSize() != 0) { 
				String fileName = mfile.getOriginalFilename();// ���� ���ϸ�
				// upload������ �������� ���� ������
				String upath =request.getSession().getServletContext().getRealPath(
						"/upload");
				System.out.println(upath);
				File file = new File(upath + "/" + fileName); // File ��ü ����
				mfile.transferTo(file); // ���Ϸ� ����
				System.out.println(fileName + " upath" + "�� ����");
				System.out.println("����ũ��=" + mfile.getSize() + "����Ʈ");
			}
			//RedirectView �丮������ ���� X
			return new ModelAndView(new RedirectView("board_list.do")); 
			
		} catch (Exception e) {

			return new ModelAndView(formViewName);
		}
	}

	@InitBinder
	// WebDataBinder�� Ŀ��� ��ü�� ���ε��Ҷ�
	void initBind(WebDataBinder binder) {
		binder.setValidator(new BoardEntryValidator());

	}

}
