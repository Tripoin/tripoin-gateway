package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.constant.statics.RoleConstant;
import id.co.tripoin.core.dto.request.RequestUpdatePasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdateProfileDTO;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityUserProfile;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path(PathNameConstant.Security.PATH_PROFILE)
public interface ISecurityUserProfileEndPoint extends IScaffoldingEndPoint<SecurityUserProfile> {

    @Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
    @GET
    @Path(PathNameConstant.Security.PATH_GET_PROFILE)
    Response getProfile();

    @Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
    @POST
    @Path(PathNameConstant.Security.PATH_UPDATE_PROFILE)
    Response updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO);
    
    @Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
    @PUT
    @Path(PathNameConstant.Security.PATH_UPDATE_PASSWORD)
    Response updatePasword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO);
}
