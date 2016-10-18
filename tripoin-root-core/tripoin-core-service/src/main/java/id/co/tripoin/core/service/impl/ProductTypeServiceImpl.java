package id.co.tripoin.core.service.impl;

import javax.annotation.PostConstruct;

import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.core.dao.IProductTypeDAO;
import id.co.tripoin.core.pojo.pos.ProductType;
import id.co.tripoin.core.service.IProductTypeService;

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

	@Override
	public void insertData(String p_Code, String p_Name) throws ServiceException{
		ProductType productType = new ProductType();
		productType.setCode(p_Code);
		productType.setName(p_Name);
		merchandiseTypeDAO.save(productType);
	}
}
