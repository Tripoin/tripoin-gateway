package id.co.tripoin.web.service.provider;

import id.co.tripoin.util.time.FormatDateConstant;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.InfoMarkerConstant;
import id.co.tripoin.web.constant.statics.ResourcePropertiesConstant;
import id.co.tripoin.web.service.security.HeaderKeyGenerator;
import id.co.tripoin.web.service.security.HeaderSignatureGenerator;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * <b>Filter Signature Header:</b></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Key &emsp;&emsp;&emsp;&nbsp;&nbsp;: 85adc8e352ddf41c0cf4a08ecf93085f <i>from HeaderKeyGenerator.key()</i></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Timestamp : 2016-02-03T10:00:00.000+07:00 <i>format date = yyyy-MM-dd'T'HH:mm:ss.SSSXXX refer ISO8601</i></br>
 * &emsp;&emsp;&emsp;X-Tripoin-Signature &nbsp;&nbsp; : acb476a3ad5940f8e790154f5033f1e853a6ba4fac4da03230fe4c4b86f6ad0c</br>
 * &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;<i>from HeaderSignatureGenerator.signature(apiKey, accessToken, method, body, path, timestamp)</i></br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a></br>
 */
public class SignatureHeaderOutbound implements ClientRequestFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SignatureHeaderOutbound.class);	
	private String apiKey;
	private String accessToken;
	private String method;
	private String path;
	private String timestamp;
	private String body;

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
	public void filter(ClientRequestContext context) throws IOException {
		try {
			for(String key : context.getCookies().keySet())
				System.err.println(key);
			if(context.getUri().getRawPath().indexOf(wscontext.concat("/")) != -1){
				context.getHeaders().add(paramKey, headerKey.key());
				context.getHeaders().add(paramTimestamp, FormatDateConstant.ISO8601.format(new Date()));
				context.getHeaders().add(paramSignature, initSignature(context));
			}
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_SIGNATURE, e.getMessage());
		}	
	}

	/**
	 * <b>For Entity:</b><br>
	 * &emsp;&emsp;&emsp;Convert context.getEntityStream() to String and set again value context.setEntityStream(ByteArrayInputStream)</br>
	 * &emsp;&emsp;&emsp;So the value of context.getEntityStream() is not empty
	 * 
	 * @param context
	 */
	private String initSignature(ClientRequestContext context){				
		this.apiKey = headerKey.key();
		this.accessToken = context.getHeaderString(CommonConstant.AUTHORIZATION).replace(CommonConstant.BEARER_PREFIX, "");
		this.method = context.getMethod();
		this.body = context.getEntity().toString();
		this.path = rawPath(context.getUri().getRawPath());
		this.timestamp = context.getHeaderString(paramTimestamp);					
		String signature = HeaderSignatureGenerator.signature(apiKey, accessToken, method, body, path, timestamp);
		if(LOGGER.isDebugEnabled())
			LOGGER.debug(paramSignature.concat(" : ").concat(signature));
		return signature;
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