package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.integration.endpoint.IAdminMenuGeneratorEndPoint;
import id.co.tripoin.core.integration.servlet.UserAuthenticationContext;
import id.co.tripoin.core.service.IAdminMenuGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.MENU_ADMIN_GENERATOR_BEAN)
public class AdminMenuGeneratorEndPointImpl implements IAdminMenuGeneratorEndPoint {

    @Autowired
    IAdminMenuGenerator adminMenuGenerator;

    @Override
    public Response generateMenu() {
        return Response.ok(adminMenuGenerator.generateAdminMenu(UserAuthenticationContext.getInstance().getCurrentUsername())).build();
    }
}
