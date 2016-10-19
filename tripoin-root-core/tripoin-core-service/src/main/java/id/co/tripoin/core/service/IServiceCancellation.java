package id.co.tripoin.core.service;

import org.hibernate.service.spi.ServiceException;

import javax.transaction.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
@Transactional
public interface IServiceCancellation {

	void doCancellation() throws ServiceException;

}
