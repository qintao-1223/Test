package cn.ecut.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect:表示当前类是切面类
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    /*
    环绕通知定义：
					1. public
					2. 必须有一个返回值，推荐使用Object
					3. 方法有参数，固定的参数 ProceedingJoinPoint

				属性：value 切入点表达式
				特点：
					1. 它是功能最强的通知
					2. 在目标的前和后都能增强功能
					3. 控制目标方法是否被调用
					4. 修改原来目标方法的执行结果，影响最后调用结果
					5. 环绕通知相当于JDK动态代理InvocationHandler接口

				参数：ProceedingJoinPoint 就等同于Method
					作用：执行目标方法
				返回值：就是目标方法的执行结果，可以被修改

     */
@Around(value = "execution(* cn.ecut.ba03.SomeSeriveImpl.First(..))")
    public Object myAround(ProceedingJoinPoint prj) throws Throwable {
    System.out.println("环绕通知之前，开启事务..");
    Object[] args = prj.getArgs();
    Object res=null;
    if (args!=null){
        String str="";
        str=(String) args[0];
        if (str.equals("zhangsan")){
             res = prj.proceed();
        }
    }

    System.out.println("环绕通知之后，提交事务...");
        return res;
    }
}