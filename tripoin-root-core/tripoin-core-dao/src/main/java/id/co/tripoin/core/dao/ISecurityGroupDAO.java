package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.Role;
import id.co.tripoin.core.pojo.security.SecurityGroup;
import org.springframework.data.jpa.repository.Query;


/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityGroupDAO extends IScaffoldingDAO<SecurityGroup> {

    @Query("SELECT a FROM SecurityGroup a JOIN a.users b WHERE b.username = ?1")
    SecurityGroup findGroupByUserName(String p_UserName) throws DAOException;
    
    SecurityGroup findByName(String p_GroupName) throws DAOException;
    
    SecurityGroup findByRole(Role p_Role) throws DAOException;
    
    SecurityGroup findByCodeAndRole_Authority(String p_Code, String p_Authority) throws DAOException;
    
    SecurityGroup findByRole_Authority(String p_Authority) throws DAOException;
}
