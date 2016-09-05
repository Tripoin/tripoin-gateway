package id.co.tripoin.core.service.impl;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IMediaDao;
import id.co.tripoin.core.pojo.Media;
import id.co.tripoin.core.service.IMediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Service(BeanNameConstant.MEDIA_SERVICE_BEAN)
public class MediaServiceImpl implements IMediaService{

	@Autowired
	private IMediaDao mediaDao;
	
	@Override
	public Media findByApiTypeCode(String apiCode) {
		// TODO Auto-generated method stub
		return mediaDao.findByApiTypeCode(apiCode);
	}

}
