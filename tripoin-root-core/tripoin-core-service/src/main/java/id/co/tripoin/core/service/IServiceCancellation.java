package id.co.tripoin.core.service;

import org.hibernate.service.spi.ServiceException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
public interface IServiceCancellation {

	void doCancellation() throws ServiceException;

}
