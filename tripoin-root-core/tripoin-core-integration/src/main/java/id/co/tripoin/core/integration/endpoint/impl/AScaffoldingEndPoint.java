package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindById;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.dto.request.RequestPagination;
import id.co.tripoin.core.integration.endpoint.IEndPointInitializer;
import id.co.tripoin.core.integration.endpoint.IScaffoldingEndPoint;
import id.co.tripoin.core.integration.endpoint.IScaffoldingResponseConstructor;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.service.IScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;


/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public abstract class AScaffoldingEndPoint<DATA> implements IScaffoldingEndPoint, IEndPointInitializer {

	protected IScaffoldingService<DATA> scaffoldingService;
	protected Logger LOGGER = LoggerFactory.getLogger(AScaffoldingEndPoint.class);

	@Autowired
	IScaffoldingResponseConstructor<DATA> scaffoldingResponseConstructor;

	@Override
	public Response findAll(){
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findAll());
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findPaginationAll(RequestPagination p_RequestPagination) {
		try {
			return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findAll(p_RequestPagination.getPageable()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findById(RequestFindById p_RequestFindById){
		try {
			return scaffoldingResponseConstructor.constructSingleFindResponse(scaffoldingService.findById(p_RequestFindById.getId()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findByCode(RequestFindByCode p_RequestFindByCode) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCode(p_RequestFindByCode.getCode()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeAsc(p_RequestFindByCode.getCode()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findByCodeOrderByIdAsc(RequestFindByCode p_RequestFindByCode) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByIdAsc(p_RequestFindByCode.getCode()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findPaginationByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) {
		return null;
	}

	@Override
	public Response findByName(RequestFindByName p_RequestFindByName) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByName(p_RequestFindByName.getName()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findByNameOrderByIdAsc(RequestFindByName p_RequestFindByName) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByIdAsc(p_RequestFindByName.getName()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameAsc(p_RequestFindByName.getName()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findPaginationByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) {
		return null;
	}
}
