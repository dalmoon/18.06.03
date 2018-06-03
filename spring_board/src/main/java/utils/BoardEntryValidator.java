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

		// �ΰ� Ȥ�� ������ �ԷµȰ��
		/*
		 * if ( board.getPassword()==null || board.getPassword().length()==0) {
		 * errors.rejectValue("password", "error.required","��ȣ�Է�"); //�޼��� :
		 * �����ڵ�+Ŀ��尴ü+�ʵ�� }
		 */
		// �ΰ� Ȥ�� ������ �ԷµȰ�� �������� ValidationUtils ���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.required", "��ȣ�Է�");
		// ��ȿ�� �˻����� ���� errors ��ü�� �����ѷ� �޼ҵ��� BindingResult �� ����
		if (errors.hasErrors()) {
			// ������ ������ ��� �޽��� �Է� ���� �޽��� �߰�
			errors.reject("error.input"); // �޼����ڵ� : �����ڵ�+Ŀ��尴ü
		}
	}
}
