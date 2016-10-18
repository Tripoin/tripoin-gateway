package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.pos.ProductType;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProductTypeService extends IScaffoldingService<ProductType> {

    @Transactional
    void insertData(String p_Code, String p_Name) throws ServiceException;
}
