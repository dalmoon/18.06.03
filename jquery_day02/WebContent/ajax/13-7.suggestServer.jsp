<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
   String [] keyWords ={
	    "Ajax" ,"Ajax 실전 프로그래밍" ,
	    "웹프로그래밍","웹마스터","웹디자인",
	    "자바스터디","자바 서비스","자 캔"	,
	    "자라","자바","자바 프로그래밍","자바 서버 페이지"
    };

   // 넘어오는 단어와 keyWords의 첫단어를 비교하여 같으면 ArrayList에 저장하여 리턴한다.
   public ArrayList<String> search(String keyWord){
	   ArrayList<String> list = new ArrayList<String>();
	   
	   for(String compareKeyWord : keyWords){
		   //startsWith메소드는 인수로 들어오는keyWord의 단어 첫글자와 일치하는지 체크
		   if(compareKeyWord.toUpperCase().startsWith(keyWord.toUpperCase())){
			 list.add(compareKeyWord);
		   }
	   }	   
	   return list;
   }


%>

<%
   /*
   클라이언트쪽에서 보내오는 단어를 받아서 서버에 있는 데이터와 비교해서
    첫 단어가 같은 단어를 찾아 클라이언트쪽에 보낸다.
     전송데이터 : 개수|제시어단어,제시어단어,....
   */
    request.setCharacterEncoding("UTF-8");
    String keyWord = request.getParameter("keyWord");
    
    ArrayList<String> list = search(keyWord);
    
    out.print(list.size() + "|");
    for(int i=0; i< list.size() ; i++){
    	String key = list.get(i);
    	out.print(key);
    	if(i < list.size()-1 ) out.print(",");
    }
%>








