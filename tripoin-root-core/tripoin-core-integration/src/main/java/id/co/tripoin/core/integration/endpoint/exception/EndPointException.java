package id.co.tripoin.core.integration.endpoint.exception;

import id.co.tripoin.core.exception.ATripoinException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class EndPointException extends ATripoinException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121502315924173984L;

	public EndPointException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
		// TODO Auto-generated constructor stub
	}

	public EndPointException(String p_Message) {
		super(p_Message);
		// TODO Auto-generated constructor stub
	}

	
}
