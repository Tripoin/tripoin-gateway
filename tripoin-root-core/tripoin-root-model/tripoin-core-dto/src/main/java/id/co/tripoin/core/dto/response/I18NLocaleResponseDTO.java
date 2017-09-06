package id.co.tripoin.core.dto.response;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class I18NLocaleResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510245510153245463L;
	private String code;
	private String language;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
