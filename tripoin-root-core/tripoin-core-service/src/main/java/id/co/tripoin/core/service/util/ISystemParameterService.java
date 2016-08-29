package id.co.tripoin.core.service.util;

import id.co.tripoin.core.pojo.SystemParameter;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ISystemParameterService {

	public SystemParameter loadValue(String code) throws Exception;
	
	public List<SystemParameter> listValue(Object[] code) throws Exception;
	
	public List<SystemParameter> getListSystemParameter() throws Exception;
	
	public Map<String, String> getMapSystemParameter() throws Exception;

}