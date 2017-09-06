package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.constant.statics.RoleConstant;
import id.co.tripoin.core.dto.request.AuthenticationDataRequest;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IAuthenticationEndpoint {
	
	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@Path(PathNameConstant.PATH_CHANGE)
	@PUT
	public Response putChange(AuthenticationDataRequest authenticationDataRequest);


	/*@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@Path(PathNameConstant.PATH_LOGOUT)
	@POST*/
	public Response logout();

	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@Path(PathNameConstant.PATH_LOGOUT)
	@POST
	public Response logoutJwt();
}
