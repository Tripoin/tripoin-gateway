package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.PaginationDTO;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.IDataBuilderEndPoint;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class DataBuilderEndPointImpl implements IDataBuilderEndPoint {

    @Override
    public PageRequest buildPageRequest(PaginationDTO p_PaginationDTO) {
        return new PageRequest(
                p_PaginationDTO.getLimit()/ p_PaginationDTO.getOffset(),
                p_PaginationDTO.getLimit(),
                Sort.Direction.fromString(p_PaginationDTO.getOrder()),
                p_PaginationDTO.getSort()
        );
    }

    @Override
    public PaginationDTO buildDTOPagination(int p_Limit, int p_Offset, String p_Order, String p_Sort) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setLimit(p_Limit);
        paginationDTO.setOffset(p_Offset);
        paginationDTO.setOrder(p_Order);
        paginationDTO.setSort(p_Sort);
        return paginationDTO;
    }

    @Override
    public ResponseData buildSuccessResponse() {
        return new ResponseData("1", "oke");
    }

    @Override
    public ResponseData buildFailedResponse() {
        return new ResponseData("-1", "failed");
    }
}
