package com.mind.webapp.commom.dto;

import java.util.Date;

public class RoleDTO {

	private Integer roleId;
	private String roleName;
	private String description;
	private String ip_address;
	private Integer authLevel;
	private Integer status;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	/**
	 * Default Constructor
	 */
	public RoleDTO(){
		
	}
	/**
	 * Parameterized Constructor
	 */
	public RoleDTO(Integer roleId, String roleName, String description, String ip_address,
			Integer authLevel, Integer status, String createdBy, Date createdDate, String updatedBy, Date updatedDate){
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.ip_address = ip_address;
		this.status = status;
		this.authLevel = authLevel;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	/*
	 *  @Return Role Id 
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/*
	 *  @Set Role Id 
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/*
	 *  @Return Role Name 
	 */
	public String getRoleName() {
		return roleName;
	}
	/*
	 *  @Set Role Name 
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/*
	 *  @Return Role Description 
	 */
	public String getDescription() {
		return description;
	}
	/*
	 *  @Set Role Description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * @Return IP Address
	 */
	public String getIp_address() {
		return ip_address;
	}
	/*
	 * @Set IP Address
	 */
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	/*
	 *  @Return Role Auth Level 
	 */
	public Integer getAuthLevel() {
		return authLevel;
	}
	/*
	 *  @Set Role Auth Level 
	 */
	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}
	/*
	 *  @Return Role Status 
	 */
	public Integer getStatus() {
		return status;
	}
	/*
	 *  @Set Role Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/*
	 * @Return Role created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/*
	 * @Set Role created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/*
	 * @Return Role created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/*
	 * @Set Role created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/*
	 * @Return Role updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/*
	 * @Set Role updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/*
	 * @Return Role updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/*
	 * @Set Role updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Override
	public String toString() {
		return "Role Id : "+this.roleId+"\nRole Name : "+this.roleName
				+"\nRole Desc : "+this.description+"\nStatus Id : "+this.status+"\nCreated By : "+this.createdBy+"\nCreated Date : "+this.createdDate
				+"\nUpdated By: "+this.updatedBy+"\nUpdated Date : "+this.updatedDate;
	}
}
