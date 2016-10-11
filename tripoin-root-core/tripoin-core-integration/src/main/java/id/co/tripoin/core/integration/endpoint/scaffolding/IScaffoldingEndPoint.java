package id.co.tripoin.core.integration.endpoint.scaffolding;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface IScaffoldingEndPoint<DATA, ID> extends IInsertEndPoint<DATA>, IUpdateEndPoint<DATA>, IDeleteEndPoint<ID> {

}
