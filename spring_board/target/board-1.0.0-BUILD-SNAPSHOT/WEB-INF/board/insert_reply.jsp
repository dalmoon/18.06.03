<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h2 align="center">게시판 답글 등록</h2>
	<hr />


	<form:form method="post" action="board_insert_reply.do"
		enctype="multipart/form-data">
		<form:errors />
		<!-- 4개 정보 컨츠롤러 전달 -->
		<input type=hidden name="seq" value="${board.seq}">
		<input type=hidden name="bref" value="${board.bref}">
		<input type=hidden name="bstep" value="${board.bstep}">
		<input type=hidden name="blevel" value="${board.blevel}">
		<table border="1">
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" value="${board.title}"
					onclick="this.value=''" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" class="password" name="password" />
					<form:errors path="password" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="5" cols="60" name="content"></textarea> <form:errors
						path="content" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="mfile"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록" />
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>










