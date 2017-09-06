package id.co.tripoin.core.dao.security;

import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.SecurityUserContact;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityUserContactDAO extends IScaffoldingDAO<SecurityUserContact> {
	
	SecurityUserContact findByEmail(String p_Email);
}
