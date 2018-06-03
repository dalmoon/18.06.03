<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <!-- ���� �±׶��̺귯��(Ŭ������ �����ϴ� �±� ����) ���� -->  
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
<h2 align="center">�Խ��� �� ���</h2>
<hr/>

<!-- ���� ȭ�� ��½� ��(��û������ ����)����
�𵨸�  board �̸��� Ŀ�ǵ� ��ü �˻�-->
<form:form commandName="board" method="post" 
action="board_insert.do" enctype="multipart/form-data">

	<table border="1">
		<tr>
			<th>������</th>
			<td><input type="text" name="title" value="${board.title}" 
			onclick="this.value=''"/>
			<!-- ������ ����������� BoardVO�� title ������ �����޼����� ���  -->
			<!-- �������� Ŀ���� �±׿��� cssStyle�� CSS ���� --> 
			 <form:errors path="title" cssStyle="color:red;"/></td>
		</tr>
		<tr>
			<th>�۾���</th>
			<td><input type="text" name="writer"/>
			<form:errors path="writer" cssStyle="color:red;"/>
			</td>
		</tr>
	<tr>
					<th>�н�����</th>
					<td>	<input type="password" class="password" 
					name="password" />
					<!-- �������� Ŀ���� �±׿��� cssStyle�� CSS ���� --> 
					<form:errors path="password"   cssStyle="color:red;"/>	
					</td>
				</tr>
		<tr>
			<th>�۳���</th>
			<td><textarea rows="5" cols="60" name="content"></textarea>
			<form:errors path="content" cssStyle="color:red;"/></td>
		</tr>
		<tr>
			<th>÷������</th>
			<td><input type="file" name="mfile">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="���"/>
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>










