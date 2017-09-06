package id.co.tripoin.core.integration.endpoint.scaffolding.impl;

import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.IDATAMapper;
import id.co.tripoin.core.dto.request.*;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.IDataBuilderEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.IEndPointInitializer;
import id.co.tripoin.core.integration.endpoint.scaffolding.IResponseConstructor;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.integration.provider.TripoinAuthenticationProvider;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * 
 */
public abstract class AScaffoldingEndPoint<DATA> implements IScaffoldingEndPoint<DATA>, IEndPointInitializer {

	protected IScaffoldingService<DATA> scaffoldingService;
	protected IDATAMapper dataMapperIntegration;
	protected Logger LOGGER = LoggerFactory.getLogger(AScaffoldingEndPoint.class);

	@Autowired
	protected IResponseConstructor<DATA> scaffoldingResponseConstructor;

	@Autowired
	protected IDataBuilderEndPoint iDataBuilderEndPoint;

	@Autowired
	protected TripoinAuthenticationProvider tripoinAuthenticationProvider;

	/*===========================INQUIRY ENDPOINT IMPLEMENTATION===========================*/
	/*====================================DATA ENTITY======================================*/
	@Override
	public Response findAll(){
		try {
			if (dataMapperIntegration != null){
				return findAllDTO();
			}else {
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findAll());
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findPaginationAll(RequestPaginationAllDTO p_RequestPaginationAll) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationAll.getLimit(),
							p_RequestPaginationAll.getOffset(),
							p_RequestPaginationAll.getOrder(),
							p_RequestPaginationAll.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findAll(pr);
			if (dataMapperIntegration != null){
				return findPaginationAllDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findById(RequestFindById p_RequestFindById){
		try {
			if (dataMapperIntegration != null){
				return findByIdDTO(p_RequestFindById);
			}else{
				return scaffoldingResponseConstructor.constructSingleFindResponse(scaffoldingService.findById(p_RequestFindById.getId()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCode(RequestFindByCode p_RequestFindByCode) {
		try {
			if (dataMapperIntegration != null){
				return findByCodeDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCode(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) {
		try {
			if (dataMapperIntegration != null){
				return findByCodeOrderByCodeAscDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeAsc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeOrderByCodeDesc(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			if (dataMapperIntegration != null){
				return findByCodeOrderByCodeDescDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByCodeDesc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeOrderByIdAsc(RequestFindByCode p_RequestFindByCode) {
		try {
			if (dataMapperIntegration != null){
				return findByCodeOrderByIdAscDTO(p_RequestFindByCode);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByCodeOrderByIdAsc(p_RequestFindByCode.getCode()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findPaginationByCodeOrderByCodeAsc(RequestPaginationByCodeDTO p_RequestPaginationByCode) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationByCode.getLimit(),
							p_RequestPaginationByCode.getOffset(),
							p_RequestPaginationByCode.getOrder(),
							p_RequestPaginationByCode.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findByCodeOrderByCodeAsc(p_RequestPaginationByCode.getCode(), pr);
			if (dataMapperIntegration != null){
				return findPaginationByCodeOrderByCodeAscDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByName(RequestFindByName p_RequestFindByName) {
		try {
			if (dataMapperIntegration != null){
				return findByNameDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByName(p_RequestFindByName.getName()));
			}
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameOrderByIdAsc(RequestFindByName p_RequestFindByName) {
		try {
			if (dataMapperIntegration != null){
				return findByNameOrderByIdAscDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByIdAsc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) {
		try {
			if (dataMapperIntegration != null){
				return findByNameOrderByNameAscDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameAsc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameOrderByNameDesc(RequestFindByName p_RequestFindByName) throws EndPointException {
		try {
			if (dataMapperIntegration != null){
				return findByNameOrderByNameDescDTO(p_RequestFindByName);
			}else{
				return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.findByNameOrderByNameDesc(p_RequestFindByName.getName()));
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findPaginationByNameOrderByNameAsc(RequestPaginationByNameDTO p_RequestPaginationByName) {
		try {
			PageRequest pr = iDataBuilderEndPoint.buildPageRequest(
					iDataBuilderEndPoint.buildDTOPagination(
							p_RequestPaginationByName.getLimit(),
							p_RequestPaginationByName.getOffset(),
							p_RequestPaginationByName.getOrder(),
							p_RequestPaginationByName.getSort())
			);
			Page<DATA> dataPage = scaffoldingService.findByNameOrderByNameAsc(
					p_RequestPaginationByName.getName(),pr

			);
			if (dataMapperIntegration != null){
				return findPaginationByNameOrderByNameAscDTO(pr, dataPage);
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(dataPage);
			}
		} catch (EndPointException | ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response selectLOV() throws EndPointException {
		try{
			return scaffoldingResponseConstructor.constructListFindResponse(scaffoldingService.selectLOV());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	/*===========================INQUIRY ENDPOINT IMPLEMENTATION===========================*/
	/*=======================================DTO===========================================*/

	@Override
	public Response findPaginationByNameOrderByNameAscDTO(PageRequest p_PageRequest, Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public Response findByNameOrderByNameDescDTO(RequestFindByName p_RequestFindByName) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByNameDesc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameOrderByNameAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByNameAsc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameOrderByIdAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByNameOrderByIdAsc(p_RequestFindByName.getName())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByNameDTO(RequestFindByName p_RequestFindByName) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByName(p_RequestFindByName.getName())));
	}

	@Override
	public Response findPaginationByCodeOrderByCodeAscDTO(PageRequest p_PageRequest, Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public Response findByCodeOrderByCodeDescDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByIdAsc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeOrderByCodeAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByCodeDesc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeOrderByIdAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCodeOrderByCodeAsc(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByCodeDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findByCode(p_RequestFindByCode.getCode())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findByIdDTO(RequestFindById p_RequestFindById) throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOSingleFindResponse(dataMapperIntegration.convert(scaffoldingService.findById(p_RequestFindById.getId())));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response findPaginationAllDTO(PageRequest p_PageRequest, Page p_DataPage) throws EndPointException {
		return scaffoldingResponseConstructor.constructDTOPaginationResponse(dataMapperIntegration.mapEntityPageIntoDTOPage(p_PageRequest, p_DataPage));
	}

	@Override
	public Response findAllDTO() throws EndPointException {
		try {
			return scaffoldingResponseConstructor.constructDTOListFindResponse(dataMapperIntegration.mapEntitiesIntoDTOs(scaffoldingService.findAll()));
		} catch (ServiceException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	/*@Override
	public Response advancedPagination(RequestAdvancedPaginationDTO p_RequestAdvancedPaginationDTO) throws EndPointException {
		try {
			if (p_RequestAdvancedPaginationDTO.getFilterKey() == null || p_RequestAdvancedPaginationDTO.getFilterValue() == null){
				return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.findAll(
						iDataBuilderEndPoint.buildPageRequest(
								iDataBuilderEndPoint.buildDTOPagination(
										p_RequestAdvancedPaginationDTO.getLimit(),
										p_RequestAdvancedPaginationDTO.getOffset(),
										p_RequestAdvancedPaginationDTO.getOrder(),
										p_RequestAdvancedPaginationDTO.getSort())
						)
				));
			}else{
				return scaffoldingResponseConstructor.constructPaginationResponse(scaffoldingService.advancedPagination(
						p_RequestAdvancedPaginationDTO.getFilterKey(),
						p_RequestAdvancedPaginationDTO.getFilterValue(),
						iDataBuilderEndPoint.buildPageRequest(
								iDataBuilderEndPoint.buildDTOPagination(
										p_RequestAdvancedPaginationDTO.getLimit(),
										p_RequestAdvancedPaginationDTO.getOffset(),
										p_RequestAdvancedPaginationDTO.getOrder(),
										p_RequestAdvancedPaginationDTO.getSort())
						)
				));
			}
		} catch (EndPointException e) {
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return null;
		}
	}*/

	/*===========================TRANSACTION ENDPOINT IMPLEMENTATION===========================*/
	@Override
	public Response approveAll() throws EndPointException {
		try {
			scaffoldingService.approveAll();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response approveSingleData(RequestID p_RequestID) throws EndPointException {
		try {
			scaffoldingService.approveSingleData(Long.valueOf(p_RequestID.getId()));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response cancelAll()throws EndPointException {
		try {
			scaffoldingService.cancelAll();
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response cancelSingleData(RequestID p_RequestID) throws EndPointException {
		try {
			scaffoldingService.cancelSingleData(Long.valueOf(p_RequestID.getId()));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response updateData(DATA p_DATA) throws EndPointException{
		try {
			scaffoldingService.update(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response insertData(DATA p_DATA) throws EndPointException {
		try {
			scaffoldingService.setAuthenticationDTO(tripoinAuthenticationProvider.generateAuth());
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response insertAndFlushData(DATA p_DATA) throws EndPointException {
		try {
			scaffoldingService.insert(p_DATA);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response insertCollection(List<DATA> p_DATAs) throws EndPointException {
		try {
			scaffoldingService.insertCollection(p_DATAs);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response delete(String p_ID) throws EndPointException{
		try {
			scaffoldingService.delete(Long.valueOf(p_ID));
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | NumberFormatException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response deleteByEntity(String p_Code) throws EndPointException{
		try {
			LOGGER.info("CODE DELETE ENTITY : {}"+p_Code);
			scaffoldingService.deleteByEntity(p_Code);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response deleteCollection(List<String> p_Codes) throws EndPointException{
		try {
			scaffoldingService.deleteCollection(p_Codes);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}

	@Override
	public Response deleteCollectionById(List<String> p_IDs) throws EndPointException {
		try {
			List<Long> longList = new ArrayList<Long>();
			for (String str : p_IDs) longList.add(Long.valueOf(str));
			scaffoldingService.deleteCollectionById(longList);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildSuccessResponse());
		}catch (EndPointException | ServiceException e){
			LOGGER.error(InfoMarkerConstant.ERR_SCAFFOLDING_ENDPOINT);
			return scaffoldingResponseConstructor.constructSimpleTransactionResponse(iDataBuilderEndPoint.buildFailedResponse(e.getMessage()));
		}
	}
}