package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.pojo.master.village.Village;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

import java.util.List;

/**
 * created on 1/10/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IVillageService extends IScaffoldingService<Village> {
	
	List<District> findVillageByDistrictId(Long p_DistrictId) throws ServiceException;
	
	List<District> findVillageByDistrictCode(String p_DistrictCode) throws ServiceException;
	
	List<District> findVillageByDistrictName(String p_DistrictName) throws ServiceException;

}
