package id.co.tripoin.test.core.integration.service;

import id.co.tripoin.constant.statics.RoleConstant;
import id.co.tripoin.test.core.dto.CurrencyDTORequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;

/**
 * <b>Description:</b><br>
 * &emsp;&emsp;&emsp;if all of the methods are the same path, path can be added here</br>
 * &emsp;&emsp;&emsp;<code>@Path("/service")</code></br>
 * &emsp;&emsp;&emsp;<code>public interface ISampleService</code>
 * 
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 **/
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("/service")
public interface ISampleService {

	/**
	 * <b>Description:</b><br>
	 * &emsp;&emsp;&emsp;URI : <code>www.tripoin.co.id/api/sample/service</code></br>
	 * &emsp;&emsp;&emsp;Body : <code>{"currencyCode":"IDR"}</code></br></br>
	 * &emsp;&emsp;&emsp;if path is different for each method, path can be added here</br>
	 * &emsp;&emsp;&emsp;<code>@Path("/servicepost")</code></br>
	 * &emsp;&emsp;&emsp;<code>public Response postCurrency(CurrencyDTORequest currencyCode)</code>
	 * 
	 * @param currencyCode
	 * @return
	 */
	@Secured({RoleConstant.ROLE_USER})
	@POST
	public Response postCurrency(CurrencyDTORequest currencyCode);

	/**
	 * <b>Description:</b><br>
	 * &emsp;&emsp;&emsp;URI : <code>www.tripoin.co.id/api/sample/service/IDR</code></br></br>
	 * &emsp;&emsp;&emsp;if path is different for each method, the path can be added here</br>
	 * &emsp;&emsp;&emsp;<code>@Path("/serviceget/{currencyCode}")</code></br>
	 * &emsp;&emsp;&emsp;<code>public Response getCurrency()</code>
	 * 
	 * @param currencyCode
	 * @return
	 */
	

	@Secured({RoleConstant.ROLE_USER})
	@GET
	@Path("/{currencyCode}")
	public Response getCurrency(@PathParam("currencyCode") String currencyCode);
	
}
