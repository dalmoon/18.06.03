package jpub.ajax.ex13_4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 13-3. htm과 연동
 */

@WebServlet("/PostSendServlet")
public class PostSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   // 그림파일명 배열
		   String img [] ={"spring.jpg" ,"android.jpg","jquery.jpg","jsmasterbook.jpg"};
		   //"2"
		  String book = request.getParameter("book");
		  //2
		  int bookIndex = Integer.parseInt(book);
		  //응답(출력)데이터  jquery.jpg
		  out.print(img[bookIndex]); //img[0] ="spring.jpg"		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	}
	
	

}
