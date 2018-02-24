package com.mind.webapp.commom.dto;

import java.util.Date;

public class DataAccessDTO {

	private Integer dataAccessId;
	private String dataAccessName;
	private String description;
	private String ip_address;
	private Integer status;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	/**
	 * Default Constructor
	 */
	public DataAccessDTO(){

	}
	/**
	 * Parameterized Constructor
	 */
	public DataAccessDTO(Integer dataAccessId, String dataAccessName, String description, String ip_address,
			Integer status, String createdBy, Date createdDate, String updatedBy, Date updatedDate){
		this.dataAccessId = dataAccessId;
		this.dataAccessName = dataAccessName;
		this.description = description;
		this.ip_address = ip_address;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	/*
	 *  @Return Data Access Id 
	 */
	public Integer getDataAccessId() {
		return dataAccessId;
	}
	/*
	 *  @Set Data Access Id 
	 */
	public void setDataAccessId(Integer dataAccessId) {
		this.dataAccessId = dataAccessId;
	}
	/*
	 *  @Return Data Access Name 
	 */
	public String getDataAccessName() {
		return dataAccessName;
	}
	/*
	 *  @Set Data Access Name 
	 */
	public void setDataAccessName(String dataAccessName) {
		this.dataAccessName = dataAccessName;
	}
	/*
	 *  @Return Data Access Description 
	 */
	public String getDescription() {
		return description;
	}
	/*
	 *  @Set Data Access Description 
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
	 *  @Return Data Access Status 
	 */
	public Integer getStatus() {
		return status;
	}
	/*
	 *  @Set Data Access Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/*
	 * @Return Data Access created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/*
	 * @Set Data Access created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/*
	 * @Return Data Access created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/*
	 * @Set Data Access created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/*
	 * @Return Data Access updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/*
	 * @Set Data Access updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/*
	 * @Return Data Access updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/*
	 * @Set Data Access updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Data Access Id : "+this.dataAccessId+"\nData Access Name : "+this.dataAccessName
				+"\nData Access Desc : "+this.description+"\nStatus Id : "+this.status+"\nCreated By : "+this.createdBy+"\nCreated Date : "+this.createdDate
				+"\nUpdated By: "+this.updatedBy+"\nUpdated Date : "+this.updatedDate;
	}
}
