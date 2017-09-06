package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.ISecurityFunctionAssignmentEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityFunctionAssignment;
import id.co.tripoin.core.service.ISecurityFunctionAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_FUNCTION_ASSIGNMENT_BEAN)
public class SecurityFunctionAssignmentEndPointImpl extends AScaffoldingEndPoint<SecurityFunctionAssignment> implements ISecurityFunctionAssignmentEndPoint {
    @Autowired
    ISecurityFunctionAssignmentService securityFunctionAssignmentService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityFunctionAssignmentService;
    }
}
