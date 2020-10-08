package cn.ecut.aspectj.annotation;
import org.springframework.context.ApplicationContext;
import 
    org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ecut.jdk.UserDao;

public class TestAnnotationAspectj {
	public static void main(String args[]) {
		String xmlPath = 
                  "cn/ecut/aspectj/annotation/applicationContext.xml";
		ApplicationContext applicationContext = 
                 new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		userDao.addUser();
	}
}
