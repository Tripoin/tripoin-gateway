package id.co.tripoin.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import id.co.tripoin.core.pojo.pos.MerchandiseType;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public interface IMerchandiseTypeDAO extends JpaRepository<MerchandiseType, Long>, IScaffoldingDAO<MerchandiseType>{
}
