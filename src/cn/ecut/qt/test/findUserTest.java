package cn.ecut.qt.test;

import org.apache.ibatis.session.SqlSession;

import cn.ecut.qt.po.User;
import cn.ecut.qt.utils.MybatisUtils;

public class findUserTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
SqlSession session=MybatisUtils.getSession();
User user=session.selectOne("cn.ecut.qt.mapper"+".UserMapper.findUserWithOrders",2);

System.out.println(user);

	}

}
