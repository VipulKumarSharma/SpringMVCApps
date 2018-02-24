package com.mind.webapp.logic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mind.webapp.commom.dto.CompanyDTO;
import com.mind.webapp.dao.CompanyDao;
import com.mind.webapp.dao.bean.Company;
import com.mind.webapp.logic.CompanyLogic;

@Component
public class CompanyLogicImpl implements CompanyLogic {

	Logger logger = Logger.getLogger(CompanyLogicImpl.class);

	@Resource
	private CompanyDao companyDao;

	public CompanyDTO getDetailById(Integer companyId) {
		CompanyDTO companyDto = new CompanyDTO();
		BeanUtils.copyProperties(companyDao.getDetailById(companyId),companyDto);
		return companyDto;
	}

	public List<CompanyDTO> getList() {
		List<Company> companyList =  companyDao.getList();
		List<CompanyDTO> companyDtoList = null;
		CompanyDTO companyDto = null;
		if(companyList != null && !companyList.isEmpty()){
			companyDtoList = new ArrayList<CompanyDTO>();
			for(Company company : companyList){
				companyDto = new CompanyDTO();
				BeanUtils.copyProperties(company, companyDto);
				companyDtoList.add(companyDto);
			}
			return companyDtoList;
		}
		return Collections.EMPTY_LIST;
	}

	public boolean update(CompanyDTO companyDto) {
		Company company = new Company();
		BeanUtils.copyProperties(companyDto, company);
		return companyDao.update(company);
	}

	public boolean delete(Integer comapnyId) {
		return companyDao.delete(comapnyId);
	}

	public boolean save(CompanyDTO companyDto) {
		Company company = new Company();
		BeanUtils.copyProperties(companyDto, company);
		return companyDao.save(company);
	}

}
