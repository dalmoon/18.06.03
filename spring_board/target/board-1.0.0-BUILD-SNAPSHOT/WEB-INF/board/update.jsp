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

//��й�ȣ ��ġ ���� (�������� ����) : ���̺� ��й�ȣ�� �Է� ��й�ȣ ��
var pass=document.getElementById("password").value;
if(pass!="${boardVO.password}"){
	alert("��ȣƲ��");
document.getElementById("password").focus();
return;
}
//��ġ�ϸ� ������ ���� forms[0]: ù��° ���±� ��ü
document.forms[0].submit();//���±�name�� ���

}

</script>
</head>
<body>
<h2 align="center">�Խ��� �� ����</h2>
<hr/>
<form method="post" action="board_update_action.do">
<input type="hidden" name="seq" value="${boardVO.seq}"/> <!-- ������ �� ��ȣ -->
	<table border="1">
		<tr>
			<th>������</th>
			<td><input type="text" name="title" value="${boardVO.title}"/></td>
		</tr>
		<tr>
			<th>�۾���</th>
			<td><input type="text" name="writer" value="${boardVO.writer}"/></td>
		</tr>
		<tr>
			<th>��й�ȣ</th>
			<td><input type="text" name="password" id="password"/></td>
		</tr>
		<tr>
			<th>�۳���</th>
			<td><textarea rows="5" cols="60" name="content" >${boardVO.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="����" onclick="up()"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>










