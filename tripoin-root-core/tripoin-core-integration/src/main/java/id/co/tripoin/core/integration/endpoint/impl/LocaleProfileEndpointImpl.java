package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.ApplicationContextConstant;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.I18NLocaleDataRequest;
import id.co.tripoin.core.integration.endpoint.ILocaleProfileEndpoint;
import id.co.tripoin.core.integration.exception.LocaleFoundFaultException;
import id.co.tripoin.core.integration.exception.LocaleNullFaultException;
import id.co.tripoin.core.integration.handler.base.ABaseResponseHandler;
import id.co.tripoin.core.integration.servlet.UserAuthenticationContext;
import id.co.tripoin.core.pojo.I18NLocale;
import id.co.tripoin.core.service.IProfileService;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.I18NLOCALE_PROFILE_ENDPOINT_BEAN)
public class LocaleProfileEndpointImpl extends ABaseResponseHandler implements ILocaleProfileEndpoint {

	private static Logger LOGGER = LoggerFactory.getLogger(LocaleProfileEndpointImpl.class);
	private EResponseCode responseCode;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private IProfileService profileService;

	@SuppressWarnings("unchecked")
	@Override
	public Response putLocaleProfile(I18NLocaleDataRequest i18NLocaleDataRequest) {
		try {
			if(i18NLocaleDataRequest == null || i18NLocaleDataRequest.getCode().isEmpty())
				throw new LocaleNullFaultException(InfoMarkerConstant.ERR_LOCALE_CODE_NULL);
			Map<String, I18NLocale> mapLocale = (Map<String, I18NLocale>)context.getAttribute(ApplicationContextConstant.CONTEXT_I18NLOCALE);
			if(!mapLocale.containsKey(i18NLocaleDataRequest.getCode()))
				throw new LocaleFoundFaultException(InfoMarkerConstant.ERR_LOCALE_NOT_FOUND);
			int result = profileService.setProfileLocale(mapLocale.get(i18NLocaleDataRequest.getCode()), UserAuthenticationContext.getInstance().getCurrentUsername());
			if(result != 1)
				throw new Exception();
		} catch (LocaleFoundFaultException lffe) {
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, lffe);
			this.responseCode = EResponseCode.RC_LOCALE_NOT_FOUND;
			return abort();			
		} catch (LocaleNullFaultException lnfe) {
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, lnfe);
			this.responseCode = EResponseCode.RC_LOCALE_NOT_NULL;
			return abort();			
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, e);
			this.responseCode = EResponseCode.RC_BAD_REQUEST;
			return abort();
		}
		return Response.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg())).build();
	}
	
	@Override
	public EResponseCode getResponseCode() {
		return responseCode;
	}

}
