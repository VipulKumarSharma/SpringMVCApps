package com.mind.webapp.dao;

import java.util.List;

import com.mind.webapp.dao.bean.Company;

public interface CompanyDao {
	
	/**
	 * Method create Company in DB.
	 */
	public boolean save(Company comapny);
	
	/**
	 * Method return Company detail against Company Id.
	 */
	public Company getDetailById(Integer companyId);
	
	/**
	 * Method return List of all companies details.
	 */
	public List<Company> getList();
	
	/**
	 * Method update Company details
	 */
	public boolean update(Company comapny);
	
	/**
	 * Method delete Company from DB against Company Id
	 */
	public boolean delete(Integer comapnyId);

}
