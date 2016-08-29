package id.co.tripoin.core.integration.servlet;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IConfigureContext extends Serializable {

	public String getKey();
	
	public Object getValue();
	
	public ApplicationContext getApplicationContext();
	
}
