package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.constant.statics.RoleConstant;
import id.co.tripoin.core.dto.request.RequestForgotPasswordDTO;
import id.co.tripoin.core.dto.request.RequestResetPasswordDTO;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created on 2017-03-08
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path(PathNameConstant.Security.PATH_PROFILE)
public interface IForgotPasswordEndPoint {
	
	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
    @POST
    @Path(PathNameConstant.Security.PATH_FORGOT_PASSWORD)
    Response forgotPasword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO);
    
    @Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
    @PUT
    @Path(PathNameConstant.Security.PATH_RESET_PASSWORD)
    Response resetPasword(RequestResetPasswordDTO p_RequestResetPasswordDTO);

}
