package id.co.tripoin.core.integration.endpoint.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.response.MasterDataResponse;
import id.co.tripoin.core.integration.endpoint.IMerchandiseTypeEndPoint;
import id.co.tripoin.core.pojo.pos.MerchandiseType;
import id.co.tripoin.core.service.IMerchandiseTypeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.MERCHANDISE_TYPE_ENDPOINT_BEAN)
public class MerchandiseTypeEndPointImpl implements IMerchandiseTypeEndPoint {

	private static Logger LOGGER = LoggerFactory
			.getLogger(MerchandiseTypeEndPointImpl.class);
	
	@Autowired
	IMerchandiseTypeService merchandiseTypeService;

	@Override
	public Response findAll() {
		List<MasterDataResponse> dataResponses = new ArrayList<MasterDataResponse>();
		try{			
			List<MerchandiseType> merchandiseTypes = merchandiseTypeService.findAll();
			if (merchandiseTypes.size() > 0){
				for (MerchandiseType merchandiseType : merchandiseTypes){
					MasterDataResponse dataResponse = new MasterDataResponse();
					dataResponse = new MasterDataResponse();
					dataResponse.setCode(merchandiseType.getCode());
					dataResponse.setName(merchandiseType.getName());
					dataResponse.setRemarks(merchandiseType.getName());
					dataResponse.setStatus(merchandiseType.getStatus());
					dataResponses.add(dataResponse);
				}
			}
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_MERCHANDISE_TYPE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(dataResponses).build();
	}
	
	@Override
	public Response findByCode(String p_Code) {
		List<MasterDataResponse> dataResponses = new ArrayList<MasterDataResponse>();
		try{			
			List<MerchandiseType> merchandiseTypes = merchandiseTypeService.findByCode(p_Code);
			if (merchandiseTypes.size() > 0){
				for (MerchandiseType merchandiseType : merchandiseTypes){
					MasterDataResponse dataResponse = new MasterDataResponse();
					dataResponse = new MasterDataResponse();
					dataResponse.setCode(merchandiseType.getCode());
					dataResponse.setName(merchandiseType.getName());
					dataResponse.setRemarks(merchandiseType.getName());
					dataResponse.setStatus(merchandiseType.getStatus());
					dataResponses.add(dataResponse);
				}
			}else{
				LOGGER.info("Merchandise Type Size : 0");
			}
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_MERCHANDISE_TYPE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(dataResponses).build();
	}
	
	@Override
	public Response findByName(String p_Name) {
		List<MasterDataResponse> dataResponses = new ArrayList<MasterDataResponse>();
		try{			
			List<MerchandiseType> merchandiseTypes = merchandiseTypeService.findByName(p_Name);
			if (merchandiseTypes.size() > 0){
				for (MerchandiseType merchandiseType : merchandiseTypes){
					MasterDataResponse dataResponse = new MasterDataResponse();
					dataResponse = new MasterDataResponse();
					dataResponse.setCode(merchandiseType.getCode());
					dataResponse.setName(merchandiseType.getName());
					dataResponse.setRemarks(merchandiseType.getName());
					dataResponse.setStatus(merchandiseType.getStatus());
					dataResponses.add(dataResponse);
				}
			}else{
				LOGGER.info("Merchandise Type Size : 0");
			}
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_MERCHANDISE_TYPE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(dataResponses).build();
	}
}
