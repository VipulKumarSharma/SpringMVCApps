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
import com.mind.webapp.dao.DataAccessDao;
import com.mind.webapp.dao.bean.DataAccess;
import com.mind.webapp.dao.util.DatabaseActionEnum;

@Repository
public class DataAccessDaoImpl extends BaseDAO implements DataAccessDao {
	
	Logger logger = Logger.getLogger(DataAccessDaoImpl.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private static final String SPROC_NAME = "PR_DATA_ACCESS_ROLE_MST";
	Map<String, Object> outParamMap;

	@Override
	public boolean save(DataAccess dataAccess) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataAccess getDetailById(Integer dataAccessId) {
		String sql = "SELECT * FROM Data_Access_Role_Mst WHERE DARole_ID = " + dataAccessId;
		List<DataAccess> dataAccessList = jdbcTemplate.query(sql, new DataAccessMapper());
		if(dataAccessList != null && !dataAccessList.isEmpty()){
			return dataAccessList.get(0);
		}
		return null;
	}

	@Override
	public List<DataAccess> getList() {
		String sql = "SELECT * FROM Data_Access_Role_Mst ";
		return (List<DataAccess>)jdbcTemplate.query(sql, new DataAccessMapper());
	}

	@Override
	public boolean update(DataAccess dataAccess) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer dataAccessId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SqlParameterSource getSqlParameterSource(DataAccess dataAccess, Integer dataAccessId, String action){
		final String DATA_ACCESS_ID = "P_Company_ID";
		final String DATA_ACCESS_NAME = "P_company_name";
		final String DATA_ACCESS_DESC = "P_company_desc";
		final String IP_ADDRESS = "P_ip_address";
		final String USER_ID = "P_user_id";
		final String STATUS = "P_status";
		final String ACTION = "P_Action";
		
		SqlParameterSource sqlParameterSource = null;
		if(action.equals(DatabaseActionEnum.INSERT.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(DATA_ACCESS_ID, 0)
			.addValue(DATA_ACCESS_NAME, dataAccess.getDataAccessName())
			.addValue(DATA_ACCESS_DESC, dataAccess.getDescription())
			.addValue(IP_ADDRESS, dataAccess.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}else if(action.equals(DatabaseActionEnum.UPDATE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(DATA_ACCESS_ID, dataAccess.getDataAccessId())
			.addValue(DATA_ACCESS_NAME, dataAccess.getDataAccessName())
			.addValue(DATA_ACCESS_DESC, dataAccess.getDescription())
			.addValue(IP_ADDRESS, dataAccess.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);

		}else if(action.equals(DatabaseActionEnum.DELETE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(DATA_ACCESS_ID, dataAccessId)
			.addValue(DATA_ACCESS_NAME, StringUtils.EMPTY)
			.addValue(DATA_ACCESS_DESC, StringUtils.EMPTY)
			.addValue(IP_ADDRESS, StringUtils.EMPTY)
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}
		return sqlParameterSource;
	}
	
	private final class DataAccessMapper implements RowMapper<DataAccess> {

		@Override
		public DataAccess mapRow(ResultSet rs, int rowNum) throws SQLException {
			DataAccess dataAccess = new DataAccess();
			dataAccess.setDataAccessId(rs.getString("DARole_Id") != null ? rs.getInt("DARole_Id") : null);
			dataAccess.setDataAccessName(rs.getString("DARole_name"));
			dataAccess.setDescription(rs.getString("DARole_desc"));
			dataAccess.setIp_address(rs.getString("ip_address"));
			dataAccess.setStatus(rs.getInt("status_id"));
			dataAccess.setCreatedBy(rs.getString("c_user_id"));
			dataAccess.setCreatedDate(rs.getDate("c_date"));
			dataAccess.setUpdatedBy(rs.getString("u_user_id"));
			dataAccess.setUpdatedDate(rs.getDate("u_date"));
			return dataAccess;
		}
	}

}
