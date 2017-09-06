package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.dto.ResponseData;
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
public interface IResponseConstructor<DATA> {

    Response constructSingleFindResponse(DATA p_DATA) throws EndPointException;

    Response constructDTOSingleFindResponse(Object p_DATA) throws EndPointException;

    Response constructListFindResponse(List<DATA> p_DATA) throws EndPointException;

    Response constructDTOListFindResponse(List<?> p_DATA) throws EndPointException;

    Response constructPaginationResponse(Page<DATA> p_DATAPage) throws EndPointException;

    Response constructDTOPaginationResponse(Page<?> p_DATAPage) throws EndPointException;

    Response constructSimpleTransactionResponse(ResponseData p_ResponseData) throws EndPointException;
}
