package com.mind.web.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mind.web.controller.LoginController;
import com.mind.webapp.commom.dto.LoginDTO;

@Controller
public class LoginControllerImpl extends AbstractBaseController implements
		LoginController {
	@Override
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "access", required = false) String access,
			ModelMap model, HttpServletRequest request) {
		LoginDTO loginDTO = new LoginDTO();
		model.put("loginDTO", loginDTO);
		if ("true".equals(error)) {
			model.put("error",
					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		} else if ("true".equals(logout)) {
			model.put("msg", "You've been logged out successfully.");
		} else if ("false".equals(access)) {
			model.put("msg", "No Access!");
		}
		return new ModelAndView("common/login", model);

	}

	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username or password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username or password!";
		}
		return error;
	}

	@Override
	public ModelAndView displayHomePagelogin(ModelMap model,
			HttpServletRequest request) {
		return new ModelAndView("homePage");
	}

	@Override
	public ResponseEntity<String> invalidSession(ModelMap model,
			HttpServletRequest request) {
		return new ResponseEntity<String>(
				"{\"success\" : false, \"message\" : \"session-expired\"}",
				getJsonHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@Override
	public ModelAndView unauthorized(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("error/accessDeniedPage_403", model);
	}

	@Override
	public ResponseEntity<String> loginFailure(ModelMap model,
			HttpServletRequest request) {
		return new ResponseEntity<String>(
				"{\"success\" : false, \"message\" : \"authentication-failure\"}",
				getJsonHeaders(), HttpStatus.UNAUTHORIZED);
	}

	private HttpHeaders getJsonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return headers;
	}

	@Override
	public String loginUser(LoginDTO loginDTO, HttpServletRequest request,
			ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}

}