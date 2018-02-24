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
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.mind.webapp.dao.BaseDAO;
import com.mind.webapp.dao.SiteDao;
import com.mind.webapp.dao.bean.Site;
import com.mind.webapp.dao.util.DatabaseActionEnum;

@Repository
public class SiteDaoImpl extends BaseDAO implements SiteDao {

	Logger logger = Logger.getLogger(SiteDaoImpl.class);

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private static final String SPROC_NAME = "PR_SITE_MST";
	Map<String, Object> outParamMap;
	
	public SiteDaoImpl(){
	}

	public Site getDetailById(Integer siteId) {
		String sql = "SELECT * FROM SITE_MST WHERE sITE_ID = " + siteId;
		return (Site) jdbcTemplate.query(sql, new SiteMapper()).get(0);
	}

	public List<Site> getList() {
		String sql = "SELECT * FROM SITE_MST ";
		return (List<Site>) jdbcTemplate.query(sql, new SiteMapper());
	}

	public boolean update(Site site) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
		.execute(getSqlParameterSource(site, null, DatabaseActionEnum.UPDATE.getName()));
		return true;
	}

	public boolean delete(Integer siteId) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
		.execute(getSqlParameterSource(null, siteId, DatabaseActionEnum.DELETE.getName()));
		return true;
	}

	public boolean save(Site site) {
		outParamMap = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SPROC_NAME)
		.execute(getSqlParameterSource(site, null, DatabaseActionEnum.INSERT.getName()));
		return true;
	}

	private SqlParameterSource getSqlParameterSource(Site site, Integer SiteId, String action){
		final String COMPANY_ID = "P_company_id";
		final String SITE_ID = "P_site_id";
		final String SITE_NAME = "P_site_name";
		final String SITE_DESC = "P_site_desc";
		final String IP_ADDRESS = "P_ip_address";
		final String USER_ID = "P_user_id";
		final String STATUS = "P_status";
		final String ACTION = "P_Action";
		
		SqlParameterSource sqlParameterSource = null;
		if(action.equals(DatabaseActionEnum.INSERT.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(SITE_ID, 0)
			.addValue(SITE_NAME, site.getSiteName())
			.addValue(SITE_DESC, site.getSiteDesc())
			.addValue(COMPANY_ID, site.getCompanyId())
			.addValue(IP_ADDRESS, site.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}else if(action.equals(DatabaseActionEnum.UPDATE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(SITE_ID, site.getSiteId())
			.addValue(SITE_NAME, site.getSiteName())
			.addValue(SITE_DESC, site.getSiteDesc())
			.addValue(COMPANY_ID, site.getCompanyId())
			.addValue(IP_ADDRESS, site.getIp_address())
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);

		}else if(action.equals(DatabaseActionEnum.DELETE.getName())){
			sqlParameterSource = new MapSqlParameterSource()
			.addValue(SITE_ID, SiteId)
			.addValue(SITE_NAME, StringUtils.EMPTY)
			.addValue(SITE_DESC, StringUtils.EMPTY)
			.addValue(COMPANY_ID, 1)
			.addValue(IP_ADDRESS, StringUtils.EMPTY)
			.addValue(ACTION, action)
			.addValue(USER_ID, 1)
			.addValue(STATUS, 0);
		}
		return sqlParameterSource;
	}
	
	private final class SiteMapper implements RowMapper<Site> {

		@Override
		public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
			Site site = new Site();
			site.setSiteId(rs.getInt("site_id"));
			site.setSiteName(rs.getString("site_name"));
			site.setSiteDesc(rs.getString("site_desc"));
			site.setStatus(rs.getInt("status_id"));
			site.setCompanyId(rs.getInt("company_id"));
			site.setCreatedBy(rs.getString("c_user_id"));
			site.setCreatedDate(rs.getDate("c_date"));
			site.setUpdatedBy(rs.getString("u_user_id"));
			site.setUpdatedDate(rs.getDate("u_date"));
			return site;
		}
	}
}
