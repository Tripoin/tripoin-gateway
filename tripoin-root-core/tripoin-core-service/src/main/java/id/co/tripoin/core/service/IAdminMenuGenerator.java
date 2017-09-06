package id.co.tripoin.core.service;

import id.co.tripoin.core.dto.response.AdminMenuDTO;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAdminMenuGenerator {

    List<AdminMenuDTO> generateAdminMenu(String p_UserName);
}
