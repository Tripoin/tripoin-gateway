package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityBranch;
import id.co.tripoin.core.service.ISecurityBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_BRANCH_BEAN)
public class SecurityBranchEndPointImpl extends AScaffoldingEndPoint<SecurityBranch> implements IScaffoldingEndPoint<SecurityBranch> {

    @Autowired
    ISecurityBranchService securityBranchService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityBranchService;
    }
}
