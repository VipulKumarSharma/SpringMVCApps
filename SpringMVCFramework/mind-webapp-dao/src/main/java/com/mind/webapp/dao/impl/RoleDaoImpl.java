package com.mind.webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.mind.webapp.dao.BaseDAO;
import com.mind.webapp.dao.RoleDao;
import com.mind.webapp.dao.bean.Role;
import com.mind.webapp.dao.util.DatabaseActionEnum;
@Repository
public class RoleDaoImpl extends BaseDAO implements RoleDao {
	
	Logger logger = Logger.getLogger(RoleDaoImpl.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private static final String SPROC_NAME = "PR_SYSTEM_ROLE_MST";
	Map<String, Object> outParamMap;

	@Override
	public boolean save(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role getDetailById(Integer roleId) {
		String sql = "SELECT * FROM system_role_Mst WHERE SRole_ID = " + roleId;
		List<Role> roleList = jdbcTemplate.query(sql, new RoleMapper());
		if(roleList != null && !roleList.isEmpty()){
			return roleList.get(0);
		}
		return null;
	}

	@Override
	public List<Role> getList() {
		String sql = "SELECT * FROM system_role_Mst ";
		return (List<Role>)jdbcTemplate.query(sql, new RoleMapper());
	}

	@Override
	public boolean update(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer roleId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private SqlParameterSource getSqlParameterSource(Role role, Integer roleId, String action){
		final String ROLE_ID = "P_SROLE_ID";
		final String ROLE_NAME = "P_SYSTEM_ROLE_NAME";
		final String ROLE_DESC = "P_SYSTEM_ROLE_DESC";
		final String IP_ADDRESS = "P_ip_address";
		final String USER_ID = "P_user_id";
		final String STATUS = "P_status";
		final String ACTION = "P_Action";
		
		SqlParameterSource sqlParameterSource = null;
		if(action.equals(DatabaseActionEnum.INSERT.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(ROLE_ID, 0)
			.addValue(ROLE_NAME, role.getRoleName())
			.addValue(ROLE_DESC, role.getDescription())
			.addValue(IP_ADDRESS, role.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}else if(action.equals(DatabaseActionEnum.UPDATE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(ROLE_ID, role.getRoleId())
			.addValue(ROLE_NAME, role.getRoleName())
			.addValue(ROLE_DESC, role.getDescription())
			.addValue(IP_ADDRESS, role.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);

		}else if(action.equals(DatabaseActionEnum.DELETE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(ROLE_ID, roleId)
			.addValue(ROLE_NAME, StringUtils.EMPTY)
			.addValue(ROLE_DESC, StringUtils.EMPTY)
			.addValue(IP_ADDRESS, StringUtils.EMPTY)
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}
		return sqlParameterSource;
	}
	
	private final class RoleMapper implements RowMapper<Role> {

		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setRoleId(rs.getString("SRole_Id") != null ? rs.getInt("SRole_Id") : null);
			role.setRoleName(rs.getString("System_Role_name"));
			role.setDescription(rs.getString("System_Role_desc"));
			role.setAuthLevel(rs.getInt("auth_level"));
			role.setStatus(rs.getInt("status_id"));
			role.setCreatedBy(rs.getString("c_user_id"));
			role.setCreatedDate(rs.getDate("c_date"));
			role.setUpdatedBy(rs.getString("u_user_id"));
			role.setUpdatedDate(rs.getDate("u_date"));
			return role;
		}
	}

}
