package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityBranchDAO;
import id.co.tripoin.core.pojo.security.SecurityBranch;
import id.co.tripoin.core.service.ISecurityBranchService;
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
public class SecurityBranchServiceImpl extends AScaffoldingService<SecurityBranch> implements ISecurityBranchService {

    @Autowired
    ISecurityBranchDAO securityBranchDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityBranchDAO;
    }
}
