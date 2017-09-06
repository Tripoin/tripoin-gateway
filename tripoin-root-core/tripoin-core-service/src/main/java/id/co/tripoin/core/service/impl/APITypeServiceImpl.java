package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IAPITypeDao;
import id.co.tripoin.core.pojo.master.APIType;
import id.co.tripoin.core.service.IAPITypeService;
import id.co.tripoin.core.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service(BeanNameConstant.API_TYPE_SERVICE_BEAN)
public class APITypeServiceImpl extends AScaffoldingService<APIType> implements IAPITypeService {

	@Autowired
	private IAPITypeDao aPITypeDao;

	@Override
	public APIType findByApiTypeCode(String apiCode) {
		return aPITypeDao.findByCode(apiCode);
	}

	@PostConstruct
	@Override
	public void init() {
		scaffoldingDAO = aPITypeDao;
	}

}
