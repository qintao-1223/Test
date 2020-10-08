package cn.ecut.ba01;

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
    定义方法，方法是实现切面功能
    方法定义要求：
        1. 公共方法 public
        2. 方法没有返回值
        3. 方法可以没有参数，也可有
        如果有参数，参数不是自定义的


        @Before:前置通知注解
        属性：value,是切入点表达式，表示切面的功能执行的位置
        位置：在方法的上面
        特点：
            1.在目标方法之前先执行
            2.不会改变目标方法的执行结果
            3.不会影响目标方法的执行

     */
@Before(value = "execution(* cn.ecut.ba01.*.*())")
    public void myBefore(){
        //这是切面要执行的功能代码
        System.out.println("前置通知，在目标方法前输出时间"+new Date());

    }
}
