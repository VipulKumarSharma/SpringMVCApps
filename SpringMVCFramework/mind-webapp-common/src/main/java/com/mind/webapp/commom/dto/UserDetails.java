package com.mind.webapp.commom.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetails extends User {

	private static final long serialVersionUID = 1L;

	private final String loginId;
	private final String salt;
	private final String lastSuccessfulLogin;
	private final String lastFailedLogin;
	private final String displayName;
	private final Collection<? extends GrantedAuthority> userGrantedAuthorities;
	private final String emailAddress;
	private final String firstName;
	private final String lastName;
	private final List<Integer> approverRoleIds;
	private final List<String> approverRoleNames;

	public UserDetails(String userId, String loginId, String password,
			String salt, String displayName, String lastSuccessfulLogin,
			String lastFailedLogin, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			Collection<? extends GrantedAuthority> userGrantedAuthorities,
			String emailAddress, String firstName, String lastName,
			List<Integer> approverRoleIds, List<String> approverRoleNames) {

		super(userId, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

		this.loginId = loginId;
		this.salt = salt;
		this.lastSuccessfulLogin = lastSuccessfulLogin;
		this.lastFailedLogin = lastFailedLogin;
		this.displayName = displayName;
		this.userGrantedAuthorities = userGrantedAuthorities;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.approverRoleIds = approverRoleIds;
		this.approverRoleNames = approverRoleNames;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getSalt() {
		return salt;
	}

	public String getLastSuccessfulLogin() {
		return lastSuccessfulLogin;
	}

	public String getLastFailedLogin() {
		return lastFailedLogin;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Collection<? extends GrantedAuthority> getUserGrantedAuthorities() {
		return userGrantedAuthorities;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Integer> getApproverRoleIds() {
		return approverRoleIds;
	}

	public List<String> getApproverRoleNames() {
		return approverRoleNames;
	}

	

}
