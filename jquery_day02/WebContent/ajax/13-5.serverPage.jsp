<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트쪽으로 응답하기위한 xml구현
	out.println("<people>");
	out.println("<person>");
	out.println("<name>장희정</name>");
	out.println("<age>18</age>");
	out.println("<addr>경기도 성남시</addr>");
	out.println("</person>");

	out.println("<person>");
	out.println("<name>오정원</name>");
	out.println("<age>25</age>");
	out.println("<addr>서울시 강북구</addr>");
	out.println("</person>");

	out.println("<person>");
	out.println("<name>김육섭</name>");
	out.println("<age>22</age>");
	out.println("<addr>서울시 강남구</addr>");
	out.println("</person>");

	out.println("</people>");
%>
