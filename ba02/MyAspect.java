package cn.ecut.ba02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect:表示当前类是切面类
 */
@Component("myaspect")
@Aspect
public class MyAspect {
    /*
    定义方法，方法是实现切面功能
    方法定义要求：
        1. 公共方法 public
        2. 方法没有返回值
        3. 方法有参数，推荐使用Object

          @AfterReturning:后置通知
				属性：1. value 切入点表达式
					  2. returning 自定义的变量，表示目标的返回值、
					  自定义变量名必须和通知方法的形参名一样
				位置：在方法定义的上面
				特点：
					1. 在目标方法之后执行
					2. 能够获取到目标方法的返回值
					3. 可以修改这个返回值
     */
    @AfterReturning(value = "execution(* *..SomeSeriveImpl.doOther(..))",returning = "res")
     public void myAfterReturing(Object res){
        System.out.println("这是后置通知，提交事务");
        System.out.println(res);
     }
}
