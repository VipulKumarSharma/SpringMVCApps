package com.mind.webapp.logic;

import java.util.List;

import com.mind.webapp.commom.dto.UserDTO;

public interface UserLogic {

	public UserDTO getDetaiByUserName(String userName);
	List<UserDTO> getList();

	boolean save(UserDTO userDTO);

	boolean delete(Integer id);

	UserDTO getById(Integer id);

	boolean update(UserDTO userDTO);
	
}
