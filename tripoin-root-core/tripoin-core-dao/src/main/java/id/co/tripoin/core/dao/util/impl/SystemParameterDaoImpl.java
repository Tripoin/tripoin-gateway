package id.co.tripoin.core.dao.util.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.dao.util.ISystemParameterDao;
import id.co.tripoin.core.mapper.SystemParameterMapper;
import id.co.tripoin.core.pojo.system.SystemParameter;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Repository(BeanNameConstant.SYSTEM_PARAMETER_DAO_BEAN)
public class SystemParameterDaoImpl implements ISystemParameterDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<SystemParameter> systemParameterMapper = new SystemParameterMapper();

	@Override
	public SystemParameter loadValue(String code) throws Exception {
		return jdbcTemplate.queryForObject(QueryConstant.SYS_PARAM_LOAD_VALUE, new Object[]{code}, systemParameterMapper);
	}

	@Override
	public List<SystemParameter> listValue(Object[] code) throws Exception {
		return jdbcTemplate.query(QueryConstant.SYS_PARAM_LIST_VALUE, code, systemParameterMapper);
	}

	@Override
	public List<SystemParameter> getAllSystemParameter() throws Exception {
		return jdbcTemplate.query(QueryConstant.SYS_PARAM_ALL, systemParameterMapper);
	}

}
