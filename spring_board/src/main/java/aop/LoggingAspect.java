package aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//aopalliance-1.0.jar , aspectjweaver-1.7.4.jar ��ġ
//@Aspect ������� AOP ����
@Aspect
public class LoggingAspect {
	/*
	 * AOP
�޼ҵ������� ����

����:AspectJ :PointCut

* OOP
------------------------------------------
��ü1 �ٽɸ޼ҵ�(�α�,�ٽ�insert����,Tx) ������
------------------------------------------
��ü2 �ٽɸ޼ҵ�(�α�,�ٽ�update����,Tx)
------------------------------------------
Log ��ü3 ������ ȣ��Ǵ� ����޼ҵ�(�α�)
------------------------------------------
*AOP
Log ����(Aspect)��ü3 ������ : �ݵ��ȣ��Ǵ� ����޼ҵ�(�α�)
------------------------------------------
������ : ����޼ҵ�(Tx)
	 */
	// ������(����=Aspect)
	//1. Advice(������ ȣ������(ȣ��)���� + ����(ȣ��)������)
	//2. JoinPoint(�ٽɱ��) -> PointCut(AspctJ ��� ǥ�������� ����)
	// dao��Ű���� ��� Ŭ������ ��� �޼ҵ� (���ڰ��� 0���̻�)
	//3. aspectj ���Ͻø� DS ��������������(AC)�� ���� 
	//<aop:aspectj-autoproxy/>
	//4. LoggingAspect �� ������ ������ ���
	//<bean class="aop.LoggingAspect"/>
	
	// ����޼ҵ�  before()�� �ٽɸ޼ҵ� dao.*.*(..) ȣ������
	// ������AOP (aspectj-autoproxy)�� ��� �ڵ� ȣ��
	//execution(* dao.*.*(..)) : dao��Ű���� ��� Ŭ������ ��� �޼ҵ�
	//@After("execution(* dao.*.*(..))")
	/*@Before("execution(* com.springapp.dao.*.*(..))")
	public void before(JoinPoint joinPoint) {//JoinPoint
		//toLongString(): JoinPoint �󼼳��� Ȯ��
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		System.out.println("������ before() ����ȣ��");
		System.out.println("������۽ð�" + new Date());
	}*/
	/*
	 * biz��Ű���� ���Ŭ������
   set���� �����ϴ� �޼ҵ�(���ڰ��� 2) ȣ�� ��
   ������۽ð��� ����ϴ� Aspect
   Ŭ���� ����
	 */
	/*@After("execution(* biz.*.set*(*,*))")
	public void doAfter(JoinPoint joinPoint) {	
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		System.out.println("������۽ð�" + new Date());
	}*/
	
	@Around("execution(* com.springapp.dao.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("joinPoint : "+joinPoint.toLongString());		
		
		System.out.println("�ٽɸ޼ҵ������ ������  ����ȣ��");
		System.out.println("������۽ð�" + new Date());
		Object obj= joinPoint.proceed(); //�ٽɸ޼ҵ� ����
		System.out.println("�ٽɸ޼ҵ������ ������  ����ȣ��");
		System.out.println("������۽ð�" + new Date());
		return obj; //�ݵ�� ����
		
	}
	
	
	
	
	

}
