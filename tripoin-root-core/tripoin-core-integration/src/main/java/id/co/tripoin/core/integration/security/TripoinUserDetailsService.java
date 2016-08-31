package id.co.tripoin.core.integration.security;

import id.co.tripoin.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.mapper.SecurityUserDetailsMapper;
import id.co.tripoin.core.pojo.SecurityUserDetails;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinUserDetailsService implements UserDetailsService {

	private static final RowMapper<SecurityUserDetails> securityUserDetailsMapper = new SecurityUserDetailsMapper();
	private JdbcTemplate jdbcTemplate;
	private String emptyPassword = "";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.emptyPassword = passwordEncoder.encode("");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUserDetails securityUserDetails = jdbcTemplate.queryForObject(QueryConstant.LOGIN, new Object[]{username, username, username}, securityUserDetailsMapper);		
		String clientSecret = securityUserDetails.getPassword();
		if ((clientSecret == null) || (clientSecret.trim().length() == 0)) {
			clientSecret = this.emptyPassword;
		}
		return new User(username, clientSecret,
				securityUserDetails.isEnabled(),
				securityUserDetails.isAccountNonExpired(),
				securityUserDetails.isCredentialsNonExpired(),
				securityUserDetails.isAccountNonLocked(),
				securityUserDetails.getAuthorities());
	}

}
