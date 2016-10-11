package id.co.tripoin.web.dto.request;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class I18NLocaleDataRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8926102027919874860L;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
