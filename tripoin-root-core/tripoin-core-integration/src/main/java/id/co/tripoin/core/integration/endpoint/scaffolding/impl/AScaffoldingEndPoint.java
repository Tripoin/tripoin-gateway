package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.request.BaseRequestDTO;
import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindById;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.dto.request.RequestPaginationAllDTO;
import id.co.tripoin.core.dto.request.RequestPaginationByCodeDTO;
import id.co.tripoin.core.dto.request.RequestPaginationByNameDTO;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.IDataBuilderEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.IEndPointInitializer;
import id.co.tripoin.core.integration.endpoint.scaffolding.IResponseConstructor;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;


/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public abstract class AScaffoldingEndPoint<DATA> implements IScaffoldingEndPoint<DATA, Long>, IEndPointInitializer {

	protected IScaffoldingService<DATA> scaffoldingService;
	protected Logger LOGGER = LoggerFactory.getLogger(AScaffoldingEndPoint.class);

	@Autowired
	IResponseConstructor<DATA> scaffoldingResponseConstructor;

	@Autowired
	IDataBuilderEndPoint iDataBuilderEndPoint;

	/*===========================INQUIRY ENDPOINT IMPLEMENTATION===========================*/
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
	public Response findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAll) {
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
	public Response findPaginationByCodeOrderByCodeAsc(RequestPaginationByCodeDTO p_RequestPaginationByCode) {
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
	public Response findPaginationByNameOrderByNameAsc(RequestPaginationByNameDTO p_RequestPaginationByName) {
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

	/*===========================TRANSACTION ENDPOINT IMPLEMENTATION===========================*/
	@Override
	public Response doApproval() throws EndPointException {
		try {
			scaffoldingService.doApproval();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}



	@Override
	public Response doCancellation()throws EndPointException {
		try {
			scaffoldingService.doCancellation();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response updateData(BaseRequestDTO p_BaseRequestDTO) throws EndPointException{
		try {
			scaffoldingService.updateBaseData(p_BaseRequestDTO.getId(), p_BaseRequestDTO.getCode(), p_BaseRequestDTO.getName(), p_BaseRequestDTO.getRemarks());
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response insertData(DATA p_DATA) throws EndPointException {
		try {
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response insertAndFlushData(DATA p_DATA) throws EndPointException {
		try {
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response insertCollection(List<DATA> p_DATAs) throws EndPointException {
		try {
			scaffoldingService.insertCollection(p_DATAs);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response delete(Long p_ID) throws EndPointException{
		try {
			scaffoldingService.delete(p_ID);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response deleteByEntity(DATA p_DATA) throws EndPointException{
		try {
			scaffoldingService.deleteByEntity(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}

	@Override
	public Response deleteCollection(List<DATA> p_DATAs) throws EndPointException{
		try {
			scaffoldingService.deleteCollection(p_DATAs);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse());
		}
	}
}
