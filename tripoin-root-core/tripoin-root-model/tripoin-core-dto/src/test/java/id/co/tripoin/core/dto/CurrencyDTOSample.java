package id.co.tripoin.core.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 **/
@XmlRootElement(name="Currency")
public class CurrencyDTOSample implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5742749212884989377L;

	private String currencyCode;
	private String currencyName;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
