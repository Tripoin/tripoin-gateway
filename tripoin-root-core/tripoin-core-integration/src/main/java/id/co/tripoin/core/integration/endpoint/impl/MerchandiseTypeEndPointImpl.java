package id.co.tripoin.core.integration.endpoint.impl;

import javax.annotation.PostConstruct;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.IMerchandiseTypeEndPoint;
import id.co.tripoin.core.pojo.pos.MerchandiseType;
import id.co.tripoin.core.service.IMerchandiseTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.MERCHANDISE_TYPE_ENDPOINT_BEAN)
public class MerchandiseTypeEndPointImpl extends AScaffoldingEndPoint<MerchandiseType> implements IMerchandiseTypeEndPoint {
	
	@Autowired
	IMerchandiseTypeService merchandiseTypeService;

	@PostConstruct
	@Override
	public void init() {
		super.scaffoldingService = merchandiseTypeService;
	}	
}
