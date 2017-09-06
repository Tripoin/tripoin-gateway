package id.co.tripoin.core.dao;


import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.master.district.District;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDistrictDAO extends IScaffoldingDAO<District> {
	
	List<District> findByCity_id(Long p_CityId) throws DAOException;
	
	List<District> findByCity_code(String p_CityCode) throws DAOException;
	
	List<District> findByCity_name(String p_CityName) throws DAOException;
}
