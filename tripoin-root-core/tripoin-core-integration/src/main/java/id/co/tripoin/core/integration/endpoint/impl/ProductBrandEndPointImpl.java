package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.IProductBrandEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.pos.ProductBrand;
import id.co.tripoin.core.service.IProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created on 10/19/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.PRODUCT_BRAND_ENDPOINT_BEAN)
public class ProductBrandEndPointImpl extends AScaffoldingEndPoint<ProductBrand> implements IProductBrandEndPoint{

    @Autowired
    IProductBrandService productBrandService;

    @Override
    public void init() {
        scaffoldingService = productBrandService;
    }
}
