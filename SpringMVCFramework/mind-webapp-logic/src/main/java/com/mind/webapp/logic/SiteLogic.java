package com.mind.webapp.logic;

import java.util.List;
import com.mind.webapp.commom.dto.SiteDTO;

public interface SiteLogic {
	
	/**
	 * Method create Site in DB.
	 * @param Site Object
	 */
	public boolean save(SiteDTO site);
	
	/**
	 * Method return Site detail against Site Id.
	 * @param siteId
	 * @return SiteDTO Object
	 */
	public SiteDTO getDetailById(Integer siteId);
	
	/**
	 * Method return List of all site details.
	 * @return List of SiteDTO Object
	 */
	public List<SiteDTO> getList();
	
	/**
	 * Method update Site details
	 * @param SiteDTO
	 */
	public boolean update(SiteDTO dto);
	
	/**
	 * Method delete Site from DB against Site Id
	 * @param siteId
	 */
	public boolean delete(Integer siteId);

}
