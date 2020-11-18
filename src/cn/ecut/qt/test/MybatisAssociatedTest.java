package cn.ecut.qt.test;

import org.apache.ibatis.session.SqlSession;

import cn.ecut.qt.po.Person;
import cn.ecut.qt.utils.MybatisUtils;

public class MybatisAssociatedTest {

	public static void main(String[] args) {
		SqlSession session=MybatisUtils.getSession();
		Person person=session.selectOne("cn.ecut.qt.mapper"+".PersonMapper.findPersonById02",2);
		System.out.println(person);
		session.close();
		
	}

}
