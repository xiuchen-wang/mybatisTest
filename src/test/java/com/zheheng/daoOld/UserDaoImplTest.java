package com.zheheng.daoOld;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zheheng.daoOld.UserDao;
import com.zheheng.daoOld.UserDaoImpl;
import com.zheheng.po.User;

public class UserDaoImplTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;
	// 创建工厂
	@Before
	public void init() throws Exception {
		
		String resourse = "SqlMapConfig.xml";
		// 加载配置文件到流
		InputStream inputStream =  Resources.getResourceAsStream(resourse);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
