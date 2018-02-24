package com.mind.webapp.dao;

import java.util.List;
import com.mind.webapp.dao.bean.Site;

public interface SiteDao {
	
	/**
	 * Method create Site in DB.
	 */
	public boolean save(Site site);
	
	/**
	 * Method return Site detail against Site Id.
	 */
	public Site getDetailById(Integer siteId);
	
	/**
	 * Method return List of all site details.
	 */
	public List<Site> getList();
	
	/**
	 * Method update Site details
	 */
	public boolean update(Site site);
	
	/**
	 * Method delete Site from DB against Site Id
	 */
	public boolean delete(Integer siteId);

}
