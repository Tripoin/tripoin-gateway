package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.pos.MerchandiseType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingDAO extends JpaRepository<MerchandiseType, Long>, 
ITransactionDAO<MerchandiseType, Long>, 
IInquiryDAO<MerchandiseType, Long>{}
