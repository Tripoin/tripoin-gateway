package id.co.tripoin.core.service.impl;

import java.util.List;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IMerchandiseTypeDAO;
import id.co.tripoin.core.dao.IScaffoldingDAO;
import id.co.tripoin.core.dao.exception.DAOExeption;
import id.co.tripoin.core.pojo.pos.MerchandiseType;
import id.co.tripoin.core.service.IScaffoldingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Service(BeanNameConstant.SCAFFOLDING_SERVICE_BEAN)
public class ScaffoldingServiceImpl<DATA> implements
		IScaffoldingService<DATA> {

	private static Logger LOGGER = LoggerFactory.getLogger(ScaffoldingServiceImpl.class);

	protected IScaffoldingDAO<DATA> scaffoldingDAO;

	@Override
	public List<DATA> findAll() {
		return (List<DATA>) scaffoldingDAO.findAll();
	}

	@Override
	public DATA findById(Long p_ID) {
		try {
			return (DATA) scaffoldingDAO.findById(p_ID);
		} catch (DAOExeption e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<DATA> findByCode(String p_Code) {
		try {
			return (List<DATA>) scaffoldingDAO.findByCode(p_Code);
		} catch (DAOExeption e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<DATA> findByName(String p_Name) {
		try {
			return (List<DATA>) scaffoldingDAO.findByName(p_Name);
		} catch (DAOExeption e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<DATA> pagination(Pageable p_Pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DATA> advancedPagination(Pageable p_Pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DATA> selectLOV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPhysicalColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(List<DATA> p_DATA) {
		/*try {
			iScaffoldingDAO.insert((List<MerchandiseType>) p_DATA);
		} catch (DAOExeption e) {
			LOGGER.error(e.getMessage());
		}*/

	}

	@Override
	public void update(List<DATA> p_DATA) {
		/*iScaffoldingDAO.update((List<MerchandiseType>) p_DATA);*/
		LOGGER.info("update");
	}

	@Override
	public void delete(List<Long> p_ID) {
		/*try {
			iScaffoldingDAO.delete(p_ID);
		} catch (DAOExeption e) {
			LOGGER.error(e.getMessage());
		}*/

	}

	@Override
	public void doCancellation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doApproval() {
		// TODO Auto-generated method stub

	}

}
