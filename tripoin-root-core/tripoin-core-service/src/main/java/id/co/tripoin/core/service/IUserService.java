package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.security.User;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserService {
	
	/**
	 * 
	 * @param p_User
	 * @return -1 : failed || 0 : success
	 */
	int insert(User p_User);

	User findByEmail(String p_Email);
	
	User findByUserName(String p_UserName);
	
	User findById(Long p_Id);
	
	/**
	 * 
	 * @param p_User
	 * @return -1 : failed || 0 : success
	 */
	int update(User p_User);
}
