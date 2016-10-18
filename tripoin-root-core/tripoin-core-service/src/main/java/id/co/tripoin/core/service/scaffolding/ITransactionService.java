package id.co.tripoin.core.service.scaffolding;

import java.util.List;

import id.co.tripoin.core.service.IServiceApproval;
import id.co.tripoin.core.service.IServiceCancellation;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
@Transactional
public interface ITransactionService<DATA, ID> extends IServiceCancellation, IServiceApproval {

	/*Insert*/
	void insert(DATA p_DATA) throws ServiceException;

	void insertAndFlush(DATA p_DATA) throws ServiceException;

	void insertCollection(List<DATA> p_DATA)  throws ServiceException;

	/*Update*/
	void updateBaseData(ID p_Id, String p_Code, String p_Name, String p_Remarks)  throws ServiceException;


	/*Delete*/
	void delete(ID p_ID)  throws ServiceException;

	void deleteByEntity(DATA p_DATA)  throws ServiceException;

	void deleteCollection(List<DATA> p_DATA)  throws ServiceException;

	
}
