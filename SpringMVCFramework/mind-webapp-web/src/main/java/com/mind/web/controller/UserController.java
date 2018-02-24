package com.mind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mind.webapp.commom.dto.GridData;
import com.mind.webapp.commom.dto.UserDTO;

public interface UserController {

	@RequestMapping(value = "/siteadmin/displayuserlist", method = RequestMethod.GET)
	ModelAndView displayUserList(ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/siteadmin/adduser", method = RequestMethod.GET)
	ModelAndView displayAddUser(ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/admin/edituser/{userId}", method = RequestMethod.GET)
	ModelAndView displayEditUser(@PathVariable("userId") String userId,
			ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/siteadmin/userList", method = RequestMethod.POST)
	public @ResponseBody GridData<UserDTO> userList(ModelMap model,
			HttpServletRequest request);

	@RequestMapping(value = "/siteadmin/saveuser", method = RequestMethod.POST)
	public ModelAndView saveUser(UserDTO userDTO, ModelMap model,
			HttpServletRequest request);

	@RequestMapping(value = "/siteadmin/deleteuser", method = RequestMethod.POST)
	public @ResponseBody String deleteUser(@RequestBody UserDTO user);

	@RequestMapping(value = "/siteadmin/updateuser", method = RequestMethod.POST)
	public ModelAndView updateUser(UserDTO userDTO, ModelMap model,
			HttpServletRequest request);
}
