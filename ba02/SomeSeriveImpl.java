package cn.ecut.ba02;

import org.springframework.stereotype.Component;

/**
 * 目标类
 */
@Component("target")
public class SomeSeriveImpl implements SomeSerive {
//给doSome方法增加一个功能在目标方法之前添加一个，方法输出时间
    public void doSome() {
        System.out.println("目标方法都Some()");
    }

    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther()");
        return "abc";
    }
}
