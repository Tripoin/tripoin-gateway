package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityCompanyDAO;
import id.co.tripoin.core.pojo.security.SecurityCompany;
import id.co.tripoin.core.service.ISecurityCompanyService;
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
public class SecurityCompanyServiceImpl extends AScaffoldingService<SecurityCompany> implements ISecurityCompanyService {

    @Autowired
    ISecurityCompanyDAO securityCompanyDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = securityCompanyDAO;
    }
}
