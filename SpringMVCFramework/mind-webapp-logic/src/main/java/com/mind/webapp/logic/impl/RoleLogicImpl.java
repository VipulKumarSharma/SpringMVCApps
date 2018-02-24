package com.mind.webapp.logic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mind.webapp.commom.dto.RoleDTO;
import com.mind.webapp.dao.RoleDao;
import com.mind.webapp.dao.bean.Role;

@Component
public class RoleLogicImpl {

	Logger logger = Logger.getLogger(RoleLogicImpl.class);

	@Resource
	private RoleDao roleDao;

	public RoleDTO getDetailById(Integer roleId) {
		RoleDTO roleDto = new RoleDTO();
		BeanUtils.copyProperties(roleDao.getDetailById(roleId),roleDto);
		return roleDto;
	}

	public List<RoleDTO> getList() {
		List<Role> roleList =  roleDao.getList();
		List<RoleDTO> roleDtoList = null;
		RoleDTO roleDto = null;
		if(roleList != null && !roleList.isEmpty()){
			roleDtoList = new ArrayList<RoleDTO>();
			for(Role role : roleList){
				roleDto = new RoleDTO();
				BeanUtils.copyProperties(role, roleDto);
				roleDtoList.add(roleDto);
			}
			return roleDtoList;
		}
		return Collections.EMPTY_LIST;
	}

	public boolean update(RoleDTO roleDto) {
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		return roleDao.update(role);
	}

	public boolean delete(Integer comapnyId) {
		return roleDao.delete(comapnyId);
	}

	public boolean save(RoleDTO roleDto) {
		Role role = new Role();
		BeanUtils.copyProperties(roleDto, role);
		return roleDao.save(role);
	}

}
