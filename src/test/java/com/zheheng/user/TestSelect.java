package com.zheheng.user;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zheheng.po.User;


public class TestSelect {
	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	// 创建工厂
	@Before
	public void init() throws IOException {

		// 配置文件（SqlMapConfig.xml）
		String resource = "SqlMapConfig.xml";
		// 加载配置文件到输入 流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = null;
		try {
			user = sqlSession.selectOne("test.findUserById", 1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(user);
		
	}
	
	@Test
	public void findUsersByName() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = new ArrayList<User>();
		try {
			userList = sqlSession.selectList ("test.findUsersByName", "小明");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(userList.get(0).getUsername());
	}

}
