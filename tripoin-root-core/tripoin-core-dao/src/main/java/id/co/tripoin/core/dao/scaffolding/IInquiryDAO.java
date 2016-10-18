package id.co.tripoin.core.dao.scaffolding;

import id.co.tripoin.core.dao.exception.DAOException;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IInquiryDAO<DATA> {

	/*Property CODE*/
	List<DATA> findByCodeLike(String p_Code) throws DAOException;

	List<DATA> findByCodeLikeOrderByIdAsc(String p_Code) throws DAOException;
	
	List<DATA> findByCodeLikeOrderByCodeAsc(String p_Code) throws DAOException;

	List<DATA> findByCodeLikeOrderByCodeDesc(String p_Code) throws DAOException;
	
	Page<DATA> findByCodeLikeOrderByCodeAsc(String p_Code, Pageable p_Pageable) throws DAOException;

	/*Property NAME*/
	List<DATA> findByNameLike(String p_Name) throws DAOException;

	List<DATA> findByNameLikeOrderByIdAsc(String p_Name) throws DAOException;
	
	List<DATA> findByNameLikeOrderByNameAsc(String p_Name) throws DAOException;

	List<DATA> findByNameLikeOrderByNameDesc(String p_Name) throws DAOException;
	
	Page<DATA> findByNameLikeOrderByNameAsc(String p_Name, Pageable p_Pageable) throws DAOException;

	/*List Of Value*/
	List<DATA> selectLOV() throws DAOException;

	/*List<String> getPhysicalColumnNames() throws DAOException;*/
}