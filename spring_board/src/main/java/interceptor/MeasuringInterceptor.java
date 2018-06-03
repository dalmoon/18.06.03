package interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;

import org.apache.log4j.Logger;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//���� : ��û ����ð� �α� ������
//HandlerInterceptor �⺻����Ŭ����
public class MeasuringInterceptor extends HandlerInterceptorAdapter{
	
    //�αװ�ü ����
	//Log log= LogFactory.getLog(MeasuringInterceptor.class);
	//Log4J Logger ȹ��
	Logger logger = Logger.getLogger(MeasuringInterceptor.class);
	//�������� �������� �ڵ� ȣ��(callback)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// TODO Auto-generated method stub
		//�α׼��� :����
		//log.info("MyLog :" +request.getRequestURI() +" ��û ����ð�" +new Date());
		logger.info("MyLog :" +request.getRequestURI() +" ��û ����ð�" +new Date());
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AC �������� preHandle() ȣ��");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AC �����Ŀ� preHandle() ȣ��");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
}
