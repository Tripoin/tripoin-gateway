package id.co.tripoin.core.service.scaffolding;

import id.co.tripoin.core.service.IApprovalService;
import id.co.tripoin.core.service.ICancellationService;
import id.co.tripoin.core.service.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
@Transactional
public interface ITransactionService<DATA, ID> extends ICancellationService<ID>, IApprovalService<ID> {

	@Transactional
	void insert(DATA p_DATA) throws ServiceException;

	@Transactional
	void insertAndFlush(DATA p_DATA) throws ServiceException;

	@Transactional
	void insertCollection(List<DATA> p_DATA)  throws ServiceException;

	void update(DATA p_DATA)  throws ServiceException;

	@Transactional
	void delete(ID p_ID)  throws ServiceException;

	@Transactional
	void deleteByEntity(String p_Code)  throws ServiceException;

	@Transactional
	void deleteCollection(List<String> p_Codes)  throws ServiceException;

	@Transactional
	void deleteCollectionById(List<ID> p_ID)  throws ServiceException;

}
