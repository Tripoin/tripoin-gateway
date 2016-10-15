package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOException;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IInquiryDAO<DATA, ID> {

	/*Property CODE*/
	List<DATA> findByCode(String p_Code) throws DAOException;

	List<DATA> findByCodeOrderByIdAsc(String p_Code) throws DAOException;
	
	List<DATA> findByCodeOrderByCodeAsc(String p_Code) throws DAOException;

	List<DATA> findByCodeOrderByCodeDesc(String p_Code) throws DAOException;
	
	Page<DATA> findByCodeOrderByCodeAsc(String p_Code, Pageable p_Pageable) throws DAOException;

	/*Property NAME*/
	List<DATA> findByName(String p_Name) throws DAOException;

	List<DATA> findByNameOrderByIdAsc(String p_Name) throws DAOException;
	
	List<DATA> findByNameOrderByNameAsc(String p_Name) throws DAOException;

	List<DATA> findByNameOrderByNameDesc(String p_Name) throws DAOException;
	
	Page<DATA> findByNameOrderByNameAsc(String p_Name, Pageable p_Pageable) throws DAOException;

	/*Particular Property*/
	
	/*List<DATA> pagination(Pageable p_Pageable) throws DAOExeption;

	List<DATA> advancedPagination(Pageable p_Pageable) throws DAOExeption;

	List<DATA> selectLOV()throws DAOExeption;

	List<String> getPhysicalColumnNames() throws DAOExeption;*/
}
