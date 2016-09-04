package id.co.tripoin.core.integration.servlet.impl;

import id.co.tripoin.constant.statics.ApplicationContextConstant;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.integration.servlet.AConfigureContext;
import id.co.tripoin.core.service.II18NLocaleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class I18NLocaleConfigureImpl extends AConfigureContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3220847756649349303L;
	private static Logger LOGGER = LoggerFactory.getLogger(I18NLocaleConfigureImpl.class);

	public I18NLocaleConfigureImpl(ApplicationContext applicationContext) {
		super(applicationContext);
	}

	@Override
	public String getKey() {
		return ApplicationContextConstant.CONTEXT_I18NLOCALE;
	}

	@Override
	public Object getValue() {
		II18NLocaleService i18NLocaleService = (II18NLocaleService)getApplicationContext().getBean(BeanNameConstant.I18NLOCALE_SERVICE_BEAN);
		try {
			return i18NLocaleService.getAllMapByStatus();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_I18NLOCALE_CONFIGURE, e);
			return null;
		}
	}

}
