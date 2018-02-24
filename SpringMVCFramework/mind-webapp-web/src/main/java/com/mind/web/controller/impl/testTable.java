package com.mind.web.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testTable extends AbstractBaseController {
	
	@RequestMapping(value = "/exm", method = RequestMethod.GET)
	public ModelAndView displayTableScreen(ModelMap model,
			HttpServletRequest request){
		return new ModelAndView("common/User");
	}

}