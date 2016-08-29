package id.co.tripoin.test.core.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 **/
@XmlRootElement(name="CurrencyRequest")
public class CurrencyDTORequest {

	private String currencyCode;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
