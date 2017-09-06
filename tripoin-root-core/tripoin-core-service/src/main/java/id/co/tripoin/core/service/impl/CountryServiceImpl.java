package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ICountryDAO;
import id.co.tripoin.core.pojo.master.country.Country;
import id.co.tripoin.core.service.ICountryService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CountryServiceImpl extends AScaffoldingService<Country> implements ICountryService {

    @Autowired
    ICountryDAO countryDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = countryDAO;
    }
}
