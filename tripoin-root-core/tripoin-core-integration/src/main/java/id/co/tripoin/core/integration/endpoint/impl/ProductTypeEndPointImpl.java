package id.co.tripoin.core.integration.endpoint.impl;

import javax.annotation.PostConstruct;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dto.request.producttype.InsertDataProductTypeDTO;
import id.co.tripoin.core.integration.endpoint.IProductTypeEndPoint;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.pos.ProductType;
import id.co.tripoin.core.service.IProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.MERCHANDISE_TYPE_ENDPOINT_BEAN)
public class ProductTypeEndPointImpl extends AScaffoldingEndPoint<ProductType> implements IProductTypeEndPoint {
	
	@Autowired
	IProductTypeService merchandiseTypeService;

	@PostConstruct
	@Override
	public void init() {
		super.scaffoldingService = merchandiseTypeService;
	}

	@Override
	public void insertData(InsertDataProductTypeDTO p_InsertDataProductTypeDTO) throws EndPointException {
		merchandiseTypeService.insertData(p_InsertDataProductTypeDTO.getCode(), p_InsertDataProductTypeDTO.getName());
	}
}
