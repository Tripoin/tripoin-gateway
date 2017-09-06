package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.security.SecurityUserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityUserVerificationDAO extends JpaRepository<SecurityUserVerification, Long> {

	SecurityUserVerification findByToken(String p_Token);
}
