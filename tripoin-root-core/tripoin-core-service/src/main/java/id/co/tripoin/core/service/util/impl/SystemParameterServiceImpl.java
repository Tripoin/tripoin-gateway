package id.co.tripoin.core.service.util.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.util.ISystemParameterDao;
import id.co.tripoin.core.pojo.SystemParameter;
import id.co.tripoin.core.service.util.ISystemParameterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service(BeanNameConstant.SYSTEM_PARAMETER_SERVICE_BEAN)
public class SystemParameterServiceImpl implements ISystemParameterService {
	
	@Autowired
	private ISystemParameterDao systemParameterDao;

	@Override
	public SystemParameter loadValue(String code) throws Exception {
		return systemParameterDao.loadValue(code);
	}

	@Override
	public List<SystemParameter> listValue(Object[] code) throws Exception {
		return systemParameterDao.listValue(code);
	}

	@Override
	public List<SystemParameter> getListSystemParameter() throws Exception {
		return systemParameterDao.getAllSystemParameter();
	}

	@Override
	public Map<String, String> getMapSystemParameter() throws Exception {
		Map<String, String> mapSystemParameter = new HashMap<String, String>();
		for(SystemParameter systemParameter : systemParameterDao.getAllSystemParameter()){
			mapSystemParameter.put(systemParameter.getCode(), systemParameter.getValue());
		}
		return mapSystemParameter;
	}

}