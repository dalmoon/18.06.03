package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springapp.dao.*;
import com.springapp.vo.BoardVO;

public class BoardEntryValidator implements Validator {

	public boolean supports(Class clazz) {
		return BoardVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object command, Errors errors) {

		BoardVO board = (BoardVO) command;

		// 널값 혹은 공백이 입력된경우
		/*
		 * if ( board.getPassword()==null || board.getPassword().length()==0) {
		 * errors.rejectValue("password", "error.required","암호입력"); //메세지 :
		 * 에러코드+커멘드객체+필드명 }
		 */
		// 널값 혹은 공백이 입력된경우 스프링의 ValidationUtils 사용
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.required", "암호입력");
		// 유효성 검사결과를 담은 errors 객체가 컨츠롤러 메소드의 BindingResult 에 전달
		if (errors.hasErrors()) {
			// 에러가 존재할 경우 메시지 입력 에러 메시지 추가
			errors.reject("error.input"); // 메세지코드 : 에러코드+커멘드객체
		}
	}
}
