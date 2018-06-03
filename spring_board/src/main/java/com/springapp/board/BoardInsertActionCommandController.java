package com.springapp.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springapp.dao.MybatisBoardDAO;
import com.springapp.vo.BoardVO;

import utils.BoardEntryValidator;

@Controller
@RequestMapping("/board_insert.do")
public class BoardInsertActionCommandController {
	private String formViewName = "insert";
	@Autowired
	private MybatisBoardDAO boardDao;

	// @ModelAttribute("�̸�")�� ����� �Լ� ���� ����
	// �Լ��� @ModelAttribute("�̸�")�� ���� @ModelAttribute("�̸�")
	// ���� �̸��� ��ġ�ϸ� �Լ��� �����ϴ� ��ü��  �𵨿� ������ ���ڿ� ����
	// ���� ���޹��� �ڸ�� ��ü �ʱ�ȭ�ϰ����ϴ� ��� ����
	// �� ���(get��û) �� �� ���(post��û)
	@ModelAttribute("board")
	// ó�� get ��û ȭ����� bean name 'board' available as request attribute �� ������
	public BoardVO formBacking(HttpServletRequest request) { // �ڸ�� ��ü �ʱ�ȭ
		BoardVO boardVO = new BoardVO();
		if (request.getMethod().equalsIgnoreCase("get")) {
			boardVO.setTitle("�����Է�");// �信�� ���� ���� �信 ���� �ʱⰪ
		} else {// post
			boardVO.setHitcount(100); // db ��Ʈī��Ʈ 100���� ����
		}
		return boardVO;// onSubmit()�� boardVO ���ڿ� ����
	}
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	// ��ȿ�� �˻����� ���� errors ��ü�� BindingResult �� ����
	//BindingResult =Errors
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request,
			@Valid @ModelAttribute("board") BoardVO boardVO,
			BindingResult result) {//BindingResult =Errors
		// TODO Auto-generated method stub
		// @InitBinder ���
		// new BoardEntryValidator().validate(boardVO, result);
		if (result.hasErrors())
			// ������ ������ �������� �����ֱ�
			//return new ModelAndView(formViewName);
			return formViewName;
		try {
			// BoardVO vo = boardVO;
			// vo.setHitcount(0);
			
			// ���Ͼ��ε� ����
			MultipartFile mfile = boardVO.getMfile();
			// ���ϸ��� VO��  ����
			boardVO.setUploadPath(mfile.getOriginalFilename());
			// DAO �޼ҵ� ȣ��
			boardDao.insert(boardVO);
			if(!mfile.isEmpty()){ //������ �����ϸ�
			System.out.println("mfile=" + mfile); //���Ϲ̼��õ� ��ü ����
			//if (mfile != null && mfile.getSize() != 0) { 
				String fileName = mfile.getOriginalFilename();// ���� ���ϸ�
				// upload������ �������� ���� ������
				// F5 ȸ��(�ڵ� ����ȭ : ������ ������ X)
				String upath = request.getSession().getServletContext().getRealPath(
						"/upload");
				System.out.println(upath);
				File file = new File(upath + "/" + fileName); // upload���� File ��ü ����
				mfile.transferTo(file); // MultipartFile ������ File ���Ϸ� upload������ ����
				System.out.println(fileName + " upath" + "�� ����");
				System.out.println("����ũ��=" + mfile.getSize() + "����Ʈ");
			}
		//	}
			//RedirectView��ü  �丮������ ���� X
			// ������(�۸�� ��û��)�� ���� ,�𵨿� ��°�� ���� X
			return "redirect:board_list.do";
			//return new ModelAndView(new RedirectView("board_list.do")); 
			
		} catch (Exception e) {

			//return new ModelAndView(formViewName);
			return formViewName;
		}
	}

	//JSR303���� ��ȯ
	//@InitBinder
	// WebDataBinder�� Ŀ��� ��ü�� ���ε��Ҷ�
	/*void initBind(WebDataBinder binder) {
		binder.setValidator(new BoardEntryValidator());

	}*/

}
