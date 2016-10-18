package id.co.tripoin.core.dao.scaffolding;

import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.dao.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@NoRepositoryBean
public interface IScaffoldingDAO<DATA> extends JpaRepository<DATA, Long>, ITransactionDAO<Long>, IInquiryDAO<DATA> {

    @Query(QueryConstant.SELECT_LOV)
    @Override
    List<DATA> selectLOV() throws DAOException;
}
