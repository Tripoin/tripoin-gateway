package id.co.tripoin.core.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
@Transactional
public interface IServiceApproval {

	void doApproval() throws ServiceException;

}
