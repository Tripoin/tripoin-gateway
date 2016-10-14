package id.co.tripoin.core.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.core.dao.IMerchandiseTypeDAO;
import id.co.tripoin.core.pojo.pos.MerchandiseType;
import id.co.tripoin.core.service.IMerchandiseTypeService;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class MerchandiseTypeServiceImpl extends AScaffoldingService<MerchandiseType> implements IMerchandiseTypeService{

	@Autowired
	IMerchandiseTypeDAO merchandiseTypeDAO;
	
	@PostConstruct
	public void init() {
		super.scaffoldingDAO = merchandiseTypeDAO;
	}
	
}
