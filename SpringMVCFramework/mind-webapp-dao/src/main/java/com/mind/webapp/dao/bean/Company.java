package com.mind.webapp.dao.bean;

import java.util.Date;

public class Company {

	private static final long serialVersionUID = 1L;

	private Integer companyId;
	private String companyName;
	private String companyDesc;
	private Integer status;
	private String ip_address;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	/*
	 * @Default Constructor
	 */
	public Company(){

	}
	/*
	 * @Parametrized Constructor
	 */
	public Company(Integer companyId, String companyName, String companyDecs, String ip_address,
			String createdBy, Date createdDate, String updatedBy, Date updatedDate){
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDesc = companyDecs;
		this.ip_address = ip_address;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	/*
	 * @Return Company Id
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/*
	 * @Set Company Id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/*
	 * @Return Company Name
	 */
	public String getCompanyName() {
		return companyName;
	}
	/*
	 * @Set Company Name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/*
	 * @Return Company Description
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}
	/*
	 * @Set Company Description
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
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
	 *  @Return Company Status 
	 */
	public Integer getStatus() {
		return status;
	}
	/*
	 *  @Set Company Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/*
	 * @Return Company created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/*
	 * @Set Company created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/*
	 * @Return Company created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/*
	 * @Set Company created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/*
	 * @Return Company updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/*
	 * @Set Company updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/*
	 * @Return Company updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/*
	 * @Set Company Description
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "Company Id : "+this.companyId+"\nCompany Name : "+this.companyName
				+"\nCompany Desc : "+this.companyDesc+"\nCreated By : "+this.createdBy+"\nCreated Date : "+this.createdDate
				+"\nUpdated By: "+this.updatedBy+"\nUpdated Date : "+this.updatedDate;
	}
}
