package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.pojo.master.village.Village;

import java.util.List;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IVillageDAO extends IScaffoldingDAO<Village> {

	List<District> findByDistrict_id(Long p_DistrictId) throws DAOException;
	
	List<District> findByDistrict_code(String p_DistrictCode) throws DAOException;

	List<District> findByDistrict_name(String p_DistrictName) throws DAOException;
}
