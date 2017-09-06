package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.ISecurityGroupEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityGroup;
import id.co.tripoin.core.service.ISecurityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_GROUP_BEAN)
public class SecurityGroupEndPointImpl extends AScaffoldingEndPoint<SecurityGroup> implements ISecurityGroupEndPoint {
    @Autowired
    ISecurityGroupService securityGroupService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityGroupService;
    }
}
