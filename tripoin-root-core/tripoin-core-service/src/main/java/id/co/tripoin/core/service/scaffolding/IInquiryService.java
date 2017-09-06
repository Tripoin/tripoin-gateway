package id.co.tripoin.core.service.scaffolding;

import id.co.tripoin.core.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IInquiryService<DATA, ID> {

	List<DATA> findAll() throws ServiceException;

	Page<DATA> findAll(Pageable p_Pageable);

	DATA findById(ID p_ID) throws ServiceException;

	/*Property Code*/
	List<DATA> findByCode(String p_Code) throws ServiceException;

	List<DATA> findByCodeOrderByIdAsc(String p_Code) throws ServiceException;

	List<DATA> findByCodeOrderByCodeAsc(String p_Code) throws ServiceException;

	List<DATA> findByCodeOrderByCodeDesc(String p_Code) throws ServiceException;

	Page<DATA> findByCodeOrderByCodeAsc(String p_Code, Pageable p_Pageable) throws ServiceException;

	/*Property Name*/
	List<DATA> findByName(String p_Name);

	List<DATA> findByNameOrderByIdAsc(String p_Name) throws ServiceException;

	List<DATA> findByNameOrderByNameAsc(String p_Name) throws ServiceException;

	List<DATA> findByNameOrderByNameDesc(String p_Name) throws ServiceException;

	Page<DATA> findByNameOrderByNameAsc(String p_Name, Pageable p_Pageable) throws ServiceException;

	List<DATA> selectLOV();

	List<String> getPhysicalColumnNames();

	/*Page<DATA> advancedPagination(String p_FilterKey, String p_FilterValue, Pageable p_Pageable) throws ServiceException;*/
}