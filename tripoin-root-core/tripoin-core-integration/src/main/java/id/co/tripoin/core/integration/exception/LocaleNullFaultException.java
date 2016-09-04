package id.co.tripoin.core.integration.exception;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class LocaleNullFaultException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -211933895376016390L;

	public LocaleNullFaultException(String message) {
		super(message);
	}
	
	public LocaleNullFaultException(String message, Throwable cause) {
		super(message, cause);
	}
	
}