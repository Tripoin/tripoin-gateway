package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.security.ISecurityUserContactDAO;
import id.co.tripoin.core.pojo.security.SecurityUserContact;
import id.co.tripoin.core.service.ISecurityUserContactService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SecurityUserContactServiceImpl extends AScaffoldingService<SecurityUserContact> implements ISecurityUserContactService {

	@Autowired
	ISecurityUserContactDAO securityUserContactDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityUserContactDAO;
	}

}
