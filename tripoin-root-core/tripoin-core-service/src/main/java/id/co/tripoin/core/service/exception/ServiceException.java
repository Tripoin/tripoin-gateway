package id.co.tripoin.core.service.exception;

import id.co.tripoin.core.exception.ATripoinException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class ServiceException extends ATripoinException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -946741192849089787L;
	
	public ServiceException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
	}

	public ServiceException(String p_Message) {
		super(p_Message);
	}


}
