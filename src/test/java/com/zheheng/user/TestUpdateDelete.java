package com.zheheng.user;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zheheng.po.User;

public class TestUpdateDelete {
	// 会话工场
	private SqlSessionFactory sqlSessionFactory;
	
	// 创建工厂
	@Before
	public void init() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(28);
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("karry");
		user.setAddress("上海市");
		try {
			
			sqlSession.update("test.updateUser", user);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("test.deleteUser",10 );
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}
