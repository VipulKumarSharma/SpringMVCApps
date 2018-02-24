package com.mind.webapp.logic;

import java.util.List;

import com.mind.webapp.commom.dto.DataAccessDTO;

public interface DataAccessLogic {
	
	/**
	 * Method create DataAccess in DB.
	 */
	public boolean save(DataAccessDTO dataAccessDto);
	
	/**
	 * Method return DataAccess detail against Company Id.
	 */
	public DataAccessDTO getDetailById(Integer dataAccessId);
	
	/**
	 * Method return List of all DataAccess details.
	 */
	public List<DataAccessDTO> getList();
	
	/**
	 * Method update DataAccess details
	 */
	public boolean update(DataAccessDTO dataAccessDto);
	
	/**
	 * Method delete DataAccess from DB against DataAccess Id
	 */
	public boolean delete(Integer dataAccessId);
}
