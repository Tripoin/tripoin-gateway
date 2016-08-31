package id.co.tripoin.test.core.integration.service.impl;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.test.core.dto.CurrencyDTORequest;
import id.co.tripoin.test.core.dto.CurrencyDTOSample;
import id.co.tripoin.test.core.integration.service.ISampleService;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 **/
@Component(BeanNameConstant.SAMPLE_SERVICE_BEAN)
public class SampleServiceImpl implements ISampleService {

	@Override
	public Response postCurrency(CurrencyDTORequest currencyCode) {
		CurrencyDTOSample currency = new CurrencyDTOSample();
		currency.setCurrencyCode(currencyCode.getCurrencyCode());
		currency.setCurrencyName("Indonesia Rupiah");
		return Response.ok(currency).build();
	}

	@Override
	public Response getCurrency(String currencyCode) {
		CurrencyDTOSample currency = new CurrencyDTOSample();
		currency.setCurrencyCode(currencyCode);
		currency.setCurrencyName("Indonesia Rupiah");
		return Response.ok(currency).build();
	}
	
}
