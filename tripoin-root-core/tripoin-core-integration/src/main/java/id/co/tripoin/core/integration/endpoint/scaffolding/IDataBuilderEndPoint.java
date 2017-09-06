package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.PaginationDTO;
import org.springframework.data.domain.PageRequest;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDataBuilderEndPoint {

    PageRequest buildPageRequest(PaginationDTO p_PaginationDTO);

    PaginationDTO buildDTOPagination(int p_Limit, int p_Offset, String p_Order, String p_Sort);

    ResponseData buildSuccessResponse();

    ResponseData buildFailedResponse();
    
    ResponseData buildFailedResponse(String p_ErrorMessage);
}
