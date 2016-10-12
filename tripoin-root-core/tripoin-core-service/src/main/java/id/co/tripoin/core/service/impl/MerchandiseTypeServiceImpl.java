package id.co.tripoin.core.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.core.dao.IMerchandiseTypeDAO;
import id.co.tripoin.core.pojo.pos.MerchandiseType;
import id.co.tripoin.core.service.IMerchandiseTypeService;

@Service
public class MerchandiseTypeServiceImpl extends ScaffoldingServiceImpl<MerchandiseType> implements IMerchandiseTypeService{

	@Autowired
	IMerchandiseTypeDAO merchandiseTypeDAO;
	
	@PostConstruct
	public void initializeDAO(){
		super.scaffoldingDAO = merchandiseTypeDAO;
	}
}
