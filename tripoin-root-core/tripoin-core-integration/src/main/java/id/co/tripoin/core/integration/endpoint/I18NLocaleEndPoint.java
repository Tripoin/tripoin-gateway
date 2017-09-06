package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.constant.statics.RoleConstant;
import id.co.tripoin.core.dto.request.I18NLocaleDataRequest;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.I18NLocale;
import org.springframework.security.access.annotation.Secured;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created on 2017-03-09
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path(PathNameConstant.PATH_LOCALE)
public interface I18NLocaleEndPoint extends IScaffoldingEndPoint<I18NLocale> {

	@Secured({RoleConstant.ROLE_USER , RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_SUPERADMIN})
	@PUT
	@Path(PathNameConstant.PATH_CHANGE)
	public Response putLocaleProfile(I18NLocaleDataRequest i18NLocaleDataRequest);
	
}
