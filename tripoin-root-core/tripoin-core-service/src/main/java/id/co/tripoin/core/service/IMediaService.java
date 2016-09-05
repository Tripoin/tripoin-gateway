package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.Media;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public interface IMediaService {

	public Media findByApiTypeCode(String apiCode);
}
