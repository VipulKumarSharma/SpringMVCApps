package com.mind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Transactional
public interface HeaderController {

	@RequestMapping(value = "/headerWithMenu", method = RequestMethod.GET)
	ModelAndView displayHeader(ModelMap model, HttpServletRequest request);

}
