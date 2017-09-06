package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.ApplicationContextConstant;
import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.I18NLocaleDataRequest;
import id.co.tripoin.core.integration.endpoint.I18NLocaleEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.integration.exception.LocaleFoundFaultException;
import id.co.tripoin.core.integration.exception.LocaleNullFaultException;
import id.co.tripoin.core.integration.handler.base.IBaseResponseHandler;
import id.co.tripoin.core.integration.servlet.UserAuthenticationContext;
import id.co.tripoin.core.pojo.security.I18NLocale;
import id.co.tripoin.core.service.II18NLocaleService;
import id.co.tripoin.core.service.ISecurityUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.Map;

/**
 * created on 2017-03-09
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_LOCALE_BEAN)
public class I18NLocaleEndPointImpl extends AScaffoldingEndPoint<I18NLocale> implements I18NLocaleEndPoint, IBaseResponseHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(I18NLocaleEndPointImpl.class);
	
	@Autowired
	II18NLocaleService i18NLocaleService;

	@Override
	public void init() {
		scaffoldingService = i18NLocaleService;
	}
	
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ISecurityUserProfileService profileService;

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
	
	protected EResponseCode responseCode = EResponseCode.RC_FAILURE;

	
	public Response abort() {
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		ResponseBuilder responseBuilder = Response.status(getResponseCode().getHttpResponse());
		responseBuilder.entity(responseData);
		responseBuilder.type(MediaType.APPLICATION_JSON_VALUE);
		return responseBuilder.build();
	}


	@Override
	public EResponseCode getResponseCode() {
		return null;
	}
	

}
