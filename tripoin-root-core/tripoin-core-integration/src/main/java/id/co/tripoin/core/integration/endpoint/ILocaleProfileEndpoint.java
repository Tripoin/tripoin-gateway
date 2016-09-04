package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.constant.statics.PathNameConstant;
import id.co.tripoin.constant.statics.RoleConstant;
import id.co.tripoin.core.dto.request.I18NLocaleDataRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
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
@Path(PathNameConstant.PATH_LOCALE)
public interface ILocaleProfileEndpoint {

	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@PUT
	@Path(PathNameConstant.PATH_CHANGE)
	public Response putLocaleProfile(I18NLocaleDataRequest i18NLocaleDataRequest);
	
}
