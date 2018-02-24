package com.mind.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class AuthenticationFailureHandler extends
		ExceptionMappingAuthenticationFailureHandler {
	// private static final String BADATTEMPTMESSAGE =
	// "Invalid Login ID/password";

	public AuthenticationFailureHandler() {
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		// TODO Update failed login attempts and process other rules as per
		// password policy (if any).
		exception.printStackTrace();
		if (exception instanceof SessionAuthenticationException) {
			// TODO
		} else if (exception instanceof BadCredentialsException) {
			BadCredentialsException bce = (BadCredentialsException) exception;

			WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) exception
					.getAuthentication().getDetails();
			//
			// userLogic.updateBadAttempt(exception.getAuthentication().getName());
			//
			// UserLoginDTO userLoginDTO = new UserLoginDTO();
			// userLoginDTO.setLoginId(exception.getAuthentication().getName());
			// userLoginDTO.setStatus(Status.LOGINBADATTEMPT.getValue());
			// userLoginDTO.setRemarks(BADATTEMPTMESSAGE);
			// userLoginDTO.setHostIp(webAuthenticationDetails.getRemoteAddress());
			// userLoginLogic.saveBadAttempt(userLoginDTO);
		}

		// super.onAuthenticationFailure(request, response, exception);
		request.setAttribute("error", true);
		getRedirectStrategy().sendRedirect(request, response, "/?error=true");
	}
}
