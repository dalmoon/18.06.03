<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="boardVO" class="com.springapp.vo.BoardVO" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function up(){

//비밀번호 일치 검증 (수정권한 검증) : 테이블 비밀번호와 입력 비밀번호 비교
var pass=document.getElementById("password").value;
if(pass!="${boardVO.password}"){
	alert("암호틀림");
document.getElementById("password").focus();
return;
}
//일치하면 서버로 전송 forms[0]: 첫번째 폼태그 객체
document.forms[0].submit();//폼태그name이 없어서

}

</script>
</head>
<body>
<h2 align="center">게시판 글 수정</h2>
<hr/>
<form method="post" action="board_update_action.do">
<input type="hidden" name="seq" value="${boardVO.seq}"/> <!-- 수정할 글 번호 -->
	<table border="1">
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" value="${boardVO.title}"/></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type="text" name="writer" value="${boardVO.writer}"/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="password" id="password"/></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="5" cols="60" name="content" >${boardVO.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" onclick="up()"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>










