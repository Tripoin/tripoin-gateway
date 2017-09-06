package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.master.province.Province;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProvinceDAO extends IScaffoldingDAO<Province> {
	
	List<Province> findProvinceByCountry_id(Long p_Id) throws DAOException;
	
	List<Province> findProvinceByCountry_code(String p_Code) throws DAOException;
	
	List<Province> findProvinceByCountry_name(String p_Name) throws DAOException;
}
