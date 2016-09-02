package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.constant.statics.PathNameConstant;
import id.co.tripoin.constant.statics.RoleConstant;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IAuthenticationEndpoint {
	
	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@Path(PathNameConstant.PATH_AUTHENTICATION_CHANGE)
	@POST
	public Response postChange(String oldAccess, String newAccess);
	
}
