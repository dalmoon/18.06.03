<%@page import="java.util.Locale"%>
<%@page import="org.springframework.context.MessageSource"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page contentType="text/html; charset=euc-kr"  
pageEncoding="euc-kr"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>
<spring:message code="message.board.welcome"/> 
<%
//new ClassPathXmlApplicationContext("")
//WAC  설정파일의 Ioc컨테네이너 획득
/* WebApplicationContext context
= WebApplicationContextUtils.getWebApplicationContext(
		session.getServletContext());
//DL
MessageSource messageSource
= (MessageSource)context.getBean("messageSource");
out.print(messageSource.getMessage("message.board.welcome", null, Locale.getDefault()));
 */
%>


</h1>
<h2>
<a href="board_list.do">
<spring:message code="message.board.list.head"/></a>
</h2>
</body>
</html>