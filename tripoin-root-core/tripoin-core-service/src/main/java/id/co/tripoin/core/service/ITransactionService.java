package id.co.tripoin.core.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
@Transactional
public interface ITransactionService<DATA, ID> extends ICancellation, IApproval{

	void insert(List<DATA> p_DATA);
	
	void update(List<DATA> p_DATA);
	
	void delete(List<ID> p_IDs);	
	
}
