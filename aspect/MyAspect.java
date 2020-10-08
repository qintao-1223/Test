package cn.ecut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public  void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知：模拟执行权限检查....");
        System.out.println("目标类是："+ joinPoint.getTarget());
        System.out.println("增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知：模拟记录日志....");
        System.out.println("增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始：执行目标方法之前，模拟开启是事务...");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标之后，模拟事务关闭...");
        return proceed;
    }
}
