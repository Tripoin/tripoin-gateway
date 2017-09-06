package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.IProductBrandDAO;
import id.co.tripoin.core.pojo.pos.ProductBrand;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 10/19/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ProductBrandServiceImpl extends AScaffoldingService<ProductBrand> implements IScaffoldingService<ProductBrand> {

    @Autowired
    IProductBrandDAO productBrandDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = productBrandDAO;
    }
}
