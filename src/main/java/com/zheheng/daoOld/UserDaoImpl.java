package com.zheheng.daoOld;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zheheng.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
	// sqlSessionfactory注入
	UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = null;
		user = sqlSession.selectOne("test.findUserById", 1);
		sqlSession.close();
		return user;
	}

}
