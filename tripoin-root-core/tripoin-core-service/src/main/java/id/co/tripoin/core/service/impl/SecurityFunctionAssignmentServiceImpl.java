package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityFunctionAssignmentDAO;
import id.co.tripoin.core.pojo.security.SecurityFunctionAssignment;
import id.co.tripoin.core.service.ISecurityFunctionAssignmentService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityFunctionAssignmentServiceImpl extends AScaffoldingService<SecurityFunctionAssignment> implements ISecurityFunctionAssignmentService {
    @Autowired
    ISecurityFunctionAssignmentDAO securityFunctionAssignmentDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityFunctionAssignmentDAO;
    }
}
