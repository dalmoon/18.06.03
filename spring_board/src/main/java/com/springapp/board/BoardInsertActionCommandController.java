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

	// @ModelAttribute("이름")이 선언된 함수 먼저 실행
	// 함수의 @ModelAttribute("이름")과 인자 @ModelAttribute("이름")
	// 간의 이름이 일치하면 함수가 리턴하는 객체가  모델에 저장후 인자에 전달
	// 따라서 전달받을 코멘드 객체 초기화하고자하는 경우 적용
	// 폼 출력(get요청) 및 글 등록(post요청)
	@ModelAttribute("board")
	// 처음 get 요청 화면상의 bean name 'board' available as request attribute 못 가져옴
	public BoardVO formBacking(HttpServletRequest request) { // 코멘드 객체 초기화
		BoardVO boardVO = new BoardVO();
		if (request.getMethod().equalsIgnoreCase("get")) {
			boardVO.setTitle("제목입력");// 뷰에서 참조 가능 뷰에 보일 초기값
		} else {// post
			boardVO.setHitcount(100); // db 히트카운트 100으로 설정
		}
		return boardVO;// onSubmit()의 boardVO 인자에 전달
	}
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	// 유효성 검사결과를 담은 errors 객체가 BindingResult 에 전달
	//BindingResult =Errors
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request,
			@Valid @ModelAttribute("board") BoardVO boardVO,
			BindingResult result) {//BindingResult =Errors
		// TODO Auto-generated method stub
		// @InitBinder 사용
		// new BoardEntryValidator().validate(boardVO, result);
		if (result.hasErrors())
			// 오류가 있으면 폼페이지 보여주기
			//return new ModelAndView(formViewName);
			return formViewName;
		try {
			// BoardVO vo = boardVO;
			// vo.setHitcount(0);
			
			// 파일업로드 로직
			MultipartFile mfile = boardVO.getMfile();
			// 파일명을 VO에  설정
			boardVO.setUploadPath(mfile.getOriginalFilename());
			// DAO 메소드 호출
			boardDao.insert(boardVO);
			if(!mfile.isEmpty()){ //업파일 존재하면
			System.out.println("mfile=" + mfile); //파일미선택도 객체 생성
			//if (mfile != null && mfile.getSize() != 0) { 
				String fileName = mfile.getOriginalFilename();// 업된 파일명
				// upload폴더의 물리적인 폴더 절대경로
				// F5 회피(자동 동기화 : 파일이 보이지 X)
				String upath = request.getSession().getServletContext().getRealPath(
						"/upload");
				System.out.println(upath);
				File file = new File(upath + "/" + fileName); // upload폴더 File 객체 생성
				mfile.transferTo(file); // MultipartFile 파일을 File 파일로 upload폴더로 복사
				System.out.println(fileName + " upath" + "에 저장");
				System.out.println("파일크기=" + mfile.getSize() + "바이트");
			}
		//	}
			//RedirectView객체  뷰리졸버를 경유 X
			// 뷰정보(글목록 요청명)만 설정 ,모델에 출력결과 저장 X
			return "redirect:board_list.do";
			//return new ModelAndView(new RedirectView("board_list.do")); 
			
		} catch (Exception e) {

			//return new ModelAndView(formViewName);
			return formViewName;
		}
	}

	//JSR303으로 변환
	//@InitBinder
	// WebDataBinder가 커멘드 객체를 바인딩할때
	/*void initBind(WebDataBinder binder) {
		binder.setValidator(new BoardEntryValidator());

	}*/

}
