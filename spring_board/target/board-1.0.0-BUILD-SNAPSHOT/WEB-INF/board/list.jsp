<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.springapp.vo.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" 
content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">�Խ��� ����Ʈ</h2>
<hr/>
<input type="button" value="�۾���" 
onclick="location.href='board_insert.do';"/>
<br/><br/>
<table border="1">    
	<tr>
		<th>��ȣ</th><th>����</th>
		<th>�����</th><th>�����</th>
	</tr>

<c:forEach var="vo" items="${boardList}">
	<tr>
		<td>${vo.seq}</td>
		<td>
		<!--  �鿩���� ���� =����ΰ� -->
		<c:set var="lev" value="${vo.blevel }"/>
				<c:forEach var="k" begin="1" end="${lev}" step="1">
				&nbsp;&nbsp;
				</c:forEach>
				<!-- ��۸� �鿩����� ȭ��ǥ ǥ��(������ �鿩���� 0) -->
				<c:if test="${lev>0 }">
				->
				</c:if>
			<a href="board_detail.do?seq=${vo.seq}">
			${vo.title}</a>	
		</td>
		<td>${vo.writer}</td>
		<td>${vo.regdate}</td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>










