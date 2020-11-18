package cn.ecut.qt.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	private static SqlSessionFactory sessionFactory =null;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			sessionFactory =new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}				
	}
public static SqlSession getSession() {
	return sessionFactory.openSession();
}	
}

