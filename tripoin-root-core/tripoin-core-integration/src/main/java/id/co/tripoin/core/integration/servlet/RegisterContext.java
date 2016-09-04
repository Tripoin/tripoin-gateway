package id.co.tripoin.core.integration.servlet;

import id.co.tripoin.core.integration.servlet.impl.I18NLocaleConfigureImpl;
import id.co.tripoin.core.integration.servlet.impl.SystemParameterConfigurerImpl;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class RegisterContext {

	private static RegisterContext instance = null;
	private RegisterContext() {}

	public static RegisterContext getInstance() {
		if (instance == null) {
			instance = new RegisterContext();
		}
		return instance;
	}

	public void init(ApplicationContext applicationContext, ServletContext servletContext) {
		IConfigureContext configSysParameter = new SystemParameterConfigurerImpl(applicationContext);
		servletContext.setAttribute(configSysParameter.getKey(), configSysParameter.getValue());
		IConfigureContext configI18NLocale = new I18NLocaleConfigureImpl(applicationContext);
		servletContext.setAttribute(configI18NLocale.getKey(), configI18NLocale.getValue());
	}

}
