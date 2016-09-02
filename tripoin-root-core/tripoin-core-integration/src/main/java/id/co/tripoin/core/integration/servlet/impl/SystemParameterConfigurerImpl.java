package id.co.tripoin.core.integration.servlet.impl;

import id.co.tripoin.constant.statics.ApplicationContextConstant;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.integration.servlet.AConfigureContext;
import id.co.tripoin.core.service.util.ISystemParameterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SystemParameterConfigurerImpl extends AConfigureContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2880627259779780510L;
	private static Logger LOGGER = LoggerFactory.getLogger(SystemParameterConfigurerImpl.class);

	public SystemParameterConfigurerImpl(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	public String getKey() {
		return ApplicationContextConstant.CONTEXT_SYSTEM_PARAMETER;
	}

	@Override
	public Object getValue() {
		ISystemParameterService systemParameterService = (ISystemParameterService)getApplicationContext().getBean(BeanNameConstant.SYSTEM_PARAMETER_SERVICE_BEAN);
		try {
			return systemParameterService.getMapSystemParameter();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_SYSTEM_PARAMETER_CONFIGURE, e);
			return null;
		}
	}

}
