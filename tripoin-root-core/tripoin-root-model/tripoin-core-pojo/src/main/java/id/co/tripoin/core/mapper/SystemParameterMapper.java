package id.co.tripoin.core.mapper;

import id.co.tripoin.core.pojo.SystemParameter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SystemParameterMapper implements RowMapper<SystemParameter> {
	
	public SystemParameter mapRow(ResultSet rs, int rowNum) throws SQLException {
		SystemParameter systemParameter = new SystemParameter();
		systemParameter.setId(rs.getLong("system_parameter_id"));
		systemParameter.setCode(rs.getString("system_parameter_code"));
		systemParameter.setValue(rs.getString("system_parameter_value"));
		systemParameter.setStatus(rs.getInt("status"));
		systemParameter.setRemarks(rs.getString("remarks"));
		systemParameter.setCreatedBy(rs.getString("created_by"));
		systemParameter.setCreatedIP(rs.getString("created_ip"));
		systemParameter.setCreatedTime(rs.getDate("created_time"));
		systemParameter.setCreatedPlatform(rs.getString("created_platform"));
		systemParameter.setModifiedBy(rs.getString("modified_by"));
		systemParameter.setModifiedIP(rs.getString("modified_ip"));
		systemParameter.setModifiedTime(rs.getDate("modified_time"));
		systemParameter.setModifiedPlatform(rs.getString("modified_platform"));
		return systemParameter;
	}
 
}