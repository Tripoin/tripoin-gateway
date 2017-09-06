package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.master.APIType;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAPITypeService extends IScaffoldingService<APIType> {

	public APIType findByApiTypeCode(String apiCode);
}
