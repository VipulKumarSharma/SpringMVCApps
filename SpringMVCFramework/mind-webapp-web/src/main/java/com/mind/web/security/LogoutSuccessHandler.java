package com.mind.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {


	public LogoutSuccessHandler() {
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
System.out.println("Logged Out");
//		if (authentication != null) {
//			WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication
//					.getDetails();
//
//			UserLoginDTO userLoginDTO = new UserLoginDTO();
//			userLoginDTO.setLoginId(authentication.getName());
//			userLoginDTO.setUserSessionId(webAuthenticationDetails
//					.getSessionId());
//			userLoginDTO.setStatus(Status.LOGOUTSUCCESS.getValue());
//			userLoginDTO.setRemarks(" ");
//			userLoginLogic.update(userLoginDTO);
//		}

		super.onLogoutSuccess(request, response, authentication);
	}
}
