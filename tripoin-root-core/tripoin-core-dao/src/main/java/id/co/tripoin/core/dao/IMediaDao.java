package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.Media;
import id.co.tripoin.core.pojo.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public interface IMediaDao extends JpaRepository<Media, Long>{

	public Media findByApiTypeCode(String apiTypeCode);
}
