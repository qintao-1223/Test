package cn.ecut.qt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.org.apache.regexp.internal.recompile;

import cn.ecut.qt.po.Customer;
import cn.ecut.qt.utils.MybatisUtils;


public class MybatisTest02 {
	public static void main(String[] args) throws Exception {
		SqlSession sqlSession=MybatisUtils.getSession(); 
//		Customer customer=new Customer();
//		customer.setId(3);
//		customer.setJobs("maker");
//		List<Customer> customers=sqlSession.selectList("cn.ecut.qt.mapper" + ".CustomerMapper.findCustomerByNameJobs",customer);
//		for (Customer customer2 : customers) {
//			System.out.println(customer2);
//		}
//		int row=sqlSession.update("cn.ecut.qt.mapper" + ".CustomerMapper.updateCustomer",customer);
//		if (row>0) {
//			System.out.println("修改了"+row+"条数据");
//		} else {
//			System.out.println("修改错误！！");
//
//		}
		//foreach使用
//		List<Integer> ids=new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(2);
//		List<Customer> customers=sqlSession.selectList("cn.ecut.qt.mapper" + ".CustomerMapper.findCustomerByIds",ids);
//		for (Customer customer : customers) {
//			System.out.println(customer);
//		}
		//模糊查询
		Customer customer=new Customer();
		customer.setUsername("x");
		List<Customer> customers=sqlSession.selectList("cn.ecut.qt.mapper" + ".CustomerMapper.findCustomerByName",customer);
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		sqlSession.close();
	}

}
