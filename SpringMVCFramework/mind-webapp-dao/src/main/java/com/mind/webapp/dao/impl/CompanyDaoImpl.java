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
import com.mind.webapp.dao.CompanyDao;
import com.mind.webapp.dao.bean.Company;
import com.mind.webapp.dao.util.DatabaseActionEnum;

@Repository
public class CompanyDaoImpl extends BaseDAO implements CompanyDao {

	Logger logger = Logger.getLogger(CompanyDaoImpl.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private static final String SPROC_NAME = "PR_COMPANY_MST";
	Map<String, Object> outParamMap;
	
	public CompanyDaoImpl() {
	}
	
	public Company getDetailById(Integer companyId) {
		String sql = "SELECT * FROM COMPANY_MST WHERE COMPANY_ID = " + companyId;
		List<Company> companyList = jdbcTemplate.query(sql, new CompanyMapper());
		if(companyList != null && !companyList.isEmpty()){
			return companyList.get(0);
		}
		return null;
	}

	public List<Company> getList() {
		String sql = "SELECT * FROM COMPANY_MST ";
		return (List<Company>)jdbcTemplate.query(sql, new CompanyMapper());
	}

	public boolean save(final Company company) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
				.execute(getSqlParameterSource(company, null, DatabaseActionEnum.INSERT.getName()));
		return true;
	}
	
	public boolean update(final Company company) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
		.execute(getSqlParameterSource(company, null, DatabaseActionEnum.UPDATE.getName()));
		return true;
	}

	public boolean delete(final Integer companyId) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
		.execute(getSqlParameterSource(null, companyId, DatabaseActionEnum.DELETE.getName()));
		return true;
	}

	private SqlParameterSource getSqlParameterSource(Company company, Integer companyId, String action){
		final String COMPANY_ID = "P_Company_ID";
		final String COMPANY_NAME = "P_company_name";
		final String COMPANY_DESC = "P_company_desc";
		final String IP_ADDRESS = "P_ip_address";
		final String USER_ID = "P_user_id";
		final String STATUS = "P_status";
		final String ACTION = "P_Action";
		
		SqlParameterSource sqlParameterSource = null;
		if(action.equals(DatabaseActionEnum.INSERT.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(COMPANY_ID, 0)
			.addValue(COMPANY_NAME, company.getCompanyName())
			.addValue(COMPANY_DESC, company.getCompanyDesc())
			.addValue(IP_ADDRESS, company.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}else if(action.equals(DatabaseActionEnum.UPDATE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(COMPANY_ID, company.getCompanyId())
			.addValue(COMPANY_NAME, company.getCompanyName())
			.addValue(COMPANY_DESC, company.getCompanyDesc())
			.addValue(IP_ADDRESS, company.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);

		}else if(action.equals(DatabaseActionEnum.DELETE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(COMPANY_ID, companyId)
			.addValue(COMPANY_NAME, "")
			.addValue(COMPANY_DESC, "")
			.addValue(IP_ADDRESS, "")
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}
		return sqlParameterSource;
	}
	
	private final class CompanyMapper implements RowMapper<Company> {

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company company = new Company();
			company.setCompanyId(rs.getString("company_id") != null ? rs.getInt("company_id") : null);
			company.setCompanyName(rs.getString("company_name"));
			company.setCompanyDesc(rs.getString("company_desc"));
			company.setIp_address(rs.getString("ip_address"));
			company.setStatus(rs.getInt("status_id"));
			company.setCreatedBy(rs.getString("c_user_id"));
			company.setCreatedDate(rs.getDate("c_date"));
			company.setUpdatedBy(rs.getString("u_user_id"));
			company.setUpdatedDate(rs.getDate("u_date"));
			return company;
		}
	}
}
