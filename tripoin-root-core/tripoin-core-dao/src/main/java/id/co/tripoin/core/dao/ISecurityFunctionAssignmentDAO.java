package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.SecurityFunctionAssignment;
import id.co.tripoin.core.pojo.security.SecurityGroup;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityFunctionAssignmentDAO extends IScaffoldingDAO<SecurityFunctionAssignment> {

    List<SecurityFunctionAssignment> findByGroup(SecurityGroup p_Group);
}
