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
		System.out.println("前置通知：模拟执行权限！");
		System.out.println("目标类："+joinPoint.getTarget());
		System.out.println(",被植入增强处理的方法："+joinPoint.getSignature().getName());
		
	}
	
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("后置通知：模拟记录日志！");
		System.out.println(",被植入增强处理的方法："+joinPoint.getSignature().getName());
	}
		
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) 
            throws Throwable {
		System.out.println("环绕开始：执行目标之前，模拟事务开始");
		Object object=proceedingJoinPoint.proceed();
		System.out.println("环绕结束：执行目标之后，结束事务。。");
		return object;
	}
	
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常通知："+"出错了"+e.getMessage());
	}
	
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("最终通知：模拟结束后释放资源");
	}
}
