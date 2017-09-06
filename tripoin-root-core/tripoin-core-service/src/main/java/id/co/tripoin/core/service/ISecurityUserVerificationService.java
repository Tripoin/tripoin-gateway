package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.security.SecurityUserVerification;
import id.co.tripoin.core.pojo.security.User;

public interface ISecurityUserVerificationService {

	String insert(SecurityUserVerification p_SecurityUserVerification);
	
	String generateTokenVerification();
	
	boolean verifyToken(String p_Token);
	
	User findUserByToken(String p_Token);
}
