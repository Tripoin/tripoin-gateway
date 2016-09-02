package id.co.tripoin.core.integration.exception;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UsernameFaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8233348693701011893L;
	
	public UsernameFaultException(String message) {
		super(message);
	}
	
	public UsernameFaultException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
