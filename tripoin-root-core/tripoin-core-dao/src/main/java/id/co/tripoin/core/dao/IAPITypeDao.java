package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.master.APIType;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
public interface IAPITypeDao extends IScaffoldingDAO<APIType> {

	public APIType findByCode(String code);
}
