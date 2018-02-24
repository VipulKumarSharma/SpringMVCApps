package com.mind.webapp.logic;

import java.util.List;

import com.mind.webapp.commom.dto.CompanyDTO;

public interface CompanyLogic {
	
	/**
	 * Method create Company in DB.
	 * @param Company Object
	 */
	public boolean save(CompanyDTO comapny);
	
	/**
	 * Method return Company detail against Company Id.
	 * @param companyId
	 * @return CompanyDTO Object
	 */
	public CompanyDTO getDetailById(Integer companyId);
	
	/**
	 * Method return List of all companies details.
	 * @return List of CompanyDTO Object
	 */
	public List<CompanyDTO> getList();
	
	/**
	 * Method update Company details
	 * @param CompanyDTO
	 */
	public boolean update(CompanyDTO dto);
	
	/**
	 * Method delete Company from DB against Company Id
	 * @param comapnyId
	 */
	public boolean delete(Integer comapnyId);

}
