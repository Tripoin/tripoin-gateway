package id.co.tripoin.core.integration.provider;

import id.co.tripoin.constant.statics.CommonConstant;
import id.co.tripoin.constant.statics.ResourcePropertiesConstant;
import id.co.tripoin.core.integration.security.HeaderKeyGenerator;
import id.co.tripoin.core.integration.security.HeaderSignatureGenerator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.tripoin.util.io.TransformInputStream;
import com.tripoin.util.time.FormatDateConstant;

/**
 * <b>Filter Signature Header:</b></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Key &emsp;&emsp;&emsp;&nbsp;&nbsp;: 85adc8e352ddf41c0cf4a08ecf93085f <i>from HeaderKeyGenerator.key()</i></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Timestamp : 2016-02-03T10:00:00.000+07:00 <i>format date = yyyy-MM-dd'T'HH:mm:ss.SSSXXX refer ISO8601</i></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Signature &nbsp;&nbsp; : acb476a3ad5940f8e790154f5033f1e853a6ba4fac4da03230fe4c4b86f6ad0c</br>
 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;<i>from HeaderSignatureGenerator.signature(apiKey, accessToken, method, body, path, timestamp)</i></br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a></br>
 */
public class SignatureHeaderInbound implements ContainerRequestFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SignatureHeaderInbound.class);	
	private String apiKey;
	private String accessToken;
	private String method;
	private String path;
	private String timestamp;
	private String body;
	private String signature;
	private ByteArrayOutputStream entity;

	@Value(ResourcePropertiesConstant.PARAM_HEADER_KEY)
	private String paramKey;
	
	@Value(ResourcePropertiesConstant.PARAM_HEADER_TIMESTAMP)
	private String paramTimestamp;
	
	@Value(ResourcePropertiesConstant.PARAM_HEADER_SIGNATURE)
	private String paramSignature;

	@Value(ResourcePropertiesConstant.WSCONTEXT)
	private String wscontext;
	
	private HeaderKeyGenerator headerKey;
	
	public void setHeaderKey(HeaderKeyGenerator headerKey) {
		this.headerKey = headerKey;
	}

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		try {
			if(context.getHeaders().containsKey(paramKey) &&
					context.getHeaders().containsKey(paramTimestamp) &&
					context.getHeaders().containsKey(paramSignature)){
				// TODO: Validate X-Tripoin-Key
				if(!headerKey.key().equals(context.getHeaderString(paramKey))){
					throw new Exception();
				}
				// TODO: Validate X-Tripoin-Timestamp
				try {
					FormatDateConstant.ISO8601.parse(context.getHeaderString(paramTimestamp));	
				} catch (ParseException e) {
					throw new Exception();
				}
				// TODO: Validate X-Tripoin-Signature
				initSignature(context);
				if(!signature.equals(context.getHeaderString(paramSignature))){
					throw new Exception();
				}				
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			context.abortWith(Response.status(Status.BAD_REQUEST).build());
		}
	}

	/**
	 * <b>For Entity:</b><br>
	 * &emsp;&emsp;&emsp;Convert context.getEntityStream() to String and set again value context.setEntityStream(ByteArrayInputStream)</br>
	 * &emsp;&emsp;&emsp;So the value of context.getEntityStream() is not empty
	 * 
	 * @param context
	 */
	private void initSignature(ContainerRequestContext context){				
		this.entity = TransformInputStream.toByteArray(context.getEntityStream());
		this.apiKey = headerKey.key();
		this.accessToken = context.getHeaderString(CommonConstant.AUTHORIZATION).replace(CommonConstant.BEARER, "");
		this.method = context.getMethod();
		this.body = new String(this.entity.toByteArray());
		this.path = rawPath(context.getUriInfo().getAbsolutePath().getRawPath());
		this.timestamp = context.getHeaderString(paramTimestamp);					
		this.signature = HeaderSignatureGenerator.signature(apiKey, accessToken, method, body, path, timestamp);
		context.setEntityStream(new ByteArrayInputStream(entity.toByteArray()));
		if(LOGGER.isDebugEnabled())
			LOGGER.debug(paramSignature.concat(" : ").concat(signature));		
	}
	
	/**
	 * <b>Description:</b><br>
	 * &emsp;&emsp;&emsp;Raw path must begin with value <b>${tripoin.wscontext}/</b>
	 * 
	 * @param path
	 * @return
	 */
	private String rawPath(String path){
		return path.substring(path.indexOf(wscontext.concat("/")));
	}
	
}