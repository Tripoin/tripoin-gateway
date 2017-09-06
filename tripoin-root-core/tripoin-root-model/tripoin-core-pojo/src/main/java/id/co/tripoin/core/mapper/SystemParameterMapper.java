package id.co.tripoin.core.mapper;

import id.co.tripoin.core.pojo.system.SystemParameter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SystemParameterMapper implements RowMapper<SystemParameter> {

	public SystemParameter mapRow(ResultSet rs, int rowNum) throws SQLException {
		SystemParameter systemParameter = new SystemParameter();
		systemParameter.setId(rs.getLong("id"));
		systemParameter.setCode(rs.getString("code"));
		systemParameter.setName(rs.getString("name"));
		systemParameter.setStatus(rs.getInt("status"));
		systemParameter.setRemarks(rs.getString("remarks"));
		systemParameter.setCreatedBy(rs.getString("created_by"));
		systemParameter.setCreatedIP(rs.getString("created_ip"));
		systemParameter.setCreatedOn(rs.getDate("created_on"));
		systemParameter.setCreatedPlatform(rs.getString("created_platform"));
		systemParameter.setModifiedBy(rs.getString("modified_by"));
		systemParameter.setModifiedIP(rs.getString("modified_ip"));
		systemParameter.setModifiedOn(rs.getDate("modified_on"));
		systemParameter.setModifiedPlatform(rs.getString("modified_platform"));
		return systemParameter;
	}


}