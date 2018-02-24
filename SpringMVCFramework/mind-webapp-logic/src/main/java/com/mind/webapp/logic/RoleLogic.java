package com.mind.webapp.logic;

import java.util.List;

import com.mind.webapp.commom.dto.RoleDTO;

public interface RoleLogic {
	
	/**
	 * Method create Role in DB.
	 */
	public boolean save(RoleDTO roleDto);
	
	/**
	 * Method return Role detail against Role Id.
	 */
	public RoleDTO getDetailById(Integer roleId);
	
	/**
	 * Method return List of all Role details.
	 */
	public List<RoleDTO> getList();
	
	/**
	 * Method update Role details
	 */
	public boolean update(RoleDTO roleDto);
	
	/**
	 * Method delete Role from DB against Role Id
	 */
	public boolean delete(Integer roleId);
}
