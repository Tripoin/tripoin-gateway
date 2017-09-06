package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityFunctionDAO;
import id.co.tripoin.core.pojo.security.SecurityFunction;
import id.co.tripoin.core.service.ISecurityFunctionService;
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
public class SecurityFunctionServiceImpl extends AScaffoldingService<SecurityFunction> implements ISecurityFunctionService {

    @Autowired
    ISecurityFunctionDAO securityFunctionDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityFunctionDAO;
    }
}
