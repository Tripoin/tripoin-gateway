package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.master.province.Province;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProvinceService extends IScaffoldingService<Province> {
	
	List<Province> findProvinceByCountryId(Long p_CountryId) throws ServiceException;
	
	List<Province> findProvinceByCountryCode(String p_CountryCode) throws ServiceException;
	
	List<Province> findProvinceByCountryName(String p_CountryName) throws ServiceException;
}
