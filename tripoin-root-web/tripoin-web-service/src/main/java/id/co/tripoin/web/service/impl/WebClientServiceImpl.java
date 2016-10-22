package id.co.tripoin.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.ResourcePropertiesConstant;
import id.co.tripoin.web.service.AWebClientService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Scope(value = CommonConstant.SESSION, proxyMode = ScopedProxyMode.INTERFACES)
@Service(BeanNameConstant.WEB_CLIENT_SERVICE_BEAN)
public class WebClientServiceImpl extends AWebClientService {
	
	private final WebClient webClient;
	
	//@Resource(name = "providers")
	private List<Object> providers;
	
	@Autowired
	public WebClientServiceImpl(@Value(ResourcePropertiesConstant.TRIPOIN_INTEGRATION_URL) String baseAddress) {
		providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());
		this.webClient = WebClient.create(baseAddress, providers);
	}

	@Override
	public WebClient getWebClient() {
		return this.webClient;
	}

}
