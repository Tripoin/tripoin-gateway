package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.CommonConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.PaginationDTO;
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
                p_PaginationDTO.getOffset(),
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
        return new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
    }

    @Override
    public ResponseData buildFailedResponse() {
        return new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
    }
    
    @Override
    public ResponseData buildFailedResponse(String p_ErrorMessage) {
        return new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg().concat(CommonConstant.Punctuation.HYPHEN).concat(p_ErrorMessage));
    }
}
