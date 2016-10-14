package id.co.tripoin.core.integration.endpoint.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.integration.endpoint.IEndPointInitializer;
import id.co.tripoin.core.integration.endpoint.IScaffoldingEndPoint;
import id.co.tripoin.core.service.IScaffoldingService;


/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public abstract class AScaffoldingEndPoint<DATA> implements IScaffoldingEndPoint<DATA>, IEndPointInitializer {

	protected IScaffoldingService<DATA> scaffoldingService;
	protected Logger LOGGER = LoggerFactory.getLogger(AScaffoldingEndPoint.class);
	
	@Override
	public Response findAll() {
		return constructFindResponse(scaffoldingService.findAll());		
	}

	@Override
	public Response findByCode(RequestFindByCode p_RequestFindByCode) {
		return constructFindResponse(scaffoldingService.findByCode(p_RequestFindByCode.getCode()));
	}

	@Override
	public Response findByName(RequestFindByName p_RequestFindByName) {
		return constructFindResponse(scaffoldingService.findByName(p_RequestFindByName.getName()));
	}
	
	@Override
	public Response constructFindResponse(List<DATA> p_DATA) {
		List<DATA> response = new ArrayList<DATA>();
		try{					
			if (p_DATA.size() > 0){
				response = p_DATA;
			}else{
				LOGGER.info(InfoMarkerConstant.INFO_DATA_NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_MERCHANDISE_TYPE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(response).build();
	}

}
