package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.security.ISecurityUserAddressDAO;
import id.co.tripoin.core.pojo.security.SecurityUserAddress;
import id.co.tripoin.core.service.ISecurityUserAddressService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SecurityUserAddressServiceImpl extends AScaffoldingService<SecurityUserAddress> implements ISecurityUserAddressService {

	@Autowired
	ISecurityUserAddressDAO securityUserAddressDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityUserAddressDAO;	
	}

}
