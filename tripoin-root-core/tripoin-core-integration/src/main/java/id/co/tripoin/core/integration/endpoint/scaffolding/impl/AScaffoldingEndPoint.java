package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.request.*;
import id.co.tripoin.core.integration.endpoint.scaffolding.IEndPointInitializer;
import id.co.tripoin.core.integration.endpoint.scaffolding.IDataBuilderEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.IResponseConstructor;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;
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
	IResponseConstructor<DATA> scaffoldingResponseConstructor;

	@Autowired
	IDataBuilderEndPoint iDataBuilderEndPoint;

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
	public Response findPaginationAll(RequestPaginationAll p_RequestPaginationAll) {
		try {
			return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findAll(
					iDataBuilderEndPoint.buildPageRequest(
							iDataBuilderEndPoint.buildDTOPagination(
									p_RequestPaginationAll.getLimit(),
									p_RequestPaginationAll.getOffset(),
									p_RequestPaginationAll.getOrder(),
									p_RequestPaginationAll.getSort())
					)
			));
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
	public Response findByCodeOrderByCodeDesc(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeDesc(p_RequestFindByCode.getCode()));
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
	public Response findPaginationByCodeOrderByCodeAsc(RequestPaginationByCode p_RequestPaginationByCode) {
		try {
			return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findByCodeOrderByCodeAsc(
					p_RequestPaginationByCode.getCode(),
					iDataBuilderEndPoint.buildPageRequest(
							iDataBuilderEndPoint.buildDTOPagination(
									p_RequestPaginationByCode.getLimit(),
									p_RequestPaginationByCode.getOffset(),
									p_RequestPaginationByCode.getOrder(),
									p_RequestPaginationByCode.getSort())
					)
			));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
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
	public Response findByNameOrderByNameDesc(RequestFindByName p_RequestFindByName) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameDesc(p_RequestFindByName.getName()));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response findPaginationByNameOrderByNameAsc(RequestPaginationByName p_RequestPaginationByName) {
		try {
			return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findByNameOrderByNameAsc(
					p_RequestPaginationByName.getName(),
					iDataBuilderEndPoint.buildPageRequest(
							iDataBuilderEndPoint.buildDTOPagination(
									p_RequestPaginationByName.getLimit(),
									p_RequestPaginationByName.getOffset(),
									p_RequestPaginationByName.getOrder(),
									p_RequestPaginationByName.getSort())
					)
			));
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response selectLOV() throws EndPointException {
		try{
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.selectLOV());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response doApproval() throws EndPointException {
		SimpleTransactionDTO simpleTransactionDTO = new SimpleTransactionDTO();
		try {
			scaffoldingService.doApproval();
			simpleTransactionDTO.setTransactionStatus(1);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(simpleTransactionDTO);
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}



	@Override
	public Response doCancellation() {
		SimpleTransactionDTO simpleTransactionDTO = new SimpleTransactionDTO();
		try {
			scaffoldingService.doCancellation();
			simpleTransactionDTO.setTransactionStatus(0);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(simpleTransactionDTO);
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}

	@Override
	public Response setBaseDataById(BaseUpdateDTO p_BaseUpdateDTO) {
		SimpleTransactionDTO simpleTransactionDTO = new SimpleTransactionDTO();
		try {
			scaffoldingService.updateBaseData(p_BaseUpdateDTO.getId(), p_BaseUpdateDTO.getCode(), p_BaseUpdateDTO.getName(), p_BaseUpdateDTO.getRemarks());
			simpleTransactionDTO.setTransactionStatus(0);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(simpleTransactionDTO);
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}
}
