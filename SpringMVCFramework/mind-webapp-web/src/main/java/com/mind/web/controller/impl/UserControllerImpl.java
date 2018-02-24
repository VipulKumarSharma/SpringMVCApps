package com.mind.web.controller.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mind.web.controller.UserController;
import com.mind.webapp.commom.dto.GridData;
import com.mind.webapp.commom.dto.UserDTO;
import com.mind.webapp.logic.UserLogic;

@Controller
public class UserControllerImpl extends AbstractBaseController implements
		UserController {

	@Resource
	UserLogic userLogic;
	

	@Override
	public ModelAndView displayUserList(ModelMap model,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new ModelAndView("userList");
	}

	@Override
	public @ResponseBody
	GridData<UserDTO> userList(ModelMap model, HttpServletRequest request) {
		List<UserDTO> dtos = userLogic.getList();
		return new GridData<UserDTO>(dtos, 0, 100, dtos.size());
	}

	@Override
	public ModelAndView displayAddUser(ModelMap model,
			HttpServletRequest request) {

		UserDTO userDTO = new UserDTO();
		model.put("userDTO", userDTO);
		model.put("page", "add");

		return new ModelAndView("addUser", model);
	}

	@Override
	public ModelAndView saveUser(UserDTO userDTO, ModelMap model,
			HttpServletRequest request) {
		boolean status = userLogic.save(userDTO);
		if (status) {
			// return GeneratedResponse.getGeneratedResponse("success", true);
		} else {
			// return GeneratedResponse.getGeneratedResponse("error", false);
		}
		return new ModelAndView("redirect:/siteadmin/displayuserlist");
	}

	@Override
	public String deleteUser(@RequestBody UserDTO user) {
		try {
			Long id = new Long(user.getUserId());
			boolean status = userLogic.delete(id.intValue());
			if (status) {
			//	return GeneratedResponse.getGeneratedResponse("success", true);
			} else {
		//		return GeneratedResponse.getGeneratedResponse("error", false);
			}
		} catch (Exception e) {
		//	return GeneratedResponse.getGeneratedResponse("error", false);
		}
		return "{'a':'aa'}";
	}

	@Override
	public ModelAndView displayEditUser(@PathVariable("userId") String userId,
			ModelMap model, HttpServletRequest request) {

		Integer id = new Integer(userId);
		UserDTO userDTO = userLogic.getById(id);
		model.put("userDTO", userDTO);
		model.put("page", "edit");
		return new ModelAndView("addUser", model);
	}

	@Override
	public ModelAndView updateUser(UserDTO userDTO, ModelMap model,
			HttpServletRequest request) {
		boolean status = userLogic.update(userDTO);
		if (status) {
			// return GeneratedResponse.getGeneratedResponse("success", true);
		} else {
			// return GeneratedResponse.getGeneratedResponse("error", false);
		}
		return new ModelAndView("redirect:/siteadmin/displayuserlist");
	}

}
