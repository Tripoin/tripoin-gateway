package id.co.tripoin.core.integration.endpoint.scaffolding;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IScaffoldingEndPoint<DATA, ID extends Serializable> extends IInquiryEndPoint, ITransactionEndPoint<DATA, ID> {


}
