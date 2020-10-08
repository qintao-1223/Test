package cn.ecut.aspectj.annotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* cn.ecut.jdk.*.*(..))")
	
	private void myPointCut(){}
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ��ģ��ִ��Ȩ�ޣ�");
		System.out.println("Ŀ���ࣺ"+joinPoint.getTarget());
		System.out.println(",��ֲ����ǿ����ķ�����"+joinPoint.getSignature().getName());
		
	}
	
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("����֪ͨ��ģ���¼��־��");
		System.out.println(",��ֲ����ǿ����ķ�����"+joinPoint.getSignature().getName());
	}
		
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) 
            throws Throwable {
		System.out.println("���ƿ�ʼ��ִ��Ŀ��֮ǰ��ģ������ʼ");
		Object object=proceedingJoinPoint.proceed();
		System.out.println("���ƽ�����ִ��Ŀ��֮�󣬽������񡣡�");
		return object;
	}
	
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ��"+"������"+e.getMessage());
	}
	
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("����֪ͨ��ģ��������ͷ���Դ");
	}
}
