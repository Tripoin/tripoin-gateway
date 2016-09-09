package id.co.tripoin.core.dao.util.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.dao.util.IAuthenticationDao;
import id.co.tripoin.core.mapper.SecurityUserDetailsMapper;
import id.co.tripoin.core.pojo.SecurityUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Repository(BeanNameConstant.AUTHENTICATION_DAO_BEAN)
public class AuthenticationDaoImpl implements IAuthenticationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<SecurityUserDetails> securityUserDetailsMapper = new SecurityUserDetailsMapper();

	@Override
	public SecurityUserDetails login(String username) throws Exception {
		return jdbcTemplate.queryForObject(QueryConstant.LOGIN, new Object[]{username, username, username}, securityUserDetailsMapper);
	}

	@Override
	public int change(String username, String secret) throws Exception {
		return jdbcTemplate.update(QueryConstant.AUTHENTICATION_CHANGE, new Object[]{username, secret});
	}

}
