package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import org.springframework.data.domain.Page;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingResponseConstructor<DATA> {

    public Response constructSingleFindResponse(DATA p_DATA) throws EndPointException;

    public Response constructListFindResponse(List<DATA> p_DATA) throws EndPointException;

    public Response constructPaginationResponse(Page<DATA> p_DATAPage) throws EndPointException;
}
