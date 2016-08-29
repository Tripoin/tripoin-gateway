package id.co.tripoin.core.integration.servlet;

import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AConfigureContext implements IConfigureContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -602533378200387472L;
	private transient ApplicationContext applicationContext;

	public AConfigureContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

}
