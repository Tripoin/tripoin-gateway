package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.SecurityFunction;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ISecurityFunctionDAO extends IScaffoldingDAO<SecurityFunction> {
	
	@Query("select a from SecurityFunction a where a.parentFunction = ?1")
    List<SecurityFunction> findByParentFunction(SecurityFunction p_Function) throws DAOException;
}
