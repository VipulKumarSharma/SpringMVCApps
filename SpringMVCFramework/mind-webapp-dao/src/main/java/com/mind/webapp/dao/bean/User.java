package com.mind.webapp.dao.bean;

public class User {
	 	private int id;
	    private String empCode;
	    private String loginId;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String winUserId;
	    private String domainName;
	    
	    /**
	     * Default constructor
	     */
	    public User(){
	    }
	    
	    /**
	     * Parameterized constructor
	     */	    
		public User(int id, String empCode, String loginId, String password,
				String firstName, String lastName, String email,
				String winUserId, String domainName) {
			super();
			this.id = id;
			this.empCode = empCode;
			this.loginId = loginId;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.winUserId = winUserId;
			this.domainName = domainName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmpCode() {
			return empCode;
		}
		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getWinUserId() {
			return winUserId;
		}
		public void setWinUserId(String winUserId) {
			this.winUserId = winUserId;
		}
		public String getDomainName() {
			return domainName;
		}
		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}
	    
	    
	    
}
