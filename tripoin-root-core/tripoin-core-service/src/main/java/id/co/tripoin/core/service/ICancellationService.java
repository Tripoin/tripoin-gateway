package id.co.tripoin.core.service;

import org.hibernate.service.spi.ServiceException;

import javax.transaction.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param<ID>
 */
@Transactional
public interface ICancellationService<ID> {

	void cancelAll() throws ServiceException;

	void cancelSingleData(ID p_ID) throws ServiceException;
}
