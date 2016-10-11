package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IAPITypeDao;
import id.co.tripoin.core.pojo.APIType;
import id.co.tripoin.core.service.IAPITypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Service(BeanNameConstant.API_TYPE_SERVICE_BEAN)
public class APITypeServiceImpl implements IAPITypeService {

	@Autowired
	private IAPITypeDao aPITypeDao;

	@Override
	public APIType findByApiTypeCode(String apiCode) {
		// TODO Auto-generated method stub
		return aPITypeDao.findByCode(apiCode);
	}

}
