package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.APIType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public interface IAPITypeDao extends JpaRepository<APIType, Long>{

	public APIType findByApiTypeCode(String apiTypeCode);
}
