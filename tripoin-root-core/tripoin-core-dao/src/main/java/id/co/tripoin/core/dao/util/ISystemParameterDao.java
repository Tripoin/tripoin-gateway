package id.co.tripoin.core.dao.util;

import java.util.List;

import id.co.tripoin.core.pojo.SystemParameter;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ISystemParameterDao {

	public SystemParameter loadValue(String code) throws Exception;
	
	public List<SystemParameter> listValue(Object[] code) throws Exception;
	
	public List<SystemParameter> getAllSystemParameter() throws Exception;
	
}
