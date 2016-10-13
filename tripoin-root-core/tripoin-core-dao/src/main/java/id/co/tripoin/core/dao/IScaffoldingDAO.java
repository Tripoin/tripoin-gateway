package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOExeption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
@NoRepositoryBean
public interface IScaffoldingDAO<DATA> extends JpaRepository<DATA, Long>, ITransactionDAO<DATA, Long>, IInquiryDAO<DATA, Long>{

	@Query("SELECT a FROM #{#entityName} a where a.code = ?1")
	@Override
	public List<DATA> findByCode(String p_Code) throws DAOExeption;
	
	@Query("SELECT a FROM #{#entityName} a where a.name = ?1")
	@Override
	public List<DATA> findByName(String p_Name) throws DAOExeption;
}
