package cn.ecut.qt.test;

import org.apache.ibatis.session.SqlSession;

import cn.ecut.qt.po.Orders;
import cn.ecut.qt.utils.MybatisUtils;

public class TestFindProduct {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
SqlSession session=MybatisUtils.getSession();
Orders orders=session.selectOne("cn.ecut.qt.mapper"+".OrdersMapper.findUserWithProduct",1);
System.out.println(orders);
	}
}
