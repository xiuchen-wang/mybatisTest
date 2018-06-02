package com.zheheng.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zheheng.po.User;

public interface UserMapper {
	// 测试位置在 test com.zheheng.dao.UserMapperTest.java
	
	// 通过id查找用户
	public User findUserById(int id) throws Exception;
	// 通过用户名模糊查找用户列表
	public List<User> findUsersByName(String username) throws Exception;
	// 插入用户
	public void insertUser(User user) throws Exception;
	// 修改用户信息
	public void updateUser(User user);
	// 删除用户
	public void deleteUser(int id);
	// 返回结果为HashMap
	public List<Map<String, String>> findMapUsersByName(String username) throws Exception; 
}
