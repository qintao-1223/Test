package cn.ecut.qt.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import cn.ecut.qt.po.Customer;
/**
 * 入门程序测试类
 */
public class MybatisTest {
	/**
	 * 根据客户编号查询客户信息
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {	
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
                     Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = 
                     new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//1.查询客户
//		Customer customer = sqlSession.selectOne("cn.ecut.qt.mapper"
//			  + ".CustomerMapper.findCustomerById", 2);
//		2.模糊查询
//		List<Customer> customer=sqlSession.selectOne("cn.ecut.qt.mapper" + ".CustomerMapper.findCustomerByName","t");
//		for (Customer customer2 : customer) {
//			System.out.println(customer2);
//		}
		//3.插入
		Customer customer=new Customer();
		customer.setId(4);
		customer.setUsername("xiaohuang");
		customer.setJobs("worker");
		customer.setPhone("1546445");
		int row=sqlSession.insert("cn.ecut.qt.mapper" + ".CustomerMapper.addCustomer",customer);
		System.out.println(customer);
		//4.更新用户
//		customer.setId(3);
//		customer.setUsername("haha");
//		customer.setJobs("worker");
//		customer.setPhone("12388888");
//		int row=sqlSession.update("cn.ecut.qt.mapper" + ".CustomerMapper.updateCustomer",customer);
		//5.删除用户
		//int row=sqlSession.delete("cn.ecut.qt.mapper" + ".CustomerMapper.deleteCustomer",5);
		
		if (row>0) {
			System.out.println("你成功修改了"+row+"条数据！");			
		}
		else {
			System.out.println("执行修改操作失败！！");
		}
		
		//System.out.println(customer);
		sqlSession.commit();
		
		sqlSession.close();
	}
}
	
	
