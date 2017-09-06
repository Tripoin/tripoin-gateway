package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ICityDAO;
import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.pojo.master.city.City;
import id.co.tripoin.core.service.ICityService;
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
public class CityServiceImpl extends AScaffoldingService<City> implements ICityService {

    @Autowired
    ICityDAO cityDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = cityDAO;
    }

    @Override
    public List<City> findCityByProvinceCode(String p_ProvinceCode) {
        List<City> result = new ArrayList<>();
        try {
            result = cityDAO.findByProvince_code(p_ProvinceCode);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

    @Override
    public List<City> findCityByProvinceName(String p_ProvinceName) throws ServiceException {
        List<City> result = new ArrayList<>();
        try {
            result = cityDAO.findByProvince_name(p_ProvinceName);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }

    @Override
    public List<City> findCityByProvinceId(Long p_ProvinceId) throws ServiceException {
        List<City> result = new ArrayList<>();
        try {
            result = cityDAO.findByProvince_id(p_ProvinceId);
        } catch (DAOException e) {
            LOGGER.error(e.toString());
        }
        return result;
    }
}
