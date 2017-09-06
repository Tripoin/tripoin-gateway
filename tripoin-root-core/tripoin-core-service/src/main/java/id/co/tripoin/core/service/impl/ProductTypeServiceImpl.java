package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.IProductTypeDAO;
import id.co.tripoin.core.pojo.pos.ProductType;
import id.co.tripoin.core.service.IProductTypeService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductTypeServiceImpl extends AScaffoldingService<ProductType> implements IProductTypeService {

	@Autowired
	IProductTypeDAO merchandiseTypeDAO;
	
	@PostConstruct
	public void init() {
		super.scaffoldingDAO = merchandiseTypeDAO;
	}
}
