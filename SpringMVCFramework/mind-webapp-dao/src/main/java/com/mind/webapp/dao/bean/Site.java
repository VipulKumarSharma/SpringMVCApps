package com.mind.webapp.dao.bean;

import java.util.Date;

public class Site {

	private static final long serialVersionUID = 1L;

	private Integer siteId;
	private String siteName;
	private String siteDesc;
	private String ip_address;
	private Integer status;
	private Integer companyId;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	/*
	 * Default Constructor
	 */
	public Site(){

	}
	/*
	 * Parameterized Constructor
	 */
	public Site(Integer siteId, String siteName, String siteDecs, String ip_address,
			Integer companyId, String createdBy, Date createdDate, String updatedBy, Date updatedDate){
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.siteDesc = siteDecs;
		this.ip_address = ip_address;
		this.companyId = companyId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	/*
	 *  Site Id
	 */
	public Integer getSiteId() {
		return siteId;
	}
	/*
	 *  Site Id
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	/*
	 *  Site Name
	 */
	public String getSiteName() {
		return siteName;
	}
	/*
	 *  Site Name
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/*
	 *  Site Description
	 */
	public String getSiteDesc() {
		return siteDesc;
	}
	/*
	 *  Site Description
	 */
	public void setSiteDesc(String siteDesc) {
		this.siteDesc = siteDesc;
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
	 *  @Return Site Status 
	 */
	public Integer getStatus() {
		return status;
	}
	/*
	 *  @Set Site Status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/*
	 *  Associated Company Id
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/*
	 *  Associated Company Id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/*
	 *  Site created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/*
	 *  Site created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/*
	 *  Site created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/*
	 *  Site created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/*
	 *  Site updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/*
	 *  Site updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/*
	 *  Site updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/*
	 *  Site updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "Site Id : "+this.siteId+"\nSite Name : "+this.siteName+"\nSite Desc : "+this.siteDesc
				+"\nAssociated Company Id : "+this.companyId;
	}
}
