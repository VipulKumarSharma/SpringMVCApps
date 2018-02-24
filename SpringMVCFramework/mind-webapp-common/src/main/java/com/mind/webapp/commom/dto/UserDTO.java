package com.mind.webapp.commom.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long userRoleId;
	private String createdBy;
	private Date createdDate;
	private String email;
	private String mobileNumber;
	private String firstName;
	private String lastName;
	private String loginName;
	private String password;
	private String confirmPassword;
	private Boolean passwordSent;
	private Long questionId;
	private String securityAnswer;
	private String status;
	private String updatedBy;
	private String updatedDate;// Timestamp
	private Long departmentId;
	private Long levelId;
	private String salt;
	private String employeeName;
	private List<String> countryCode;
	private List<String> areaCode;
	private List<String> phoneNumber;
	private List<Integer> approverRoleIds;
	private List<String> approverRoleNames;
	private String empCode;
	private String companyId;

	/**
	 * Parameterized constructor
	 */
	public UserDTO(Long userId, Long userRoleId, String createdBy,
			Date createdDate, String email, String firstName,
			String lastName, String loginName, String password,
			Boolean passwordSent, Long questionId, String securityAnswer,
			String status, String updatedBy, String updatedDate,
			Long departmentId, Long levelId, String salt, String employeeName,
			List<String> countryCode, List<String> areaCode,
			List<String> phoneNumber, List<Integer> approverRoleIds,
			List<String> approverRoleNames) {
		super();
		this.userId = userId;
		this.userRoleId = userRoleId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.password = password;
		this.passwordSent = passwordSent;
		this.questionId = questionId;
		this.securityAnswer = securityAnswer;
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.departmentId = departmentId;
		this.levelId = levelId;
		this.salt = salt;
		this.employeeName = employeeName;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.phoneNumber = phoneNumber;
		this.approverRoleIds = approverRoleIds;
		this.approverRoleNames = approverRoleNames;
	}

	/**
	 * Default constructor
	 */
	public UserDTO() {

	}
	/**
	 *return Confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 *set Confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/**
	 *return Company Id
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 *set Company Id
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 *return Employee code
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 *set Employee code
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 *return Mobile No.
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 *set Mobile No.
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 *return User Role Id
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}
	/**
	 *return Approver Role Ids
	 */
	public List<Integer> getApproverRoleIds() {
		return approverRoleIds;
	}
	/**
	 *set Approver Role Ids
	 */
	public void setApproverRoleIds(List<Integer> approverRoleIds) {
		this.approverRoleIds = approverRoleIds;
	}
	/**
	 *return Approver Role Names
	 */
	public List<String> getApproverRoleNames() {
		return approverRoleNames;
	}
	/**
	 *set Approver Role Names
	 */
	public void setApproverRoleNames(List<String> approverRoleNames) {
		this.approverRoleNames = approverRoleNames;
	}
	/**
	 *set User Role Id
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 *return Country codes
	 */
	public List<String> getCountryCode() {
		return countryCode;
	}
	/**
	 *set Country codes
	 */
	public void setCountryCode(List<String> countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 *return Area codes
	 */
	public List<String> getAreaCode() {
		return areaCode;
	}
	/**
	 *set Area codes
	 */
	public void setAreaCode(List<String> areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 *return Phone No.
	 */
	public List<String> getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 *set Phone No.
	 */
	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 *return User Id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 *set User Id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 *return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 *set createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 *return created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 *set created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 *return User email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 *set User email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 *set first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 *return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 *set last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 *return login name
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 *set login name
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 *return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 *return password sent
	 */
	public Boolean getPasswordSent() {
		return passwordSent;
	}
	/**
	 *set password sent
	 */
	public void setPasswordSent(Boolean passwordSent) {
		this.passwordSent = passwordSent;
	}
	/**
	 *return question id
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 *set question id
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	/**
	 *return security answer
	 */
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	/**
	 *set security answer
	 */
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	/**
	 *return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 *set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 *return updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 *set updatedBy
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 *return updated date
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}
	/**
	 *set updated date
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 *return department id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}
	/**
	 *set department id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 *return level id
	 */
	public Long getLevelId() {
		return levelId;
	}
	/**
	 *set level id
	 */
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	/**
	 *return salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 *set salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 *return employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 *set employee name
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
