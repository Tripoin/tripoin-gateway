package id.co.tripoin.web.ui.servlet;

import org.springframework.context.ApplicationContext;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SpringApplicationContext implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2371537659581581707L;
	private static transient ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContext.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
}
