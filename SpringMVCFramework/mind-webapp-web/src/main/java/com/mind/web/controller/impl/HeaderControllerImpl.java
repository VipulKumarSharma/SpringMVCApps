package com.mind.web.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.mind.web.controller.HeaderController;
import com.mind.webapp.commom.dto.UserDetails;

@Controller
public class HeaderControllerImpl extends AbstractBaseController implements
		HeaderController {
	Logger logger = Logger.getLogger(HeaderControllerImpl.class);

	@Override
	public ModelAndView displayHeader(ModelMap model, HttpServletRequest request) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String loginUser = userDetails.getDisplayName();
		model.put("loginUser", loginUser);
		System.out.println("IN Header");
		return new ModelAndView("common/headerWithMenu", model);
	}
}