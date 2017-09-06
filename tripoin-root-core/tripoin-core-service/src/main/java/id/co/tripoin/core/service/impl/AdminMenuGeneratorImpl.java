package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityFunctionAssignmentDAO;
import id.co.tripoin.core.dao.ISecurityFunctionDAO;
import id.co.tripoin.core.dao.ISecurityGroupDAO;
import id.co.tripoin.core.dao.exception.DAOException;
import id.co.tripoin.core.dto.response.AdminMenuDTO;
import id.co.tripoin.core.pojo.security.SecurityFunction;
import id.co.tripoin.core.pojo.security.SecurityFunctionAssignment;
import id.co.tripoin.core.pojo.security.SecurityGroup;
import id.co.tripoin.core.service.IAdminMenuGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AdminMenuGeneratorImpl implements IAdminMenuGenerator {

    @Autowired
    ISecurityFunctionDAO securityFunctionDAO;

    @Autowired
    ISecurityFunctionAssignmentDAO securityFunctionAssignmentDAO;

    @Autowired
    ISecurityGroupDAO securityGroupDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminMenuGeneratorImpl.class);

    @Override
    public List<AdminMenuDTO> generateAdminMenu(String p_UserName){
        SecurityGroup securityGroup = null;
        try {
            securityGroup = securityGroupDAO.findGroupByUserName(p_UserName);
        } catch (DAOException e) {
            LOGGER.error("Error getting group ", e.toString());
        }
        List<AdminMenuDTO> result = new ArrayList<>();
        List<SecurityFunction> securityFunctions = new ArrayList<>();
        List<SecurityFunctionAssignment> securityFunctionAssignments = securityFunctionAssignmentDAO.findByGroup(securityGroup);
        for (SecurityFunctionAssignment securityFunctionAssignment : securityFunctionAssignments){            
            securityFunctions.add(securityFunctionDAO.findOne(securityFunctionAssignment.getFunction().getId()));                
        }
        for (SecurityFunction securityFunction : securityFunctions){
        	List<AdminMenuDTO> generatedSubMenu = new ArrayList<>();        	
            if (securityFunction.getParentFunction() == null){
            	AdminMenuDTO itemMenu = new AdminMenuDTO();
                itemMenu.setCode(securityFunction.getCode());
                itemMenu.setName(securityFunction.getName());
                itemMenu.setLink(securityFunction.getUrl());
                itemMenu.setStyle(securityFunction.getStyle());
                itemMenu.setOrder(securityFunction.getOrder());
                itemMenu.setLevel(securityFunction.getLevel());
                itemMenu.setParent(null);
                try {
					for (SecurityFunction subMenu : securityFunctionDAO.findByParentFunction(securityFunction)){
						AdminMenuDTO itemSubMenu = new AdminMenuDTO();
					    itemSubMenu.setCode(subMenu.getCode());
					    itemSubMenu.setName(subMenu.getName());
					    itemSubMenu.setLink(subMenu.getUrl());
					    itemSubMenu.setStyle(subMenu.getStyle());
					    itemSubMenu.setOrder(subMenu.getOrder());
					    itemSubMenu.setLevel(subMenu.getLevel());
					    itemSubMenu.setParent(securityFunction.getId());
					    itemSubMenu.setSubMenu(null);
					    generatedSubMenu.add(itemSubMenu);
					}
				} catch (DAOException e) {
					LOGGER.error("Error selection Security Function {}", e.toString());
				}
                itemMenu.setSubMenu(generatedSubMenu);
                result.add(itemMenu);            	            	
            }            
        }
        return result;
    }
}
