package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindById;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.ws.rs.core.Response;

/**
 * created on 2/1/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IInquiryEndPointResponseDTOConstructor<DATA> {

    Response findAllDTO() throws EndPointException;
    Response findPaginationAllDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;

    /*Property ID*/
    Response findByIdDTO(RequestFindById p_RequestFindById) throws EndPointException;

    /*Property Code*/
    Response findByCodeDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    Response findByCodeOrderByIdAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    Response findByCodeOrderByCodeAscDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    Response findByCodeOrderByCodeDescDTO(RequestFindByCode p_RequestFindByCode) throws EndPointException;
    Response findPaginationByCodeOrderByCodeAscDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;

    /*Property Name*/
    Response findByNameDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    Response findByNameOrderByIdAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    Response findByNameOrderByNameAscDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    Response findByNameOrderByNameDescDTO(RequestFindByName p_RequestFindByName) throws EndPointException;
    Response findPaginationByNameOrderByNameAscDTO(PageRequest p_PageRequest, Page<DATA> p_DataPage) throws EndPointException;
}
