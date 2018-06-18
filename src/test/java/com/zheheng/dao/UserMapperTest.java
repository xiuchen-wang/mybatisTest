 package com.zheheng.dao;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zheheng.po.User;

public class UserMapperTest {

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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
		
	}
	@Test
	public void testFindUsersByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.findUsersByName("小明");
		System.out.println(userList);
		sqlSession.close();
	}
	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("小酱");
		user.setSex("2");
		user.setBirthday(new Date());
		user.setAddress("大连市");
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testUpdateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(29);
		user.setUsername("王秀忱");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("大连市");
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testDeleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(26);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testfindHashMapResult() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Map<String,String>> userMap = userMapper.findMapUsersByName("小明");
		
		System.out.println(userMap);
		sqlSession.close();
	}
}
