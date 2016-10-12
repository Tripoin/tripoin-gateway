package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOExeption;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IInquiryDAO<DATA, ID> {

	/*List<DATA> findAll() throws DAOExeption;*/

	DATA findById(ID p_ID) throws DAOExeption;

	List<DATA> findByCode(String p_Code) throws DAOExeption;

	List<DATA> findByName(String p_Name) throws DAOExeption;

	/*List<DATA> pagination(Pageable p_Pageable) throws DAOExeption;

	List<DATA> advancedPagination(Pageable p_Pageable) throws DAOExeption;

	List<DATA> selectLOV()throws DAOExeption;

	List<String> getPhysicalColumnNames() throws DAOExeption;*/
}
