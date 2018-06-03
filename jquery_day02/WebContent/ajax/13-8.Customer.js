$(document).ready(function(){
	
	  //여러 ajax에서 동일하게 사용 되는 속성 global로 설정
	   $.ajaxSetup({
		   contentType:'application/x-www-form-urlencoded;charset=UTF-8',
		   type: "post"
       });
	   
	 //모든 레코드 가져오기
	   function getData(){
		   $.ajax({
			 //url은 /프로젝트명/servlet문서에서 정의한 @WebServlet의 urlpattern
	           url: "/jQuery_Ajax_Book/CustomerSelectServlet",
	           dataType: "xml", // 결과데이터 타입
	           success: function (data) { 
	        	   $("#listTable tr:gt(0)").remove();//테이블의 첫행을 제외하고 모두 제거한다.
	 			     var table="";
	 			     $(data).find('customer').each(function (index) {//customer element를 찾아서
	                     table+="<tr>"
	                     table+="<td>"+$(this).find("no").text() +"</td>"
	                     table+="<td>"+$(this).find("id").text()+"</td>"
	                     table+="<td>"+$(this).find("name").text()+"</td>"
	                     table+="<td>"+$(this).find("age").text()+"</td>"
	                     table+="<td>"+$(this).find("tel").text()+"</td>"
	                     table+="<td>"+$(this).find("addr").text()+"</td>"
	                     table+="<td id='tdDel'><input type='button' value='삭제' id='del' name='"+$(this).find("no").text()+"'></td>"
	                     table+="</tr>"
	 			    	 
	 			     })
	 			     $("#listTable tr:eq(0)").after(table);//테이블의 첫번째 행 뒤에 table 추가한다.
	 			    
	           },
	          error: function (data) { alert(data+'=> 에러 발생'); }
	        });//ajax끝
		   
	   }//getData()함수끝
	   
	   
	 //Id중복체크하기
	   $("#id").keyup(function(){
		   $.ajax({
	           url: "/jQuery_Ajax_Book/CustomerIdCheckServlet", 
	            dataType: "text", // 결과데이터 타입
	           data:"id="+$("#id").val(),
	           success: function (data) { 
	       	    $("span").html(data); 				
	           },
	           error: function (data) { alert(data+'=> 에러 발생'); }
	       }); //ajax끝
	   });//keyup 끝
	 
	   
	   //가입하기를 클릭했을때
	   $("#btn").click(function(){
		   $.ajax({ 
	           url: "/jQuery_Ajax_Book/CustomerInsertServlet",
	           dataType: "text", // 결과데이터 타입 
	           data: $("#inForm").serialize(),
	           success: function (data) { 
	 			    if(data>0){
	 			    	alert("가입되었습니다.")
	 			    	getData();//가입완료 후 다시 레코드 검색하기
	 			    	
	 			    	//input태그 중 속성 type=text 태그를 찾아서 모두 text value를 지운다.
	 			    	$("input[type=text]").each(function(){
	 			    		  $(this).val("");
	 			    	});
	 			    }else{
	 			    	alert("가입되지 않았습니다..")
	 			    }
	 			    		
	           },
	           error: function (data) { alert(data+'=> 에러 발생'); }
	       }); //ajax끝
		   
	   })//clic끝
	   
	 
	   
	   
	  
	   /*삭제를 클릭했을때
	      삭제 버튼은 동적으로 생성된 요소이므로 on()함수 사용해야한다.
	    */
	   $("table").on("click" ,'#del', function(){
		  $.ajax({ 
	           url: "/jQuery_Ajax_Book/CustomerDelServlet",
	           dataType: "text", // 결과데이터 타입 
	           data:"no=" + $(this).attr("name"),
	           success: function (data) { 
	 			    if(data>0){
	 			    	alert("삭제되었습니다.")
	 			    	getData();//삭제완료 후 다시 레코드 검색하기
	 			    	
	 			    }else{
	 			    	alert("삭제되지 않았습니다..")
	 			    }
	 			    		
	           },
	           error: function (data) { alert(data+'=> 에러 발생'); }
	       }); //ajax끝
	       
	   })
	   
	   
	   getData(); //onLoad되면 레코드 가져오기
	   
   })//ready끝