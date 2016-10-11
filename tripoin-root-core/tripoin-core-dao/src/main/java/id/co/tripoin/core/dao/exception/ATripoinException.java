package id.co.tripoin.core.dao.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public abstract class ATripoinException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3006085274327484535L;

	private Logger logger = LoggerFactory.getLogger(ATripoinException.class);

    public ATripoinException(String p_Message) {
        this(p_Message, null);
    }

    public ATripoinException(String p_Message, Throwable p_Throwable) {
        super(p_Message, p_Throwable);
        if (p_Message != null && p_Throwable != null) {
            logger.info(p_Message);
            p_Throwable.printStackTrace();

        } else {
            if (p_Message != null) {
                logger.info(p_Message);
            }
            if (p_Throwable != null) {
                logger.error(p_Throwable.getMessage());
                p_Throwable.printStackTrace();
            }
        }
    }
}
