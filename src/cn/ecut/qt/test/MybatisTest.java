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
 * ���ų��������
 */
public class MybatisTest {
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {	
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
                     Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = 
                     new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//1.��ѯ�ͻ�
//		Customer customer = sqlSession.selectOne("cn.ecut.qt.mapper"
//			  + ".CustomerMapper.findCustomerById", 2);
//		2.ģ����ѯ
//		List<Customer> customer=sqlSession.selectOne("cn.ecut.qt.mapper" + ".CustomerMapper.findCustomerByName","t");
//		for (Customer customer2 : customer) {
//			System.out.println(customer2);
//		}
		//3.����
		Customer customer=new Customer();
		customer.setId(4);
		customer.setUsername("xiaohuang");
		customer.setJobs("worker");
		customer.setPhone("1546445");
		int row=sqlSession.insert("cn.ecut.qt.mapper" + ".CustomerMapper.addCustomer",customer);
		System.out.println(customer);
		//4.�����û�
//		customer.setId(3);
//		customer.setUsername("haha");
//		customer.setJobs("worker");
//		customer.setPhone("12388888");
//		int row=sqlSession.update("cn.ecut.qt.mapper" + ".CustomerMapper.updateCustomer",customer);
		//5.ɾ���û�
		//int row=sqlSession.delete("cn.ecut.qt.mapper" + ".CustomerMapper.deleteCustomer",5);
		
		if (row>0) {
			System.out.println("��ɹ��޸���"+row+"�����ݣ�");			
		}
		else {
			System.out.println("ִ���޸Ĳ���ʧ�ܣ���");
		}
		
		//System.out.println(customer);
		sqlSession.commit();
		
		sqlSession.close();
	}
}
	
	
