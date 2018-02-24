package com.mind.webapp.logic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mind.webapp.commom.dto.DataAccessDTO;
import com.mind.webapp.dao.DataAccessDao;
import com.mind.webapp.dao.bean.DataAccess;

@Component
public class DataAccessLogicImpl {

	Logger logger = Logger.getLogger(DataAccessLogicImpl.class);

	@Resource
	private DataAccessDao dataAccessDao;

	public DataAccessDTO getDetailById(Integer dataAccessId) {
		DataAccessDTO daDto = new DataAccessDTO();
		BeanUtils.copyProperties(dataAccessDao.getDetailById(dataAccessId),daDto);
		return daDto;
	}

	public List<DataAccessDTO> getList() {
		List<DataAccess> dataAccessList =  dataAccessDao.getList();
		List<DataAccessDTO> daDtoList = null;
		DataAccessDTO daDto = null;
		if(dataAccessList != null && !dataAccessList.isEmpty()){
			daDtoList = new ArrayList<DataAccessDTO>();
			for(DataAccess da : dataAccessList){
				daDto = new DataAccessDTO();
				BeanUtils.copyProperties(da, daDto);
				daDtoList.add(daDto);
			}
			return daDtoList;
		}
		return Collections.EMPTY_LIST;
	}

	public boolean update(DataAccessDTO dataAccessDto) {
		DataAccess da = new DataAccess();
		BeanUtils.copyProperties(dataAccessDto, da);
		return dataAccessDao.update(da);
	}

	public boolean delete(Integer dataAccessId) {
		return dataAccessDao.delete(dataAccessId);
	}

	public boolean save(DataAccessDTO dataAccessDto) {
		DataAccess da = new DataAccess();
		BeanUtils.copyProperties(dataAccessDto, da);
		return dataAccessDao.save(da);
	}

}
