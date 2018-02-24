package com.mind.webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.mind.webapp.dao.BaseDAO;
import com.mind.webapp.dao.UserDao;
import com.mind.webapp.dao.bean.User;
import com.mind.webapp.dao.util.DatabaseActionEnum;
@Repository
public class UserDaoImpl extends BaseDAO implements UserDao {

	Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private static final String SPROC_NAME = "PROC_FW_USER_INFO_MST";
	Map<String, Object> outParamMap;

	

	public User getDetaiByUserName(String userName) {
		String sql = "SELECT * FROM user_info_mst WHERE login_id='" + userName+"'";
		return (User) jdbcTemplate.query(sql, new UserMapper()).get(0);
	}

	@Override
	public List<User> getList() {
		String sql = "SELECT * FROM user_info_mst";
		return (List<User>) jdbcTemplate.query(sql, new UserMapper());
	}
	
	@Override
	public User getById(Integer id) {
		String sql = "SELECT * FROM user_info_mst WHERE User_Info_ID = " + id;
		return (User) jdbcTemplate.query(sql, new UserMapper()).get(0);
	}

	@Override
	public boolean save(User user) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
				.execute(getSqlParameterSource(user, null, DatabaseActionEnum.INSERT.getName()));
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
				.execute(getSqlParameterSource(null, id, DatabaseActionEnum.DELETE.getName()));
		return true;
	}

	@Override
	public boolean update(User user) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
				.execute(getSqlParameterSource(user, null, DatabaseActionEnum.UPDATE.getName()));
		return true;
	}

	private SqlParameterSource getSqlParameterSource(User user, Integer userInfoId, String action){
		final String USER_INFO_ID = "P_User_Info_ID";
		final String EMP_CODE = "P_Emp_Code";
		final String LOGIN_ID = "P_Login_ID";
		final String PASSWORD = "P_Password";
		final String FIRST_NAME = "P_First_Name";
		final String LAST_NAME = "P_Last_Name";
		final String EMAIL =" P_Email";
		final String WIN_USER_ID = "P_Win_User_ID";
		final String DOMAIN_NAME = "P_Domain_Name";
		final String ACTION = "P_Action";
		final String USER_ID = "P_User_ID";
		final String STATUS = "P_Status";
		
		SqlParameterSource sqlParameterSource = null;
		if(action.equals(DatabaseActionEnum.INSERT.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(USER_INFO_ID, 0)
			.addValue(EMP_CODE, user.getEmpCode())
			.addValue(LOGIN_ID, user.getLoginId())
			.addValue(PASSWORD, user.getPassword())
			.addValue(FIRST_NAME, user.getFirstName())
			.addValue(LAST_NAME, user.getLastName())
			.addValue(EMAIL, user.getEmail())
			.addValue(WIN_USER_ID, user.getWinUserId())
			.addValue(DOMAIN_NAME, user.getDomainName())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}else if(action.equals(DatabaseActionEnum.UPDATE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(USER_INFO_ID, user.getId())
			.addValue(EMP_CODE, user.getEmpCode())
			.addValue(LOGIN_ID, user.getLoginId())
			.addValue(PASSWORD, user.getPassword())
			.addValue(FIRST_NAME, user.getFirstName())
			.addValue(LAST_NAME, user.getLastName())
			.addValue(EMAIL, user.getEmail())
			.addValue(WIN_USER_ID, user.getWinUserId())
			.addValue(DOMAIN_NAME, user.getDomainName())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);

		}else if(action.equals(DatabaseActionEnum.DELETE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(USER_INFO_ID, userInfoId)
			.addValue(EMP_CODE, "")
			.addValue(LOGIN_ID, "")
			.addValue(PASSWORD, "")
			.addValue(FIRST_NAME, "")
			.addValue(LAST_NAME, "")
			.addValue(EMAIL, "")
			.addValue(WIN_USER_ID, "")
			.addValue(DOMAIN_NAME, "")
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}
		return sqlParameterSource;
	}
	
	private final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("user_info_id"));
			user.setEmpCode(rs.getString("emp_code"));
			user.setLoginId(rs.getString("login_id"));
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setWinUserId(rs.getString("win_user_id"));
			user.setDomainName(rs.getString("domain_name"));
			return user;
		}
	}
}
