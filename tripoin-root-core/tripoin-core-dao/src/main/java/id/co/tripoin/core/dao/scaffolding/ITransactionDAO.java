package id.co.tripoin.core.dao.scaffolding;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import id.co.tripoin.core.dao.exception.DAOException;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
@SuppressWarnings("rawtypes")
@Transactional
public interface ITransactionDAO<ID extends Serializable> extends IApprovalDAO, ICancellationDAO {

	@Modifying
    @Query("UPDATE #{#entityName} a set a.code = ?2, a.name = ?3, a.remarks = ?4 where a.id = ?1")
    void setBaseDataById(ID p_Id, String p_Code, String p_Name, String p_Remarks) throws DAOException;
	
}
