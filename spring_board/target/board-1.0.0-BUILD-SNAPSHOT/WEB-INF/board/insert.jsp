<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <!-- 각종 태그라이브러리(클래스에 상응하는 태그 집합) 포함 -->  
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
<h2 align="center">게시판 글 등록</h2>
<hr/>

<!-- 최초 화면 출력시 모델(요청영역에 저장)에서
모델명  board 이름의 커맨드 객체 검색-->
<form:form commandName="board" method="post" 
action="board_insert.do" enctype="multipart/form-data">

	<table border="1">
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" value="${board.title}" 
			onclick="this.value=''"/>
			<!-- 제목이 비워져있으면 BoardVO의 title 변수의 오류메세지가 출력  -->
			<!-- 스프링의 커스텀 태그에는 cssStyle로 CSS 설정 --> 
			 <form:errors path="title" cssStyle="color:red;"/></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type="text" name="writer"/>
			<form:errors path="writer" cssStyle="color:red;"/>
			</td>
		</tr>
	<tr>
					<th>패스워드</th>
					<td>	<input type="password" class="password" 
					name="password" />
					<!-- 스프링의 커스텀 태그에는 cssStyle로 CSS 설정 --> 
					<form:errors path="password"   cssStyle="color:red;"/>	
					</td>
				</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="5" cols="60" name="content"></textarea>
			<form:errors path="content" cssStyle="color:red;"/></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="mfile">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록"/>
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>










