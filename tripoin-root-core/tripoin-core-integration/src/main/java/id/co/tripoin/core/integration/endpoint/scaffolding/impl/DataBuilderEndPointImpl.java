package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.dto.request.DTOPagination;
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
    public PageRequest buildPageRequest(DTOPagination p_DTOPagination) {
        return new PageRequest(
                p_DTOPagination.getLimit()/ p_DTOPagination.getOffset(),
                p_DTOPagination.getLimit(),
                Sort.Direction.fromString(p_DTOPagination.getOrder()),
                p_DTOPagination.getSort()
        );
    }

    @Override
    public DTOPagination buildDTOPagination(int p_Limit, int p_Offset, String p_Order, String p_Sort) {
        DTOPagination dtoPagination = new DTOPagination();
        dtoPagination.setLimit(p_Limit);
        dtoPagination.setOffset(p_Offset);
        dtoPagination.setOrder(p_Order);
        dtoPagination.setSort(p_Sort);
        return dtoPagination;
    }
}
