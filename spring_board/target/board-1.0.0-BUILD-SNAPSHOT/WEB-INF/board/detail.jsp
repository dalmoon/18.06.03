<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function uf() {
		location.href = "board_update.do?seq=${boardVO.seq}";
	}
	function df() {
		location.href = "board/board_delete.do?seq=${boardVO.seq}&blevel=${boardVO.blevel}";
	}
	function lf() {
		location.href = "board_list.do";
	}

	function rf() {
		location.href = "board_insert_reply.do?seq=${boardVO.seq}";
	}
</script>
</head>
<body>
	<h2 align="center">�Խ��� �� �ۺ���</h2>
	<hr />
	<jsp:useBean id="boardVO" type="com.springapp.vo.BoardVO" scope="request" />
	<table border="1">
		<tr>
			<th>�۹�ȣ</th>
			<td>${boardVO.seq}</td>
		</tr>
		<tr>
			<th>������</th>
			<td>${boardVO.title}</td>
		</tr>
		<tr>
			<th>�۳���</th>
			<td>${boardVO.content}</td>
		</tr>
		<tr>
			<th>÷������</th>
			<td>
			
			<a href="file_download.do?fileName=${boardVO.uploadPath}">${boardVO.uploadPath}</a></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="button" value="���"
				onClick="rf()"> <input type="button" value="����"
				onclick="uf()" /> <input type="button" value="����" onclick="df()" />
				<input type="button" value="���" onclick="lf()" /></td>
		</tr>
	</table>
</body>
</html>










