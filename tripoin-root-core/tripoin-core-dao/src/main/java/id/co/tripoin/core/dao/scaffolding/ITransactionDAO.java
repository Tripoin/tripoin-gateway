package id.co.tripoin.core.dao.scaffolding;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ID>
 */
@Transactional
public interface ITransactionDAO<ID extends Serializable> extends IApprovalDAO<ID>, ICancellationDAO<ID> {

	/*@Modifying
    @Query("UPDATE #{#entityName} a set a.code = ?2, a.name = ?3, a.remarks = ?4 where a.id = ?1")
    void setBaseDataById(ID p_Id, String p_Code, String p_Name, String p_Remarks) throws DAOException;*/

}
