package id.co.tripoin.core.mapper;

import id.co.tripoin.core.pojo.SecurityUserDetails;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SecurityUserDetailsMapper implements RowMapper<SecurityUserDetails> {
	
	public SecurityUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		SecurityUserDetails securityUserDetails = new SecurityUserDetails();
		securityUserDetails.setUsername(rs.getString("client_id"));
		securityUserDetails.setPassword(rs.getString("client_secret"));
		securityUserDetails.setEnabled(getBoolean(rs.getInt("user_enabled")));
		securityUserDetails.setAccountNonExpired(getBoolean(rs.getDate("user_expired_date")));
		securityUserDetails.setCredentialsNonExpired(getBoolean(rs.getDate("user_credentials_expired_date")));
		securityUserDetails.setAccountNonLocked(getBoolean(rs.getInt("user_non_locked")));
		securityUserDetails.setAuthorities(rs.getString("role_code"));
		return securityUserDetails;
	}
	
	private boolean getBoolean(int data) {
		return data == 1 ? true : false;
	}
	
	private boolean getBoolean(Date date) {
		if(date != null){
			if(date.compareTo(new Date(new java.util.Date().getTime())) >= 0)
				return true;
			else
				return false;				
		}else
			return true;
	}
 
}