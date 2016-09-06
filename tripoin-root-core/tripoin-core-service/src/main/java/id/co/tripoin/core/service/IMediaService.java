package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.APIType;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public interface IMediaService {

	public APIType findByApiTypeCode(String apiCode);
}
