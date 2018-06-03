package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;

import org.apache.log4j.Logger;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//목적 : 요청 실행시간 로그 공통기능
//HandlerInterceptor 기본구현클래스
public class MeasuringInterceptor extends HandlerInterceptorAdapter{
	
    //로그객체 생성
	//Log log= LogFactory.getLog(MeasuringInterceptor.class);
	//Log4J Logger 획득
	Logger logger = Logger.getLogger(MeasuringInterceptor.class);
	//뷰페이지 실행이후 자동 호출(callback)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// TODO Auto-generated method stub
		//로그수준 :정보
		//log.info("MyLog :" +request.getRequestURI() +" 요청 실행시간" +new Date());
		logger.info("MyLog :" +request.getRequestURI() +" 요청 실행시간" +new Date());
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AC 실행전에 preHandle() 호출");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AC 실행후에 preHandle() 호출");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
}
