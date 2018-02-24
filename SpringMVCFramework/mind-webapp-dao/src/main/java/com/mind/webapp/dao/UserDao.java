package com.mind.webapp.dao;

import java.util.List;

import com.mind.webapp.dao.bean.User;

public interface UserDao {

	/**
	 * Method return User against User Name.
	 */
	public User getDetaiByUserName(String userName);
	
	/**
	 * Method return List of User in the system. 
	 */
	List<User> getList();

	/**
	 * Method create new user in DB. 
	 */
	boolean save(User user);

	/**
	 * Method delete User from DB. 
	 */
	boolean delete(Integer id);

	/**
	 * Method return User against User Id. 
	 */
	User getById(Integer id);

	/**
	 * Method update user details in DB. 
	 */
	boolean update(User user);
}
