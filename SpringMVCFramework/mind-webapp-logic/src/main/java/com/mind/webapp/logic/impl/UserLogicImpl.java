package com.mind.webapp.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mind.webapp.commom.dto.UserDTO;
import com.mind.webapp.dao.UserDao;
import com.mind.webapp.dao.bean.User;
import com.mind.webapp.logic.UserLogic;

@Component
public class UserLogicImpl implements UserLogic {

	Logger logger = Logger.getLogger(UserLogicImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public UserDTO getDetaiByUserName(String userName) {

		User user = userDao.getDetaiByUserName(userName);
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	@Override
	public List<UserDTO> getList() {

		List<User> users = userDao.getList();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserDTO userDTO = null;
		for (User user : users) {
			userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	@Override
	public boolean save(UserDTO userDTO) {

		/*
		 * // PaswordEncoder paswordEncoder = new PaswordEncoder(); long salt =
		 * new Date().getTime(); User user = new User();
		 * user.setUserName(userDTO.getLoginName()); //
		 * user.setPassword(paswordEncoder.encodePassword(userDTO.getPassword(),
		 * // "" + salt));
		 * 
		 * user.setPassword(userDTO.getPassword());
		 * user.setFirstName(userDTO.getFirstName());
		 * user.setLastName(userDTO.getLastName());
		 * user.setEmail(userDTO.getEmail());
		 * user.setMobileno(userDTO.getMobileNumber());
		 * user.setEmpcode(userDTO.getEmpCode());
		 * 
		 * user.setSalt("" + salt);
		 * 
		 * user.setCreatedBy(1); user.setCreatedDate(new Date());
		 * user.setEditedBy(1); user.setEditedDate(new Date());
		 * user.setStatus(10);
		 * 
		 * return userDAO.saveUser(user);
		 */
		return true;

	}

	@Override
	public boolean delete(Integer id) {
		userDao.delete(id);
		return true;
	}

	@Override
	public UserDTO getById(Integer id) {
		User user = userDao.getById(id);
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public boolean update(UserDTO userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		userDao.update(user);
		return true;

	}

}
