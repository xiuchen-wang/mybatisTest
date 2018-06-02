package com.zheheng.user;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import com.zheheng.po.User;

public class TestInsert {
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
	public void testInsertUser() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setAddress("沈阳市");
		user.setSex("2");
		user.setUsername("喆珩2");
		user.setBirthday(new Date());
		try {
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		System.out.println("用户的id为： "+ user.getId());
	}
}
