package com.mind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mind.webapp.commom.dto.LoginDTO;

@Transactional
public interface LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "access", required = false) String access,
			ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	ModelAndView displayHomePagelogin(ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/auth/session.html", method = RequestMethod.GET)
	ResponseEntity<String> invalidSession(ModelMap model,
			HttpServletRequest request);

	@RequestMapping(value = "/auth/unauthorized", method = RequestMethod.GET)
	ModelAndView unauthorized(ModelMap model, HttpServletRequest request);

	@RequestMapping(value = "/auth/failure.html", method = RequestMethod.GET)
	ResponseEntity<String> loginFailure(ModelMap model,
			HttpServletRequest request);

	@RequestMapping(value = "/auth/loginUser.html", method = RequestMethod.POST)
	String loginUser(LoginDTO loginDTO, HttpServletRequest request,
			ModelMap model);
}
