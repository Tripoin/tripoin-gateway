package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.ISecurityRoleEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.Role;
import id.co.tripoin.core.service.ISecurityRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_ROLE_BEAN)
public class SecurityRoleEndPointImpl extends AScaffoldingEndPoint<Role> implements ISecurityRoleEndPoint {

	@Autowired
	ISecurityRoleService securityRoleService;
	
	@PostConstruct
	@Override
	public void init() {
		scaffoldingService = securityRoleService;
	}

}
