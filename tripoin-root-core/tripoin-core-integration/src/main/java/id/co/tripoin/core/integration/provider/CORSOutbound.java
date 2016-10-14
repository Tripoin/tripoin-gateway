package id.co.tripoin.core.integration.provider;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class CORSOutbound implements ContainerResponseFilter {

	@Value("${tripoin.token.header}")
	private String tokenHeader;

	@Value("${tripoin.token.expiration}")
	private Long expiration;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		responseContext.getHeaders().putSingle("Access-Control-Max-Age", this.expiration);
		responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + this.tokenHeader);
	}

}
