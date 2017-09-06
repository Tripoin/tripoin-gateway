package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.IDistrictDAO;
import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.pojo.master.district.District;
import id.co.tripoin.core.service.IDistrictService;
import id.co.tripoin.core.service.exception.ServiceException;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class DistrictServiceImpl extends AScaffoldingService<District> implements IDistrictService {

    @Autowired
	IDistrictDAO districtDAO;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DistrictServiceImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = districtDAO;
    }
    
    @Override
    public List<District> findDistrictByCityId(Long p_CityId) throws ServiceException {
    	List<District> result = new ArrayList<>();
    	try {
			result = districtDAO.findByCity_id(p_CityId);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
    }
    
    @Override
    public List<District> findDistrictByCityCode(String p_CityCode) throws ServiceException {
    	List<District> result = new ArrayList<>();
    	try {
			result = districtDAO.findByCity_code(p_CityCode);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
    }
    
    @Override
    public List<District> findDistrictByCityName(String p_CityName) throws ServiceException {
    	List<District> result = new ArrayList<>();
    	try {
			result = districtDAO.findByCity_name(p_CityName);
		} catch (DAOException e) {
			LOGGER.error(e.toString());			
		}
    	return result;
    }
}
