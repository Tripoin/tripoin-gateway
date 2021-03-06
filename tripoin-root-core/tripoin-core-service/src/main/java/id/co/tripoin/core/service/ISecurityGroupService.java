package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.security.SecurityGroup;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityGroupService extends IScaffoldingService<SecurityGroup> {
	
	SecurityGroup findByAuthority(String p_Authority);
}
