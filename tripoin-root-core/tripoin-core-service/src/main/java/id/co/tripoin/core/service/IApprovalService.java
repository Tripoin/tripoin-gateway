package id.co.tripoin.core.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
@Transactional
public interface IApprovalService<ID> {

	void approveAll() throws ServiceException;

	void approveSingleData(ID p_ID) throws ServiceException;

}
