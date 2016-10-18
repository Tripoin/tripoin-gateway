package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.dto.request.DTOPagination;
import org.springframework.data.domain.PageRequest;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDataBuilderEndPoint {

    PageRequest buildPageRequest(DTOPagination p_DTOPagination);

    DTOPagination buildDTOPagination(int p_Limit, int p_Offset, String p_Order, String p_Sort);
}
