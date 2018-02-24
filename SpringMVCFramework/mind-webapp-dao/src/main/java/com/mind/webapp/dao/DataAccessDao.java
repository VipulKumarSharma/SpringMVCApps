package com.mind.webapp.dao;

import java.util.List;

import com.mind.webapp.dao.bean.DataAccess;

public interface DataAccessDao {
	
	/**
	 * Method create DataAccess in DB.
	 */
	public boolean save(DataAccess dataAccess);
	
	/**
	 * Method return DataAccess detail against DataAccess Id.
	 */
	public DataAccess getDetailById(Integer dataAccessId);
	
	/**
	 * Method return List of all DataAccess details.
	 */
	public List<DataAccess> getList();
	
	/**
	 * Method update DataAccess details
	 */
	public boolean update(DataAccess dataAccess);
	
	/**
	 * Method delete DataAccess from DB against DataAccess Id
	 */
	public boolean delete(Integer dataAccessId);

}
