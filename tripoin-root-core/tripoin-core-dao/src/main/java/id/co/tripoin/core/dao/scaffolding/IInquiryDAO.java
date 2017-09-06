package id.co.tripoin.core.dao.scaffolding;

import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.dao.exception.DAOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IInquiryDAO<DATA> {
	List<DATA> findByStatus(int p_Status) throws DAOException;

	/*Property CODE*/
	List<DATA> findByCodeContainingAndStatus(String p_Code, int p_Status) throws DAOException;

	List<DATA> findByCodeContainingAndStatusOrderByIdAsc(String p_Code, int p_Status) throws DAOException;

	List<DATA> findByCodeContainingAndStatusOrderByCodeAsc(String p_Code, int p_Status) throws DAOException;

	List<DATA> findByCodeContainingAndStatusOrderByCodeDesc(String p_Code, int p_Status) throws DAOException;

	Page<DATA> findByCodeContainingAndStatusOrderByCodeAsc(String p_Code, int p_Status, Pageable p_Pageable) throws DAOException;

	/*Property NAME*/
	List<DATA> findByNameContainingAndStatus(String p_Name, int p_Status) throws DAOException;

	List<DATA> findByNameContainingAndStatusOrderByIdAsc(String p_Name, int p_Status) throws DAOException;

	List<DATA> findByNameContainingAndStatusOrderByNameAsc(String p_Name, int p_Status) throws DAOException;

	List<DATA> findByNameContainingAndStatusOrderByNameDesc(String p_Name, int p_Status) throws DAOException;

	Page<DATA> findByNameContainingAndStatusOrderByNameAsc(String p_Name, int p_Status, Pageable p_Pageable) throws DAOException;

	/*List Of Value*/
	@Query(QueryConstant.SELECT_LOV)
	List<DATA> selectLOV() throws DAOException;

	/*Entity Size Counter*/
	@Query(QueryConstant.COUNT_ENTITY_SIZE_BY_STATUS)
	Long countDATASizeByStatus(int p_Status);

	@Query(QueryConstant.COUNT_ENTITY_SIZE_BY_CODE)
	Long countDATASizeByCode(String p_Code);

	@Query(QueryConstant.COUNT_ENTITY_SIZE_BY_CODE_AND_STATUS)
	Long countDATASizeByCodeAndStatus(String p_Code, int p_Status);

	@Query(QueryConstant.COUNT_ENTITY_SIZE_BY_NAME)
	Long countDATASizeByName(String p_Name);

	@Query(QueryConstant.COUNT_ENTITY_SIZE_BY_NAME_AND_STATUS)
	Long countDATASizeByNameAndStatus(String p_Name, int p_Status);

	/*@Query(QueryConstant.ADVANCED_PAGINATION)
	Page<DATA> advancedPagination(String p_FilterKey, String p_FilterValue, Pageable p_Pageable) throws DAOException;*/

	/*List<String> getPhysicalColumnNames() throws DAOException;*/


}