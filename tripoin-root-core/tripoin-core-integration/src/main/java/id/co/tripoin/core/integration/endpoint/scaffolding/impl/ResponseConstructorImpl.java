package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.IResponseConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Service
public class ResponseConstructorImpl<DATA> implements IResponseConstructor<DATA> {

    private static Logger LOGGER = LoggerFactory.getLogger(ResponseConstructorImpl.class);

    @Override
    public Response constructSingleFindResponse(DATA p_DATA) throws EndPointException {
        try{
            if (p_DATA == null){
                LOGGER.info(InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return Response.ok(p_DATA).build();
        } catch (Exception e) {
            LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response constructListFindResponse(List<DATA> p_DATA) throws EndPointException {
        List<DATA> response = new ArrayList<DATA>();
        try{
            if (p_DATA.size() > 0){
                response = p_DATA;
            }else{
                LOGGER.info(InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
        } catch (Exception e) {
            LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return Response.serverError().build();
        }
        return Response.ok(response).build();
    }

    @Override
    public Response constructPaginationResponse(Page<DATA> p_DATAPage) {
        try{
            if (p_DATAPage == null){
                LOGGER.info(InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return Response.ok(p_DATAPage).build();
        } catch (Exception e) {
            LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response constructSimpleTransactionResponse(ResponseData p_ResponseData) {
        try{
            if (p_ResponseData == null){
                LOGGER.info(InfoMarkerConstant.INFO_DATA_NOT_FOUND);
            }
            return Response.ok(p_ResponseData).build();
        } catch (Exception e) {
            LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT, e);
            return Response.serverError().build();
        }
    }
}