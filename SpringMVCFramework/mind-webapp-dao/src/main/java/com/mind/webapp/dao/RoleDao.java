package com.mind.webapp.dao;

import java.util.List;

import com.mind.webapp.dao.bean.Role;

public interface RoleDao {
	
	/**
	 * Method create Role in DB.
	 */
	public boolean save(Role role);
	
	/**
	 * Method return Role detail against Role Id.
	 */
	public Role getDetailById(Integer roleId);
	
	/**
	 * Method return List of all Role details.
	 */
	public List<Role> getList();
	
	/**
	 * Method update Role details
	 */
	public boolean update(Role role);
	
	/**
	 * Method delete Role from DB against Role Id
	 */
	public boolean delete(Integer roleId);

}
