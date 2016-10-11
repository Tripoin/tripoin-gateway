package id.co.tripoin.core.service;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IScaffoldingService<DATA, ID extends Serializable> extends IInquiryService<DATA, ID>, ITransactionService<DATA, ID>{
	
}
