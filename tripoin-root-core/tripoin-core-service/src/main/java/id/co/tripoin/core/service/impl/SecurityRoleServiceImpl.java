package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityRoleDAO;
import id.co.tripoin.core.pojo.security.Role;
import id.co.tripoin.core.service.ISecurityRoleService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityRoleServiceImpl extends AScaffoldingService<Role> implements ISecurityRoleService {

	@Autowired
	ISecurityRoleDAO securityRoleDAO;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = securityRoleDAO;
	}

}
