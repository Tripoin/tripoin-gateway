package id.co.tripoin.core.integration.exception;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class LocaleFoundFaultException  extends Exception {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4176685227412385689L;

	public LocaleFoundFaultException(String message) {
		super(message);
	}
	
	public LocaleFoundFaultException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
