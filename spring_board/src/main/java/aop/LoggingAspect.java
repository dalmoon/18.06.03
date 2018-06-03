package aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//aopalliance-1.0.jar , aspectjweaver-1.7.4.jar 설치
//@Aspect 기반으로 AOP 구현
@Aspect
public class LoggingAspect {
	/*
	 * AOP
메소드의존성 관리

조건:AspectJ :PointCut

* OOP
------------------------------------------
객체1 핵심메소드(로그,핵심insert연산,Tx) 의존성
------------------------------------------
객체2 핵심메소드(로그,핵심update연산,Tx)
------------------------------------------
Log 객체3 선택적 호출되는 공통메소드(로그)
------------------------------------------
*AOP
Log 관점(Aspect)객체3 의존성 : 반드시호출되는 공통메소드(로그)
------------------------------------------
의존성 : 공통메소드(Tx)
	 */
	// 공통기능(관심=Aspect)
	//1. Advice(공통기능 호출주입(호출)시점 + 주입(호출)공통기능)
	//2. JoinPoint(핵심기능) -> PointCut(AspctJ 언어 표현식으로 서술)
	// dao패키지의 모든 클래스의 모든 메소드 (인자개수 0개이상)
	//3. aspectj 프록시를 DS 스프링설정파일(AC)에 설정 
	//<aop:aspectj-autoproxy/>
	//4. LoggingAspect 를 스프링 빈으로 등록
	//<bean class="aop.LoggingAspect"/>
	
	// 공통메소드  before()를 핵심메소드 dao.*.*(..) 호출전에
	// 스프링AOP (aspectj-autoproxy)가 대신 자동 호출
	//execution(* dao.*.*(..)) : dao패키지의 모든 클래스의 모든 메소드
	//@After("execution(* dao.*.*(..))")
	/*@Before("execution(* com.springapp.dao.*.*(..))")
	public void before(JoinPoint joinPoint) {//JoinPoint
		//toLongString(): JoinPoint 상세내용 확인
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		System.out.println("공통기능 before() 주입호출");
		System.out.println("실행시작시간" + new Date());
	}*/
	/*
	 * biz패키지의 모든클래스의
   set으로 시작하는 메소드(인자개수 2) 호출 후
   실행시작시간을 출력하는 Aspect
   클래스 구현
	 */
	/*@After("execution(* biz.*.set*(*,*))")
	public void doAfter(JoinPoint joinPoint) {	
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		System.out.println("실행시작시간" + new Date());
	}*/
	
	@Around("execution(* com.springapp.dao.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		
		System.out.println("핵심메소드실행전 공통기능  주입호출");
		System.out.println("실행시작시간" + new Date());
		Object obj= joinPoint.proceed(); //핵심메소드 실행
		System.out.println("핵심메소드실행후 공통기능  주입호출");
		System.out.println("실행시작시간" + new Date());
		return obj; //반드시 리턴
		
	}
	
	
	
	
	

}
