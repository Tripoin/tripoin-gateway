package id.co.tripoin.core.integration.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
* @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
*/
public class TripoinIntegrationServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2658977332610074003L;
	private static Logger LOGGER = LoggerFactory.getLogger(TripoinIntegrationServlet.class);
	
    private static final String CONTEXT_CONFIG_LOCATION_PARAMETER = "contextConfigLocation";
    
    /**
     * Spring Application Context
     */
    private transient ApplicationContext applicationContext;
    
    private LocaleResolver localeResolver;

	@Override
	public void init(ServletConfig config) throws ServletException {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        if (config.getInitParameter(CONTEXT_CONFIG_LOCATION_PARAMETER) != null) {
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            context.setParent(applicationContext);
            context.setConfigLocation(config.getInitParameter(CONTEXT_CONFIG_LOCATION_PARAMETER));
            context.setServletConfig(config);
            context.setServletContext(config.getServletContext());
            context.refresh();
            applicationContext = context;
        }
        if (SpringApplicationContext.getApplicationContext() == null){
            SpringApplicationContext.setApplicationContext(applicationContext);
        }
        super.init(config);  	
        initLocaleResolver(applicationContext); 
        startupInitialized(config.getServletContext());
	}
	
	private void initLocaleResolver(ApplicationContext context) {
        try {
            this.localeResolver = (LocaleResolver) context.getBean(DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME,
                    LocaleResolver.class);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Using LocaleResolver [" + this.localeResolver + "]");
            }
        } catch (NoSuchBeanDefinitionException ex) {
            this.localeResolver = new SessionLocaleResolver();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Unable to locate LocaleResolver with name '"
                        + DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME + "' using default [" + localeResolver + "]");
            }
        }
	}
	
	public void startupInitialized(ServletContext servletContext) {
		LOGGER.debug("Initializing context...");
		try{
			RegisterContext.getInstance().init(applicationContext, servletContext);
		} catch (Exception e) {
			LOGGER.error("Error Initialized Web Service Integration", e);		
		}
}
}
