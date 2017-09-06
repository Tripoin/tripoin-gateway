package id.co.tripoin.core.dao;


import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.master.city.City;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICityDAO extends IScaffoldingDAO<City> {
	
	List<City> findByProvince_code(String p_ProvinceCode) throws DAOException;
	
	List<City> findByProvince_name(String p_ProvinceName) throws DAOException;
	
	List<City> findByProvince_id(Long p_ProvinceId) throws DAOException;
}
