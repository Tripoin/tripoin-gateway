package id.co.tripoin.core.dao.exception;

import id.co.tripoin.core.exception.ATripoinException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public class DAOException extends ATripoinException {

	public DAOException(String p_Message) {
		super(p_Message);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String p_Message, Throwable p_Throwable) {
		super(p_Message, p_Throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
