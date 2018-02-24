package com.mind.web.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mind.webapp.commom.dto.UserDTO;
import com.mind.webapp.commom.dto.UserDetails;
import com.mind.webapp.logic.UserLogic;

public class UserDetailService implements UserDetailsService {
	@Resource
	private UserLogic userInfoLogic;
	static Logger logger = Logger.getLogger(UserDetailService.class.getName());

	@Override
	// @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		UserDTO user = userInfoLogic.getDetaiByUserName(userName);

		// TODO fetch values from db.
		String lastSuccessfulLogin = "05-Nov-2014 5:00:28 PM IST";

		// TODO fetch values from db.
		String lastFailedLogin = "05-Nov-2014 5:00:28 PM IST";

		Collection<SimpleGrantedAuthority> userGrantedAuthorities = new ArrayList<>();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		userGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		ArrayList<String> approverRoles = new ArrayList<String>();
		approverRoles.add("");
		ArrayList<Integer> appriverRolesids = new ArrayList<Integer>();
		appriverRolesids.add(0);

		// authorities.addAll(userGrantedAuthorities);

		UserDetails ud = new UserDetails("" + "1", "Admin", "*******", "12345",
				user.getEmployeeName(), lastSuccessfulLogin, lastFailedLogin,
				true, true, true, true, authorities, userGrantedAuthorities,
				user.getEmail(), user.getFirstName(), user.getLastName(),
				appriverRolesids, approverRoles);
		return ud;

	}
}
