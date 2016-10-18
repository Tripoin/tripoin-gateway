package id.co.tripoin.core.service.scaffolding;

import java.lang.Long;
/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingService<DATA> extends IInquiryService<DATA, Long>, ITransactionService<DATA, Long> {
	
}
