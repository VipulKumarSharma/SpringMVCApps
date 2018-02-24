package com.mind.webapp.logic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mind.webapp.commom.dto.SiteDTO;
import com.mind.webapp.dao.SiteDao;
import com.mind.webapp.dao.bean.Site;
import com.mind.webapp.logic.SiteLogic;

@Component
public class SiteLogicImpl implements SiteLogic {

	Logger logger = Logger.getLogger(SiteLogicImpl.class);

	@Resource
	private SiteDao siteDao;
	
	public SiteDTO getDetailById(Integer siteId) {
		Site site = siteDao.getDetailById(siteId);
		SiteDTO siteDto = new SiteDTO();
		BeanUtils.copyProperties(site, siteDto);
		return siteDto;
	}

	public List<SiteDTO> getList() {
		List<Site> siteList =  siteDao.getList();
		List<SiteDTO> siteDtoList = null;
		SiteDTO siteDto = null;
		if(siteList != null && !siteList.isEmpty()){
			siteDtoList = new ArrayList<SiteDTO>();
			for(Site site : siteList){
				siteDto = new SiteDTO();
				BeanUtils.copyProperties(site, siteDto);
				siteDtoList.add(siteDto);
			}
			return siteDtoList;
		}
		return Collections.EMPTY_LIST;
	}

	public boolean update(SiteDTO siteDto) {
		Site site = new Site();
		BeanUtils.copyProperties(siteDto, site);
		return siteDao.update(site);
	}

	public boolean delete(Integer siteId) {
		return siteDao.delete(siteId);
	}

	public boolean save(SiteDTO siteDto) {
		Site site = new Site();
		BeanUtils.copyProperties(siteDto, site);
		return siteDao.save(site);
	}

}
