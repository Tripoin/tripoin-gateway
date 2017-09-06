package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.ISecurityCompanyEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityCompany;
import id.co.tripoin.core.service.ISecurityCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_COMPANY_BEAN)
public class SecurityCompanyEndPointImpl extends AScaffoldingEndPoint<SecurityCompany> implements ISecurityCompanyEndPoint {
    @Autowired
    ISecurityCompanyService securityCompanyService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityCompanyService;
    }
}
