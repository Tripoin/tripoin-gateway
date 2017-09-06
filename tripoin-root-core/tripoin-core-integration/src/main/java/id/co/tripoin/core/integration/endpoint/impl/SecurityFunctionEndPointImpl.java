package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.ISecurityFunctionEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityFunction;
import id.co.tripoin.core.service.ISecurityFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_FUNCTION_BEAN)
public class SecurityFunctionEndPointImpl extends AScaffoldingEndPoint<SecurityFunction> implements ISecurityFunctionEndPoint {

    @Autowired
    ISecurityFunctionService securityFunctionService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityFunctionService;
    }
}
